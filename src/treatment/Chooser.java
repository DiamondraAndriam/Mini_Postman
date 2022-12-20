package treatment;

import javax.swing.*;
import javax.swing.filechooser.*;

public class Chooser extends JFileChooser {
    static JFrame frame = new JFrame();

    public Chooser() {
        super();
        frame.setSize(100, 100);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "HTML Document", "html");
        this.setFileFilter(filter);
    }

    public static String getPath() throws Exception {
        Chooser chooser = new Chooser();
        int returnVal = chooser.showSaveDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return (String) chooser.getSelectedFile().getPath();
        } else {
            throw new Exception("Pas de fichier selectionné");
        }
    }
}
