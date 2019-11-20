/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author tuannnh
 */
public class ReplaceWindow extends javax.swing.JDialog {

    /**
     * Creates new form Replace
     */
    public ReplaceWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnFind() {
        return btnFind;
    }

    public JButton getBtnReplace() {
        return btnReplace;
    }

    public JButton getBtnReplaceAll() {
        return btnReplaceAll;
    }

    public JTextField getTxtFind() {
        return txtFind;
    }

    public JTextField getTxtReplace() {
        return txtReplace;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtReplace = new javax.swing.JTextField();
        btnReplace = new javax.swing.JButton();
        btnReplaceAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        jLabel1.setText("Find:");
        jLabel1.setPreferredSize(new java.awt.Dimension(75, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtFind.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        btnFind.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        btnFind.setText("Find");
        btnFind.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        btnCancel.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        jLabel2.setText("Replace with:");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtReplace.setPreferredSize(new java.awt.Dimension(150, 30));
        getContentPane().add(txtReplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 150, -1));

        btnReplace.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        btnReplace.setText("Replace");
        btnReplace.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(btnReplace, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        btnReplaceAll.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        btnReplaceAll.setText("Replace all");
        btnReplaceAll.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(btnReplaceAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnReplace;
    private javax.swing.JButton btnReplaceAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtReplace;
    // End of variables declaration//GEN-END:variables
}
