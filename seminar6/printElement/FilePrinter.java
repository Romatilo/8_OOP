package seminar6.printElement;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter<T> implements I_Printable<T> {

    private String filename;

    public FilePrinter(String filename) {
        this.filename = filename;
    }
    public void print (T element) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(String.valueOf(element));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}