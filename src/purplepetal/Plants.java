package purplepetal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
        initComponents();
        btnRefreshActionPerformed(null);
        updatePlantTypesCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        javax.swing.JPanel panPlants = new javax.swing.JPanel();
        final javax.swing.JScrollPane scrPlants = new javax.swing.JScrollPane();
        lstPlants = new javax.swing.JList<Pair>();
        final javax.swing.JButton btnNew = new javax.swing.JButton();
        final javax.swing.JButton btnRefresh = new javax.swing.JButton();

        labName.setText("Common Name");

        labLatin.setText("Latin Name");

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

        javax.swing.GroupLayout panDetailsLayout = new javax.swing.GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labName)
                    .addComponent(labLatin)
                    .addComponent(labSupplier)
                    .addComponent(labType)
                    .addComponent(labPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName)
                    .addComponent(txtLatin)
                    .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(cmbType, 0, 132, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewType))
                    .addComponent(txtPrice)))
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panDetailsLayout.setVerticalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete)
                    .addComponent(btnSave)))
        );

        lstPlants.setModel(mdlPlants);
        lstPlants.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlantsValueChanged(evt);
            }
        });
        scrPlants.setViewportView(lstPlants);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panPlantsLayout = new javax.swing.GroupLayout(panPlants);
        panPlants.setLayout(panPlantsLayout);
        panPlantsLayout.setHorizontalGroup(
            panPlantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPlantsLayout.createSequentialGroup()
                .addComponent(scrPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panPlantsLayout.createSequentialGroup()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPlantsLayout.setVerticalGroup(
            panPlantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPlantsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrPlants)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPlantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnRefresh))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panPlants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(378, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panPlants, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        mdlPlants.clear();
        try (Statement s = createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM Plant;")) {
            plantsCombo.addElement(new Pair(-1, ""));
            while (rs.next()) {
                mdlPlants.addElement(new Pair(rs.getInt("PlantID"), rs.getString("CommonName")));
                plantsCombo.addElement(new Pair(rs.getInt("PlantID"), rs.getString("CommonName")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void lstPlantsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            int id = lstPlants.getSelectedValue().getKey();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Plant WHERE PlantID = " + id + ";")) {
                while (rs.next()) {
                    txtName.setText(rs.getString("CommonName"));
                    txtLatin.setText(rs.getString("LatinName"));
                    selectKey(cmbSupplier, rs.getInt("SupplierREF"));
                    selectKey(cmbType, rs.getInt("TypeREF"));
                    txtPrice.setText(rs.getString("Price"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lstPlantsValueChanged

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        lstPlants.clearSelection();
        txtName.setText("");
        txtLatin.setText("");
        cmbSupplier.setSelectedIndex(0);
        cmbType.setSelectedIndex(0);
        txtPrice.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try (Statement s = createStatement()) {
            String[] data = new String[3];
            int[] refs = new int[2];
            data[0] = txtName.getText();
            data[1] = txtLatin.getText();
            data[2] = txtPrice.getText();
            refs[0] = getSelection(cmbSupplier).getKey();
            refs[1] = getSelection(cmbType).getKey();
            if (lstPlants.isSelectionEmpty()) {
                s.executeUpdate("INSERT INTO Plant (CommonName, LatinName, SupplierREF, TypeREF, Price) VALUES (" +
                    "'" + data[0] + "', " +
                    "'" + data[1] + "', " +
                    refs[0] + ", " + refs[1] + ", " +
                    "'" + data[2] + "');");
            } else {
                int id = lstPlants.getSelectedValue().getKey();
                s.executeUpdate("UPDATE Plant SET " +
                    "CommonName = '" + data[0] + "', " +
                    "LatinName = '" + data[1] + "', " +
                    "SupplierREF = " + refs[0] + ", " +
                    "TypeREF = " + refs[1] + ", " +
                    "Price = '" + data[2] + "' " +
                    "WHERE PlantID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstPlantsValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewTypeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewTypeActionPerformed
        String newName = JOptionPane.showInputDialog(this, "Enter new plant type:");
        if (newName != null && newName.length() > 0) {
            try (Statement s = createStatement()) {
                s.executeUpdate("INSERT INTO PlantType (Description) VALUES ('" + newName + "');");
                updatePlantTypesCombo();
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnNewTypeActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try (Statement s = createStatement()) {
            if (!lstPlants.isSelectionEmpty()) {
                int id = lstPlants.getSelectedValue().getKey();
                s.executeUpdate("DELETE FROM Plant WHERE PlantID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
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
