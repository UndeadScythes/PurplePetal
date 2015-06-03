package com.undeadscythes.purplepetal.panels.products;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.keyables.typedpart.TypedPart;
import com.undeadscythes.purplepetal.panels.PurplePanel;

/**
 *
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"ClassWithoutLogger", "serial"})
public class NewComponent extends PurplePanel {
    /**
     * Creates new form NewComponent
     * @param type_
     */
    public NewComponent(ProductPartType type_) {
        initComponents();
        type = type_;
        switch (type) {
            case PLANT:
                cmbSelection.setModel(plantsCombo);
                break;
            case FEEDSTOCK:
                cmbSelection.setModel(feedstockCombo);
                break;
        }
    }
    
    private final ProductPartType type;
    
    /**
     * Get the user's selection.
     * @return
     */
    public TypedPart getSelection() {
        return new TypedPart((Pair) cmbSelection.getSelectedItem(), Integer.parseInt(txtQuantity.getText()), type);
    }
    
    @SuppressWarnings({"unchecked", "Convert2Diamond"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtQuantity = new javax.swing.JTextField();
        javax.swing.JLabel labQuantity = new javax.swing.JLabel();
        cmbSelection = new javax.swing.JComboBox<Pair>();

        txtQuantity.setText("1");

        labQuantity.setText("Quantity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(cmbSelection, 0, 250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmbSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Pair> cmbSelection;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
