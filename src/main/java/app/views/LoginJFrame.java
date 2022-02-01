/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.views;

import app.controllers.LoginController;
import helpers.Dialog;
import helpers.Log;
import java.awt.Color;

/**
 *
 * @author raulsm
 */
public class LoginJFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginJFrame
     */
    public LoginJFrame() {
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

        jLabelTitle = new javax.swing.JLabel();
        jLabelUserName = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jLabelUserPassword = new javax.swing.JLabel();
        jButtonLoggin = new javax.swing.JButton();
        jPasswordFieldUserPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frameLogin"); // NOI18N
        setResizable(false);

        jLabelTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Presentaciones Contables");

        jLabelUserName.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelUserName.setText("Nombre de usuario:");

        jTextFieldUserName.setToolTipText("Introducir nombre de usuario");
        jTextFieldUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enableLoginButton(evt);
            }
        });

        jLabelUserPassword.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelUserPassword.setText("Contraseña");

        jButtonLoggin.setText("Iniciar sesión");
        jButtonLoggin.setEnabled(false);
        jButtonLoggin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogginActionPerformed(evt);
            }
        });

        jPasswordFieldUserPassword.setToolTipText("Introducir contraseña");
        jPasswordFieldUserPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enableLoginButton(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPasswordFieldUserPassword)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUserPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLoggin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUserPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLoggin, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogginActionPerformed
        try {
            if (!validateInputs()) {
                throw new Exception("Inputs fieds are invalid.");
            }

            String name = getInputName();
            String password = getInputPassword();

            LoginController.loggin(name, password);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error loggin");
        }
    }//GEN-LAST:event_jButtonLogginActionPerformed

    private void enableLoginButton(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enableLoginButton
        try {
            jButtonLoggin.setEnabled(validateInputs());
        } catch (Exception e) {
            Log.error(e);
        }
    }//GEN-LAST:event_enableLoginButton

    /**
     * Validate Inputs.
     *
     * @return True if inputs are valid
     */
    private Boolean validateInputs() {
        return validateInputLogin() && validateInputPassword();
    }

    /**
     * Validate Input Login.
     *
     * @return
     */
    private Boolean validateInputLogin() {
        String name = getInputName();
        Boolean isValid = name.length() >= 1 && name.length() <= 10;

        if (isValid || name.length() == 0) {
            jTextFieldUserName.setBackground(Color.white);
        } else {
            jTextFieldUserName.setBackground(Color.orange);
        }

        return isValid;
    }

    /**
     * Validate Input Password.
     *
     * @return
     */
    private Boolean validateInputPassword() {
        String password = getInputPassword();
        Boolean isValid = password.length() >= 4 && password.length() <= 8;

        if (isValid || password.length() == 0) {
            jPasswordFieldUserPassword.setBackground(Color.white);
        } else {
            jPasswordFieldUserPassword.setBackground(Color.orange);
        }

        return isValid;
    }

    /**
     * Get Input Name.
     *
     * @return Input Name
     */
    private String getInputName() {
        return jTextFieldUserName.getText();
    }

    /**
     * Get Input Password.
     *
     * @return Input Password.
     */
    private String getInputPassword() {
        return String.valueOf(jPasswordFieldUserPassword.getPassword());
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLoggin;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JLabel jLabelUserPassword;
    private javax.swing.JPasswordField jPasswordFieldUserPassword;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}