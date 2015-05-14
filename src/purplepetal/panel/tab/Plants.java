package purplepetal.panel.tab;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import purplepetal.Pair;
import purplepetal.Part;
import purplepetal.panel.PurplePanel;

/**
 * Allows editing of plants in the database.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Plants extends PurplePanel {
    private final DefaultListModel<Pair> mdlPlants = new DefaultListModel<>();
    private final DefaultListModel<Part> mdlEntries = new DefaultListModel<>();
    private final DocumentListener updateExVAT = new DocumentListener() {
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

    /**
     * Initialise components.
     */
    public Plants() {
        super("Plant", "PlantID", "CommonName");
        initComponents();
        txtPrice.getDocument().addDocumentListener(updateExVAT);
        refresh();
        updatePlantTypesCombo();
    }

    @Override
    protected void clear() {
        clearFields(lstPlants, lstEntries);
        mdlEntries.clear();
        clearFields(txtName, txtLatin, txtPrice, txtTraySize, txtStock);
        clearFields(cmbSupplier, cmbType);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        final javax.swing.JScrollPane scrPlants = new javax.swing.JScrollPane();
        lstPlants = new javax.swing.JList<Pair>();
        final javax.swing.JPanel panDetails = new javax.swing.JPanel();
        final javax.swing.JLabel labName = new javax.swing.JLabel();
        final javax.swing.JLabel labLatin = new javax.swing.JLabel();
        final javax.swing.JLabel labSupplier = new javax.swing.JLabel();
        final javax.swing.JLabel labType = new javax.swing.JLabel();
        final javax.swing.JLabel labPrice = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLatin = new javax.swing.JTextField();
        cmbSupplier = new javax.swing.JComboBox<Pair>();
        cmbType = new javax.swing.JComboBox<Pair>();
        txtPrice = new javax.swing.JTextField();
        btnNewType = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        javax.swing.JSeparator sep1 = new javax.swing.JSeparator();
        final javax.swing.JButton btnNew = new javax.swing.JButton();
        javax.swing.JLabel labPound1 = new javax.swing.JLabel();
        javax.swing.JLabel labExVAT = new javax.swing.JLabel();
        txtExVAT = new javax.swing.JTextField();
        javax.swing.JLabel labPound2 = new javax.swing.JLabel();
        javax.swing.JButton btnCalc = new javax.swing.JButton();
        javax.swing.JLabel labTraySize = new javax.swing.JLabel();
        txtTraySize = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JLabel labStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        javax.swing.JScrollPane scrEntries = new javax.swing.JScrollPane();
        lstEntries = new javax.swing.JList<Part>();

        spl1.setDividerLocation(250);

        lstPlants.setModel(mdlPlants);
        lstPlants.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlantsValueChanged(evt);
            }
        });
        scrPlants.setViewportView(lstPlants);

        spl1.setLeftComponent(scrPlants);

        labName.setText("Common");

        labLatin.setText("Latin");

        labSupplier.setText("Supplier");

        labType.setText("Type");

        labPrice.setText("Price");

        cmbSupplier.setModel(suppliersCombo);

        cmbType.setModel(plantTypesCombo);

        btnNewType.setText("New Type");
        btnNewType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTypeActionPerformed(evt);
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

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        labPound1.setText("£");

        labExVAT.setText("Ex. VAT");

        labPound2.setText("£");

        btnCalc.setText("Calc");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        labTraySize.setText("Tray Size");

        labStock.setText("Total Stock");

        lstEntries.setModel(mdlEntries);
        scrEntries.setViewportView(lstEntries);

        javax.swing.GroupLayout panDetailsLayout = new javax.swing.GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep1)
            .addComponent(jSeparator1)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrEntries)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(labTraySize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(labLatin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panDetailsLayout.createSequentialGroup()
                                        .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labPound1))
                                    .addComponent(labName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panDetailsLayout.createSequentialGroup()
                                        .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNewType))
                                    .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtLatin, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbSupplier, javax.swing.GroupLayout.Alignment.LEADING, 0, 250, Short.MAX_VALUE))
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panDetailsLayout.createSequentialGroup()
                                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTraySize, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(labExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labPound2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCalc))))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(labStock, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(labLatin)
                    .addComponent(txtLatin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSupplier)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labType)
                    .addComponent(cmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound1)
                    .addComponent(labExVAT)
                    .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound2)
                    .addComponent(btnCalc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTraySize)
                    .addComponent(txtTraySize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete)
                    .addComponent(btnNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labStock)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrEntries, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
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
        refreshLists(mdlPlants, plantsCombo);
    }
    
    private void lstPlantsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            try {
                int id = lstPlants.getSelectedValue().getKey();
                ResultSet rs = getEntry(id);
                int traySize = 0;
                while (rs.next()) {
                    txtName.setText(rs.getString("CommonName"));
                    txtLatin.setText(rs.getString("LatinName"));
                    comboSelectKey(cmbSupplier, rs.getInt("SupplierREF"));
                    comboSelectKey(cmbType, rs.getInt("TypeREF"));
                    txtPrice.setText(rs.getString("Price"));
                    traySize = rs.getInt("TraySize");
                    txtTraySize.setText(Integer.toString(traySize));
                    updateExVAT();
                }
                String query = String.format("SELECT * FROM PlantDiary WHERE PlantREF=%d;", id);
                rs = executeQuery(query);
                int stock = 0;
                mdlEntries.clear();
                while (rs.next()) {
                    int bought = rs.getInt("Bought");
                    int delivered = rs.getInt("Delivered");
                    int lost = rs.getInt("Lost");
                    if (bought > 0) {
                        mdlEntries.addElement(new Part(new Pair(id, rs.getString("Date") + " Bought"), bought));
                    }
                    if (delivered > 0) {
                        mdlEntries.addElement(new Part(new Pair(id, rs.getString("Date") + " Delivered"), delivered));
                    }
                    if (lost > 0) {
                        mdlEntries.addElement(new Part(new Pair(id, rs.getString("Date") + " Lost"), lost));
                    }
                    stock += delivered * traySize - lost;
                }
                setFields(Integer.toString(stock), txtStock);
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstPlantsValueChanged

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HashMap<String, String> values = new HashMap<>(5);
        values.put("CommonName", wrap(txtName.getText()));
        values.put("LatinName", wrap(txtLatin.getText()));
        values.put("SupplierREF", comboGetSelection(cmbSupplier).getKeyString());
        values.put("TypeREF", comboGetSelection(cmbType).getKeyString());
        String textPrice = txtPrice.getText();
        if (textPrice.isEmpty()) {
            values.put("Price", "0");
        } else {
            values.put("Price", textPrice);
        }
        values.put("TraySize", txtTraySize.getText());
        if (lstPlants.isSelectionEmpty()) {
            newEntry(values);
        } else {
            updateEntry(lstPlants.getSelectedValue().getKey(), values);
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstPlantsValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewTypeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewTypeActionPerformed
        String newName = JOptionPane.showInputDialog(this, "Enter new plant type:");
        if (newName != null && newName.length() > 0) {
            executeUpdate("INSERT INTO PlantType (Description) VALUES ('" + newName + "');");
            updatePlantTypesCombo();
        }
    }//GEN-LAST:event_btnNewTypeActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records

        if (!lstPlants.isSelectionEmpty()) {
            deleteEntry(lstPlants.getSelectedValue().getKey());
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void updateIncVAT() {
        String exText = txtExVAT.getText();
        double exVAT = 0;
        if (!exText.isEmpty()) {
            exVAT = Double.parseDouble(exText);
        }
        double incVAT = exVAT / (1.0 + VAT);
        txtPrice.setText(String.format("%.2f", incVAT));
    }
    
    private void updateExVAT() {
        String incText = txtPrice.getText();
        double incVAT = 0;
        if (!incText.isEmpty()) {
            incVAT = Double.parseDouble(incText);
        }
        double exVAT = incVAT * (1.0 + VAT);
        txtExVAT.setText(String.format("%.2f", exVAT));
    }
    
    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        updateIncVAT();
    }//GEN-LAST:event_btnCalcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewType;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Pair> cmbSupplier;
    private javax.swing.JComboBox<Pair> cmbType;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<Part> lstEntries;
    private javax.swing.JList<Pair> lstPlants;
    private javax.swing.JTextField txtExVAT;
    private javax.swing.JTextField txtLatin;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTraySize;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Plants.class.getName());
}
