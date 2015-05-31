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
                int stock = rs.getInt("Stock");
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
        double incVAT = exVAT / (1.0 + getVAT());
        txtPrice.setText(String.format("%.2f", incVAT));
    }
    
    private void updateExVAT() {
        String incText = txtPrice.getText();
        double incVAT = 0;
        if (!incText.isEmpty()) {
            incVAT = Double.parseDouble(incText);
        }
        double exVAT = incVAT * (1.0 + getVAT());
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
        javax.swing.JLabel labPound2 = new javax.swing.JLabel();
        txtExVAT = new javax.swing.JTextField();
        javax.swing.JLabel labPound1 = new javax.swing.JLabel();
        javax.swing.JLabel labExVAT = new javax.swing.JLabel();
        javax.swing.JButton btnCalc = new javax.swing.JButton();
        cmbSupplier = new javax.swing.JComboBox<Pair>();
        txtName = new javax.swing.JTextField();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JButton btnCancel = new javax.swing.JButton();

        labName.setText("Name");

        labSupplier.setText("Supplier");

        labPrice.setText("Price");

        labPackSize.setText("Pack Size");

        labPound2.setText("£");

        labPound1.setText("£");

        labExVAT.setText("Ex. VAT");

        btnCalc.setText("Calc");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        cmbSupplier.setModel(suppliersCombo);

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
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancel)
                            .addGap(254, 254, 254))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                        .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labPound2))
                                .addComponent(labPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(labExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labPound1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnCalc)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
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
                        .addComponent(labPound2)
                        .addComponent(labExVAT)
                        .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labPound1)
                        .addComponent(btnCalc))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labPackSize)
                        .addComponent(txtPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnCancel))
                    .addContainerGap(65, Short.MAX_VALUE)))
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
