package purplepetal.panel.tab;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import purplepetal.Pair;
import purplepetal.panel.PurplePanel;

/**
 * Panel containing methods to modify suppliers.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Suppliers extends PurplePanel {
    private final DefaultListModel<Pair> mdlSuppliers = new DefaultListModel<>();

    /**
     * Initialise panel components.
     */
    public Suppliers() {
        initComponents();
        btnRefreshActionPerformed(null);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        javax.swing.JPanel panSuppliers = new javax.swing.JPanel();
        final javax.swing.JScrollPane scrSuppliers = new javax.swing.JScrollPane();
        lstSuppliers = new javax.swing.JList<Pair>();
        final javax.swing.JButton btnNew = new javax.swing.JButton();
        final javax.swing.JButton btnRefresh = new javax.swing.JButton();
        javax.swing.JSeparator sep2 = new javax.swing.JSeparator();
        final javax.swing.JPanel panDetails = new javax.swing.JPanel();
        final javax.swing.JLabel labName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        final javax.swing.JLabel labContactNo = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        javax.swing.JLabel labEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        final javax.swing.JLabel labWebsite = new javax.swing.JLabel();
        txtWebsite = new javax.swing.JTextField();
        javax.swing.JLabel labStreet = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        javax.swing.JLabel labTown = new javax.swing.JLabel();
        txtTown = new javax.swing.JTextField();
        final javax.swing.JLabel labPostcode = new javax.swing.JLabel();
        txtPostcode = new javax.swing.JTextField();
        final javax.swing.JLabel labAccount = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        javax.swing.JSeparator sep1 = new javax.swing.JSeparator();
        final javax.swing.JButton btnSave = new javax.swing.JButton();
        final javax.swing.JButton btnCancel = new javax.swing.JButton();
        javax.swing.JButton btnDelete = new javax.swing.JButton();

        spl1.setDividerLocation(250);

        lstSuppliers.setModel(mdlSuppliers);
        lstSuppliers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstSuppliers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSuppliersValueChanged(evt);
            }
        });
        scrSuppliers.setViewportView(lstSuppliers);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panSuppliersLayout = new javax.swing.GroupLayout(panSuppliers);
        panSuppliers.setLayout(panSuppliersLayout);
        panSuppliersLayout.setHorizontalGroup(
            panSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sep2)
            .addGroup(panSuppliersLayout.createSequentialGroup()
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew)
                .addGap(0, 119, Short.MAX_VALUE))
        );
        panSuppliersLayout.setVerticalGroup(
            panSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrSuppliers, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnNew)))
        );

        spl1.setLeftComponent(panSuppliers);

        labName.setText("Name");

        labContactNo.setText("Contact No");

        labEmail.setText("Email");

        labWebsite.setText("Website");

        labStreet.setText("Street");

        labTown.setText("Town");

        labPostcode.setText("Postcode");

        labAccount.setText("Account No");

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

        javax.swing.GroupLayout panDetailsLayout = new javax.swing.GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labName, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAccount))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactNo))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWebsite))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStreet))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labTown, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTown))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPostcode)))
                .addGap(10, 10, 10))
            .addComponent(sep1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(0, 348, Short.MAX_VALUE))
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
                    .addComponent(labContactNo)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labWebsite)
                    .addComponent(txtWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labStreet)
                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTown)
                    .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPostcode)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labAccount)
                    .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        spl1.setRightComponent(panDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lstSuppliersValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstSuppliersValueChanged
        if (!lstSuppliers.isSelectionEmpty()) {
            int id = lstSuppliers.getSelectedValue().getKey();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Supplier WHERE SupplierID = " + id + ";")) {
                while (rs.next()) {
                    txtName.setText(rs.getString("Name"));
                    txtContactNo.setText(rs.getString("ContactNo"));
                    txtEmail.setText(rs.getString("ContactEmail"));
                    txtWebsite.setText(rs.getString("Website"));
                    txtStreet.setText(rs.getString("StreetName"));
                    txtTown.setText(rs.getString("Town"));
                    txtPostcode.setText(rs.getString("Postcode"));
                    txtAccount.setText(rs.getString("AccountNo"));
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstSuppliersValueChanged

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try (Statement s = createStatement()) {
            String name = txtName.getText();
            String contactNo = txtContactNo.getText();
            String contactEmail = txtEmail.getText();
            String website = txtWebsite.getText();
            String street = txtStreet.getText();
            String town = txtTown.getText();
            String postcode = txtPostcode.getText();
            String account = txtAccount.getText();
            if (lstSuppliers.isSelectionEmpty()) {
                s.executeUpdate("INSERT INTO Supplier (Name, ContactNo, ContactEmail, Website, StreetName, Town, Postcode, AccountNo) VALUES (" +
                        "'" + name + "', " +
                        "'" + contactNo + "', " +
                        "'" + contactEmail + "', " +
                        "'" + website + "', " +
                        "'" + street + "', " +
                        "'" + town + "', " +
                        "'" + postcode + "', " +
                        "'" + account + "');");
            } else {
                int id = lstSuppliers.getSelectedValue().getKey();
                s.executeUpdate("UPDATE Supplier SET " +
                        "Name = '" + name + "', " +
                        "ContactNo = '" + contactNo + "', " +
                        "ContactEmail = '" + contactEmail + "', " +
                        "Website = '" + website + "', " +
                        "StreetName = '" + street + "', " +
                        "Town = '" + town + "', " +
                        "Postcode = '" + postcode + "', " +
                        "AccountNo = '" + account + "' " +
                        "WHERE SupplierID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstSuppliersValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        lstSuppliers.clearSelection();
        txtName.setText("");
        txtContactNo.setText("");
        txtWebsite.setText("");
        txtPostcode.setText("");
        txtAccount.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnRefreshActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        mdlSuppliers.clear();
        suppliersCombo.removeAllElements();
        suppliersCombo.addElement(new Pair(-1, ""));
        try (Statement s = createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM Supplier;")) {
            while (rs.next()) {
                mdlSuppliers.addElement(new Pair(rs.getInt("SupplierID"), rs.getString("Name")));
                suppliersCombo.addElement(new Pair(rs.getInt("SupplierID"), rs.getString("Name")));
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try (Statement s = createStatement()) {
            JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records
            
            if (!lstSuppliers.isSelectionEmpty()) {
                int id = lstSuppliers.getSelectedValue().getKey();
                s.executeUpdate("DELETE FROM Supplier WHERE SupplierID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Pair> lstSuppliers;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtTown;
    private javax.swing.JTextField txtWebsite;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Suppliers.class.getName());
}
