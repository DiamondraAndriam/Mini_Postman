package affichage;

/**
 * @author DIAMONDRA
*/

import java.io.*;
import javax.swing.*;

import listener.ButtonListener;
import treatment.Client;

public class Fenetre1 extends JFrame {

    JButton jButton1;
    JButton jButton2;
    JComboBox<String> jComboBox1;
    JEditorPane jEditorPane1;
    JPanel jPanel1;
    JScrollPane jScrollPane1;
    JScrollPane jScrollPane2;
    JScrollPane jScrollPane3;
    JTabbedPane jTabbedPane1;
    JTextField jTextField1;
    JTextPane jTextPane1;
    JTextPane jTextPane2;
    ButtonListener buttonListener;
    Client client;

// getters & setters
    public JButton getJButton1(){
        return jButton1;
    }
    public JButton getJButton2(){
        return jButton2;
    }
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    public JTextField getJTextField1(){
        return jTextField1;
    }
    public JComboBox<String> getJComboBox1(){
        return jComboBox1;
    }
    public JScrollPane getJScrollPane1(){
        return jScrollPane1;
    }

// Creates new form Fenetre

    public Fenetre1(Client client) {
        setClient(client);
        initComponents();
        setLocationRelativeTo(null);
        //setVisible(true);
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton("Send");
        jButton2 = new javax.swing.JButton("Save");
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(920, 560));
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(890, 530));

        jComboBox1.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GET", "POST", "PUT", "DELETE" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox1.setDoubleBuffered(true);

        jButton1.setBackground(new java.awt.Color(91, 154, 160));
        jButton1.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setPreferredSize(new java.awt.Dimension(84, 24));

        jButton2.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setPreferredSize(new java.awt.Dimension(84, 24));
        jButton2.setRequestFocusEnabled(false);

        jTextField1.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        jTextField1.setText("http://www.example.com");
        jTextField1.setCaretColor(new java.awt.Color(204, 204, 204));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(55, 120));

        jScrollPane1.setViewportView(jTextPane1);

        jTabbedPane1.addTab("Header", jScrollPane1);

        jScrollPane2.setViewportView(jTextPane2);

        jTabbedPane1.addTab("Body", jScrollPane2);

        jScrollPane3.setViewportView(jEditorPane1);

        jTabbedPane1.addTab("Preview", jScrollPane3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jComboBox1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 886, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }

// fonction setJTextPane1/2/EditorPane
    public void setJtextPane1(){

    }

    public void setJTextPane2(){

    }

    public void setJEditorPane1(){
        jEditorPane1.setEditable(false);
        try{
            jEditorPane1.setPage(client.getUrl().toString());
        } catch (IOException e){
            jEditorPane1.setContentType("text/html");
            jEditorPane1.setText("La page n'a pas pu charger");
        }
    }

    public void save(){}
}
