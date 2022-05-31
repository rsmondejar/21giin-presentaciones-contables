/**
 * Presentation Create JInternalFrame.
 */
package app.views.presentation;

import app.Main;
import app.controllers.PresentationController;
import app.entities.Convocatory;
import app.entities.Presentation;
import app.entities.PresentationDocumentType;
import app.entities.User;
import helpers.DateHelper;
import helpers.Dialog;
import helpers.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author raulsm
 */
public class PresentationShowJInternalFrame extends javax.swing.JInternalFrame {

    private final JDesktopPane jDesktopPanelContainer;

    String noFile = "Sin fichero";
    String documentTypeFileName1 = null;
    String documentTypeFileName2 = null;
    String documentTypeFileName3 = null;
    String documentTypeFileName4 = null;
    String documentTypeFileName5 = null;
    byte[] documentType1 = null;
    byte[] documentType2 = null;
    byte[] documentType3 = null;
    byte[] documentType4 = null;
    byte[] documentType5 = null;

    /**
     * Creates new form PresentationJInternalFrame.
     *
     * @param jDesktopPanelContainer
     */
    public PresentationShowJInternalFrame(JDesktopPane jDesktopPanelContainer) {
        initComponents();
        this.jDesktopPanelContainer = jDesktopPanelContainer;
    }

    /**
     * Load Data.
     * @param presentation Presentation
     */
    public void loadData(Presentation presentation) {
        disableAllInputFilesDownload();
        loadLoggedUserInfo();

        // Set Convocatory
        Convocatory convocatory = presentation.getConvocatory();
        jTextFieldConvocatory.setText(convocatory.getName());
        setDatesConvocatory(convocatory);
        
        jTextFieldPresentationDate.setText(DateHelper.formatToYMD(presentation.getDate()));
        jCheckBoxPresentationIsValid.setSelected(presentation.getIsValid());
        jTextFieldPresentationId.setVisible(false);
        jTextFieldPresentationId.setText(String.valueOf(presentation.getId()));
        
        // Load uploaded documents
        loadUploadedDocuments(presentation);
    }

    /**
     * Set Dates Convocatory.
     */
    private void setDatesConvocatory(Convocatory convocatory) {
        jTextFieldConvocatoryStartDate.setText(DateHelper.formatToYMD(convocatory.getStartDate()));
        jTextFieldConvocatoryEndDate.setText(DateHelper.formatToYMD(convocatory.getEndDate()));
    }
    
    /**
     * Load Uploaded Documents.
     * @param presentation Presentation
     */
    private void loadUploadedDocuments(Presentation presentation) {
        List<PresentationDocumentType> presentationDocumentTypes = presentation.getPresentationDocumentTypes();
        
        if (presentationDocumentTypes != null) {            
            for(PresentationDocumentType presentationDocumentType : presentationDocumentTypes) {
                int documentTypeID = presentationDocumentType.getDocumentTypeId();
                
                if (documentTypeID == 1) {
                    jButtonDocumentTypeDownload1.setEnabled(true);
                    documentType1 = presentationDocumentType.getContent();
                    documentTypeFileName1 = presentationDocumentType.getFileName();
                    jLabelDocumentType1.setText(documentTypeFileName1);
                }
                if (documentTypeID == 2) {
                    jButtonDocumentTypeDownload2.setEnabled(true);
                    documentType2 = presentationDocumentType.getContent();
                    documentTypeFileName2 = presentationDocumentType.getFileName();
                    jLabelDocumentType2.setText(documentTypeFileName2);
                }
                if (documentTypeID == 3) {
                    jButtonDocumentTypeDownload3.setEnabled(true);
                    documentType3 = presentationDocumentType.getContent();
                    documentTypeFileName3 = presentationDocumentType.getFileName();
                    jLabelDocumentType3.setText(documentTypeFileName3);
                }
                if (documentTypeID == 4) {
                    jButtonDocumentTypeDownload4.setEnabled(true);
                    documentType4 = presentationDocumentType.getContent();
                    documentTypeFileName4 = presentationDocumentType.getFileName();
                    jLabelDocumentType4.setText(documentTypeFileName4);
                }
                if (documentTypeID == 5) {
                    jButtonDocumentTypeDownload5.setEnabled(true);
                    documentType5 = presentationDocumentType.getContent();
                    documentTypeFileName5 = presentationDocumentType.getFileName();
                    jLabelDocumentType5.setText(documentTypeFileName5);
                }
            }
        }
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
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelConvocatory = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jTextFieldUserId = new javax.swing.JTextField();
        jTextFieldUserName = new javax.swing.JTextField();
        jLabelNecesaryDocuments = new javax.swing.JLabel();
        jPanelDocumentType1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelDocumentType1 = new javax.swing.JLabel();
        jButtonDocumentTypeDownload1 = new javax.swing.JButton();
        jPanelDocumentType2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelDocumentType2 = new javax.swing.JLabel();
        jButtonDocumentTypeDownload2 = new javax.swing.JButton();
        jPanelDocumentType3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelDocumentType3 = new javax.swing.JLabel();
        jButtonDocumentTypeDownload3 = new javax.swing.JButton();
        jPanelDocumentType4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelDocumentType4 = new javax.swing.JLabel();
        jButtonDocumentTypeDownload4 = new javax.swing.JButton();
        jPanelDocumentType5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelDocumentType5 = new javax.swing.JLabel();
        jButtonDocumentTypeDownload5 = new javax.swing.JButton();
        jLabelConvocatory1 = new javax.swing.JLabel();
        jTextFieldConvocatoryStartDate = new javax.swing.JTextField();
        jLabelConvocatory2 = new javax.swing.JLabel();
        jTextFieldConvocatoryEndDate = new javax.swing.JTextField();
        jTextFieldConvocatory = new javax.swing.JTextField();
        jLabelPresentationDate = new javax.swing.JLabel();
        jTextFieldPresentationDate = new javax.swing.JTextField();
        jCheckBoxPresentationIsValid = new javax.swing.JCheckBox();
        jButtonPresentationEdit = new javax.swing.JButton();
        jButtonPresentationDelete = new javax.swing.JButton();
        jTextFieldPresentationId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Presentación");
        setToolTipText("");

        jLabelConvocatory.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatory.setText("Convocatoria:");

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

        jLabelDocumentType1.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType1.setText("Sin fichero");

        jButtonDocumentTypeDownload1.setText("Ver");
        jButtonDocumentTypeDownload1.setEnabled(false);
        jButtonDocumentTypeDownload1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocumentTypeDownload1ActionPerformed(evt);
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
                        .addGap(93, 93, 93)
                        .addComponent(jButtonDocumentTypeDownload1))
                    .addGroup(jPanelDocumentType1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))))
        );
        jPanelDocumentType1Layout.setVerticalGroup(
            jPanelDocumentType1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanelDocumentType1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocumentType1)
                    .addComponent(jButtonDocumentTypeDownload1))
                .addContainerGap())
        );

        jPanelDocumentType2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Libro Mayor");

        jLabelDocumentType2.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType2.setText("Sin fichero");

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
                        .addGap(93, 93, 93)
                        .addComponent(jButtonDocumentTypeDownload2))
                    .addGroup(jPanelDocumentType2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))))
        );
        jPanelDocumentType2Layout.setVerticalGroup(
            jPanelDocumentType2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentType2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDocumentTypeDownload2)
                    .addComponent(jLabelDocumentType2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDocumentType3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Balance de Sumas y Saldos");
        jLabel3.setToolTipText("");

        jLabelDocumentType3.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType3.setText("Sin fichero");

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
                        .addGap(93, 93, 93)
                        .addComponent(jButtonDocumentTypeDownload3))
                    .addGroup(jPanelDocumentType3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))))
        );
        jPanelDocumentType3Layout.setVerticalGroup(
            jPanelDocumentType3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentType3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDocumentTypeDownload3)
                    .addComponent(jLabelDocumentType3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDocumentType4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Registro de Ingreso de Caja");
        jLabel4.setToolTipText("");

        jLabelDocumentType4.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType4.setText("Sin fichero");

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
                        .addGap(93, 93, 93)
                        .addComponent(jButtonDocumentTypeDownload4))
                    .addGroup(jPanelDocumentType4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))))
        );
        jPanelDocumentType4Layout.setVerticalGroup(
            jPanelDocumentType4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentType4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDocumentTypeDownload4)
                    .addComponent(jLabelDocumentType4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDocumentType5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Registro de Movimientos de Bancos");
        jLabel5.setToolTipText("");

        jLabelDocumentType5.setFont(new java.awt.Font("Lucida Grande", 2, 10)); // NOI18N
        jLabelDocumentType5.setText("Sin fichero");

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
                        .addGap(93, 93, 93)
                        .addComponent(jButtonDocumentTypeDownload5))
                    .addGroup(jPanelDocumentType5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(99, 99, 99))))
        );
        jPanelDocumentType5Layout.setVerticalGroup(
            jPanelDocumentType5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDocumentType5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDocumentType5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonDocumentTypeDownload5)
                    .addComponent(jLabelDocumentType5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelConvocatory1.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatory1.setText("Convocatoria fecha inicio:");

        jTextFieldConvocatoryStartDate.setEditable(false);
        jTextFieldConvocatoryStartDate.setEnabled(false);

        jLabelConvocatory2.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelConvocatory2.setText("Convocatoria fecha fin:");

        jTextFieldConvocatoryEndDate.setEditable(false);
        jTextFieldConvocatoryEndDate.setEnabled(false);

        jTextFieldConvocatory.setEditable(false);
        jTextFieldConvocatory.setEnabled(false);

        jLabelPresentationDate.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelPresentationDate.setText("Fecha Presentación:");

        jTextFieldPresentationDate.setEditable(false);
        jTextFieldPresentationDate.setEnabled(false);

        jCheckBoxPresentationIsValid.setText("Estado apertura");
        jCheckBoxPresentationIsValid.setEnabled(false);

        jButtonPresentationEdit.setText("Editar");
        jButtonPresentationEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPresentationEditActionPerformed(evt);
            }
        });

        jButtonPresentationDelete.setBackground(new java.awt.Color(255, 153, 153));
        jButtonPresentationDelete.setText("Eliminar");
        jButtonPresentationDelete.setBorderPainted(false);
        jButtonPresentationDelete.setOpaque(true);
        jButtonPresentationDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPresentationDeleteActionPerformed(evt);
            }
        });

        jTextFieldPresentationId.setEditable(false);
        jTextFieldPresentationId.setToolTipText("");
        jTextFieldPresentationId.setEnabled(false);

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
                    .addComponent(jLabelConvocatory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUserName))
                    .addComponent(jPanelDocumentType5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNecesaryDocuments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDocumentType4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldConvocatory)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonPresentationDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPresentationEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelConvocatory1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jTextFieldConvocatoryStartDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelConvocatory2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldConvocatoryEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPresentationDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldPresentationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxPresentationIsValid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPresentationId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jTextFieldConvocatory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelConvocatory1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelConvocatory2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldConvocatoryEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldConvocatoryStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPresentationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPresentationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPresentationIsValid)
                    .addComponent(jTextFieldPresentationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPresentationEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPresentationDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    @SuppressWarnings("unused")
    private void jButtonPresentationEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPresentationEditActionPerformed
        try {

            int id = Integer.parseInt(jTextFieldPresentationId.getText());
            Presentation presentation = PresentationController.findById(id);

            PresentationEditJInternalFrame presentationEdit = new PresentationEditJInternalFrame();

            jDesktopPanelContainer.add(presentationEdit);

            // Load convocatory info in view
            presentationEdit.loadData(presentation);

            this.hide();

            presentationEdit.setVisible(true);
        } catch (NumberFormatException e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error editar presentación");
        }
    }//GEN-LAST:event_jButtonPresentationEditActionPerformed

    @SuppressWarnings("unused")
    private void jButtonPresentationDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPresentationDeleteActionPerformed
        int input = JOptionPane.showConfirmDialog(null, "Deseas eliminar?");
        // 0=yes, 1=no, 2=cancel

        if (input == 0) {
            // Delete
            int id = Integer.parseInt(jTextFieldPresentationId.getText());
            boolean status = PresentationController.delete(id);

            if (status) {
                Dialog.info("Presentatición eliminada correctamente", "Info");

                this.hide();
            } else {
                Dialog.error("Presentatición no se ha eliminado", "Error");
            }
        }

    }//GEN-LAST:event_jButtonPresentationDeleteActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDocumentTypeDownload1;
    private javax.swing.JButton jButtonDocumentTypeDownload2;
    private javax.swing.JButton jButtonDocumentTypeDownload3;
    private javax.swing.JButton jButtonDocumentTypeDownload4;
    private javax.swing.JButton jButtonDocumentTypeDownload5;
    private javax.swing.JButton jButtonPresentationDelete;
    private javax.swing.JButton jButtonPresentationEdit;
    private javax.swing.JCheckBox jCheckBoxPresentationIsValid;
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
    private javax.swing.JLabel jLabelPresentationDate;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanelDocumentType1;
    private javax.swing.JPanel jPanelDocumentType2;
    private javax.swing.JPanel jPanelDocumentType3;
    private javax.swing.JPanel jPanelDocumentType4;
    private javax.swing.JPanel jPanelDocumentType5;
    private javax.swing.JTextField jTextFieldConvocatory;
    private javax.swing.JTextField jTextFieldConvocatoryEndDate;
    private javax.swing.JTextField jTextFieldConvocatoryStartDate;
    private javax.swing.JTextField jTextFieldPresentationDate;
    private javax.swing.JTextField jTextFieldPresentationId;
    private javax.swing.JTextField jTextFieldUserId;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
