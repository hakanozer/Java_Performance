package perform_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    private String fileName = "";
    private File file = null;
    public Manager(String fileName) {
        this.fileName = fileName + ".txt";
        file = new File(this.fileName);
    }

    public void createFile() {
        try {
            file.createNewFile();
        }catch (Exception ex) {
            System.err.println("createFile Error: " + ex.getMessage());
        }
    }

    public void deleteFile() {
        file.delete();
    }

    public void addData(String line) {
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.append(line);
            fw.append(System.lineSeparator());
            fw.close();
        }catch (Exception ex) {
            System.err.println("addData Error: " + ex.getMessage());
        }
    }

    public List<String> readFile() {
        List<String> lines = new ArrayList<>();
        try {

            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            FileChannel fc = fis.getChannel();
            long size = fc.size();
            ByteBuffer byteBuffer = fis.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, size);
            CharBuffer charBuffer = StandardCharsets.ISO_8859_1.decode(byteBuffer);
            Scanner scanner = new Scanner(charBuffer);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        }catch (Exception ex) {
            System.err.println("readFile Error: " + ex.getMessage());
        }
        return lines;
    }

}
