/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package app.views.municipality;

import app.controllers.MunicipalityController;
import app.entities.Municipality;
import helpers.Dialog;
import helpers.Log;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author raulsm
 */
public class MunicipalityShowJInternalFrame extends javax.swing.JInternalFrame {

    private final JDesktopPane jDesktopPanelContainer;
    
    /**
     * Creates new form MunicipalityJInternalFrame
     * @param jDesktopPanelContainer
     */
    public MunicipalityShowJInternalFrame(JDesktopPane jDesktopPanelContainer) {
        initComponents();
        this.jDesktopPanelContainer = jDesktopPanelContainer;
        jTextFieldMunicipioId.setVisible(false);
    }

    /**
     * Load Data.
     * @param municipality
     */
    public void loadData(Municipality municipality) {        
        jTextFieldMunicipioName.setText(municipality.getName());
        jComboBoxMunicipioCategory.setSelectedIndex(0); // @TODO
        jTextFieldMunicipioId.setText(String.valueOf(municipality.getId()));
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
        jButtonMunicipioEdit = new javax.swing.JButton();
        jComboBoxMunicipioCategory = new javax.swing.JComboBox<>();
        jTextFieldMunicipioId = new javax.swing.JTextField();
        jButtonMunicipioDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver Municipio");
        setToolTipText("");

        jLabelMunicipioName.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelMunicipioName.setText("Nombre del municipio:");

        jTextFieldMunicipioName.setToolTipText("Introducir nombre del municipio");
        jTextFieldMunicipioName.setEnabled(false);

        jLabelMunicipioCategoria.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelMunicipioCategoria.setText("Categoría del municipio:");

        jButtonMunicipioEdit.setText("Editar");
        jButtonMunicipioEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMunicipioEditActionPerformed(evt);
            }
        });

        jComboBoxMunicipioCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        jComboBoxMunicipioCategory.setEnabled(false);

        jTextFieldMunicipioId.setEditable(false);
        jTextFieldMunicipioId.setEnabled(false);

        jButtonMunicipioDelete.setBackground(new java.awt.Color(255, 153, 153));
        jButtonMunicipioDelete.setText("Eliminar");
        jButtonMunicipioDelete.setBorderPainted(false);
        jButtonMunicipioDelete.setOpaque(true);
        jButtonMunicipioDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMunicipioDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMunicipioName)
                    .addComponent(jLabelMunicipioName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxMunicipioCategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMunicipioCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldMunicipioId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonMunicipioDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMunicipioEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMunicipioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMunicipioEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMunicipioDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unused")
    private void jButtonMunicipioEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMunicipioEditActionPerformed
        try {

            int id = Integer.parseInt(jTextFieldMunicipioId.getText());
            Municipality municipality = MunicipalityController.findById(id);
            
            MunicipalityEditJInternalFrame municipalitiesEdit = new MunicipalityEditJInternalFrame();
        
            jDesktopPanelContainer.add(municipalitiesEdit);
        
            // Load municipio info in view
            municipalitiesEdit.loadData(municipality);
            
            municipalitiesEdit.setVisible(true);
        } catch (NumberFormatException e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creaando municipio");
        }
    }//GEN-LAST:event_jButtonMunicipioEditActionPerformed

    @SuppressWarnings("unused")
    private void jButtonMunicipioDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMunicipioDeleteActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Deseas eliminar?");
        // 0=yes, 1=no, 2=cancel
        
        if (input == 0) {
            // Delete
            int id = Integer.parseInt(jTextFieldMunicipioId.getText());
            boolean status = MunicipalityController.delete(id);
            
            if (status) {
                Dialog.info("Municipio eliminado correctamente", "Info");
                
                this.hide();
            } else {
                Dialog.error("Municipio no se ha eliminado", "Error");
            }
        }
        
    }//GEN-LAST:event_jButtonMunicipioDeleteActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMunicipioDelete;
    private javax.swing.JButton jButtonMunicipioEdit;
    private javax.swing.JComboBox<String> jComboBoxMunicipioCategory;
    private javax.swing.JLabel jLabelMunicipioCategoria;
    private javax.swing.JLabel jLabelMunicipioName;
    private javax.swing.JTextField jTextFieldMunicipioId;
    private javax.swing.JTextField jTextFieldMunicipioName;
    // End of variables declaration//GEN-END:variables
}
