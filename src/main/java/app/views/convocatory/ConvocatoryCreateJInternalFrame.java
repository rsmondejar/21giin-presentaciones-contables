/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package app.views.convocatory;

import app.controllers.ConvocatoryController;
import app.dao.DocumentTypeDao;
import app.entities.Convocatory;
import app.entities.DocumentType;
import helpers.Dialog;
import helpers.Log;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raulsm
 */
public class ConvocatoryCreateJInternalFrame extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form ConvocatoryShowJInternalFrame
     */
    public ConvocatoryCreateJInternalFrame() {
        initComponents();
        jTextFieldConvocatoryId.setVisible(false);
    }

    /**
     * Load Data.
     * @param convocatory
     */
    public void loadData(Convocatory convocatory) {        
        jTextFieldConvocatoryName.setText(convocatory.getName());
        jTextAreaConvocatoryDescription.setText(convocatory.getDescription());
        jDateChooserStartDate.setDateFormatString(convocatory.getStartDate().toString());
        jDateChooserEndDate.setDateFormatString(convocatory.getEndDate().toString());
        jCheckBoxConvocatoryStatus.setSelected(convocatory.getIsValid());
        
        jTextFieldConvocatoryId.setText(String.valueOf(convocatory.getId()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelConvocatoryName = new javax.swing.JLabel();
        jTextFieldConvocatoryName = new javax.swing.JTextField();
        jLabelConvocatoryDescription = new javax.swing.JLabel();
        jButtonConvocatoryCreate = new javax.swing.JButton();
        jTextFieldConvocatoryId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaConvocatoryDescription = new javax.swing.JTextArea();
        jLabelConvocatoryStartDate = new javax.swing.JLabel();
        jDateChooserStartDate = new com.toedter.calendar.JDateChooser();
        jLabelConvocatoryStatus = new javax.swing.JLabel();
        jDateChooserEndDate = new com.toedter.calendar.JDateChooser();
        jLabelConvocatoryEndDate1 = new javax.swing.JLabel();
        jCheckBoxConvocatoryStatus = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxDocumentTypeId1 = new javax.swing.JCheckBox();
        jCheckBoxDocumentTypeId2 = new javax.swing.JCheckBox();
        jCheckBoxDocumentTypeId3 = new javax.swing.JCheckBox();
        jCheckBoxDocumentTypeId4 = new javax.swing.JCheckBox();
        jCheckBoxDocumentTypeId5 = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Convocatoria");
        setToolTipText("");

        jLabelConvocatoryName.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatoryName.setText("Nombre de la convocatoria:");

        jTextFieldConvocatoryName.setToolTipText("Introducir nombre del municipio");

        jLabelConvocatoryDescription.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatoryDescription.setText("Descripción:");

        jButtonConvocatoryCreate.setText("Crear");
        jButtonConvocatoryCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConvocatoryCreateActionPerformed(evt);
            }
        });

        jTextFieldConvocatoryId.setEditable(false);
        jTextFieldConvocatoryId.setEnabled(false);

        jTextAreaConvocatoryDescription.setColumns(20);
        jTextAreaConvocatoryDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaConvocatoryDescription);

        jLabelConvocatoryStartDate.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatoryStartDate.setText("Fecha inicio:");

        jDateChooserStartDate.setDateFormatString("yyyy-MM-dd");

        jLabelConvocatoryStatus.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatoryStatus.setText("Estado Apertura?:");

        jDateChooserEndDate.setDateFormatString("yyyy-MM-dd");

        jLabelConvocatoryEndDate1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatoryEndDate1.setText("Fecha inicio:");

        jCheckBoxConvocatoryStatus.setText("¿Activa?");

        jLabel1.setText("Documentos necesarios:");

        jCheckBoxDocumentTypeId1.setText("Libro Diario");

        jCheckBoxDocumentTypeId2.setText("Libro Mayor");

        jCheckBoxDocumentTypeId3.setText("Balance de Sumas y Saldos");

        jCheckBoxDocumentTypeId4.setText("Registro de Ingreso de Caja");

        jCheckBoxDocumentTypeId5.setText("Registro de Movimientos de Bancos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConvocatoryCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelConvocatoryName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelConvocatoryDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelConvocatoryStartDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldConvocatoryId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserStartDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelConvocatoryEndDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxConvocatoryStatus)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabelConvocatoryStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxDocumentTypeId1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxDocumentTypeId2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxDocumentTypeId3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxDocumentTypeId4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxDocumentTypeId5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldConvocatoryName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelConvocatoryName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldConvocatoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelConvocatoryDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConvocatoryStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConvocatoryEndDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConvocatoryStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxConvocatoryStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldConvocatoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDocumentTypeId1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDocumentTypeId2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDocumentTypeId3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDocumentTypeId4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxDocumentTypeId5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConvocatoryCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unused")
    private void jButtonConvocatoryCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConvocatoryCreateActionPerformed
        try {
            if (!validateInputs()) {
                throw new Exception("Inputs fieds are invalid.");
            }

            String name = getInputName();
            String description = getInputDescription();
            Date startDate = getInputStartDate();
            Date endDate = getInputEndDate();
            Boolean status = getInputStatus();
            List<DocumentType> documentsTypes = getInputDocumentTypesSelected();
            
            // Convocatory create
            Convocatory convocatory = new Convocatory(name, description, startDate, endDate, status, documentsTypes);
            ConvocatoryController.create(convocatory);
            
            Dialog.info("Convocatoria creada correctamente", "Info");
            
            cleanInputs();
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando municipio");
        }
    }//GEN-LAST:event_jButtonConvocatoryCreateActionPerformed

    /**
     * Clean Inputs
     */
    private void cleanInputs() {
        jTextFieldConvocatoryName.setText("");
        jTextAreaConvocatoryDescription.setText("");
        
        jDateChooserStartDate.setDate(null);
        jDateChooserEndDate.setDate(null);
        
        jCheckBoxConvocatoryStatus.setSelected(false);
        
        jCheckBoxDocumentTypeId1.setSelected(false);
        jCheckBoxDocumentTypeId2.setSelected(false);
        jCheckBoxDocumentTypeId3.setSelected(false);
        jCheckBoxDocumentTypeId4.setSelected(false);
        jCheckBoxDocumentTypeId5.setSelected(false);
        
        jButtonConvocatoryCreate.setEnabled(validateInputs());
    }
    
    /**
     * Validate Inputs.
     *
     * @return True if inputs are valid
     */
    private Boolean validateInputs() {
        return validateInputName() 
                && validateInputDescription()
                && validateInputStartDate()
                && validateInputEndDate();
    }

    /**
     * Validate Input Name.
     *
     * @return
     */
    private Boolean validateInputName() {
        String name = getInputName();
        Boolean isValid = name.length() > 0 && name.length() <= 100;

        if (isValid || name.length() == 0) {
            jTextFieldConvocatoryName.setBackground(Color.white);
        } else {
            jTextFieldConvocatoryName.setBackground(Color.orange);
        }

        return isValid;
    }
    
    /**
     * Validate Input Description.
     *
     * @return
     */
    private Boolean validateInputDescription() {
        String name = getInputDescription();
        Boolean isValid = name.length() > 0 && name.length() <= 2000;

        if (isValid || name.length() == 0) {
            jTextAreaConvocatoryDescription.setBackground(Color.white);
        } else {
            jTextAreaConvocatoryDescription.setBackground(Color.orange);
        }

        return isValid;
    }

    /**
     * Validate Input Start Date.
     *
     * @return
     */
    private Boolean validateInputStartDate() {
        Date startDate = jDateChooserStartDate.getDate();
        Boolean isValid = startDate != null;

        if (isValid) {
            jDateChooserStartDate.setBackground(Color.white);
        } else {
            jDateChooserStartDate.setBackground(Color.orange);
        }

        return isValid;
    }
    
    /**
     * Validate Input End Date.
     *
     * @return
     */
    private Boolean validateInputEndDate() {
        Date startDate = jDateChooserStartDate.getDate();
        Date endDate = jDateChooserEndDate.getDate();
        Boolean isValid = endDate != null && (endDate.compareTo(startDate) > 0);

        if (isValid) {
            jDateChooserEndDate.setBackground(Color.white);
        } else {
            jDateChooserEndDate.setBackground(Color.orange);
        }

        return isValid;
    }


    /**
     * Get Input Name.
     *
     * @return Input Name
     */
    private String getInputName() {
        return jTextFieldConvocatoryName.getText();
    }

    /**
     * Get Input Description.
     *
     * @return Input Category.
     */
    private String getInputDescription() {
        return jTextAreaConvocatoryDescription.getText();
    }
    
    /**
     * Get Input Start Date.
     * @return Input Start Date.
     */
    private Date getInputStartDate() {
        return jDateChooserStartDate.getDate();
    }
    
    /**
     * Get Input End Date.
     * @return Input Start Date.
     */
    private Date getInputEndDate() {
        return jDateChooserEndDate.getDate();
    }
    
    /**
     * Get Input Status.
     * @return Input Status.
     */
    private boolean getInputStatus() {
        return jCheckBoxConvocatoryStatus.isSelected();
    }
    
    /**
     * Get Input Document Type Id 1.
     * @return Input Document Type Id 1.
     */
    private boolean getInputDocumentTypeId1() {
        return jCheckBoxDocumentTypeId1.isSelected();
    }
    
    /**
     * Get Input Document Type Id 2.
     * @return Input Document Type Id 2.
     */
    private boolean getInputDocumentTypeId2() {
        return jCheckBoxDocumentTypeId2.isSelected();
    }
    
    /**
     * Get Input Document Type Id 3.
     * @return Input Document Type Id 3.
     */
    private boolean getInputDocumentTypeId3() {
        return jCheckBoxDocumentTypeId3.isSelected();
    }
    
    /**
     * Get Input Document Type Id 4.
     * @return Input Document Type Id 4.
     */
    private boolean getInputDocumentTypeId4() {
        return jCheckBoxDocumentTypeId4.isSelected();
    }
    
    /**
     * Get Input Document Type Id 5.
     * @return Input Document Type Id 5.
     */
    private boolean getInputDocumentTypeId5() {
        return jCheckBoxDocumentTypeId5.isSelected();
    }
    
    /**
     * Get Input Document Types Selected
     * @return Documents Types Selected
     */
    private List<DocumentType> getInputDocumentTypesSelected() {
        List<DocumentType> documentsTypes = new ArrayList<>();
        
        DocumentTypeDao documentTypeDao = new DocumentTypeDao();
            
        if (getInputDocumentTypeId1()) {
            documentsTypes.add(documentTypeDao.findById(1));
        }

        if (getInputDocumentTypeId2()) {
            documentsTypes.add(documentTypeDao.findById(2));
        }

        if (getInputDocumentTypeId3()) {
           documentsTypes.add(documentTypeDao.findById(3));
        }

        if (getInputDocumentTypeId4()) {
            documentsTypes.add(documentTypeDao.findById(4));
        }

        if (getInputDocumentTypeId5()) {
            documentsTypes.add(documentTypeDao.findById(5));
        }
            
        return documentsTypes;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConvocatoryCreate;
    private javax.swing.JCheckBox jCheckBoxConvocatoryStatus;
    private javax.swing.JCheckBox jCheckBoxDocumentTypeId1;
    private javax.swing.JCheckBox jCheckBoxDocumentTypeId2;
    private javax.swing.JCheckBox jCheckBoxDocumentTypeId3;
    private javax.swing.JCheckBox jCheckBoxDocumentTypeId4;
    private javax.swing.JCheckBox jCheckBoxDocumentTypeId5;
    private com.toedter.calendar.JDateChooser jDateChooserEndDate;
    private com.toedter.calendar.JDateChooser jDateChooserStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelConvocatoryDescription;
    private javax.swing.JLabel jLabelConvocatoryEndDate1;
    private javax.swing.JLabel jLabelConvocatoryName;
    private javax.swing.JLabel jLabelConvocatoryStartDate;
    private javax.swing.JLabel jLabelConvocatoryStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaConvocatoryDescription;
    private javax.swing.JTextField jTextFieldConvocatoryId;
    private javax.swing.JTextField jTextFieldConvocatoryName;
    // End of variables declaration//GEN-END:variables
}
