package com.undeadscythes.purplepetal.panels.plants;

import com.undeadscythes.purplepetal.db.Plant;
import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.utilities.DBStep;
import com.undeadscythes.purplepetal.utilities.Swingers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * For editing plant details.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class PlantEditor extends PlantPanel {
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
    
    private final int plantID;
    private final Plants parent;
    
    /**
     * Creates new form PlantEditor.
     * @param parent
     * @throws java.sql.SQLException
     */
    public PlantEditor(Plants parent) throws SQLException {
        this(parent, -1);
    }
    
    /**
     * Creates new form PlantEditor to edit a given plant.
     * @param parent
     * @param plantID
     * @throws java.sql.SQLException
     */
    public PlantEditor(Plants parent, int plantID) throws SQLException {
        super(plantID);
        this.parent = parent;
        this.plantID = plantID;
        initComponents();
        txtPrice.getDocument().addDocumentListener(updateExVAT);
        if (plantID > -1) {
            populate();
        }
    }
    
    private void populate() throws SQLException {
        ResultSet rs = db.getEntry(plantID);
        while (rs.next()) {
            txtLatin.setText(rs.getString(Plant.LATIN.toString()));
            txtName.setText(rs.getString("CommonName"));
            txtPrice.setText(Float.toString(rs.getFloat("Price")));
            txtTraySize.setText(Integer.toString(rs.getInt("TraySize")));
            Swingers.setSelectedItem(cmbSupplier, rs.getInt("SupplierREF"));
            Swingers.setSelectedItem(cmbType, rs.getInt("TypeREF"));
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
    
    @SuppressWarnings({"unchecked", "Convert2Lambda", "Convert2Diamond"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton btnCalc = new javax.swing.JButton();
        txtExVAT = new javax.swing.JTextField();
        javax.swing.JLabel labPound2 = new javax.swing.JLabel();
        btnNewType = new javax.swing.JButton();
        cmbType = new javax.swing.JComboBox<Pair>();
        cmbSupplier = new javax.swing.JComboBox<Pair>();
        txtLatin = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        final javax.swing.JLabel labName = new javax.swing.JLabel();
        final javax.swing.JLabel labLatin = new javax.swing.JLabel();
        final javax.swing.JLabel labSupplier = new javax.swing.JLabel();
        final javax.swing.JLabel labType = new javax.swing.JLabel();
        final javax.swing.JLabel labPrice = new javax.swing.JLabel();
        javax.swing.JLabel labTraySize = new javax.swing.JLabel();
        javax.swing.JLabel labPound1 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtTraySize = new javax.swing.JTextField();
        javax.swing.JLabel labExVAT = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        btnCalc.setText("Calc");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        labPound2.setText("£");

        btnNewType.setText("New Type");
        btnNewType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTypeActionPerformed(evt);
            }
        });

        cmbType.setModel(plantTypesCombo);

        cmbSupplier.setModel(suppliersCombo);

        labName.setText("Common");

        labLatin.setText("Latin");

        labSupplier.setText("Supplier");

        labType.setText("Type");

        labPrice.setText("Price");

        labTraySize.setText("Tray Size");

        labPound1.setText("£");

        labExVAT.setText("Inc. VAT");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labTraySize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labLatin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labPound1))
                    .addComponent(labName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTraySize, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labPound2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalc))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewType))
                    .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(txtLatin)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labLatin)
                    .addComponent(txtLatin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSupplier)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labType)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound1)
                    .addComponent(labExVAT)
                    .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound2)
                    .addComponent(btnCalc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTraySize)
                    .addComponent(txtTraySize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        updateIncVAT();
    }//GEN-LAST:event_btnCalcActionPerformed

    private void btnNewTypeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewTypeActionPerformed
        String newName = JOptionPane.showInputDialog(this, "Enter new plant type:");
        if (newName != null && newName.length() > 0) {
            DBStep.executeUpdate("INSERT INTO PlantType (Description) VALUES ('" + newName + "');");
            updatePlantTypesCombo();
        }
    }//GEN-LAST:event_btnNewTypeActionPerformed

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HashMap<String, Object> values = new HashMap<>(5);
        values.put("CommonName", txtName.getText());
        values.put("LatinName", txtLatin.getText());
        values.put("SupplierREF", Swingers.getSelectedKey(cmbSupplier));
        values.put("TypeREF", Swingers.getSelectedKey(cmbType));
        String textPrice = txtPrice.getText();
        if (textPrice.isEmpty()) {
            values.put("Price", "0");
        } else {
            values.put("Price", textPrice);
        }
        values.put("TraySize", txtTraySize.getText());
        if (plantID < 0) {
            db.newEntry(values);
        } else {
            db.updateEntry(plantID, values);
        }
        parent.refresh();
        parent.setSelectedKey(plantID);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        parent.setSelectedKey(-1);
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNewType;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Pair> cmbSupplier;
    private javax.swing.JComboBox<Pair> cmbType;
    private javax.swing.JTextField txtExVAT;
    private javax.swing.JTextField txtLatin;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTraySize;
    // End of variables declaration//GEN-END:variables
}
