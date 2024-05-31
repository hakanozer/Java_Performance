package com.works.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Currency {

    private String CurrencyName;
    private String ForexBuying;
    private String ForexSelling;
    private String BanknoteBuying;
    private String BanknoteSelling;

}
