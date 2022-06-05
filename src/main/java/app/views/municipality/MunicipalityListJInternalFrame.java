/**
 * Municipality List JInternal Frame
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.views.municipality;

import app.controllers.MunicipalityController;
import app.entities.Municipality;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Municipality List JInternal Frame
 *
 * @author raulsm
 * @version 1.0.0
 */
public class MunicipalityListJInternalFrame extends javax.swing.JInternalFrame {

    private final JDesktopPane jDesktopPanelContainer;

    /**
     * Creates new form MunicipalityJInternalFrame
     *
     * @param jDesktopPanelContaine Desktop Panel Container
     */
    public MunicipalityListJInternalFrame(JDesktopPane jDesktopPanelContaine) {
        initComponents();
        this.jDesktopPanelContainer = jDesktopPanelContaine;
        loadData();
    }

    /**
     * Load Data.
     */
    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) jTableMunicipies.getModel();

        // @TODO: Load Data
        List<Municipality> items = MunicipalityController.list();

        // @TODO: Add data
        Object[] rowData = new Object[model.getColumnCount()];
        for (int i = 0; i < items.size(); i++) {
            rowData[0] = items.get(i).getId();
            rowData[1] = items.get(i).getName();
            rowData[2] = items.get(i).getCategoryId();

            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMunicipies = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado Municipios");
        setToolTipText("");

        jTableMunicipies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMunicipies.getTableHeader().setReorderingAllowed(false);
        jTableMunicipies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMunicipiesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMunicipies);

        jLabel1.setText("Seleccionar un registro para visualizar su información y poder editar y eliminar.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMunicipiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMunicipiesMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int id = Integer.parseInt(source.getModel().getValueAt(row, 0).toString());

        Municipality municipality = MunicipalityController.findById(id);

        MunicipalityShowJInternalFrame municipalitiesShow = new MunicipalityShowJInternalFrame(jDesktopPanelContainer);
        jDesktopPanelContainer.add(municipalitiesShow);
        municipalitiesShow.loadData(municipality);

        this.hide();

        municipalitiesShow.setVisible(true);
    }//GEN-LAST:event_jTableMunicipiesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMunicipies;
    // End of variables declaration//GEN-END:variables
}
