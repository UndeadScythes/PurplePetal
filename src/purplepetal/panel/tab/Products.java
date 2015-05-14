package purplepetal.panel.tab;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import purplepetal.Pair;
import purplepetal.Part;
import purplepetal.panel.PurplePanel;

/**
 * Assemble products for show and sale.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Products extends PurplePanel {
    private final DefaultListModel<Pair> mdlProducts = new DefaultListModel<>();
    private final DefaultListModel<Part> mdlPlants = new DefaultListModel<>();
    private final DefaultListModel<Part> mdlItems = new DefaultListModel<>();
    
    /**
     * Creates new form Products
     */
    public Products() {
        super("Product", "ProductID", "Name");
        initComponents();
        refresh();
    }

    @Override
    protected void clear() {
        clearFields(lstProducts, lstPlants, lstItems);
        clearFields(txtName, txtPrice, txtCompleted, txtTarget);
        setFields("0", txtPlantAmt, txtItemAmt);
        clearFields(cmbPlants, cmbItems);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        javax.swing.JScrollPane scrProducts = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<Pair>();
        javax.swing.JPanel panDetails = new javax.swing.JPanel();
        javax.swing.JLabel labName = new javax.swing.JLabel();
        javax.swing.JLabel labPrice = new javax.swing.JLabel();
        javax.swing.JLabel labCompleted = new javax.swing.JLabel();
        javax.swing.JScrollPane scrPlants = new javax.swing.JScrollPane();
        lstPlants = new javax.swing.JList<Part>();
        cmbPlants = new javax.swing.JComboBox<Pair>();
        javax.swing.JButton btnPlantEdit = new javax.swing.JButton();
        javax.swing.JSeparator sep2 = new javax.swing.JSeparator();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JButton btnCancel = new javax.swing.JButton();
        javax.swing.JButton btnDelete = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtCompleted = new javax.swing.JTextField();
        txtPlantAmt = new javax.swing.JTextField();
        javax.swing.JScrollPane scrItems = new javax.swing.JScrollPane();
        lstItems = new javax.swing.JList<Part>();
        cmbItems = new javax.swing.JComboBox<Pair>();
        txtItemAmt = new javax.swing.JTextField();
        javax.swing.JButton btnItemEdit = new javax.swing.JButton();
        javax.swing.JButton btnNew = new javax.swing.JButton();
        javax.swing.JLabel labPlants = new javax.swing.JLabel();
        javax.swing.JLabel labItems = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel labCost = new javax.swing.JLabel();
        javax.swing.JLabel labProfit = new javax.swing.JLabel();
        javax.swing.JLabel labTarget = new javax.swing.JLabel();
        txtTarget = new javax.swing.JTextField();
        javax.swing.JLabel labMax = new javax.swing.JLabel();
        javax.swing.JLabel labTotal = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        txtProfit = new javax.swing.JTextField();
        txtMax = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        javax.swing.JLabel labPound1 = new javax.swing.JLabel();
        javax.swing.JLabel labPound2 = new javax.swing.JLabel();
        javax.swing.JLabel labComingSoon = new javax.swing.JLabel();

        spl1.setDividerLocation(250);

        lstProducts.setModel(mdlProducts);
        lstProducts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstProducts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProductsValueChanged(evt);
            }
        });
        scrProducts.setViewportView(lstProducts);

        spl1.setLeftComponent(scrProducts);

        labName.setText("Name");

        labPrice.setText("Price");

        labCompleted.setText("Completed");

        lstPlants.setModel(mdlPlants);
        lstPlants.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPlants.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlantsValueChanged(evt);
            }
        });
        scrPlants.setViewportView(lstPlants);

        cmbPlants.setModel(plantsCombo);

        btnPlantEdit.setText("Edit");
        btnPlantEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantEditActionPerformed(evt);
            }
        });

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

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lstItems.setModel(mdlItems);
        lstItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstItemsValueChanged(evt);
            }
        });
        scrItems.setViewportView(lstItems);

        cmbItems.setModel(itemsCombo);

        btnItemEdit.setText("Edit");
        btnItemEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemEditActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        labPlants.setText("Plants");

        labItems.setText("Items");

        labCost.setText("Cost of Parts");

        labProfit.setText("Profit");

        labTarget.setText("Target");

        labMax.setText("Maximum");

        labTotal.setText("Total");

        txtCost.setEditable(false);

        txtProfit.setEditable(false);

        txtMax.setEditable(false);

        txtTotal.setEditable(false);

        labPound1.setText("£");

        labPound2.setText("£");

        labComingSoon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labComingSoon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labComingSoon.setText("COMING SOON");

        javax.swing.GroupLayout panDetailsLayout = new javax.swing.GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labMax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panDetailsLayout.createSequentialGroup()
                                        .addComponent(labProfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labPound1))
                                    .addComponent(labCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCost, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                    .addComponent(txtProfit)
                                    .addComponent(txtMax))
                                .addGap(28, 28, 28)
                                .addComponent(labTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labPound2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labComingSoon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(labItems, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbItems, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrItems, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panDetailsLayout.createSequentialGroup()
                                        .addComponent(txtItemAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnItemEdit)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panDetailsLayout.createSequentialGroup()
                                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(labCompleted, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(labPlants, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(scrPlants, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addGroup(panDetailsLayout.createSequentialGroup()
                                                .addComponent(txtPlantAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnPlantEdit))
                                            .addComponent(cmbPlants, 0, 250, Short.MAX_VALUE)
                                            .addComponent(txtCompleted)))
                                    .addGroup(panDetailsLayout.createSequentialGroup()
                                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labName, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                            .addComponent(labTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addComponent(jSeparator1)
            .addComponent(sep2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panDetailsLayout.setVerticalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTarget)
                    .addComponent(txtTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labCompleted)
                    .addComponent(txtCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPlants))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPlants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlantAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlantEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(scrItems, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtItemAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnItemEdit)))
                    .addComponent(labItems))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labComingSoon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labCost)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labProfit)
                    .addComponent(labTotal)
                    .addComponent(txtProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound1)
                    .addComponent(labPound2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labMax)
                    .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        mdlPlants.clear();
        mdlItems.clear();
        refreshLists(mdlProducts, productsCombo);
    }
    
    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HashMap<String, String> values = new HashMap<>(3);
        values.put("Name", wrap(txtName.getText()));
        values.put("Price", txtPrice.getText());
        values.put("Target", txtTarget.getText());
        values.put("Completed", txtCompleted.getText());
        int id;
        if (lstProducts.isSelectionEmpty()) {
            id = newEntry(values);
        } else {
            id = lstProducts.getSelectedValue().getKey();
            updateEntry(id, values);
        }
        addParts(mdlPlants, id, "Plant");
        addParts(mdlItems, id, "Item");
        clearAndRefresh();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void addParts(DefaultListModel<Part> list, int id, String partName) {
        Enumeration<Part> parts = list.elements();
        String table = partName + "_Product";
        String partRef = partName + "REF";
        while (parts.hasMoreElements()) {
            Part part = parts.nextElement();
            String crit = String.format("ProductREF = %s AND %s = %s;", id, partRef, part.getKey());
            if (entryExists(String.format("SELECT * FROM %s WHERE %s;", table, crit))) {
                executeUpdate(String.format("UPDATE %s SET Amount = %s WHERE %s;", table, part.getAmount(), crit));
            } else {
                executeUpdate(String.format("INSERT INTO %s (ProductREF, %s, Amount) VALUES (%s, %s, %s);", table, partRef, id, part.getKey(), part.getAmount()));
            }
        }
    }
    
    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstProductsValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records

        if (!lstProducts.isSelectionEmpty()) {
            deleteEntry(lstProducts.getSelectedValue().getKey());
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnItemEditActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnItemEditActionPerformed
        editPart(mdlItems, cmbItems, txtItemAmt);
    }//GEN-LAST:event_btnItemEditActionPerformed

    private void btnPlantEditActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPlantEditActionPerformed
        editPart(mdlPlants, cmbPlants, txtPlantAmt);
    }//GEN-LAST:event_btnPlantEditActionPerformed

    private void editPart(DefaultListModel<Part> model, JComboBox<Pair> combo, JTextField text) {
        Pair pair = comboGetSelection(combo);
        int amount = Integer.parseInt(text.getText());
        if (amount == 0) {
            listRemoveKey(model, pair.getKey());
        } else {
            listReplaceKey(model, pair.getKey(), new Part(pair, amount));
        }
    }
    
    private void lstPlantsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            int product = lstProducts.getSelectedValue().getKey();
            int plant = lstPlants.getSelectedValue().getKey();
            try {
                ResultSet rs = executeQuery("SELECT * FROM Plant_Product WHERE ProductREF = " + product + " AND PlantREF = " + plant + ";");
                while (rs.next()) {
                    setFields(rs.getString("Amount"), txtPlantAmt);
                    comboSelectKey(cmbPlants, plant);
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstPlantsValueChanged

    private void lstItemsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstItemsValueChanged
        if (!lstItems.isSelectionEmpty()) {
            int product = lstProducts.getSelectedValue().getKey();
            int item = lstItems.getSelectedValue().getKey();
            try {
                ResultSet rs = executeQuery("SELECT * FROM Item_Product WHERE ProductREF = " + product + " AND ItemREF = " + item + ";");
                while (rs.next()) {
                    setFields(rs.getString("Amount"), txtItemAmt);
                    comboSelectKey(cmbItems, item);
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstItemsValueChanged

    private void lstProductsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstProductsValueChanged
        if (!lstProducts.isSelectionEmpty()) {
            int id = lstProducts.getSelectedValue().getKey();
            try {
                ResultSet rs = getEntry(id);
                while (rs.next()) {
                    setFields(rs.getString("Name"), txtName);
                    setFields(rs.getString("Price"), txtPrice);
                    setFields(rs.getString("Target"), txtTarget);
                    setFields(rs.getString("Completed"), txtCompleted);
                }
            } catch (SQLException ex) {
                error(ex);
            }
            mdlPlants.clear();
            try {
                ResultSet rs = executeQuery("SELECT * FROM Plant_Product JOIN Plant ON PlantID=PlantREF WHERE ProductREF = " + id + ";");
                while (rs.next()) {
                    mdlPlants.addElement(new Part(new Pair(rs.getInt("PlantREF"), rs.getString("CommonName")), rs.getInt("Amount")));
                }
            } catch (SQLException ex) {
                error(ex);
            }
            mdlItems.clear();
            try {
                ResultSet rs = executeQuery("SELECT * FROM Item_Product JOIN Item ON ItemID=ItemREF WHERE ProductREF = " + id + ";");
                while (rs.next()) {
                    mdlItems.addElement(new Part(new Pair(rs.getInt("ItemREF"), rs.getString("Name")), rs.getInt("Amount")));
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstProductsValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Pair> cmbItems;
    private javax.swing.JComboBox<Pair> cmbPlants;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<Part> lstItems;
    private javax.swing.JList<Part> lstPlants;
    private javax.swing.JList<Pair> lstProducts;
    private javax.swing.JTextField txtCompleted;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtItemAmt;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPlantAmt;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProfit;
    private javax.swing.JTextField txtTarget;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Products.class.getName());
}
