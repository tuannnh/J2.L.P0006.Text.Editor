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
public class FindWindow extends javax.swing.JDialog {

    /**
     * Creates new form Find
     */
    public FindWindow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JButton getBtnFind() {
        return btnFind;
    }

    public JTextField getTxtFind() {
        return txtFind;
    }

    public JButton getBtnCancel() {
        return btnCancel;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        jLabel1.setText("Keyword:");
        jLabel1.setPreferredSize(new java.awt.Dimension(75, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtFind.setPreferredSize(new java.awt.Dimension(200, 30));
        getContentPane().add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        btnFind.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        btnFind.setText("Find");
        btnFind.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        btnCancel.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 15)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}