package purplepetal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Allows editing of plants in the database.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Plants extends PurplePanel {
    private final DefaultListModel<Pair> mdlPlants = new DefaultListModel<>();

    /**
     * Initialise components.
     */
    public Plants() {
        initComponents();
        btnRefreshActionPerformed(null);
        updatePlantTypesCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSplitPane spl1 = new JSplitPane();
        JPanel panPlants = new JPanel();
        final JScrollPane scrPlants = new JScrollPane();
        lstPlants = new JList<Pair>();
        final JButton btnNew = new JButton();
        final JButton btnRefresh = new JButton();
        final JPanel panDetails = new JPanel();
        final JLabel labName = new JLabel();
        final JLabel labLatin = new JLabel();
        final JLabel labSupplier = new JLabel();
        final JLabel labType = new JLabel();
        final JLabel labPrice = new JLabel();
        txtName = new JTextField();
        txtLatin = new JTextField();
        cmbSupplier = new JComboBox<Pair>();
        cmbType = new JComboBox<Pair>();
        txtPrice = new JTextField();
        btnNewType = new JButton();
        btnCancel = new JButton();
        btnDelete = new JButton();
        btnSave = new JButton();
        JSeparator sep1 = new JSeparator();

        spl1.setDividerLocation(250);

        lstPlants.setModel(mdlPlants);
        lstPlants.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                lstPlantsValueChanged(evt);
            }
        });
        scrPlants.setViewportView(lstPlants);

        btnNew.setText("New");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        GroupLayout panPlantsLayout = new GroupLayout(panPlants);
        panPlants.setLayout(panPlantsLayout);
        panPlantsLayout.setHorizontalGroup(panPlantsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panPlantsLayout.createSequentialGroup()
                .addGroup(panPlantsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panPlantsLayout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNew)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addComponent(scrPlants, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panPlantsLayout.setVerticalGroup(panPlantsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panPlantsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrPlants)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPlantsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnRefresh))
                .addGap(0, 0, 0))
        );

        spl1.setLeftComponent(panPlants);

        labName.setText("Common Name");

        labLatin.setText("Latin Name");

        labSupplier.setText("Supplier");

        labType.setText("Type");

        labPrice.setText("Price");

        cmbSupplier.setModel(suppliersCombo);

        cmbType.setModel(plantTypesCombo);

        btnNewType.setText("New Type");
        btnNewType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNewTypeActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        GroupLayout panDetailsLayout = new GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(labName, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(labLatin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labSupplier, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labPrice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtName)
                    .addComponent(txtLatin)
                    .addComponent(cmbSupplier, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(cmbType, 0, 185, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewType))
                    .addComponent(txtPrice)))
            .addComponent(sep1)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addComponent(btnSave)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panDetailsLayout.setVerticalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labName)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labLatin)
                    .addComponent(txtLatin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labSupplier)
                    .addComponent(cmbSupplier, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labType)
                    .addComponent(cmbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewType))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labPrice)
                    .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addContainerGap(215, Short.MAX_VALUE))
        );

        spl1.setRightComponent(panDetails);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(spl1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        mdlPlants.clear();
        try (Statement s = createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM Plant;")) {
            plantsCombo.addElement(new Pair(-1, ""));
            while (rs.next()) {
                mdlPlants.addElement(new Pair(rs.getInt("PlantID"), rs.getString("CommonName")));
                plantsCombo.addElement(new Pair(rs.getInt("PlantID"), rs.getString("CommonName")));
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void lstPlantsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            int id = lstPlants.getSelectedValue().getKey();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Plant WHERE PlantID = " + id + ";")) {
                while (rs.next()) {
                    txtName.setText(rs.getString("CommonName"));
                    txtLatin.setText(rs.getString("LatinName"));
                    selectKey(cmbSupplier, rs.getInt("SupplierREF"));
                    selectKey(cmbType, rs.getInt("TypeREF"));
                    txtPrice.setText(rs.getString("Price"));
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstPlantsValueChanged

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        lstPlants.clearSelection();
        txtName.setText("");
        txtLatin.setText("");
        cmbSupplier.setSelectedIndex(0);
        cmbType.setSelectedIndex(0);
        txtPrice.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try (Statement s = createStatement()) {
            String[] data = new String[3];
            int[] refs = new int[2];
            data[0] = txtName.getText();
            data[1] = txtLatin.getText();
            data[2] = txtPrice.getText();
            refs[0] = getSelection(cmbSupplier).getKey();
            refs[1] = getSelection(cmbType).getKey();
            if (lstPlants.isSelectionEmpty()) {
                s.executeUpdate("INSERT INTO Plant (CommonName, LatinName, SupplierREF, TypeREF, Price) VALUES (" +
                    "'" + data[0] + "', " +
                    "'" + data[1] + "', " +
                    refs[0] + ", " + refs[1] + ", " +
                    "'" + data[2] + "');");
            } else {
                int id = lstPlants.getSelectedValue().getKey();
                s.executeUpdate("UPDATE Plant SET " +
                    "CommonName = '" + data[0] + "', " +
                    "LatinName = '" + data[1] + "', " +
                    "SupplierREF = " + refs[0] + ", " +
                    "TypeREF = " + refs[1] + ", " +
                    "Price = '" + data[2] + "' " +
                    "WHERE PlantID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstPlantsValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewTypeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewTypeActionPerformed
        String newName = JOptionPane.showInputDialog(this, "Enter new plant type:");
        if (newName != null && newName.length() > 0) {
            try (Statement s = createStatement()) {
                s.executeUpdate("INSERT INTO PlantType (Description) VALUES ('" + newName + "');");
                updatePlantTypesCombo();
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_btnNewTypeActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try (Statement s = createStatement()) {
            if (!lstPlants.isSelectionEmpty()) {
                int id = lstPlants.getSelectedValue().getKey();
                s.executeUpdate("DELETE FROM Plant WHERE PlantID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCancel;
    private JButton btnDelete;
    private JButton btnNewType;
    private JButton btnSave;
    private JComboBox<Pair> cmbSupplier;
    private JComboBox<Pair> cmbType;
    private JList<Pair> lstPlants;
    private JTextField txtLatin;
    private JTextField txtName;
    private JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Plants.class.getName());
}
