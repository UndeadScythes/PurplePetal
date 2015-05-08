package purplepetal.panel.tab;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import purplepetal.Pair;
import purplepetal.panel.PurplePanel;

/**
 * Allows editing of plants in the database.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Plants extends PurplePanel {
    private final DefaultListModel<Pair> mdlPlants = new DefaultListModel<>();

    /**
     * Initialise components.
     */
    public Plants() {
        super("Plant", "PlantID", "CommonName");
        initComponents();
        refresh();
        updatePlantTypesCombo();
    }

    @Override
    protected void clear() {
        clearFields(lstPlants);
        clearFields(txtName, txtLatin, txtPrice);
        clearFields(cmbSupplier, cmbType);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        final javax.swing.JScrollPane scrPlants = new javax.swing.JScrollPane();
        lstPlants = new javax.swing.JList<Pair>();
        final javax.swing.JPanel panDetails = new javax.swing.JPanel();
        final javax.swing.JLabel labName = new javax.swing.JLabel();
        final javax.swing.JLabel labLatin = new javax.swing.JLabel();
        final javax.swing.JLabel labSupplier = new javax.swing.JLabel();
        final javax.swing.JLabel labType = new javax.swing.JLabel();
        final javax.swing.JLabel labPrice = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLatin = new javax.swing.JTextField();
        cmbSupplier = new javax.swing.JComboBox<Pair>();
        cmbType = new javax.swing.JComboBox<Pair>();
        txtPrice = new javax.swing.JTextField();
        btnNewType = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        javax.swing.JSeparator sep1 = new javax.swing.JSeparator();
        final javax.swing.JButton btnNew = new javax.swing.JButton();

        spl1.setDividerLocation(250);

        lstPlants.setModel(mdlPlants);
        lstPlants.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlantsValueChanged(evt);
            }
        });
        scrPlants.setViewportView(lstPlants);

        spl1.setLeftComponent(scrPlants);

        labName.setText("Common");

        labLatin.setText("Latin");

        labSupplier.setText("Supplier");

        labType.setText("Type");

        labPrice.setText("Price");

        cmbSupplier.setModel(suppliersCombo);

        cmbType.setModel(plantTypesCombo);

        btnNewType.setText("New Type");
        btnNewType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTypeActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panDetailsLayout = new javax.swing.GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep1)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(labLatin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewType))
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtLatin, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbSupplier, javax.swing.GroupLayout.Alignment.LEADING, 0, 250, Short.MAX_VALUE))
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panDetailsLayout.setVerticalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labLatin)
                    .addComponent(txtLatin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSupplier)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labType)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete)
                    .addComponent(btnNew))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spl1.setRightComponent(panDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected final void refresh() {
        refreshLists(mdlPlants, plantsCombo);
    }
    
    private void lstPlantsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            try {
                ResultSet rs = getEntry(lstPlants.getSelectedValue().getKey());
                while (rs.next()) {
                    txtName.setText(rs.getString("CommonName"));
                    txtLatin.setText(rs.getString("LatinName"));
                    comboSelectKey(cmbSupplier, rs.getInt("SupplierREF"));
                    comboSelectKey(cmbType, rs.getInt("TypeREF"));
                    txtPrice.setText(rs.getString("Price"));
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstPlantsValueChanged

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HashMap<String, String> values = new HashMap<>(5);
        values.put("CommonName", wrap(txtName.getText()));
        values.put("LatinName", wrap(txtLatin.getText()));
        values.put("SupplierREF", comboGetSelection(cmbSupplier).getKeyString());
        values.put("TypeREF", comboGetSelection(cmbType).getKeyString());
        values.put("Price", txtPrice.getText());
        if (lstPlants.isSelectionEmpty()) {
            newEntry(values);
        } else {
            updateEntry(lstPlants.getSelectedValue().getKey(), values);
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstPlantsValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewTypeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewTypeActionPerformed
        String newName = JOptionPane.showInputDialog(this, "Enter new plant type:");
        if (newName != null && newName.length() > 0) {
            executeUpdate("INSERT INTO PlantType (Description) VALUES ('" + newName + "');");
            updatePlantTypesCombo();
        }
    }//GEN-LAST:event_btnNewTypeActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records

        if (!lstPlants.isSelectionEmpty()) {
            deleteEntry(lstPlants.getSelectedValue().getKey());
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewType;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Pair> cmbSupplier;
    private javax.swing.JComboBox<Pair> cmbType;
    private javax.swing.JList<Pair> lstPlants;
    private javax.swing.JTextField txtLatin;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Plants.class.getName());
}
