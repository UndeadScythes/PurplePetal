package com.undeadscythes.purplepetal.panels.feedstock;

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
 * Display the details of an item.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class FeedstockDisplay extends FeedstockPanel {
    private final int feedstockID;
    private final DefaultListModel<Order> orders = new DefaultListModel<>();
    private int packSize;
    
    /**
     * Creates new form ItemDisplay.
     * @param itemID
     * @throws java.sql.SQLException
     */
    public FeedstockDisplay(int itemID) throws SQLException {
        super(itemID);
        this.feedstockID = itemID;
        initComponents();
        ResultSet rs = db.getEntry(itemID);
        while (rs.next()) {
            Pair pair = suppliersCombo.getKey(rs.getInt("SupplierREF"));
            String supplier = "No current supplier";
            if (pair != null) {
                supplier = "Current supplier: " + pair.toString();
            }
            packSize = rs.getInt("PackSize");
            String price = String.format("%d @ £%.2f", packSize, rs.getFloat("Price"));
            Swingers.setText(rs.getString("Name"), labName);
            Swingers.setText(supplier, labSupplier);
            Swingers.setText(price, labPrice);
            countStock();
        }
    }

    private void countStock() throws SQLException {
        String query = String.format("SELECT FeedstockOrderID, Quantity, Ordered, Delivered FROM FeedstockOrder WHERE FeedstockREF=%d;", feedstockID);
        ResultSet rs = DBStep.executeQuery(query);
        int total = 0;
        orders.clear();
        while (rs.next()) {
            int quantity = rs.getInt("Quantity");
            Order order = new Order(rs.getInt("FeedstockOrderID"), quantity, packSize, rs.getString("Ordered"));
            orders.addElement(order);
            String delivered = rs.getString("Delivered");
            if (delivered != null) {
                order.complete(delivered);
                total += quantity;
            }
        }
        String stock = String.format("Current stock: %d", total * packSize);
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
    
    @SuppressWarnings({"unchecked", "Convert2Lambda", "Convert2Diamond"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuPopup = new javax.swing.JPopupMenu();
        itmAddOrder = new javax.swing.JMenuItem();
        itmComplete = new javax.swing.JMenuItem();
        itmDelete = new javax.swing.JMenuItem();
        labName = new javax.swing.JLabel();
        labSupplier = new javax.swing.JLabel();
        labPrice = new javax.swing.JLabel();
        labStock = new javax.swing.JLabel();
        panOrders = new javax.swing.JPanel();
        scrOrders = new javax.swing.JScrollPane();
        lstOrders = new javax.swing.JList<Order>();

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

        labName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labName.setText("<ItemName>");

        labSupplier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labSupplier.setText("Current supplier: <SupplierName>");

        labPrice.setText("<PackSize> @ £<Price>");

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
            .addComponent(scrOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
            .addComponent(labStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labStock)
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
        values.put("FeedstockREF", feedstockID);
        values.put("Ordered", DatePanel.getDateString(this));
        values.put("Quantity", JOptionPane.showInputDialog(this, "Enter the quantity ordered:"));
        DBStep.newEntry("FeedstockOrder", values);
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
            String query = String.format("UPDATE FeedstockOrder SET Delivered='%s' WHERE FeedstockOrderID=%d;", date, id);
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
            String query = String.format("DELETE FROM FeedstockOrder WHERE FeedstockOrderID=%d;", id);
            DBStep.executeUpdate(query);
            try {
                countStock();
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_itmDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAddOrder;
    private javax.swing.JMenuItem itmComplete;
    private javax.swing.JMenuItem itmDelete;
    private javax.swing.JLabel labName;
    private javax.swing.JLabel labPrice;
    private javax.swing.JLabel labStock;
    private javax.swing.JLabel labSupplier;
    private javax.swing.JList<Order> lstOrders;
    private javax.swing.JPopupMenu mnuPopup;
    private javax.swing.JPanel panOrders;
    private javax.swing.JScrollPane scrOrders;
    // End of variables declaration//GEN-END:variables
}
