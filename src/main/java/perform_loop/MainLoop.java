package perform_loop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainLoop {

    public static void main(String[] args) {

        Random random =  new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.hashCode());
            int rnd = random.nextInt(1, 100);
            System.out.println("Random Count: " + rnd);
        }
        System.out.println("======================");

        List<Customer> ls = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Customer c = new Customer();
            c.setName("Name-"+i);
            c.setSurname("Surname-"+i);
            ls.add(c);
            c = null;
        }
        System.out.println(ls);
    }

}
