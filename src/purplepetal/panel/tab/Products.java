package purplepetal.panel.tab;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
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
        initComponents();
        btnRefreshActionPerformed(null);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        javax.swing.JPanel panProducts = new javax.swing.JPanel();
        javax.swing.JScrollPane scrProducts = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<Pair>();
        javax.swing.JButton btnRefresh = new javax.swing.JButton();
        javax.swing.JButton btnNew = new javax.swing.JButton();
        javax.swing.JSeparator sep1 = new javax.swing.JSeparator();
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

        spl1.setDividerLocation(250);

        lstProducts.setModel(mdlProducts);
        lstProducts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstProducts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProductsValueChanged(evt);
            }
        });
        scrProducts.setViewportView(lstProducts);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panProductsLayout = new javax.swing.GroupLayout(panProducts);
        panProducts.setLayout(panProductsLayout);
        panProductsLayout.setHorizontalGroup(
            panProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep1)
            .addGroup(panProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrProducts)
                    .addGroup(panProductsLayout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew)
                        .addGap(0, 99, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panProductsLayout.setVerticalGroup(
            panProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnNew))
                .addContainerGap())
        );

        spl1.setLeftComponent(panProducts);

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

        javax.swing.GroupLayout panDetailsLayout = new javax.swing.GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep2)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(labName, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labCompleted, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(labPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrice)
                                    .addComponent(txtCompleted)))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(cmbPlants, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlantAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPlantEdit))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(cmbItems, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtItemAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnItemEdit))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(scrPlants, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(scrItems, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
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
                    .addComponent(labPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labCompleted)
                    .addComponent(txtCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPlants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlantEdit)
                    .addComponent(txtPlantAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrItems, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnItemEdit)
                    .addComponent(txtItemAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        spl1.setRightComponent(panDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        mdlPlants.clear();
        mdlItems.clear();
        refresh(mdlProducts, productsCombo, "Product", "ProductID", "Name");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear(lstProducts, lstPlants, lstItems);
        clear(txtName, txtPrice, txtCompleted);
        set("0", txtPlantAmt, txtItemAmt);
        clear(cmbPlants, cmbItems);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try (Statement s = createStatement()) {
            String name = txtName.getText();
            String price = txtPrice.getText();
            String completed = txtCompleted.getText();
            int id;
            if (lstProducts.isSelectionEmpty()) {
                s.executeUpdate("INSERT INTO Product (Name, Price, Completed) VALUES (" +
                        "'" + name + "', " +
                        "'" + price + "', " +
                        "'" + completed + "');");
                ResultSet rs = s.executeQuery("SELECT last_insert_rowid();");
                rs.next();
                id = rs.getInt("last_insert_rowid()");
            } else {
                id = lstProducts.getSelectedValue().getKey();
                s.executeUpdate("UPDATE Product SET " +
                        "Name = '" + name + "', " +
                        "Price = '" + price + "', " +
                        "Completed = '" + completed + "' " +
                        "WHERE ProductID = " + id + ";");
            }
            addParts(s, mdlPlants, id, "Plant");
            addParts(s, mdlItems, id, "Item");
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void addParts(Statement s, DefaultListModel<Part> list, int id, String partName) throws SQLException {
        Enumeration<Part> parts = list.elements();
        String table = partName + "_Product";
        String partRef = partName + "REF";
        while (parts.hasMoreElements()) {
            Part part = parts.nextElement();
            String crit = String.format("ProductREF = %s AND %s = %s;", id, partRef, part.getKey());
            if (s.executeQuery(String.format("SELECT * FROM %s WHERE %s;", table, crit)).next()) {
                s.executeUpdate(String.format("UPDATE %s SET Amount = %s WHERE %s;", table, part.getAmount(), crit));
            } else {
                s.executeUpdate(String.format("INSERT INTO %s (ProductREF, %s, Amount) VALUES (%s, %s, %s);", table, partRef, id, part.getKey(), part.getAmount()));
            }
        }
    }
    
    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstProductsValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try (Statement s = createStatement()) {
            JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records
          
            if (!lstProducts.isSelectionEmpty()) {
                int id = lstProducts.getSelectedValue().getKey();
                s.executeUpdate("DELETE FROM Product WHERE ProductID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnItemEditActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnItemEditActionPerformed
        editPart(mdlItems, cmbItems, txtItemAmt);
    }//GEN-LAST:event_btnItemEditActionPerformed

    private void btnPlantEditActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPlantEditActionPerformed
        editPart(mdlPlants, cmbPlants, txtPlantAmt);
    }//GEN-LAST:event_btnPlantEditActionPerformed

    private void editPart(DefaultListModel<Part> model, JComboBox<Pair> combo, JTextField text) {
        Pair pair = getSelection(combo);
        int amount = Integer.parseInt(text.getText());
        if (amount == 0) {
            remove(model, pair.getKey());
        } else {
            replace(model, pair.getKey(), new Part(pair, amount));
        }
    }
    
    private void lstPlantsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            int product = lstProducts.getSelectedValue().getKey();
            int plant = lstPlants.getSelectedValue().getKey();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Plant_Product WHERE ProductREF = " + product + " AND PlantREF = " + plant + ";")) {
                while (rs.next()) {
                    set(rs.getString("Amount"), txtPlantAmt);
                    selectKey(cmbPlants, rs.getInt(plant));
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
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Item_Product WHERE ProductREF = " + product + " AND ItemREF = " + item + ";")) {
                while (rs.next()) {
                    set(rs.getString("Amount"), txtItemAmt);
                    selectKey(cmbItems, rs.getInt(item));
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstItemsValueChanged

    private void lstProductsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstProductsValueChanged
        if (!lstProducts.isSelectionEmpty()) {
            int id = lstProducts.getSelectedValue().getKey();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Product WHERE ProductID = " + id + ";")) {
                while (rs.next()) {
                    set(rs.getString("Name"), txtName);
                    set(rs.getString("Price"), txtPrice);
                    set(rs.getString("Completed"), txtCompleted);
                }
            } catch (SQLException ex) {
                error(ex);
            }
            mdlPlants.clear();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Plant_Product JOIN Plant ON PlantID=PlantREF WHERE ProductREF = " + id + ";")) {
                while (rs.next()) {
                    mdlPlants.addElement(new Part(new Pair(rs.getInt("PlantREF"), rs.getString("CommonName")), rs.getInt("Amount")));
                }
            } catch (SQLException ex) {
                error(ex);
            }
            mdlItems.clear();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Item_Product JOIN Item ON ItemID=ItemREF WHERE ProductREF = " + id + ";")) {
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
    private javax.swing.JList<Part> lstItems;
    private javax.swing.JList<Part> lstPlants;
    private javax.swing.JList<Pair> lstProducts;
    private javax.swing.JTextField txtCompleted;
    private javax.swing.JTextField txtItemAmt;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPlantAmt;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Products.class.getName());
}
