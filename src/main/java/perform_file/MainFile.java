package perform_file;

import java.util.List;
import java.util.Random;

public class MainFile {

    public static void main(String[] args) {
        Manager manager = new Manager("sample");
        //manager.createFile();
        //manager.deleteFile();
        Random random = new Random();
        manager.addData("New line-" + random.nextInt(1, 100));

        List<String> list = manager.readFile();
        for (String line : list) {
            System.out.println(line);
        }
    }

}
