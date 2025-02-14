/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaproject.AWT_AND_SWING;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Admin
 */
public class ShowTask extends javax.swing.JFrame {
    
    JTable table;
    
    Connection con= null;
    PreparedStatement smt = null;
    ResultSet rs = null;
    /**
     * Creates new form ShowTask
     */
    public ShowTask() {
        initComponents();
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        JLabel l1 = new JLabel("Sno");
        l1.setBounds(300, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Tasks");
        l2.setBounds(10, 10, 100, 20);
        add(l2);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackBtn = new javax.swing.JButton();
        UserTxt = new javax.swing.JTextField();
        Username = new javax.swing.JLabel();
        SearchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        BackBtn.setBackground(new java.awt.Color(102, 255, 102));
        BackBtn.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        BackBtn.setText("Back");
        BackBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        getContentPane().add(BackBtn);
        BackBtn.setBounds(420, 440, 55, 32);
        getContentPane().add(UserTxt);
        UserTxt.setBounds(610, 10, 170, 30);

        Username.setBackground(new java.awt.Color(102, 255, 102));
        Username.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        Username.setText("Username :");
        Username.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(Username);
        Username.setBounds(510, 10, 83, 30);

        SearchBtn.setBackground(new java.awt.Color(102, 255, 102));
        SearchBtn.setFont(new java.awt.Font("Segoe Print", 3, 14)); // NOI18N
        SearchBtn.setText("Search");
        SearchBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });
        getContentPane().add(SearchBtn);
        SearchBtn.setBounds(650, 60, 70, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        Main m = new Main();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        if(UserTxt.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Please Enter the Username");
        }
        else{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "root");
                smt = con.prepareStatement("select task,Sno from tasks where username = ?");
                smt.setString(1, UserTxt.getText());
                rs = smt.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                rs.close();
                smt.close();
                con.close();
                
            } catch (ClassNotFoundException | SQLException ex){
                Logger.getLogger(ShowTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShowTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ShowTask().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField UserTxt;
    private javax.swing.JLabel Username;
    // End of variables declaration//GEN-END:variables
}
