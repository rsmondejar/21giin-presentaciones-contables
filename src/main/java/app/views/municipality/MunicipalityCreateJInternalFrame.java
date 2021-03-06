/**
 * Municipality Create JInternal Frame
 *
 * @author raulsm
 */
package app.views.municipality;

import app.controllers.MunicipalityController;
import app.entities.Municipality;
import helpers.Dialog;
import helpers.Log;
import java.awt.Color;

/**
 * Municipality Create JInternal Frame
 *
 * @author raulsm
 */
public class MunicipalityCreateJInternalFrame extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form MunicipalityJInternalFrame
     */
    public MunicipalityCreateJInternalFrame() {
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

        jLabelMunicipioName = new javax.swing.JLabel();
        jTextFieldMunicipioName = new javax.swing.JTextField();
        jLabelMunicipioCategoria = new javax.swing.JLabel();
        jButtonMunicipioCreate = new javax.swing.JButton();
        jComboBoxMunicipioCategory = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Municipio");
        setToolTipText("");

        jLabelMunicipioName.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelMunicipioName.setText("Nombre del municipio:");

        jTextFieldMunicipioName.setToolTipText("Introducir nombre del municipio");
        jTextFieldMunicipioName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldMunicipioNameenableLoginButton(evt);
            }
        });

        jLabelMunicipioCategoria.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelMunicipioCategoria.setText("Categoría del municipio:");

        jButtonMunicipioCreate.setText("Crear");
        jButtonMunicipioCreate.setEnabled(false);
        jButtonMunicipioCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMunicipioCreateActionPerformed(evt);
            }
        });

        jComboBoxMunicipioCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMunicipioName)
                    .addComponent(jLabelMunicipioName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonMunicipioCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxMunicipioCategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMunicipioCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMunicipioName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMunicipioName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMunicipioCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxMunicipioCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(jButtonMunicipioCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unused")
    private void jTextFieldMunicipioNameenableLoginButton(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMunicipioNameenableLoginButton
        try {
            jButtonMunicipioCreate.setEnabled(validateInputs());
        } catch (Exception e) {
            Log.error(e);
        }
    }//GEN-LAST:event_jTextFieldMunicipioNameenableLoginButton

    @SuppressWarnings("unused")
    private void jButtonMunicipioCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMunicipioCreateActionPerformed
        try {
            if (!validateInputs()) {
                throw new Exception("Inputs fieds are invalid.");
            }

            String name = getInputName();
            String category = getInputCategory();

            // Municipio create
            Municipality municipality = new Municipality(name, Integer.parseInt(category));
            MunicipalityController.create(municipality);
            
            Dialog.info("Municipio creado correctamente", "Info");
            
            cleanInputs();
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando municipio");
        }
    }//GEN-LAST:event_jButtonMunicipioCreateActionPerformed

    /**
     * Clean Inputs
     */
    private void cleanInputs() {
        jTextFieldMunicipioName.setText("");
        jComboBoxMunicipioCategory.setSelectedIndex(0);
        jButtonMunicipioCreate.setEnabled(validateInputs());
    }
    
    /**
     * Validate Inputs.
     *
     * @return True if inputs are valid
     */
    private Boolean validateInputs() {
        return validateInputName() && validateInputCategory();
    }

    /**
     * Validate Input Name.
     *
     * @return
     */
    private Boolean validateInputName() {
        String name = getInputName();
        Boolean isValid = name.length() > 0 && name.length() <= 30;

        if (isValid || name.length() == 0) {
            jTextFieldMunicipioName.setBackground(Color.white);
        } else {
            jTextFieldMunicipioName.setBackground(Color.orange);
        }

        return isValid;
    }

    /**
     * Validate Input Category.
     *
     * @return
     */
    private Boolean validateInputCategory() {
        // TODO: Validation
        Boolean isValid = true;
        return isValid;
    }

    /**
     * Get Input Name.
     *
     * @return Input Name
     */
    private String getInputName() {
        return jTextFieldMunicipioName.getText();
    }

    /**
     * Get Input Category.
     *
     * @return Input Category.
     */
    private String getInputCategory() {
        return jComboBoxMunicipioCategory.getSelectedItem().toString();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMunicipioCreate;
    private javax.swing.JComboBox<String> jComboBoxMunicipioCategory;
    private javax.swing.JLabel jLabelMunicipioCategoria;
    private javax.swing.JLabel jLabelMunicipioName;
    private javax.swing.JTextField jTextFieldMunicipioName;
    // End of variables declaration//GEN-END:variables
}
