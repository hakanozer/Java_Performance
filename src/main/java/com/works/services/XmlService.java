package com.works.services;

import com.works.models.Currency;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class XmlService {

    private final CacheManager cacheManager;

    @Cacheable("xml")
    public List<Currency> xml() {
        System.out.println("xml call");
        List<Currency> currencyList = new ArrayList<>();
        try {
            String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("Currency");
            for (Element element : elements) {
                String CurrencyName = element.getElementsByTag("CurrencyName").text();
                String ForexBuying = element.getElementsByTag("ForexBuying").text();
                String ForexSelling = element.getElementsByTag("ForexSelling").text();
                String BanknoteBuying = element.getElementsByTag("BanknoteBuying").text();
                String BanknoteSelling = element.getElementsByTag("BanknoteSelling").text();
                Currency c = new Currency(CurrencyName, ForexBuying, ForexSelling, BanknoteBuying, BanknoteSelling);
                currencyList.add(c);
            }
        }catch (Exception ex) {
            System.err.println("Xml Error : " + ex.getMessage());
        }
        return currencyList;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.DAYS)
    public void xmlCacheClear() {
        System.out.println("xmlCacheClear call");
        cacheManager.getCache("xml").clear();
    }

}
