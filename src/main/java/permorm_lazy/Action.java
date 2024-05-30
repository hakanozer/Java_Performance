package permorm_lazy;

public class Action {

    private static String name = null;

    public static String instance() {
        if (name == null) {
            System.out.println("String Call");
            name = "Ali Bilmem";
        }
        return name;
    }

}
