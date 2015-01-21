/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recycleUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

//import java.util.Date;
//import java.util.List;
import javax.swing.event.*;
import javax.swing.ListSelectionModel;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;

import recycle.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class customerUI extends javax.swing.JFrame {

    /**
     * Creates new form customerUI
     */
    public customerUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rcmNames_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rcmListCust = new javax.swing.JList();
        rcmDetail_label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rcm_textArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        items_combo = new javax.swing.JComboBox();
        qty_field = new javax.swing.JTextField();
        weight_field = new javax.swing.JTextField();
        addTocart_btn = new javax.swing.JButton();
        checkOut_btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        price_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cashCoupons_box = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recycling Machine");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Select an RCM"));

        rcmNames_label.setText("RCM");

        rcmDetail_label.setText("RCM details");

        rcm_textArea.setEditable(false);
        rcm_textArea.setColumns(20);
        rcm_textArea.setRows(5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout
                                          .createSequentialGroup()
                                          .addGap(24, 24, 24)
                                          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                        Short.MAX_VALUE)
                                          .addGap(88, 88, 88)
                                          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap())
                        .addGroup(jPanel1Layout
                                          .createSequentialGroup()
                                          .addGap(61, 61, 61)
                                          .addComponent(rcmNames_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                           javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(rcmDetail_label)
                                          .addGap(144, 144, 144))
                );
        jPanel1Layout
                .setVerticalGroup(
                jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout
                                          .createSequentialGroup()
                                          .addGroup(jPanel1Layout
                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(rcmNames_label)
                                                            .addComponent(rcmDetail_label))
                                          .addGap(6, 6, 6)
                                          .addGroup(jPanel1Layout
                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jScrollPane2,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE, 115,
                                                                          Short.MAX_VALUE)
                                                            .addComponent(jScrollPane1,
                                                                          javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                                          Short.MAX_VALUE))
                                          .addContainerGap())
                );
        String ID = "RCM ";

        rcmNamesList = rmos2.getAllRecycleMachines();
        for (int i = 0; i < rcmNamesList.size(); i++)
        {
            rcmNamesCust[i] = ID + rcmNamesList.get(i).getMachineId();

        }
        rcmListCust = new javax.swing.JList<Object>(rcmNamesCust);

        rcmListCust.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(rcmListCust);

        rcmListCust.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                String itemDetails = "";
                selectedRCMName = (String) rcmListCust.getSelectedValue();
                String selectedRCM = selectedRCMName.substring(4, selectedRCMName.length());
                macID = Integer.parseInt(selectedRCM);
                for (int i = 0; i < rcmNamesList.size(); i++)
                {
                    String s = rcmNamesList.get(i).getMachineId() + "";
                    if (s.equals(selectedRCM))
                    {
                        int noOfItems = rcmNamesList.get(i).getNumberOfItems();
                        double capacity = rcmNamesList.get(i).getAvailableCapacity();
                        Date date = rcmNamesList.get(i).getLastTimeMachineEmptied();
                        //rcmList.get(i).getAllSupportedItemTypes().get(i).getName()
                        OperationalStatus OperationalStatus = rcmNamesList.get(i).getOperational();
                        itemDetails = "Machine ID:\t\t" + s + "\nNumber of items\t 4" + "\nAvailable capacity:\t" +
                                capacity + "\nLast emptied:\t\t" + date +
                                "\nOpretational status:\t" + OperationalStatus + "\t" + "Total Money Remaining 250";

                    }
                }

                RecycleMachineMonitor rm = new RecycleMachineMonitor();
                List<ItemType> as = rm.getItemTypesByMachineId(macID);
                //as=rm.getItemTypesByMachineId(macID);
                String items = "";
                itemNames = new String[10];
                for (int i = 0; i < as.size(); i++)
                {
                    itemNames[i] = as.get(i).getName();
                    items = items + as.get(i).getName() + "  " + as.get(i).getPricePerLb() + "\n\t\t";
                }
                itemDetails = itemDetails + "\nItem Details::\t\t " + items;

                rcm_textArea.setText(itemDetails);
                items_combo.setModel(new javax.swing.DefaultComboBoxModel(itemNames));
            }
        });

        // scrolListCust.setViewportView(rcmListCust);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Drop items"));

        jLabel1.setText("Items");

        jLabel2.setText("Qty");

        jLabel3.setText("Weight");

        items_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {" ", " "}));
        items_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                items_comboActionPerformed(evt);
            }
        });

        addTocart_btn.setText("AddToCart");
        addTocart_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double weight = Double.parseDouble(weight_field.getText());
                int quantity = Integer.parseInt(qty_field.getText());
                if (weight > 55)
                    JOptionPane.showMessageDialog(null, "Capacity Full");
                String s = (String) items_combo.getSelectedItem();

                shopCart.add(new Item(new ItemType(s, Double.parseDouble(rmos2.getPrice(s))), weight, quantity));

            }
        });
        // items_combo.getSelectedItem()
        String p = rmos2.getPrice("Paper");
        System.out.println("price" + p);

        checkOut_btn.setText("CheckOut");
        checkOut_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double totalDueAmount = 0.0;

                for (int j = 0; j < shopCart.size(); j++)
                {

                    totalDueAmount = totalDueAmount +
                            (shopCart.get(j).getWeight() * shopCart.get(j).getType().getPricePerLb() * shopCart.get(j)
                                    .getQuantity());
                    if (totalDueAmount >= 150)
                        JOptionPane.showMessageDialog(null, "Transaction failed");
                }
                //System.out.println("total" +totalDueAmount);
                price_field.setText("" + totalDueAmount);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout
                .setHorizontalGroup(
                jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout
                                          .createSequentialGroup()
                                          .addGroup(jPanel2Layout
                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel2Layout
                                                                              .createSequentialGroup()
                                                                              .addGap(24, 24, 24)
                                                                              .addComponent(jLabel1,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            Short.MAX_VALUE)
                                                                              .addGap(64, 64, 64))
                                                            .addGroup(jPanel2Layout
                                                                              .createSequentialGroup()
                                                                              .addContainerGap()
                                                                              .addComponent(items_combo,
                                                                                            0,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            Short.MAX_VALUE)
                                                                              .addGap(27, 27, 27)))
                                          .addGroup(jPanel2Layout
                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(jPanel2Layout
                                                                              .createSequentialGroup()
                                                                              .addGap(14, 14, 14)
                                                                              .addComponent(jLabel2,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            Short.MAX_VALUE))
                                                            .addComponent(qty_field))
                                          .addGroup(jPanel2Layout
                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel2Layout
                                                                              .createSequentialGroup()
                                                                              .addGap(60, 60, 60)
                                                                              .addComponent(jLabel3,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                            Short.MAX_VALUE))
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                    .addGap(40, 40, 40)
                                                                    .addComponent(weight_field)))
                                          .addGap(52, 52, 52)
                                          .addComponent(addTocart_btn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addGap(86, 86, 86)
                                          .addComponent(checkOut_btn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addGap(58, 58, 58))
                );
        jPanel2Layout
                .setVerticalGroup(
                jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout
                                          .createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(jPanel2Layout
                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel1,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          Short.MAX_VALUE)
                                                            .addComponent(jLabel2,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          Short.MAX_VALUE)
                                                            .addComponent(jLabel3,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          Short.MAX_VALUE))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addGroup(jPanel2Layout
                                                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(items_combo)
                                                            .addComponent(qty_field)
                                                            .addComponent(weight_field)
                                                            .addComponent(addTocart_btn,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          Short.MAX_VALUE)
                                                            .addComponent(checkOut_btn,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          Short.MAX_VALUE))
                                          .addGap(24, 24, 24))
                );
        jScrollPane2.setViewportView(rcm_textArea);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaction Details"));

        jLabel4.setText("The price due to the customer is");

        jLabel6.setText("Do you want Cash or Coupons?");

        cashCoupons_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Cash", "Coupon"}));
        cashCoupons_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashCoupons_boxActionPerformed(evt);
            }
        });

        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("$");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout
                .setHorizontalGroup(
                jPanel3Layout
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel3Layout
                                          .createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(jPanel3Layout
                                                            .createParallelGroup(Alignment.LEADING)
                                                            .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 159,
                                                                          Short.MAX_VALUE)
                                                            .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 159,
                                                                          Short.MAX_VALUE))
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addGroup(jPanel3Layout
                                                            .createParallelGroup(Alignment.TRAILING)
                                                            .addGroup(jPanel3Layout
                                                                              .createSequentialGroup()
                                                                              .addComponent(cashCoupons_box, 0, 66,
                                                                                            Short.MAX_VALUE)
                                                                              .addGap(104)
                                                                              .addComponent(jButton1,
                                                                                            GroupLayout.PREFERRED_SIZE,
                                                                                            117,
                                                                                            GroupLayout.PREFERRED_SIZE)
                                                                              .addGap(141))
                                                            .addGroup(jPanel3Layout
                                                                              .createSequentialGroup()
                                                                              .addComponent(price_field, 65, 65, 65)
                                                                              .addPreferredGap(ComponentPlacement.RELATED)
                                                                              .addComponent(jLabel5,
                                                                                            GroupLayout.PREFERRED_SIZE,
                                                                                            23,
                                                                                            GroupLayout.PREFERRED_SIZE)
                                                                              .addGap(334))))
                );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout
                        .createParallelGroup(Alignment.LEADING)
                        .addGroup(jPanel3Layout
                                          .createSequentialGroup()
                                          .addGap(3)
                                          .addGroup(jPanel3Layout
                                                            .createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE,
                                                                          GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(price_field, GroupLayout.PREFERRED_SIZE,
                                                                          GroupLayout.DEFAULT_SIZE,
                                                                          GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel5))
                                          .addGap(24)
                                          .addGroup(jPanel3Layout
                                                            .createParallelGroup(Alignment.LEADING, false)
                                                            .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE,
                                                                          GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(cashCoupons_box, GroupLayout.PREFERRED_SIZE,
                                                                          GroupLayout.DEFAULT_SIZE,
                                                                          GroupLayout.PREFERRED_SIZE))
                                          .addGap(62))
                        .addGroup(Alignment.TRAILING,
                                  jPanel3Layout
                                          .createSequentialGroup()
                                          .addGap(66)
                                          .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                          .addGap(40))
                );
        jPanel3.setLayout(jPanel3Layout);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jPanel2,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          Short.MAX_VALUE)
                                                            .addComponent(jPanel3,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          Short.MAX_VALUE)
                                                            .addComponent(jPanel1,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                          Short.MAX_VALUE))
                                          .addContainerGap())
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(18, 18, 18)
                                          .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addContainerGap())
                );

        pack();
    }// </editor-fold>                        

    private void checkOut_btnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void items_comboActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addTocart_btnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cashCoupons_boxActionPerformed(java.awt.event.ActionEvent evt) {
        String C1 = (String) cashCoupons_box.getSelectedItem();
        String C2 = (String) cashCoupons_box.getSelectedItem();
        //	int amt=0;

        //double remain=rmos2.checkTotalMoneyRemaining(macID);

        if (C1.equalsIgnoreCase("Cash"))
        {
            JOptionPane.showMessageDialog(null, "Please collect the cash");

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please collect the coupons");
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        MainUI mainUI = new MainUI();
        setVisible(false);
        mainUI.setVisible(true);
    }

    private void rcmListCustValueChanged(javax.swing.event.ListSelectionEvent evt) {
        /*
        		    String itemDetails="";
        			selectedRCMName=(String) rcmListCust.getSelectedValue();
        			String selectedRCM = selectedRCMName.substring(4,selectedRCMName.length() );
        			macID=Integer.parseInt(selectedRCM);
        			for(int i=0;i<rcmNamesList.size();i++)
        			{
        				String s= rcmNamesList.get(i).getMachineId()+"";
        				if(s.equals(selectedRCM))
        				{					
        					int noOfItems = rcmNamesList.get(i).getNumberOfItems();
        					double capacity = rcmNamesList.get(i).getAvailableCapacity();
        					Date date = rcmNamesList.get(i).getLastTimeMachineEmptied();
        					//rcmList.get(i).getAllSupportedItemTypes().get(i).getName()
        					OperationalStatus OperationalStatus = rcmNamesList.get(i).getOperational();
        					itemDetails = "Machine ID:\t" + s +"\nNumber of items\t"+ noOfItems + "\nAvailable capacity:\t\t "+ capacity+"\nLast emptied:\t\t\t"+date+
        							"\nOpretational status:\t\t"+ OperationalStatus+"\t";
        					
        					
        				}					
        			}
        			
        			RecycleMachineMonitor rm= new RecycleMachineMonitor();
        			List<ItemType> as= rm.getItemTypesByMachineId(macID);
        			//as=rm.getItemTypesByMachineId(macID);
        			String items="";
        			for(int i=0;i<as.size();i++)
        			{
        			 items=items+as.get(i).getName()+"  "+as.get(i).getPricePerLb();
        			}
        			itemDetails= itemDetails+ "\nItem Details::\t\t "+ items;
        			
        			rcm_textArea.setText(itemDetails);*/

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(customerUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addTocart_btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cashCoupons_box;
    private javax.swing.JButton checkOut_btn;
    private javax.swing.JComboBox items_combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField price_field;
    private javax.swing.JTextField qty_field;
    private javax.swing.JLabel rcmDetail_label;
    private javax.swing.JList rcmListCust;
    private javax.swing.JLabel rcmNames_label;
    private javax.swing.JTextArea rcm_textArea;
    private javax.swing.JTextField weight_field;

    RecycleMachineMonitor rmos2 = new RecycleMachineMonitor();
    List<Item> shopCart = new ArrayList();
    ArrayList<RecycleMachine> rcmNamesList = new ArrayList<RecycleMachine>();
    String[] rcmNamesCust = new String[10];
    String[] itemNames;
    static String selectedRCMName = new String();

    int macID;

    // End of variables declaration                   
}