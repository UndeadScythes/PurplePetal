package com.undeadscythes.purplepetal.panels.products;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.keyables.typedpart.TypedPart;
import com.undeadscythes.purplepetal.utilities.DBStep;
import com.undeadscythes.purplepetal.utilities.Swingers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Display a products details.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ProductDisplay extends ProductPanel {
    private final int productID;
    private float price = 0;
    private float cost;
    private int target;
    private int max;
    private final Products par;
    private final DefaultListModel<TypedPart> components = new DefaultListModel<>();
    
    /**
     * Creates new form ProductDisplay
     * @param par_
     * @param productID
     * @throws java.sql.SQLException
     */
    public ProductDisplay(Products par_, int productID) throws SQLException {
        super(productID);
        par = par_;
        this.productID = productID;
        initComponents();
        lstComponents.setMenu(mnuPopup);
        refresh();
    }
    
    private void refresh() {
        try {
            ResultSet rs = db.getEntry(productID);
            if (rs.next()) {
                Swingers.setText(rs.getString("Name"), labName);
                price = rs.getFloat("Price");
                Swingers.setText(String.format("£%.02f", price), labPrice);
                target = rs.getInt("Target");
                cost = populateComponents();
                Swingers.setText(String.format("Cost: £%.02f", cost), labCost);
                float profit = price - cost;
                HashMap<String, Object> values = new HashMap<>(1);
                values.put("Profit", profit);
                values.put("Cost", cost);
                db.updateEntry(productID, values);
                Swingers.setText(String.format("Profit: £%.02f", profit), labProfit);
                max = calcMax();
                Swingers.setText(String.format("Target: %d (Max. %d)", target, max), labTarget);
                int completed = countComplete();
                Swingers.setText(String.format("Completed: %d/%d (%.0f%%)", completed, target, 1.0 * completed / target), labCompletion);
                Swingers.setText(String.format("Total cost: £%.02f", cost * target), labTotalCost);
                Swingers.setText(String.format("Total profit: £%.02f", profit * target), labTotalProfit);
            }
            par.calcTotals();
        } catch (SQLException ex) {
            error(ex);
        }
    }
    
    private float populateComponents() throws SQLException {
        components.clear();
        return gatherData(ProductPartType.PLANT) + gatherData(ProductPartType.FEEDSTOCK);
    }
    
    private float gatherData(ProductPartType type) throws SQLException {
        float totalCost = 0;
        ResultSet rs = DBStep.executeQuery(type.getQuery(productID));
        while (rs.next()) {
            int quantity = rs.getInt("Quantity");
            float compCost = rs.getFloat("Price") * quantity / rs.getFloat(type.volume);
            totalCost += compCost;
            String display = String.format("%s x %d, £%.02f", rs.getString(type.name), quantity, compCost);
            TypedPart part = new TypedPart(new Pair(rs.getInt(type.getRef()), display), quantity, type);
            components.addElement(part);
        }
        return totalCost;
    }
    
    private int calcMax() throws SQLException {
        int newMax = -1;
        for (int i = 0; i < components.getSize(); i++) {
            TypedPart part = components.get(i);
            int count = part.getQuantity();
            int stock = countStock((ProductPartType) part.type, part.getKey());
            int poss = stock / count;
            if (poss < newMax || newMax < 0) {
                newMax = poss;
            }
        }
        return newMax < 0 ? 0 : newMax;
    }
    
    private int countStock(ProductPartType type, int id) throws SQLException {
        String query = String.format("SELECT SUM(Quantity) AS Total FROM %1$sOrder WHERE %1$sREF=%2$d AND NOT Delivered IS NULL;", type.table, id);
        ResultSet rs = DBStep.executeQuery(query);
        int stock = 0;
        if (rs.next()) {
            stock = rs.getInt("Total");
        }
        query = String.format("SELECT %s FROM %s WHERE %s=%d;", type.volume, type.table, type.getID(), id);
        rs = DBStep.executeQuery(query);
        if (rs.next()) {
            stock *= rs.getInt(type.volume);
        }
        return stock;
    }
    
    private int countComplete() throws SQLException {
        int completed = 0;
        String query = String.format("SELECT SUM(Quantity) AS Total FROM Product_Status JOIN Status ON StatusREF=StatusID WHERE ProductREF=%d AND Description='Ready for sale';", productID);
        ResultSet rs = DBStep.executeQuery(query);
        if (rs.next()) {
            completed = rs.getInt("Total");
        }
        return completed;
    }
    
    @SuppressWarnings({"unchecked", "Convert2Lambda", "Convert2Diamond"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuPopup = new javax.swing.JPopupMenu();
        itmAddPlant = new javax.swing.JMenuItem();
        itmAddFeedstock = new javax.swing.JMenuItem();
        itmDeleteItem = new javax.swing.JMenuItem();
        labTotalCost1 = new javax.swing.JLabel();
        labTotalProfit1 = new javax.swing.JLabel();
        labName = new javax.swing.JLabel();
        labPrice = new javax.swing.JLabel();
        labTarget = new javax.swing.JLabel();
        panComponents = new javax.swing.JPanel();
        scrComponents = new javax.swing.JScrollPane();
        lstComponents = new com.undeadscythes.purplepetal.lists.ListWithPopup<TypedPart>();
        labCost = new javax.swing.JLabel();
        labProfit = new javax.swing.JLabel();
        btnSetProfit = new javax.swing.JButton();
        btnSetPrice = new javax.swing.JButton();
        btnSetTarget = new javax.swing.JButton();
        btnSetMaxTarget = new javax.swing.JButton();
        labTotalCost = new javax.swing.JLabel();
        labTotalProfit = new javax.swing.JLabel();
        labCompletion = new javax.swing.JLabel();

        itmAddPlant.setText("Add plant");
        itmAddPlant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddPlantActionPerformed(evt);
            }
        });
        mnuPopup.add(itmAddPlant);

        itmAddFeedstock.setText("Add feedstock");
        itmAddFeedstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAddFeedstockActionPerformed(evt);
            }
        });
        mnuPopup.add(itmAddFeedstock);

        itmDeleteItem.setText("Delete");
        itmDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmDeleteItemActionPerformed(evt);
            }
        });
        mnuPopup.add(itmDeleteItem);

        labTotalCost1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labTotalCost1.setText("Total cost: £<TotalCost>");

        labTotalProfit1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labTotalProfit1.setText("Total profit: £<TotalProfit>");

        labName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labName.setText("<ProductName>");

        labPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labPrice.setText("£<Price>");

        labTarget.setText("Target:<Target> (Max. <Max>)");

        panComponents.setBorder(javax.swing.BorderFactory.createTitledBorder("Components"));

        lstComponents.setModel(components);
        lstComponents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrComponents.setViewportView(lstComponents);

        labCost.setText("Cost: £<Cost>");

        labProfit.setText("Profit: £<Profit>");

        btnSetProfit.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSetProfit.setText("Set Profit");
        btnSetProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetProfitActionPerformed(evt);
            }
        });

        btnSetPrice.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSetPrice.setText("Set Price");
        btnSetPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panComponentsLayout = new javax.swing.GroupLayout(panComponents);
        panComponents.setLayout(panComponentsLayout);
        panComponentsLayout.setHorizontalGroup(
            panComponentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrComponents)
            .addComponent(labCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panComponentsLayout.createSequentialGroup()
                .addComponent(labProfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSetPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSetProfit))
        );
        panComponentsLayout.setVerticalGroup(
            panComponentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panComponentsLayout.createSequentialGroup()
                .addComponent(scrComponents, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labCost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panComponentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labProfit)
                    .addComponent(btnSetProfit)
                    .addComponent(btnSetPrice)))
        );

        btnSetTarget.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSetTarget.setText("Set Target");
        btnSetTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetTargetActionPerformed(evt);
            }
        });

        btnSetMaxTarget.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSetMaxTarget.setText("Set to Max");
        btnSetMaxTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetMaxTargetActionPerformed(evt);
            }
        });

        labTotalCost.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labTotalCost.setText("Total cost: £<TotalCost>");

        labTotalProfit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labTotalProfit.setText("Total profit: £<TotalProfit>");

        labCompletion.setText("Completion: <Completed>/<Target> (<Percent>%)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSetTarget)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSetMaxTarget))
            .addComponent(panComponents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labTotalProfit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labTotalCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labCompletion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panComponents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTarget)
                    .addComponent(btnSetMaxTarget)
                    .addComponent(btnSetTarget))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labCompletion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labTotalCost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labTotalProfit)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetPriceActionPerformed
        float newPrice = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter new price:", Float.toString(price)));
        setPrice(newPrice);
    }//GEN-LAST:event_btnSetPriceActionPerformed

    private void setPrice(float newPrice) {
        HashMap<String, Float> values = new HashMap<>(1);
        values.put("Price", newPrice);
        db.updateEntry(productID, values);
        refresh();
    }
    
    private void btnSetProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetProfitActionPerformed
        float profit = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter desired profit:", price - cost));
        setPrice(cost + profit);
    }//GEN-LAST:event_btnSetProfitActionPerformed

    private void btnSetTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetTargetActionPerformed
        int newTarget = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter target:", target));
        setTarget(newTarget);
    }//GEN-LAST:event_btnSetTargetActionPerformed

    private void setTarget(int newTarget) {
        HashMap<String, Integer> values = new HashMap<>(1);
        values.put("Target", newTarget);
        db.updateEntry(productID, values);
        refresh();
    }
    
    private void btnSetMaxTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetMaxTargetActionPerformed
        setTarget(max);
    }//GEN-LAST:event_btnSetMaxTargetActionPerformed

    private void itmAddFeedstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddFeedstockActionPerformed
        addComponent(ProductPartType.FEEDSTOCK);
    }//GEN-LAST:event_itmAddFeedstockActionPerformed

    private void addComponent(ProductPartType type) {
        NewComponent nc = new NewComponent(type);
        JOptionPane.showMessageDialog(this, nc, "Select a component", JOptionPane.QUESTION_MESSAGE);
        TypedPart part = nc.getSelection();
        HashMap<String, Object> values = new HashMap<>(3);
        values.put("ProductREF", productID);
        values.put(type.getRef(), part.getKey());
        values.put("Quantity", part.getQuantity());
        DBStep.newEntry(type.getTableConnection(), values);
        refresh();
    }
    
    private void itmAddPlantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAddPlantActionPerformed
        addComponent(ProductPartType.PLANT);
    }//GEN-LAST:event_itmAddPlantActionPerformed

    private void itmDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmDeleteItemActionPerformed
        TypedPart part = lstComponents.getSelectedValue();
        ProductPartType type = (ProductPartType) part.type;
        String query = String.format("DELETE FROM %s WHERE %s=%d AND ProductREF=%d;", type.getTableConnection(), type.getRef(), part.getKey(), productID);
        DBStep.executeUpdate(query);
        refresh();
    }//GEN-LAST:event_itmDeleteItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetMaxTarget;
    private javax.swing.JButton btnSetPrice;
    private javax.swing.JButton btnSetProfit;
    private javax.swing.JButton btnSetTarget;
    private javax.swing.JMenuItem itmAddFeedstock;
    private javax.swing.JMenuItem itmAddPlant;
    private javax.swing.JMenuItem itmDeleteItem;
    private javax.swing.JLabel labCompletion;
    private javax.swing.JLabel labCost;
    private javax.swing.JLabel labName;
    private javax.swing.JLabel labPrice;
    private javax.swing.JLabel labProfit;
    private javax.swing.JLabel labTarget;
    private javax.swing.JLabel labTotalCost;
    private javax.swing.JLabel labTotalCost1;
    private javax.swing.JLabel labTotalProfit;
    private javax.swing.JLabel labTotalProfit1;
    private com.undeadscythes.purplepetal.lists.ListWithPopup<TypedPart> lstComponents;
    private javax.swing.JPopupMenu mnuPopup;
    private javax.swing.JPanel panComponents;
    private javax.swing.JScrollPane scrComponents;
    // End of variables declaration//GEN-END:variables
}
