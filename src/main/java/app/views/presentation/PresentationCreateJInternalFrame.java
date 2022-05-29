/**
 * Presentation Create JInternalFrame.
 */
package app.views.presentation;

import app.Main;
import app.controllers.ConvocatoryController;
import app.controllers.PresentationController;
import app.entities.Convocatory;
import app.entities.DocumentType;
import app.entities.Presentation;
import app.entities.PresentationDocumentType;
import app.entities.User;
import helpers.ComboBox;
import helpers.DateHelper;
import helpers.Dialog;
import helpers.filters.files.FileTypeFilterPDF;
import helpers.Log;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author raulsm
 */
public class PresentationCreateJInternalFrame extends javax.swing.JInternalFrame {

    String noFile = "Sin fichero";
    String documentTypeFileName1 = null,
            documentTypeFileName2 = null,
            documentTypeFileName3 = null,
            documentTypeFileName4 = null,
            documentTypeFileName5 = null;
    String documentTypeFileExtension1 = null,
            documentTypeFileExtension2 = null,
            documentTypeFileExtension3 = null,
            documentTypeFileExtension4 = null,
            documentTypeFileExtension5 = null;
    byte[] documentType1 = null,
            documentType2 = null,
            documentType3 = null,
            documentType4 = null,
            documentType5 = null;

    /**
     * Creates new form PresentationJInternalFrame.
     */
    public PresentationCreateJInternalFrame() {
        initComponents();
        loadData();
    }

    /**
     * Load Data.
     */
    public void loadData() {
        disableAllInputFiles();
        disableAllInputFilesDownload();
        disableAllInputFilesDelete();
        loadConvocatoriesComboBox();
        loadLoggedUserInfo();

        // Add ComboBox change event listener
        jComboBoxConvocatory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
                Convocatory convocatory = (Convocatory) comboBox.getSelectedItem();

                disableAllInputFiles();
                disableAllInputFilesDownload();
                disableAllInputFilesDelete();
                clearAllInputFiles();

                setDocumentsTypesRequiredForConvocatory(convocatory);
                setDatesConvocatory(convocatory);
            }
        });

        Convocatory convocatory = (Convocatory) jComboBoxConvocatory.getSelectedItem();
        setDocumentsTypesRequiredForConvocatory(convocatory);
        setDatesConvocatory(convocatory);
    }

    /**
     * Load Convocatories ComboBox.
     */
    private void loadConvocatoriesComboBox() {
        List<Convocatory> convocatories = ConvocatoryController.active();
        ComboBox.fill(convocatories, jComboBoxConvocatory);
    }

    /**
     * Set Dates Convocatory.
     */
    private void setDatesConvocatory(Convocatory convocatory) {
        jTextFieldConvocatoryStartDate.setText(DateHelper.formatToYMD(convocatory.getStartDate()));
        jTextFieldConvocatoryEndDate.setText(DateHelper.formatToYMD(convocatory.getEndDate()));
    }

    /**
     * Set Documents Types Required For Convocatory.
     * @param convocatory Convocatory
     */
    private void setDocumentsTypesRequiredForConvocatory(Convocatory convocatory) {
        List<DocumentType> documentTypes = convocatory.getDocumentsTypes();

        if (documentTypes != null) {
            for (DocumentType documentType : documentTypes) {
                int documentTypeID = documentType.getId();
                if (documentTypeID == 1) {
                    jButtonDocumentType1.setEnabled(true);
                }
                if (documentTypeID == 2) {
                    jButtonDocumentType2.setEnabled(true);
                }
                if (documentTypeID == 3) {
                    jButtonDocumentType3.setEnabled(true);
                }
                if (documentTypeID == 4) {
                    jButtonDocumentType4.setEnabled(true);
                }
                if (documentTypeID == 5) {
                    jButtonDocumentType5.setEnabled(true);
                }
            }
        }
    }

    /**
     * Get Documents Uploaded
     *
     * @param convocatory
     * @return
     */
    private List<PresentationDocumentType> getDocumentsUploaded(Convocatory convocatory) {
        List<DocumentType> documentTypes = convocatory.getDocumentsTypes();
        List<PresentationDocumentType> presentationDocumentTypes = new ArrayList<>();

        if (documentTypes != null) {
            for (DocumentType documentType : documentTypes) {
                int documentTypeID = documentType.getId();

                PresentationDocumentType presentationDocumentType = new PresentationDocumentType();
                presentationDocumentType.setDocumentTypeId(documentTypeID);
                byte[] documentContent = null;
                String fileName = null;
                String fileExtension = null;

                if (documentTypeID == 1 && documentType1.length > 0) {
                    documentContent = documentType1;
                    fileName = documentTypeFileName1;
                    fileExtension = documentTypeFileExtension1;
                }
                if (documentTypeID == 2 && documentType2.length > 0) {
                    documentContent = documentType2;
                    fileName = documentTypeFileName2;
                    fileExtension = documentTypeFileExtension2;
                }
                if (documentTypeID == 3 && documentType3.length > 0) {
                    documentContent = documentType3;
                    fileName = documentTypeFileName3;
                    fileExtension = documentTypeFileExtension3;
                }
                if (documentTypeID == 4 && documentType4.length > 0) {
                    documentContent = documentType4;
                    fileName = documentTypeFileName4;
                    fileExtension = documentTypeFileExtension4;
                }
                if (documentTypeID == 5 && documentType5.length > 0) {
                    documentContent = documentType5;
                    fileName = documentTypeFileName5;
                    fileExtension = documentTypeFileExtension5;
                }

                if (documentContent != null) {
                    presentationDocumentType.setContent(documentContent);
                    presentationDocumentType.setFileName(fileName);
                    presentationDocumentType.setFileExtension(fileExtension);
                    presentationDocumentTypes.add(presentationDocumentType);
                }
            }
        }

        return presentationDocumentTypes;
    }

    /**
     * Load Logged User Info
     */
    private void loadLoggedUserInfo() {
        User authUser = Main.getAuthUser();
        jTextFieldUserId.setText(String.valueOf(authUser.getId()));
        jTextFieldUserName.setText(authUser.getLogin());
    }

    /**
     * Disable All Input Files.
     */
    private void disableAllInputFiles() {
        jButtonDocumentType1.setEnabled(false);
        jButtonDocumentType2.setEnabled(false);
        jButtonDocumentType3.setEnabled(false);
        jButtonDocumentType4.setEnabled(false);
        jButtonDocumentType5.setEnabled(false);

    }

    /**
     * Disable All Input Files Download.
     */
    private void disableAllInputFilesDownload() {
        jButtonDocumentTypeDownload1.setEnabled(false);
        jButtonDocumentTypeDownload2.setEnabled(false);
        jButtonDocumentTypeDownload3.setEnabled(false);
        jButtonDocumentTypeDownload4.setEnabled(false);
        jButtonDocumentTypeDownload5.setEnabled(false);
    }

    /**
     * Disable All Input Files Delete.
     */
    private void disableAllInputFilesDelete() {
        jButtonDocumentTypeDelete1.setEnabled(false);
        jButtonDocumentTypeDelete2.setEnabled(false);
        jButtonDocumentTypeDelete3.setEnabled(false);
        jButtonDocumentTypeDelete4.setEnabled(false);
        jButtonDocumentTypeDelete5.setEnabled(false);
    }

    /**
     * Disable All Input Files.
     */
    private void clearAllInputFiles() {
        // @TODO: Delete previous added files
        jLabelDocumentType1.setText(noFile);
        jLabelDocumentType2.setText(noFile);
        jLabelDocumentType3.setText(noFile);
        jLabelDocumentType4.setText(noFile);
        jLabelDocumentType5.setText(noFile);
        documentType1 = null;
        documentType2 = null;
        documentType3 = null;
        documentType4 = null;
        documentType5 = null;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelConvocatory = new javax.swing.JLabel();
        jButtonMunicipioCreate = new javax.swing.JButton();
        jComboBoxConvocatory = new javax.swing.JComboBox<>();
        jLabelUser = new javax.swing.JLabel();
        jTextFieldUserId = new javax.swing.JTextField();
        jTextFieldUserName = new javax.swing.JTextField();
        jLabelNecesaryDocuments = new javax.swing.JLabel();
        jPanelDocumentType1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonDocumentType1 = new javax.swing.JButton();
        jLabelDocumentType1 = new javax.swing.JLabel();
        jButtonDocumentTypeDownload1 = new javax.swing.JButton();
        jButtonDocumentTypeDelete1 = new javax.swing.JButton();
        jPanelDocumentType2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonDocumentType2 = new javax.swing.JButton();
        jLabelDocumentType2 = new javax.swing.JLabel();
        jButtonDocumentTypeDelete2 = new javax.swing.JButton();
        jButtonDocumentTypeDownload2 = new javax.swing.JButton();
        jPanelDocumentType3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonDocumentType3 = new javax.swing.JButton();
        jLabelDocumentType3 = new javax.swing.JLabel();
        jButtonDocumentTypeDelete3 = new javax.swing.JButton();
        jButtonDocumentTypeDownload3 = new javax.swing.JButton();
        jPanelDocumentType4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButtonDocumentType4 = new javax.swing.JButton();
        jLabelDocumentType4 = new javax.swing.JLabel();
        jButtonDocumentTypeDelete4 = new javax.swing.JButton();
        jButtonDocumentTypeDownload4 = new javax.swing.JButton();
        jPanelDocumentType5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButtonDocumentType5 = new javax.swing.JButton();
        jLabelDocumentType5 = new javax.swing.JLabel();
        jButtonDocumentTypeDelete5 = new javax.swing.JButton();
        jButtonDocumentTypeDownload5 = new javax.swing.JButton();
        jLabelConvocatory1 = new javax.swing.JLabel();
        jTextFieldConvocatoryStartDate = new javax.swing.JTextField();
        jLabelConvocatory2 = new javax.swing.JLabel();
        jTextFieldConvocatoryEndDate = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Presentación");
        setToolTipText("");

        jLabelConvocatory.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatory.setText("Convocatoria:");

        jButtonMunicipioCreate.setText("Crear");
        jButtonMunicipioCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMunicipioCreateActionPerformed(evt);
            }
        });

        jComboBoxConvocatory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));

        jLabelUser.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelUser.setText("Nombre del usuario:");

        jTextFieldUserId.setEditable(false);
        jTextFieldUserId.setText("ID");
        jTextFieldUserId.setEnabled(false);

        jTextFieldUserName.setEditable(false);
        jTextFieldUserName.setText("Nombre Usuario");
        jTextFieldUserName.setEnabled(false);

        jLabelNecesaryDocuments.setText("Documentos necesarios:");

        jPanelDocumentType1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Libro Diario");

        jButtonDocumentType1.setText("Agregar");
        jButtonDocumentType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentType1ActionPerformed(evt);
            }
        });

        jLabelDocumentType1.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType1.setText("Sin fichero");

        jButtonDocumentTypeDownload1.setText("Ver");
        jButtonDocumentTypeDownload1.setEnabled(false);
        jButtonDocumentTypeDownload1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDownload1ActionPerformed(evt);
            }
        });

        jButtonDocumentTypeDelete1.setText("Borrar");
        jButtonDocumentTypeDelete1.setEnabled(false);
        jButtonDocumentTypeDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDocumentType1Layout = new javax.swing.GroupLayout(jPanelDocumentType1);
        jPanelDocumentType1.setLayout(jPanelDocumentType1Layout);
        jPanelDocumentType1Layout.setHorizontalGroup(
            jPanelDocumentType1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentType1Layout.createSequentialGroup()
                        .addComponent(jLabelDocumentType1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDelete1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDownload1))
                    .addGroup(jPanelDocumentType1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentType1))))
        );
        jPanelDocumentType1Layout.setVerticalGroup(
            jPanelDocumentType1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonDocumentType1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDocumentType1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocumentType1)
                    .addComponent(jButtonDocumentTypeDownload1)
                    .addComponent(jButtonDocumentTypeDelete1))
                .addContainerGap())
        );

        jPanelDocumentType2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Libro Mayor");

        jButtonDocumentType2.setText("Agregar");
        jButtonDocumentType2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentType2ActionPerformed(evt);
            }
        });

        jLabelDocumentType2.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType2.setText("Sin fichero");

        jButtonDocumentTypeDelete2.setText("Borrar");
        jButtonDocumentTypeDelete2.setEnabled(false);
        jButtonDocumentTypeDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDelete2ActionPerformed(evt);
            }
        });

        jButtonDocumentTypeDownload2.setText("Ver");
        jButtonDocumentTypeDownload2.setEnabled(false);
        jButtonDocumentTypeDownload2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDownload2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDocumentType2Layout = new javax.swing.GroupLayout(jPanelDocumentType2);
        jPanelDocumentType2.setLayout(jPanelDocumentType2Layout);
        jPanelDocumentType2Layout.setHorizontalGroup(
            jPanelDocumentType2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentType2Layout.createSequentialGroup()
                        .addComponent(jLabelDocumentType2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDelete2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDownload2))
                    .addGroup(jPanelDocumentType2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentType2))))
        );
        jPanelDocumentType2Layout.setVerticalGroup(
            jPanelDocumentType2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonDocumentType2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentType2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocumentType2)
                    .addGroup(jPanelDocumentType2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDocumentTypeDownload2)
                        .addComponent(jButtonDocumentTypeDelete2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDocumentType3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Balance de Sumas y Saldos");
        jLabel3.setToolTipText("");

        jButtonDocumentType3.setText("Agregar");
        jButtonDocumentType3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentType3ActionPerformed(evt);
            }
        });

        jLabelDocumentType3.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType3.setText("Sin fichero");

        jButtonDocumentTypeDelete3.setText("Borrar");
        jButtonDocumentTypeDelete3.setEnabled(false);
        jButtonDocumentTypeDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDelete3ActionPerformed(evt);
            }
        });

        jButtonDocumentTypeDownload3.setText("Ver");
        jButtonDocumentTypeDownload3.setEnabled(false);
        jButtonDocumentTypeDownload3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDownload3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDocumentType3Layout = new javax.swing.GroupLayout(jPanelDocumentType3);
        jPanelDocumentType3.setLayout(jPanelDocumentType3Layout);
        jPanelDocumentType3Layout.setHorizontalGroup(
            jPanelDocumentType3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentType3Layout.createSequentialGroup()
                        .addComponent(jLabelDocumentType3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDelete3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDownload3))
                    .addGroup(jPanelDocumentType3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentType3))))
        );
        jPanelDocumentType3Layout.setVerticalGroup(
            jPanelDocumentType3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonDocumentType3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentType3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocumentType3)
                    .addGroup(jPanelDocumentType3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDocumentTypeDownload3)
                        .addComponent(jButtonDocumentTypeDelete3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDocumentType4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Registro de Ingreso de Caja");
        jLabel4.setToolTipText("");

        jButtonDocumentType4.setText("Agregar");
        jButtonDocumentType4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentType4ActionPerformed(evt);
            }
        });

        jLabelDocumentType4.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType4.setText("Sin fichero");

        jButtonDocumentTypeDelete4.setText("Borrar");
        jButtonDocumentTypeDelete4.setEnabled(false);
        jButtonDocumentTypeDelete4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDelete4ActionPerformed(evt);
            }
        });

        jButtonDocumentTypeDownload4.setText("Ver");
        jButtonDocumentTypeDownload4.setEnabled(false);
        jButtonDocumentTypeDownload4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDownload4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDocumentType4Layout = new javax.swing.GroupLayout(jPanelDocumentType4);
        jPanelDocumentType4.setLayout(jPanelDocumentType4Layout);
        jPanelDocumentType4Layout.setHorizontalGroup(
            jPanelDocumentType4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentType4Layout.createSequentialGroup()
                        .addComponent(jLabelDocumentType4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDelete4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDownload4))
                    .addGroup(jPanelDocumentType4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentType4))))
        );
        jPanelDocumentType4Layout.setVerticalGroup(
            jPanelDocumentType4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonDocumentType4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentType4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocumentType4)
                    .addGroup(jPanelDocumentType4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDocumentTypeDownload4)
                        .addComponent(jButtonDocumentTypeDelete4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDocumentType5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Registro de Movimientos de Bancos");
        jLabel5.setToolTipText("");

        jButtonDocumentType5.setText("Agregar");
        jButtonDocumentType5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentType5ActionPerformed(evt);
            }
        });

        jLabelDocumentType5.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType5.setText("Sin fichero");

        jButtonDocumentTypeDelete5.setText("Borrar");
        jButtonDocumentTypeDelete5.setEnabled(false);
        jButtonDocumentTypeDelete5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDelete5ActionPerformed(evt);
            }
        });

        jButtonDocumentTypeDownload5.setText("Ver");
        jButtonDocumentTypeDownload5.setEnabled(false);
        jButtonDocumentTypeDownload5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDownload5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDocumentType5Layout = new javax.swing.GroupLayout(jPanelDocumentType5);
        jPanelDocumentType5.setLayout(jPanelDocumentType5Layout);
        jPanelDocumentType5Layout.setHorizontalGroup(
            jPanelDocumentType5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDocumentType5Layout.createSequentialGroup()
                        .addComponent(jLabelDocumentType5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDelete5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentTypeDownload5))
                    .addGroup(jPanelDocumentType5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDocumentType5))))
        );
        jPanelDocumentType5Layout.setVerticalGroup(
            jPanelDocumentType5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDocumentType5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButtonDocumentType5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentType5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocumentType5)
                    .addGroup(jPanelDocumentType5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDocumentTypeDownload5)
                        .addComponent(jButtonDocumentTypeDelete5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelConvocatory1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatory1.setText("Convocatoria fecha inicio:");

        jTextFieldConvocatoryStartDate.setEditable(false);

        jLabelConvocatory2.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatory2.setText("Convocatoria fecha fin:");

        jTextFieldConvocatoryEndDate.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDocumentType3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDocumentType2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDocumentType1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMunicipioCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(544, 544, 544))
                    .addComponent(jLabelConvocatory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                    .addComponent(jLabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUserName))
                    .addComponent(jPanelDocumentType5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNecesaryDocuments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxConvocatory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelConvocatory1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jTextFieldConvocatoryStartDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelConvocatory2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldConvocatoryEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelDocumentType4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelConvocatory, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConvocatory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelConvocatory1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelConvocatory2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldConvocatoryEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldConvocatoryStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNecesaryDocuments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDocumentType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDocumentType2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDocumentType3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDocumentType4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDocumentType5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonMunicipioCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Created Button Pressed
     * @param evt 
     */
    @SuppressWarnings("unused")
    private void jButtonMunicipioCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMunicipioCreateActionPerformed
        try {
            if (!validateInputs()) {
                throw new Exception("Inputs fieds are invalid.");
            }

            Convocatory convocatory = getInputConvocatory();
            int userId = getInputUserId();
            List<PresentationDocumentType> presentationDocumentsTypes = getDocumentsUploaded(convocatory);

            Presentation presentation = new Presentation();
            presentation.setConvocatoryId(convocatory.getId());
            presentation.setDate(DateHelper.today());
            presentation.setUserId(userId);
            presentation.setIsValid(true);
            presentation.setPresentationDocumentTypes(presentationDocumentsTypes);

            PresentationController.create(presentation);
            Dialog.info("Presentación creado correctamente", "Info");

            cleanInputs();
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando municipio");
        }
    }//GEN-LAST:event_jButtonMunicipioCreateActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentType1ActionPerformed
        loadFileContent(jLabelDocumentType1, 1);
    }//GEN-LAST:event_jButtonDocumentType1ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentType2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentType2ActionPerformed
        loadFileContent(jLabelDocumentType2, 2);
    }//GEN-LAST:event_jButtonDocumentType2ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentType3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentType3ActionPerformed
        loadFileContent(jLabelDocumentType3, 3);
    }//GEN-LAST:event_jButtonDocumentType3ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentType4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentType4ActionPerformed
        loadFileContent(jLabelDocumentType4, 4);
    }//GEN-LAST:event_jButtonDocumentType4ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentType5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentType5ActionPerformed
        loadFileContent(jLabelDocumentType5, 5);
    }//GEN-LAST:event_jButtonDocumentType5ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDelete1ActionPerformed
        deleteFile(1);
    }//GEN-LAST:event_jButtonDocumentTypeDelete1ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDelete2ActionPerformed
        deleteFile(2);
    }//GEN-LAST:event_jButtonDocumentTypeDelete2ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDelete3ActionPerformed
        deleteFile(3);
    }//GEN-LAST:event_jButtonDocumentTypeDelete3ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDelete4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDelete4ActionPerformed
        deleteFile(4);
    }//GEN-LAST:event_jButtonDocumentTypeDelete4ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDelete5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDelete5ActionPerformed
        deleteFile(5);
    }//GEN-LAST:event_jButtonDocumentTypeDelete5ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDownload1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDownload1ActionPerformed
        downloadFile(1);
    }//GEN-LAST:event_jButtonDocumentTypeDownload1ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDownload2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDownload2ActionPerformed
        downloadFile(2);
    }//GEN-LAST:event_jButtonDocumentTypeDownload2ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDownload3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDownload3ActionPerformed
        downloadFile(3);
    }//GEN-LAST:event_jButtonDocumentTypeDownload3ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDownload4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDownload4ActionPerformed
        downloadFile(4);
    }//GEN-LAST:event_jButtonDocumentTypeDownload4ActionPerformed

    @SuppressWarnings("unused")
    private void jButtonDocumentTypeDownload5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocumentTypeDownload5ActionPerformed
        downloadFile(5);
    }//GEN-LAST:event_jButtonDocumentTypeDownload5ActionPerformed

    /**
     * Delete Uploaded File
     *
     * @param documentType
     * @throws Exception
     */
    private void deleteFile(int documentType) {
        try {
            switch (documentType) {
                case 1:
                    documentType1 = null;
                    documentTypeFileName1 = null;
                    documentTypeFileExtension1 = null;
                    jButtonDocumentTypeDelete1.setEnabled(false);
                    jButtonDocumentTypeDownload1.setEnabled(false);
                    jLabelDocumentType1.setText(noFile);
                    break;
                case 2:
                    documentType2 = null;
                    documentTypeFileName2 = null;
                    documentTypeFileExtension2 = null;
                    jButtonDocumentTypeDelete2.setEnabled(false);
                    jButtonDocumentTypeDownload2.setEnabled(false);
                    jLabelDocumentType2.setText(noFile);
                    break;
                case 3:
                    documentType3 = null;
                    documentTypeFileName3 = null;
                    documentTypeFileExtension3 = null;
                    jButtonDocumentTypeDelete3.setEnabled(false);
                    jButtonDocumentTypeDownload3.setEnabled(false);
                    jLabelDocumentType3.setText(noFile);
                    break;
                case 4:
                    documentType4 = null;
                    documentTypeFileName4 = null;
                    documentTypeFileExtension4 = null;
                    jButtonDocumentTypeDelete4.setEnabled(false);
                    jButtonDocumentTypeDownload4.setEnabled(false);
                    jLabelDocumentType4.setText(noFile);
                    break;
                case 5:
                    documentType5 = null;
                    documentTypeFileName5 = null;
                    documentTypeFileExtension5 = null;
                    jButtonDocumentTypeDelete5.setEnabled(false);
                    jButtonDocumentTypeDownload5.setEnabled(false);
                    jLabelDocumentType5.setText(noFile);
                    break;
                default:
                    throw new Exception("Document type option ['%d'] is not valid".formatted(documentType));
            }
        } catch (Exception ex) {
            Dialog.error(ex.getMessage(), "Opción no valida");
            Log.error(ex);
        }
    }

    /**
     * Download File
     *
     * @param documentType
     * @throws Exception
     */
    private void downloadFile(int documentType) {
        JFileChooser fileChooser = new JFileChooser();
        byte[] documentContent;
        String fileName = null;

        try {
            switch (documentType) {
                case 1:
                    documentContent = documentType1;
                    fileName = documentTypeFileName1;
                    break;
                case 2:
                    documentContent = documentType2;
                    fileName = documentTypeFileName2;
                    break;
                case 3:
                    documentContent = documentType3;
                    fileName = documentTypeFileName3;
                    break;
                case 4:
                    documentContent = documentType4;
                    fileName = documentTypeFileName4;
                    break;
                case 5:
                    documentContent = documentType5;
                    fileName = documentTypeFileName5;
                    break;
                default:
                    throw new Exception("Document type option ['%d'] is not valid".formatted(documentType));
            }

            fileChooser.setSelectedFile(new File(fileName));
            int tampak = fileChooser.showSaveDialog(null);

            if (tampak == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                Blob blob = new SerialBlob(documentContent);
                InputStream stream = blob.getBinaryStream();

                try ( OutputStream output = new FileOutputStream(file)) {
                    byte[] buffer = new byte[4096];

                    while (stream.read(buffer) > 0) {
                        output.write(buffer);
                    }
                }
            }
        } catch (Exception ex) {
            Dialog.error(ex.getMessage(), "Opción no valida");
            Log.error(ex);
        }
    }

    /**
     * Load File Content.
     *
     * @param fileNameLabel JLable File Name To Display de file path
     * @param documentType Document Type
     */
    private void loadFileContent(JLabel fileNameLabel, int documentType) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(FileTypeFilterPDF.getFilter());
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        String fileName = file.getAbsolutePath();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            for (int readNum; (readNum = fileInputStream.read(buffer)) != -1;) {
                bos.write(buffer, 0, readNum);
            }

            switch (documentType) {
                case 1:
                    documentType1 = bos.toByteArray();
                    documentTypeFileName1 = file.getName();
                    documentTypeFileExtension1 = FilenameUtils.getExtension(fileName);
                    jButtonDocumentTypeDelete1.setEnabled(true);
                    jButtonDocumentTypeDownload1.setEnabled(true);
                    break;
                case 2:
                    documentType2 = bos.toByteArray();
                    documentTypeFileName2 = file.getName();
                    documentTypeFileExtension2 = FilenameUtils.getExtension(fileName);
                    jButtonDocumentTypeDelete2.setEnabled(true);
                    jButtonDocumentTypeDownload2.setEnabled(true);
                    break;
                case 3:
                    documentType3 = bos.toByteArray();
                    documentTypeFileName3 = file.getName();
                    documentTypeFileExtension3 = FilenameUtils.getExtension(fileName);
                    jButtonDocumentTypeDelete3.setEnabled(true);
                    jButtonDocumentTypeDownload3.setEnabled(true);
                    break;
                case 4:
                    documentType4 = bos.toByteArray();
                    documentTypeFileName4 = file.getName();
                    documentTypeFileExtension4 = FilenameUtils.getExtension(fileName);
                    jButtonDocumentTypeDelete4.setEnabled(true);
                    jButtonDocumentTypeDownload4.setEnabled(true);
                    break;
                case 5:
                    documentType5 = bos.toByteArray();
                    documentTypeFileName5 = file.getName();
                    documentTypeFileExtension5 = FilenameUtils.getExtension(fileName);
                    jButtonDocumentTypeDelete5.setEnabled(true);
                    jButtonDocumentTypeDownload5.setEnabled(true);
                    break;
                default:
                    throw new Exception("Document type option ['%d'] is not valid".formatted(documentType));
            }

            fileNameLabel.setText(fileName);
        } catch (FileNotFoundException ex) {
            Dialog.error(ex.getMessage(), "Fichero no encontrado");
            Log.error(ex);
        } catch (IOException ex) {
            Dialog.error(ex.getMessage(), "Error al processar el fichero");
            Log.error(ex);
        } catch (Exception ex) {
            Dialog.error(ex.getMessage(), "Opción no valida");
            Log.error(ex);
        }
    }

    /**
     * Clean Inputs.
     */
    private void cleanInputs() {
        disableAllInputFiles();
        disableAllInputFilesDownload();
        disableAllInputFilesDelete();
        clearAllInputFiles();
        jTextFieldConvocatoryStartDate.setText("");
        jTextFieldConvocatoryEndDate.setText("");
        jComboBoxConvocatory.setSelectedIndex(0);
    }

    /**
     * Validate Inputs.
     *
     * @return True if inputs are valid
     */
    private Boolean validateInputs() {
        // @TODO: Validation!
        return true;
    }

    /**
     * Get Input Convocatory.
     *
     * @return Convocatory Selected.
     */
    private Convocatory getInputConvocatory() {
        return (Convocatory) jComboBoxConvocatory.getSelectedItem();
    }

    /**
     * Get Input User Id.
     *
     * @return User Id
     */
    private int getInputUserId() {
        return Integer.parseInt(jTextFieldUserId.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDocumentType1;
    private javax.swing.JButton jButtonDocumentType2;
    private javax.swing.JButton jButtonDocumentType3;
    private javax.swing.JButton jButtonDocumentType4;
    private javax.swing.JButton jButtonDocumentType5;
    private javax.swing.JButton jButtonDocumentTypeDelete1;
    private javax.swing.JButton jButtonDocumentTypeDelete2;
    private javax.swing.JButton jButtonDocumentTypeDelete3;
    private javax.swing.JButton jButtonDocumentTypeDelete4;
    private javax.swing.JButton jButtonDocumentTypeDelete5;
    private javax.swing.JButton jButtonDocumentTypeDownload1;
    private javax.swing.JButton jButtonDocumentTypeDownload2;
    private javax.swing.JButton jButtonDocumentTypeDownload3;
    private javax.swing.JButton jButtonDocumentTypeDownload4;
    private javax.swing.JButton jButtonDocumentTypeDownload5;
    private javax.swing.JButton jButtonMunicipioCreate;
    private javax.swing.JComboBox<String> jComboBoxConvocatory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelConvocatory;
    private javax.swing.JLabel jLabelConvocatory1;
    private javax.swing.JLabel jLabelConvocatory2;
    private javax.swing.JLabel jLabelDocumentType1;
    private javax.swing.JLabel jLabelDocumentType2;
    private javax.swing.JLabel jLabelDocumentType3;
    private javax.swing.JLabel jLabelDocumentType4;
    private javax.swing.JLabel jLabelDocumentType5;
    private javax.swing.JLabel jLabelNecesaryDocuments;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanelDocumentType1;
    private javax.swing.JPanel jPanelDocumentType2;
    private javax.swing.JPanel jPanelDocumentType3;
    private javax.swing.JPanel jPanelDocumentType4;
    private javax.swing.JPanel jPanelDocumentType5;
    private javax.swing.JTextField jTextFieldConvocatoryEndDate;
    private javax.swing.JTextField jTextFieldConvocatoryStartDate;
    private javax.swing.JTextField jTextFieldUserId;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
