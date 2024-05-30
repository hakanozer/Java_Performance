package perform_collection;

import java.util.*;

public class MainCollection {

    public static void main(String[] args) {

        Result result = new Result();
        List<String> list = result.getTurkishNames();
        System.out.println(list);

        System.out.println("============================");
        Set<String> set = new HashSet<>();
        for (String name : list) {
            set.add(name);
        }
        System.out.println(set);


    }

}
