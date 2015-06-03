package com.undeadscythes.purplepetal.panels.plants;

import com.undeadscythes.purplepetal.keyables.Order;
import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.panels.date.DatePanel;
import com.undeadscythes.purplepetal.utilities.DBStep;
import com.undeadscythes.purplepetal.utilities.Swingers;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * To display plant details.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class PlantDisplay extends PlantPanel {
    private final int plantID;
    private final DefaultListModel<Order> orders = new DefaultListModel<>();
    private int traySize;
    private int lost;
    
    /**
     * Creates new form PlantDisplay
     * @param plantID
     * @throws java.sql.SQLException
     */
    public PlantDisplay(int plantID) throws SQLException {
        super(plantID);
        this.plantID = plantID;
        initComponents();
        refresh();
    }
    
    private void refresh() throws SQLException {
        String query = String.format("SELECT * FROM Plant LEFT JOIN PlantType ON TypeREF=PlantTypeID WHERE PlantID=%d;", plantID);
        ResultSet rs = DBStep.executeQuery(query);
        if (rs.next()) {
            Pair pair = suppliersCombo.getKey(rs.getInt("SupplierREF"));
            String supplier = "No current supplier";
            if (pair != null) {
                supplier = "Current supplier: " + pair.toString();
            }
            String latinName = rs.getString("LatinName");
            if (!latinName.isEmpty()) {
                latinName = String.format("(%s)", latinName);
            }
            traySize = rs.getInt("TraySize");
            String price = String.format("%d @ £%.2f", traySize, rs.getFloat("Price"));
            Swingers.setText(supplier, labSupplier);
            Swingers.setText(price, labPrice);
            Swingers.setText(String.format("%s %s", rs.getString("CommonName"), latinName), labNames);
            Swingers.setText(rs.getString("Description"), labType);
            lost = rs.getInt("Lost");
            Swingers.setText("Lost: " + lost, labLost);
        }
        countStock();
    }
    
    private void countStock() throws SQLException {
        String query = String.format("SELECT PlantOrderID, Quantity, Ordered, Delivered FROM PlantOrder WHERE PlantREF=%d;", plantID);
        ResultSet rs = DBStep.executeQuery(query);
        int total = 0;
        orders.clear();
        while (rs.next()) {
            int quantity = rs.getInt("Quantity");
            Order order = new Order(rs.getInt("PlantOrderID"), quantity, traySize, rs.getString("Ordered"));
            orders.addElement(order);
            String delivered = rs.getString("Delivered");
            if (delivered != null) {
                order.complete(delivered);
                total += quantity;
            }
        }
        String stock = String.format("Current stock: %d", total * traySize - lost);
        Swingers.setText(stock, labStock);
    }
    
    private void showListPopup(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            int row = lstOrders.locationToIndex(evt.getPoint());
            if (row < 0 || !lstOrders.getCellBounds(row, row).contains(evt.getPoint())) {
                lstOrders.clearSelection();
            } else {
                lstOrders.setSelectedIndex(row);
            }
            mnuPopup.show(lstOrders, evt.getX(), evt.getY());
        }
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuPopup = new javax.swing.JPopupMenu();
        itmAddOrder = new javax.swing.JMenuItem();
        itmComplete = new javax.swing.JMenuItem();
        itmDelete = new javax.swing.JMenuItem();
        labNames = new javax.swing.JLabel();
        labType = new javax.swing.JLabel();
        labSupplier = new javax.swing.JLabel();
        labPrice = new javax.swing.JLabel();
        labStock = new javax.swing.JLabel();
        panOrders = new javax.swing.JPanel();
        scrOrders = new javax.swing.JScrollPane();
        lstOrders = new javax.swing.JList<Order>();
        labLost = new javax.swing.JLabel();
        btnLost = new javax.swing.JButton();

        itmAddOrder.setText("New");
        itmAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddOrderActionPerformed(evt);
            }
        });
        mnuPopup.add(itmAddOrder);

        itmComplete.setText("Complete");
        itmComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCompleteActionPerformed(evt);
            }
        });
        mnuPopup.add(itmComplete);

        itmDelete.setText("Delete");
        itmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmDeleteActionPerformed(evt);
            }
        });
        mnuPopup.add(itmDelete);

        labNames.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labNames.setText("<CommonName> (<Latin Name>)");

        labType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labType.setText("<PlantType>");

        labSupplier.setText("Current supplier: <Supplier>");

        labPrice.setText("<TraySize> @ £<Price>");

        labStock.setText("Current stock: <Stock>");

        panOrders.setBorder(javax.swing.BorderFactory.createTitledBorder("Orders"));

        lstOrders.setModel(orders);
        lstOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstOrdersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstOrdersMouseReleased(evt);
            }
        });
        scrOrders.setViewportView(lstOrders);

        javax.swing.GroupLayout panOrdersLayout = new javax.swing.GroupLayout(panOrders);
        panOrders.setLayout(panOrdersLayout);
        panOrdersLayout.setHorizontalGroup(
            panOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrOrders)
        );
        panOrdersLayout.setVerticalGroup(
            panOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        );

        labLost.setText("Total lost: <Lost>");

        btnLost.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnLost.setText("Record Loss");
        btnLost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labNames, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addComponent(labType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labLost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLost))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labNames)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labLost)
                    .addComponent(btnLost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lstOrdersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstOrdersMousePressed
        showListPopup(evt);
    }//GEN-LAST:event_lstOrdersMousePressed

    private void lstOrdersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstOrdersMouseReleased
        showListPopup(evt);
    }//GEN-LAST:event_lstOrdersMouseReleased

    private void itmAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddOrderActionPerformed
        HashMap<String, Object> values = new HashMap<>(3);
        values.put("PlantREF", plantID);
        values.put("Ordered", DatePanel.getDateString(this));
        values.put("Quantity", JOptionPane.showInputDialog(this, "Enter the quantity ordered:"));
        DBStep.newEntry("PlantOrder", values);
        try {
            countStock();
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_itmAddOrderActionPerformed

    private void itmCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCompleteActionPerformed
        int id = Swingers.getSelectedKey(lstOrders);
        if (id > -1) {
            String date = DatePanel.getDateString(this);
            String query = String.format("UPDATE PlantOrder SET Delivered='%s' WHERE PlantOrderID=%d;", date, id);
            DBStep.executeUpdate(query);
            try {
                countStock();
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_itmCompleteActionPerformed

    private void itmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmDeleteActionPerformed
        int id = Swingers.getSelectedKey(lstOrders);
        if (id > -1) {
            String query = String.format("DELETE FROM PlantOrder WHERE PlantOrderID=%d;", id);
            DBStep.executeUpdate(query);
            try {
                countStock();
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_itmDeleteActionPerformed

    private void btnLostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLostActionPerformed
        HashMap<String, Object> values = new HashMap<>(3);
        int newLost = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the number of new plants lost:"));
        values.put("Lost", newLost);
        DBStep.updateEntry("Plant", plantID, values);
        try {
            lost += newLost;
            countStock();
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnLostActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLost;
    private javax.swing.JMenuItem itmAddOrder;
    private javax.swing.JMenuItem itmComplete;
    private javax.swing.JMenuItem itmDelete;
    private javax.swing.JLabel labLost;
    private javax.swing.JLabel labNames;
    private javax.swing.JLabel labPrice;
    private javax.swing.JLabel labStock;
    private javax.swing.JLabel labSupplier;
    private javax.swing.JLabel labType;
    private javax.swing.JList<Order> lstOrders;
    private javax.swing.JPopupMenu mnuPopup;
    private javax.swing.JPanel panOrders;
    private javax.swing.JScrollPane scrOrders;
    // End of variables declaration//GEN-END:variables
}
