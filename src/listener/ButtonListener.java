package listener;

import javax.swing.*;
import java.awt.event.*;

import affichage.*;
import treatment.*;

public class ButtonListener implements MouseListener {
    JFrame frame;

    public ButtonListener(JFrame frame) {
        this.frame = frame;
    }

    public void mouseClicked(MouseEvent e) {
        if (frame instanceof Fenetre) {
            Fenetre fen = (Fenetre) frame;
            if ((JButton) e.getSource() == fen.getJButton1()) {
                String url = fen.getJTextField1().getText();
                // System.out.println(url);
                String method = (String) fen.getJComboBox1().getSelectedItem();
                try {
                    TreatmentRequest treat = new TreatmentRequest(url, method);
                    Client client = Client.createClient(treat);
                    Fenetre1 fenetre = new Fenetre1(client);
                    fenetre.getJTextField1().setText(url);
                    fenetre.setJEditorPane1(url);
                    fenetre.setTitle(url);
                    fenetre.setVisible(true);
                    frame.setVisible(false);
                } catch (Exception exc) {
                    //exc.printStackTrace();
                    String string = exc.getMessage();
                    fen.getJLabel1().setText(string);
                }
            }
        } else if (frame instanceof Fenetre1) {
            Fenetre1 fen = (Fenetre1) frame;
            // send another request
            if ((JButton) e.getSource() == fen.getJButton1()) {
                String url = fen.getJTextField1().getText();
                // System.out.println(url);
                String method = (String) fen.getJComboBox1().getSelectedItem();
                try {
                    TreatmentRequest treat = new TreatmentRequest(url, method);
                    Client client = Client.createClient(treat);
                    Fenetre1 fenetre = new Fenetre1(client);
                    fenetre.getJTextField1().setText(url);
                    fenetre.setJEditorPane1(url);
                    fenetre.setTitle(url);
                    fenetre.setVisible(true);
                    frame.setVisible(false);
                } catch (Exception exc) {
                    Fenetre fenetre = new Fenetre();
                    String string = exc.getMessage() + ". Veuillez entrer une addresse.";
                    fenetre.getJLabel1().setText(string);
                    fenetre.getJTextField1().setText(url);
                    frame.setVisible(false);
                }
            }
            // save request
            if ((JButton) e.getSource() == fen.getJButton2()) {
                try{
                    fen.save();
                }
                catch (Exception exc) {
                    Fenetre fenetre = new Fenetre();
                    String string = "Impossible de le sauvegarder. Veuillez entrer une addresse.";
                    fenetre.getJLabel1().setText(string);
                    fenetre.getJTextField1().setText(fen.getTitle());
                    frame.setVisible(false);
                }
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}