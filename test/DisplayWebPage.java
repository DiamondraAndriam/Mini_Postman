package test;
import javax.swing.*;
import java.io.*;

public class DisplayWebPage extends JFrame{
    public static void main(String[] args){
        JEditorPane editor = new JEditorPane();
        editor.setEditable(false);

        try{
            editor.setPage("http://localhost:8080/form/");
        } catch( IOException e){
            editor.setContentType("text/html");
            editor.setText("La page n'a pas pu charger");
        }

        JScrollPane scrollpane = new JScrollPane(editor);
        JFrame f = new JFrame("Afficher la page web example.com");
        f.getContentPane().add(scrollpane);
        f.setSize(700,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}