package perform_string;

public class MainString {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        /*
        String stData = "";
        for (int i = 0; i < 10000; i++) {
            stData += "newData"+i;
        }
        System.out.println(stData);

         */

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            builder.append("newData"+i);
        }
        System.out.println(builder.toString());
        long end = System.currentTimeMillis();
        long between = end - start;
        System.out.println("builder between :" + between);

    }


}
