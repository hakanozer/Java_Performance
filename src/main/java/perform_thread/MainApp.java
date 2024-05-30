package perform_thread;

public class MainApp {
    public static void main(String[] args) {

        PartAction ac1 = new PartAction("1.jpg");
        ac1.start();

        PartAction ac2 = new PartAction("2.jpg");
        ac2.start();

        PartAction ac3 = new PartAction("3.jpg");
        ac3.start();

        System.out.println("this line call");

    }
}
