package perform_paralel;

import java.util.ArrayList;
import java.util.List;

public class ProductResult {

    public List<Product> result(int count) {
        List<Product> ls = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Product p = new Product();
            p.setTitle("Title - " + i);
            p.setPrice(i * i);
            ls.add(p);
        }
        return ls;
    }

}
