package perform_paralel;

import java.util.List;

public class MainParalel {

    public static void main(String[] args) {
        ProductResult productResult = new ProductResult();
        List<Product> ls = productResult.result(5000);

        long start = System.currentTimeMillis();
        ls.stream().forEach(item -> {
            try {
                Thread.sleep(20);
                System.out.println(item);
            }catch (Exception ex) {}
         });
        long end = System.currentTimeMillis();
        long between


    }

}
