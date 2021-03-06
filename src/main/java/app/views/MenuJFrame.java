/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app.views;

import app.Main;
import app.views.municipality.MunicipalityListJInternalFrame;
import app.entities.User;
import app.views.convocatory.ConvocatoryCreateJInternalFrame;
import app.views.convocatory.ConvocatoryListJInternalFrame;
import app.views.information.InformationDashboardJInternalFrame;
import app.views.municipality.MunicipalityCreateJInternalFrame;
import app.views.presentation.PresentationCreateJInternalFrame;
import app.views.presentation.PresentationListJInternalFrame;
import app.views.users.UserCreateJInternalFrame;
import app.views.users.UserListJInternalFrame;
import helpers.Dialog;
import helpers.Role;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raulsm
 */
public class MenuJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MenuJFrame
     */
    public MenuJFrame() {
        try {
            initComponents();
            
            // Show or Hide Sections
            User authUser = Main.getAuthUser();
            showHideSections(authUser);
        } catch (Exception ex) {
            Logger.getLogger(MenuJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Show or Hide Sections by User
     *
     * @param user Auth User
     */
    private void showHideSections(User user) throws Exception {
        int roleId = user.getRoleId();

        if (roleId != Role.ADMININISTRATOR) {
            jMenuUsers.setVisible(false);
            jMenuMunicipios.setVisible(false);
        }

        switch (roleId) {
            case Role.CUENTADANTE: {
                jMenuItemConvocatoriesCreate.setVisible(false);
            }
            break;
            case Role.FISCAL: {
                jMenuMunicipios.setVisible(true);
                jMenuItemMunicipiosCreate.setVisible(false);
                jMenuItemConvocatoriesCreate.setVisible(false);
            }
            break;
            case Role.FISCAL_GENERAL: {
                jMenuMunicipios.setVisible(true);
                jMenuItemMunicipiosCreate.setVisible(false);
            }
            break;
            default: {
                throw new Exception("Role not suported yet.");
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabelUser = new javax.swing.JLabel();
        jDesktopPanelContainer = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemCloseSession = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExit = new javax.swing.JMenuItem();
        jMenuUsers = new javax.swing.JMenu();
        jMenuItemUsersShow = new javax.swing.JMenuItem();
        jMenuItemUsersCreate = new javax.swing.JMenuItem();
        jMenuMunicipios = new javax.swing.JMenu();
        jMenuItemMunicipiosShow = new javax.swing.JMenuItem();
        jMenuItemMunicipiosCreate = new javax.swing.JMenuItem();
        jMenuConvocatories = new javax.swing.JMenu();
        jMenuItemConvocatoriesShow = new javax.swing.JMenuItem();
        jMenuItemConvocatoriesCreate = new javax.swing.JMenuItem();
        jMenuPresentations = new javax.swing.JMenu();
        jMenuItemPresentationShow = new javax.swing.JMenuItem();
        jMenuItemPresentationCreate = new javax.swing.JMenuItem();
        jMenuInformation = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Presentaciones Contables");
        setMinimumSize(new java.awt.Dimension(830, 450));
        setPreferredSize(new java.awt.Dimension(830, 800));

        jLabelUser.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        jLabelUser.setText("Usuario");
        jLabelUser.setToolTipText("");

        jDesktopPanelContainer.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPanelContainer.setRequestFocusEnabled(false);

        jMenuBar1.setMinimumSize(new java.awt.Dimension(564, 22));

        jMenu2.setText("Men??");
        jMenu2.setToolTipText("");

        jMenuItemCloseSession.setText("Cerrar sesi??n");
        jMenuItemCloseSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCloseSessionActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCloseSession);
        jMenu2.add(jSeparator1);

        jMenuItemExit.setText("Salir");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemExit);

        jMenuBar1.add(jMenu2);

        jMenuUsers.setText("Usuarios");

        jMenuItemUsersShow.setText("Ver");
        jMenuItemUsersShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsersShowActionPerformed(evt);
            }
        });
        jMenuUsers.add(jMenuItemUsersShow);

        jMenuItemUsersCreate.setText("Crear");
        jMenuItemUsersCreate.setToolTipText("");
        jMenuItemUsersCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsersCreateActionPerformed(evt);
            }
        });
        jMenuUsers.add(jMenuItemUsersCreate);

        jMenuBar1.add(jMenuUsers);

        jMenuMunicipios.setText("Municipios");

        jMenuItemMunicipiosShow.setText("Ver");
        jMenuItemMunicipiosShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMunicipiosShowActionPerformed(evt);
            }
        });
        jMenuMunicipios.add(jMenuItemMunicipiosShow);

        jMenuItemMunicipiosCreate.setText("Crear");
        jMenuItemMunicipiosCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMunicipiosCreateActionPerformed(evt);
            }
        });
        jMenuMunicipios.add(jMenuItemMunicipiosCreate);

        jMenuBar1.add(jMenuMunicipios);

        jMenuConvocatories.setText("Convocatorias");
        jMenuConvocatories.setMinimumSize(new java.awt.Dimension(116, 800));

        jMenuItemConvocatoriesShow.setText("Ver");
        jMenuItemConvocatoriesShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConvocatoriesShowActionPerformed(evt);
            }
        });
        jMenuConvocatories.add(jMenuItemConvocatoriesShow);

        jMenuItemConvocatoriesCreate.setText("Crear");
        jMenuItemConvocatoriesCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConvocatoriesCreateActionPerformed(evt);
            }
        });
        jMenuConvocatories.add(jMenuItemConvocatoriesCreate);

        jMenuBar1.add(jMenuConvocatories);

        jMenuPresentations.setText("Presentaciones");

        jMenuItemPresentationShow.setText("Ver");
        jMenuItemPresentationShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPresentationShowActionPerformed(evt);
            }
        });
        jMenuPresentations.add(jMenuItemPresentationShow);

        jMenuItemPresentationCreate.setText("Crear");
        jMenuItemPresentationCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPresentationCreateActionPerformed(evt);
            }
        });
        jMenuPresentations.add(jMenuItemPresentationCreate);

        jMenuBar1.add(jMenuPresentations);

        jMenuInformation.setText("Informaci??n");
        jMenuInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuInformationMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuInformation);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jDesktopPanelContainer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPanelContainer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUser)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unused")
    private void jMenuItemCloseSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCloseSessionActionPerformed

        Dialog.info("Este apartado todav??a no est?? disponible", "En desarrollo");
    }//GEN-LAST:event_jMenuItemCloseSessionActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed

        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemMunicipiosShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMunicipiosShowActionPerformed
        MunicipalityListJInternalFrame municipalitiesList = new MunicipalityListJInternalFrame(jDesktopPanelContainer);
        jDesktopPanelContainer.add(municipalitiesList);

        municipalitiesList.setVisible(true);
    }//GEN-LAST:event_jMenuItemMunicipiosShowActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemMunicipiosCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMunicipiosCreateActionPerformed
        MunicipalityCreateJInternalFrame municipalitiesCreate = new MunicipalityCreateJInternalFrame();
        jDesktopPanelContainer.add(municipalitiesCreate);

        municipalitiesCreate.setVisible(true);
    }//GEN-LAST:event_jMenuItemMunicipiosCreateActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemConvocatoriesShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConvocatoriesShowActionPerformed
        ConvocatoryListJInternalFrame convocatoriesList = new ConvocatoryListJInternalFrame(jDesktopPanelContainer);
        jDesktopPanelContainer.add(convocatoriesList);

        convocatoriesList.setVisible(true);
    }//GEN-LAST:event_jMenuItemConvocatoriesShowActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemConvocatoriesCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConvocatoriesCreateActionPerformed
        ConvocatoryCreateJInternalFrame convocatoryCreate = new ConvocatoryCreateJInternalFrame();
        jDesktopPanelContainer.add(convocatoryCreate);

        convocatoryCreate.setVisible(true);
    }//GEN-LAST:event_jMenuItemConvocatoriesCreateActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemUsersShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsersShowActionPerformed
        UserListJInternalFrame usersList = new UserListJInternalFrame(jDesktopPanelContainer);
        jDesktopPanelContainer.add(usersList);

        usersList.setVisible(true);
    }//GEN-LAST:event_jMenuItemUsersShowActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemUsersCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsersCreateActionPerformed
        UserCreateJInternalFrame userCreate = new UserCreateJInternalFrame();
        jDesktopPanelContainer.add(userCreate);

        userCreate.setVisible(true);
    }//GEN-LAST:event_jMenuItemUsersCreateActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemPresentationCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPresentationCreateActionPerformed
        PresentationCreateJInternalFrame presentationCreate = new PresentationCreateJInternalFrame();
        jDesktopPanelContainer.add(presentationCreate);

        presentationCreate.setVisible(true);
    }//GEN-LAST:event_jMenuItemPresentationCreateActionPerformed

    @SuppressWarnings("unused")
    private void jMenuItemPresentationShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPresentationShowActionPerformed
        PresentationListJInternalFrame presentationsList = new PresentationListJInternalFrame(jDesktopPanelContainer);
        jDesktopPanelContainer.add(presentationsList);

        presentationsList.setVisible(true);
    }//GEN-LAST:event_jMenuItemPresentationShowActionPerformed

    @SuppressWarnings("unused")
    private void jMenuInformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuInformationMouseClicked
        InformationDashboardJInternalFrame informationDashboard = new InformationDashboardJInternalFrame();
        jDesktopPanelContainer.add(informationDashboard);

        informationDashboard.setVisible(true);
    }//GEN-LAST:event_jMenuInformationMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJFrame().setVisible(true);
            }
        });
    }

    /**
     * Set User Footer Info.
     *
     * @param user User
     */
    public void setUserFooterInfo(User user) {
        String text = "Bievenido: %s [Role: %s]".formatted(user.getLogin(), user.getRoleName());
        jLabelUser.setText(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanelContainer;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConvocatories;
    private javax.swing.JMenu jMenuInformation;
    private javax.swing.JMenuItem jMenuItemCloseSession;
    private javax.swing.JMenuItem jMenuItemConvocatoriesCreate;
    private javax.swing.JMenuItem jMenuItemConvocatoriesShow;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemMunicipiosCreate;
    private javax.swing.JMenuItem jMenuItemMunicipiosShow;
    private javax.swing.JMenuItem jMenuItemPresentationCreate;
    private javax.swing.JMenuItem jMenuItemPresentationShow;
    private javax.swing.JMenuItem jMenuItemUsersCreate;
    private javax.swing.JMenuItem jMenuItemUsersShow;
    private javax.swing.JMenu jMenuMunicipios;
    private javax.swing.JMenu jMenuPresentations;
    private javax.swing.JMenu jMenuUsers;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
