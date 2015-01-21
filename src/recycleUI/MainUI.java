/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recycleUI;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_1 = new javax.swing.JPanel();
        panel_2 = new javax.swing.JPanel();
        admin_btn = new javax.swing.JButton();
        cust_btn = new javax.swing.JButton();
        panel_3 = new javax.swing.JPanel();
        logo_label = new javax.swing.JLabel();
        welcome_label = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("EcoReSystem-HOME");
        setBackground(new java.awt.Color(255, 255, 255));

        panel_1.setBackground(new java.awt.Color(255, 255, 255));
        panel_1.setLayout(new java.awt.BorderLayout());

        admin_btn.setText("ADMIN");
        admin_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_btnActionPerformed(evt);
            }
        });

        cust_btn.setText("CUSTOMER");
        cust_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cust_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_2Layout = new javax.swing.GroupLayout(panel_2);
        panel_2Layout.setHorizontalGroup(
                panel_2Layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(admin_btn, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cust_btn, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                );
        panel_2Layout.setVerticalGroup(
                panel_2Layout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, panel_2Layout.createSequentialGroup()
                                .addGap(85)
                                .addComponent(admin_btn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(30)
                                .addComponent(cust_btn, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(222, Short.MAX_VALUE))
                );
        panel_2.setLayout(panel_2Layout);

        panel_1.add(panel_2, java.awt.BorderLayout.LINE_START);

        panel_3.setBackground(new java.awt.Color(255, 255, 255));
        panel_3.setLayout(new java.awt.GridLayout(2, 1));

        logo_label.setBackground(new java.awt.Color(255, 255, 255));
        logo_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo_label.setIcon(new ImageIcon(MainUI.class.getResource("/uiResources/logo.jpg"))); // NOI18N
        logo_label.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panel_3.add(logo_label);

        welcome_label.setBackground(new java.awt.Color(255, 255, 255));
        welcome_label.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        welcome_label.setForeground(new java.awt.Color(0, 153, 0));
        welcome_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome_label.setText("WELCOME TO RECYCLING SYSTEM");
        welcome_label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panel_3.add(welcome_label);

        panel_1.add(panel_3, java.awt.BorderLayout.CENTER);

        jMenu3.setText("File");

        jMenuItem1.setText("Exit");
        jMenu3.add(jMenuItem1);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_1, javax.swing.GroupLayout.Alignment.TRAILING,
                                      javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                      javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admin_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_btnActionPerformed
        loginUI login = new loginUI();
        setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_admin_btnActionPerformed

    private void cust_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cust_btnActionPerformed
        customerUI cust = new customerUI();
        setVisible(false);
        cust.setVisible(true);
    }//GEN-LAST:event_cust_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_btn;
    private javax.swing.JButton cust_btn;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel logo_label;
    private javax.swing.JPanel panel_1;
    private javax.swing.JPanel panel_2;
    private javax.swing.JPanel panel_3;
    private javax.swing.JLabel welcome_label;

    // End of variables declaration//GEN-END:variables
}
