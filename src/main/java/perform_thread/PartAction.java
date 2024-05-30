package perform_thread;

public class PartAction extends Thread {

    private String imagePath = "";
    public PartAction(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(imagePath + " Upload");
            }
            System.out.println("Image Upload Finish - " + imagePath);
        }catch (Exception ex) {}
    }

}
