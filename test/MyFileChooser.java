package test;

import java.net.URL;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;;

public class MyFileChooser {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(100, 100);
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "HTML Document", "html");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to write 'OK' to this file: " +
                    chooser.getSelectedFile().getPath());
        }
    }
}
