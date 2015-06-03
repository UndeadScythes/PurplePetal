package com.undeadscythes.purplepetal.panels.feedstock;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.utilities.Swingers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Edit and create new items.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class FeedstockEditor extends FeedstockPanel {
    private final transient DocumentListener updateExVAT = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateExVAT();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            updateExVAT();
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
            updateExVAT();
        }
    };
    
    private final int itemID;
    private final Feedstock parent;
    
    /**
     * Create a new record.
     * @param parent
     * @throws java.sql.SQLException
     */
    public FeedstockEditor(Feedstock parent) throws SQLException {
        this(parent, -1);
    }
    
    /**
     * Creates new form ItemEditor.
     * @param parent
     * @param itemID
     * @throws java.sql.SQLException
     */
    public FeedstockEditor(Feedstock parent, int itemID) throws SQLException {
        super(itemID);
        this.parent = parent;
        this.itemID = itemID;
        initComponents();
        txtPrice.getDocument().addDocumentListener(updateExVAT);
        if (itemID > -1 ) {
            populate();
        }
    }

    private void populate() {
        try {
            ResultSet rs = db.getEntry(itemID);
            while (rs.next()) {
                txtName.setText(rs.getString("Name"));
                int packSize = rs.getInt("PackSize");
                txtPackSize.setText(Integer.toString(packSize));
                txtPrice.setText(rs.getString("Price"));
                updateExVAT();
                Swingers.setSelectedItem(cmbSupplier, rs.getInt("SupplierREF"));
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }
    
    private void updateIncVAT() {
        String exText = txtExVAT.getText();
        double exVAT = 0;
        if (!exText.isEmpty()) {
            exVAT = Double.parseDouble(exText);
        }
        double incVAT = exVAT * (1.0 + getVAT() / 100.0);
        txtPrice.setText(String.format("%.2f", incVAT));
    }
    
    private void updateExVAT() {
        String incText = txtPrice.getText();
        double incVAT = 0;
        if (!incText.isEmpty()) {
            incVAT = Double.parseDouble(incText);
        }
        double exVAT = incVAT / (1.0 + getVAT() / 100.0);
        txtExVAT.setText(String.format("%.2f", exVAT));
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel labName = new javax.swing.JLabel();
        javax.swing.JLabel labSupplier = new javax.swing.JLabel();
        javax.swing.JLabel labPrice = new javax.swing.JLabel();
        javax.swing.JLabel labPackSize = new javax.swing.JLabel();
        txtPackSize = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtExVAT = new javax.swing.JTextField();
        javax.swing.JLabel labExVAT = new javax.swing.JLabel();
        javax.swing.JButton btnCalc = new javax.swing.JButton();
        cmbSupplier = new javax.swing.JComboBox<Pair>();
        txtName = new javax.swing.JTextField();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JButton btnCancel = new javax.swing.JButton();

        labName.setText("Name");

        labSupplier.setText("Supplier");

        labPrice.setText("Price (£)");

        labPackSize.setText("Pack Size");

        labExVAT.setText("Ex. VAT (£)");

        btnCalc.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCalc.setText("Calc");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        cmbSupplier.setModel(suppliersCombo);

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labName, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCalc))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSupplier)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalc)
                    .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labExVAT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPackSize)
                    .addComponent(txtPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addGap(0, 174, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        updateIncVAT();
    }//GEN-LAST:event_btnCalcActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HashMap<String, Object> fields = new HashMap<>(4);
        fields.put("Name", txtName.getText());
        fields.put("Price", txtPrice.getText());
        fields.put("SupplierREF", Swingers.getSelectedKey(cmbSupplier));
        fields.put("PackSize", txtPackSize.getText());
        if (itemID < 0) {
            db.newEntry(fields);
        } else {
            db.updateEntry(itemID, fields);
        }
        parent.refresh();
        parent.setSelectedKey(itemID);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        parent.setSelectedKey();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Pair> cmbSupplier;
    private javax.swing.JTextField txtExVAT;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPackSize;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
