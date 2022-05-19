/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package app.views.users;

import app.controllers.MunicipalityController;
import app.controllers.UserController;
import app.controllers.UserRoleController;
import app.entities.Municipality;
import app.entities.User;
import app.entities.UserRole;
import helpers.ComboBox;
import helpers.Dialog;
import helpers.Log;
import java.awt.Color;
import java.util.List;
import javax.swing.JDesktopPane;

/**
 *
 * @author raulsm
 */
public class UserCreateJInternalFrame extends javax.swing.JInternalFrame {

    private final JDesktopPane jDesktopPanelContainer;

    /**
     * Creates new form MunicipalityJInternalFrame
     */
    public UserCreateJInternalFrame(JDesktopPane jDesktopPanelContainer) {
        initComponents();
        this.jDesktopPanelContainer = jDesktopPanelContainer;
        loadData();
    }

    /**
     * Load Data.
     */
    public void loadData() {
        jButtonUserCreate.setEnabled(validateInputs());

        // Traer de base de datos el listado de roles y agregar al combobox
        List<UserRole> userRoles = UserRoleController.list();
        ComboBox.fill(userRoles, jComboBoxUserRole);

        // Traer de base de datos el listado de Municipios y agregar al combobox
        List<Municipality> municipalities = MunicipalityController.list();
        ComboBox.fill(municipalities, jComboBoxMunicipality);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonUserCreate = new javax.swing.JButton();
        jLabelUserMunicipality = new javax.swing.JLabel();
        jLabelUserRole = new javax.swing.JLabel();
        jPasswordFieldUserPassword = new javax.swing.JPasswordField();
        jLabelUserPassword = new javax.swing.JLabel();
        jTextFieldUserLogin = new javax.swing.JTextField();
        jLabelUserLogin = new javax.swing.JLabel();
        jComboBoxUserRole = new javax.swing.JComboBox<>();
        jComboBoxMunicipality = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Usuario");
        setToolTipText("");

        jButtonUserCreate.setText("Crear");
        jButtonUserCreate.setEnabled(false);
        jButtonUserCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserCreateActionPerformed(evt);
            }
        });

        jLabelUserMunicipality.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelUserMunicipality.setText("Municipio usuario:");

        jLabelUserRole.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelUserRole.setText("Role usuario:");

        jPasswordFieldUserPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enableCreateButton(evt);
            }
        });

        jLabelUserPassword.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelUserPassword.setText("Contraseña usuario:");

        jTextFieldUserLogin.setToolTipText("Introducir nombre del municipio");
        jTextFieldUserLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                enableCreateButton(evt);
            }
        });

        jLabelUserLogin.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelUserLogin.setText("Login usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonUserCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addComponent(jTextFieldUserLogin)
                    .addComponent(jLabelUserLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelUserPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addComponent(jPasswordFieldUserPassword)
                    .addComponent(jLabelUserRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelUserMunicipality, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxUserRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxMunicipality, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUserLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUserRole)
                .addGap(5, 5, 5)
                .addComponent(jComboBoxUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUserMunicipality, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxMunicipality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonUserCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void jButtonUserCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserCreateActionPerformed
        try {
            if (!validateInputs()) {
                throw new Exception("Inputs fieds are invalid.");
            }

            String login = getInputLogin();
            String password = getInputPassword();
            int roleId = getInputUserRole().getId();
            int municipalityId = getInputMunicipality().getId();

            // User create
            User user = new User(login, password, roleId, municipalityId);
            UserController.create(user);

            Dialog.info("Usuario creado correctamente", "Info");

            cleanInputs();
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando usuario");
        }
    }//GEN-LAST:event_jButtonUserCreateActionPerformed

    /**
     * Enable Create Button Event.
     *
     * @param evt
     */
    @SuppressWarnings("unchecked")
    private void enableCreateButton(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enableCreateButton
        try {
            jButtonUserCreate.setEnabled(validateInputs());
        } catch (Exception e) {
            Log.error(e);
        }
    }//GEN-LAST:event_enableCreateButton

    /**
     * Clean Inputs.
     */
    private void cleanInputs() {
        jTextFieldUserLogin.setText("");
        jPasswordFieldUserPassword.setText("");
        jComboBoxUserRole.setSelectedIndex(0);
        jComboBoxMunicipality.setSelectedIndex(0);
        validateInputs();
    }

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
        String name = getInputLogin();
        Boolean isValid = name.length() >= 1 && name.length() <= 10;

        if (isValid || name.length() == 0) {
            jTextFieldUserLogin.setBackground(Color.white);
        } else {
            jTextFieldUserLogin.setBackground(Color.orange);
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
     * Get Input Login.
     *
     * @return Input Name
     */
    private String getInputLogin() {
        return jTextFieldUserLogin.getText();
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
     * Get Input User Role.
     *
     * @return Input User Role.
     */
    private UserRole getInputUserRole() {
        return (UserRole) jComboBoxUserRole.getSelectedItem();
    }

    /**
     * Get Input Munipality.
     *
     * @return Input Munipality.
     */
    private Municipality getInputMunicipality() {
        return (Municipality) jComboBoxMunicipality.getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonUserCreate;
    private javax.swing.JComboBox<String> jComboBoxMunicipality;
    private javax.swing.JComboBox<String> jComboBoxUserRole;
    private javax.swing.JLabel jLabelUserLogin;
    private javax.swing.JLabel jLabelUserMunicipality;
    private javax.swing.JLabel jLabelUserPassword;
    private javax.swing.JLabel jLabelUserRole;
    private javax.swing.JPasswordField jPasswordFieldUserPassword;
    private javax.swing.JTextField jTextFieldUserLogin;
    // End of variables declaration//GEN-END:variables
}
