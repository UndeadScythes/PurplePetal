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

        JButton btnCalc = new JButton();
        txtExVAT = new JTextField();
        JLabel labPound2 = new JLabel();
        btnNewType = new JButton();
        cmbType = new JComboBox<Pair>();
        cmbSupplier = new JComboBox<Pair>();
        txtLatin = new JTextField();
        txtName = new JTextField();
        final JLabel labName = new JLabel();
        final JLabel labLatin = new JLabel();
        final JLabel labSupplier = new JLabel();
        final JLabel labType = new JLabel();
        final JLabel labPrice = new JLabel();
        JLabel labTraySize = new JLabel();
        JLabel labPound1 = new JLabel();
        txtPrice = new JTextField();
        txtTraySize = new JTextField();
        JLabel labExVAT = new JLabel();
        btnSave = new JButton();
        btnCancel = new JButton();

        btnCalc.setText("Calc");
        btnCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        labPound2.setText("£");

        btnNewType.setText("New Type");
        btnNewType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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

        labExVAT.setText("Ex. VAT");

        btnSave.setText("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labTraySize, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labType, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labSupplier, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labLatin, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labPound1))
                    .addComponent(labName, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTraySize, GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(labExVAT, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labPound2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExVAT, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalc))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewType))
                    .addComponent(cmbSupplier, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(txtLatin)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labName)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labLatin)
                    .addComponent(txtLatin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labSupplier)
                    .addComponent(cmbSupplier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labType)
                    .addComponent(cmbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewType))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labPrice)
                    .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound1)
                    .addComponent(labExVAT)
                    .addComponent(txtExVAT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound2)
                    .addComponent(btnCalc))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labTraySize)
                    .addComponent(txtTraySize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
    private JButton btnCancel;
    private JButton btnNewType;
    private JButton btnSave;
    private JComboBox<Pair> cmbSupplier;
    private JComboBox<Pair> cmbType;
    private JTextField txtExVAT;
    private JTextField txtLatin;
    private JTextField txtName;
    private JTextField txtPrice;
    private JTextField txtTraySize;
    // End of variables declaration//GEN-END:variables
}
