package treatment;

import java.io.*;

public class Fichier extends File {
    public Fichier(String path) throws IOException {
        super(path);
        if (!this.exists()) {
            this.createNewFile();
        }
    }

    public void write(String[] text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this, true));
        for (int i = 0; i < text.length; i++) {
            writer.write(text[i]);
            writer.newLine();
        }
        writer.close();
    }
}
