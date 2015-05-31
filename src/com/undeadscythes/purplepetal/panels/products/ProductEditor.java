package com.undeadscythes.purplepetal.panels.products;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.keyables.Part;
import com.undeadscythes.purplepetal.utilities.DBStep;
import com.undeadscythes.purplepetal.utilities.Swingers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Edit and add new products.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ProductEditor extends ProductPanel {
    private final int productID;
    private final Products parent;
    private final DefaultListModel<Part> mdlPlants = new DefaultListModel<>();
    private final DefaultListModel<Part> mdlItems = new DefaultListModel<>();

    /**
     * Add a new entry.
     * @param parent
     * @throws java.sql.SQLException
     */
    public ProductEditor(Products parent) throws SQLException {
        this(parent, -1);
    }
    
    /**
     * Creates new form ProductEditor
     * @param parent
     * @param productID
     * @throws java.sql.SQLException
     */
    public ProductEditor(Products parent, int productID) throws SQLException {
        super(productID);
        this.parent = parent;
        this.productID = productID;
        initComponents();
        if (productID > -1) {
            populate();
        }
    }
    
    private void populate() {
        int id = productID;
        try {
            ResultSet rs = db.getEntry(id);
            while (rs.next()) {
                Swingers.setText(rs.getString("Name"), txtName);
                Swingers.setText(rs.getString("Price"), txtPrice);
                Swingers.setText(rs.getString("Target"), txtTarget);
                Swingers.setText(rs.getString("Completed"), txtCompleted);
            }
        } catch (SQLException ex) {
            error(ex);
        }
        mdlPlants.clear();
        try {
            ResultSet rs = DBStep.executeQuery("SELECT * FROM Plant_Product JOIN Plant ON PlantID=PlantREF WHERE ProductREF = " + id + ";");
            while (rs.next()) {
                mdlPlants.addElement(new Part(new Pair(rs.getInt("PlantREF"), rs.getString("CommonName")), rs.getInt("Amount")));
            }
        } catch (SQLException ex) {
            error(ex);
        }
        mdlItems.clear();
        try {
            ResultSet rs = DBStep.executeQuery("SELECT * FROM Item_Product JOIN Item ON ItemID=ItemREF WHERE ProductREF = " + id + ";");
            while (rs.next()) {
                mdlItems.addElement(new Part(new Pair(rs.getInt("ItemREF"), rs.getString("Name")), rs.getInt("Amount")));
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel labName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtTarget = new javax.swing.JTextField();
        javax.swing.JLabel labPrice = new javax.swing.JLabel();
        javax.swing.JLabel labTarget = new javax.swing.JLabel();
        javax.swing.JLabel labCompleted = new javax.swing.JLabel();
        javax.swing.JLabel labPlants = new javax.swing.JLabel();
        javax.swing.JLabel labItems = new javax.swing.JLabel();
        txtItemAmt = new javax.swing.JTextField();
        javax.swing.JButton btnItemEdit = new javax.swing.JButton();
        cmbItems = new javax.swing.JComboBox<Pair>();
        javax.swing.JScrollPane scrItems = new javax.swing.JScrollPane();
        lstItems = new javax.swing.JList<Part>();
        txtPlantAmt = new javax.swing.JTextField();
        javax.swing.JButton btnPlantEdit = new javax.swing.JButton();
        cmbPlants = new javax.swing.JComboBox<Pair>();
        javax.swing.JScrollPane scrPlants = new javax.swing.JScrollPane();
        lstPlants = new javax.swing.JList<Part>();
        txtCompleted = new javax.swing.JTextField();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JButton btnCancel = new javax.swing.JButton();

        labName.setText("Name");

        labPrice.setText("Price");

        labTarget.setText("Target");

        labCompleted.setText("Completed");

        labPlants.setText("Plants");

        labItems.setText("Items");

        btnItemEdit.setText("Edit");
        btnItemEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemEditActionPerformed(evt);
            }
        });

        cmbItems.setModel(feedstockCombo);

        lstItems.setModel(mdlItems);
        lstItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstItemsValueChanged(evt);
            }
        });
        scrItems.setViewportView(lstItems);

        btnPlantEdit.setText("Edit");
        btnPlantEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantEditActionPerformed(evt);
            }
        });

        cmbPlants.setModel(plantsCombo);

        lstPlants.setModel(mdlPlants);
        lstPlants.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPlants.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlantsValueChanged(evt);
            }
        });
        scrPlants.setViewportView(lstPlants);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labItems, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbItems, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrItems, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtItemAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnItemEdit))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labCompleted, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(labPlants, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(scrPlants, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtPlantAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnPlantEdit))
                                .addComponent(cmbPlants, 0, 250, Short.MAX_VALUE)
                                .addComponent(txtCompleted)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labName, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(labTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labName)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labPrice)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labTarget)
                        .addComponent(txtTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labCompleted)
                        .addComponent(txtCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labPlants))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cmbPlants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPlantAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPlantEdit))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(scrItems, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtItemAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnItemEdit)))
                        .addComponent(labItems))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnCancel))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnItemEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemEditActionPerformed
        editPart(mdlItems, cmbItems, txtItemAmt);
    }//GEN-LAST:event_btnItemEditActionPerformed

    private void lstItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstItemsValueChanged
        if (!lstItems.isSelectionEmpty()) {
            int item = lstItems.getSelectedValue().getKey();
            try {
                ResultSet rs = DBStep.executeQuery("SELECT * FROM Item_Product WHERE ProductREF = " + productID + " AND ItemREF = " + item + ";");
                while (rs.next()) {
                    Swingers.setText(rs.getString("Amount"), txtItemAmt);
                    Swingers.setSelectedItem(cmbItems, item);
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstItemsValueChanged

    private void btnPlantEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlantEditActionPerformed
        editPart(mdlPlants, cmbPlants, txtPlantAmt);
    }//GEN-LAST:event_btnPlantEditActionPerformed

    private void lstPlantsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            int plant = lstPlants.getSelectedValue().getKey();
            try {
                ResultSet rs = DBStep.executeQuery("SELECT * FROM Plant_Product WHERE ProductREF = " + productID + " AND PlantREF = " + plant + ";");
                while (rs.next()) {
                    Swingers.setText(rs.getString("Amount"), txtPlantAmt);
                    Swingers.setSelectedItem(cmbPlants, plant);
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstPlantsValueChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HashMap<String, Object> values = new HashMap<>(3);
        values.put("Name", txtName.getText());
        values.put("Price", txtPrice.getText());
        values.put("Target", txtTarget.getText());
        values.put("Completed", txtCompleted.getText());
        int id;
        if (productID < 0) {
            id = db.newEntry(values);
        } else {
            id = productID;
            db.updateEntry(productID, values);
        }
        addParts(mdlPlants, id, "Plant");
        addParts(mdlItems, id, "Item");
        parent.refresh();
        parent.setSelectedKey(productID);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void addParts(DefaultListModel<Part> list, int id, String partName) {
        Enumeration<Part> parts = list.elements();
        String table = partName + "_Product";
        String partRef = partName + "REF";
        while (parts.hasMoreElements()) {
            Part part = parts.nextElement();
            String crit = String.format("ProductREF = %s AND %s = %s;", id, partRef, part.getKey());
            if (DBStep.entryExists(String.format("SELECT * FROM %s WHERE %s;", table, crit))) {
                DBStep.executeUpdate(String.format("UPDATE %s SET Amount = %s WHERE %s;", table, part.getQuantity(), crit));
            } else {
                DBStep.executeUpdate(String.format("INSERT INTO %s (ProductREF, %s, Amount) VALUES (%s, %s, %s);", table, partRef, id, part.getKey(), part.getQuantity()));
            }
        }
    }
    
    private void editPart(DefaultListModel<Part> model, JComboBox<Pair> combo, JTextField text) {
        Pair pair = Swingers.getSelectedItem(combo);
        int amount = Integer.parseInt(text.getText());
        if (amount == 0) {
            Swingers.removeItem(model, pair.getKey());
        } else {
            Swingers.replaceItem(model, pair.getKey(), new Part(pair, amount));
        }
    }
    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        parent.setSelectedKey(-1);
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Pair> cmbItems;
    private javax.swing.JComboBox<Pair> cmbPlants;
    private javax.swing.JList<Part> lstItems;
    private javax.swing.JList<Part> lstPlants;
    private javax.swing.JTextField txtCompleted;
    private javax.swing.JTextField txtItemAmt;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPlantAmt;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTarget;
    // End of variables declaration//GEN-END:variables
}
