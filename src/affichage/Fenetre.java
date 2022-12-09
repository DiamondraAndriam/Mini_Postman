package affichage;

import javax.swing.*;
import listener.ButtonListener;

public class Fenetre extends JFrame {

    JButton jButton1;
    JButton jButton2;
    JComboBox<String> jComboBox1;
    JLabel jLabel1;
    JLabel jLabel2;
    JPanel jPanel1;
    JPanel jPanel5;
    JTextField jTextField1;
    ButtonListener buttonListener;

    public JButton getJButton1(){
        return jButton1;
    }
    public JButton getJButton2(){
        return jButton2;
    }
    public JComboBox<String> getJComboBox1(){
        return jComboBox1;
    }
    public JTextField getJTextField1(){
        return jTextField1;
    }
    public JLabel getJLabel1(){
        return jLabel1;
    }

    /**
     * Creates new form Fenetre
     */
    public Fenetre() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents() {

        buttonListener = new ButtonListener((JFrame)this);
        jPanel1 = new JPanel();
        jComboBox1 = new JComboBox<>();
        jButton1 = new JButton("Send");
        jButton1.addMouseListener(buttonListener);
        jButton2 = new JButton("Save");
        jButton2.addMouseListener(buttonListener);
        jTextField1 = new JTextField();
        jPanel5 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(920, 560));
        setResizable(false);
        setTitle("Mini-Postman");

        jPanel1.setPreferredSize(new java.awt.Dimension(890, 530));

        jComboBox1.setFont(new java.awt.Font("Source Sans Pro Semibold", 1, 14)); // NOI18N
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "GET", "POST", "PUT", "DELETE" }));
        jComboBox1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
        
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Veuillez entrer une addresse");

        jLabel2.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("Envoyer votre requete");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jComboBox1.getAccessibleContext().setAccessibleName("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }

    
}
