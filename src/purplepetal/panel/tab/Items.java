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
import purplepetal.panel.PurplePanel;

/**
 * Add and edit items.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Items extends PurplePanel {
    private final DefaultListModel<Pair> mdlItems = new DefaultListModel<>();
    private final DocumentListener updateTotal = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateTotal();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            updateTotal();
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
            updateTotal();
        }
    };
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
     * Creates new form Items
     */
    public Items() {
        super("Item", "ItemID", "Name");
        initComponents();
        txtPackSize.getDocument().addDocumentListener(updateTotal);
        txtStock.getDocument().addDocumentListener(updateTotal);
        txtPrice.getDocument().addDocumentListener(updateExVAT);
        refresh();
    }

    @Override
    protected void clear() {
        clearFields(lstItems);
        clearFields(txtName, txtPackSize, txtPrice, txtStock);
        clearFields(cmbSupplier);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        javax.swing.JScrollPane scrItems = new javax.swing.JScrollPane();
        lstItems = new javax.swing.JList<Pair>();
        javax.swing.JPanel panDetails = new javax.swing.JPanel();
        javax.swing.JLabel labName = new javax.swing.JLabel();
        javax.swing.JLabel labSupplier = new javax.swing.JLabel();
        javax.swing.JLabel labPrice = new javax.swing.JLabel();
        javax.swing.JLabel labPackSize = new javax.swing.JLabel();
        javax.swing.JLabel labStock = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtPackSize = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        cmbSupplier = new javax.swing.JComboBox<Pair>();
        javax.swing.JSeparator sep2 = new javax.swing.JSeparator();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JButton btnCancel = new javax.swing.JButton();
        javax.swing.JButton btnDelete = new javax.swing.JButton();
        javax.swing.JButton btnNew = new javax.swing.JButton();
        javax.swing.JLabel labTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        javax.swing.JLabel labPound2 = new javax.swing.JLabel();
        javax.swing.JLabel labExVAT = new javax.swing.JLabel();
        txtExVAT = new javax.swing.JTextField();
        javax.swing.JLabel labPound1 = new javax.swing.JLabel();
        javax.swing.JButton btnCalc = new javax.swing.JButton();

        spl1.setDividerLocation(250);

        lstItems.setModel(mdlItems);
        lstItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstItemsValueChanged(evt);
            }
        });
        scrItems.setViewportView(lstItems);

        spl1.setLeftComponent(scrItems);

        labName.setText("Name");

        labSupplier.setText("Supplier");

        labPrice.setText("Price");

        labPackSize.setText("Pack Size");

        labStock.setText("Stock");

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

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        labTotal.setText("Total");

        txtTotal.setEditable(false);

        labPound2.setText("£");

        labExVAT.setText("Ex. VAT");

        labPound1.setText("£");

        btnCalc.setText("Calc");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panDetailsLayout = new javax.swing.GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep2)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                    .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labPound2))
                            .addComponent(labPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panDetailsLayout.createSequentialGroup()
                                .addGap(0, 26, Short.MAX_VALUE)
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(cmbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panDetailsLayout.createSequentialGroup()
                                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panDetailsLayout.createSequentialGroup()
                                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(labExVAT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labPound1))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panDetailsLayout.createSequentialGroup()
                                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(labTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                            .addComponent(txtExVAT))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCalc)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(labSupplier)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound2)
                    .addComponent(labExVAT)
                    .addComponent(txtExVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPound1)
                    .addComponent(btnCalc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPackSize)
                    .addComponent(txtPackSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labStock)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labTotal)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete)
                    .addComponent(btnNew))
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
        refreshLists(mdlItems, itemsCombo);
    }
    
    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void lstItemsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstItemsValueChanged
        if (!lstItems.isSelectionEmpty()) {
            int id = lstItems.getSelectedValue().getKey();
            try {
                ResultSet rs = getEntry(id);
                while (rs.next()) {
                    txtName.setText(rs.getString("Name"));
                    int packSize = rs.getInt("PackSize");
                    txtPackSize.setText(Integer.toString(packSize));
                    txtPrice.setText(rs.getString("Price"));
                    updateExVAT();
                    int stock = rs.getInt("Stock");
                    txtStock.setText(Integer.toString(stock));
                    txtTotal.setText(Integer.toString(packSize * stock));
                    comboSelectKey(cmbSupplier, rs.getInt("SupplierREF"));
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstItemsValueChanged

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        HashMap<String, String> fields = new HashMap<>(4);
        fields.put("Name", wrap(txtName.getText()));
        fields.put("Price", wrap(txtPrice.getText()));
        fields.put("SupplierREF", comboGetSelection(cmbSupplier).getKeyString());
        fields.put("PackSize", wrap(txtPackSize.getText()));
        fields.put("Stock", wrap(txtStock.getText()));
        if (lstItems.isSelectionEmpty()) {
            newEntry(fields);
        } else {
            updateEntry(lstItems.getSelectedValue().getKey(), fields);
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstItemsValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records

        if (!lstItems.isSelectionEmpty()) {
            deleteEntry(lstItems.getSelectedValue().getKey());
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed
        updateIncVAT();
    }//GEN-LAST:event_btnCalcActionPerformed

    private void updateTotal() {
        String stockText = txtStock.getText();
        int stock = 0;
        if (!stockText.isEmpty()) {
            stock = Integer.parseInt(stockText);
        }
        String packSizeText = txtPackSize.getText();
        int packSize = 0;
        if (!packSizeText.isEmpty()) {
            packSize = Integer.parseInt(packSizeText);
        }
        txtTotal.setText(Integer.toString(stock * packSize));
    }
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Pair> cmbSupplier;
    private javax.swing.JList<Pair> lstItems;
    private javax.swing.JTextField txtExVAT;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPackSize;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Items.class.getName());
}
