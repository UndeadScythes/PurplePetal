package purplepetal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*; // NB code
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Panel containing methods to modify suppliers.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
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

        final JPanel panDetails = new JPanel();
        final JLabel labName = new JLabel();
        txtName = new JTextField();
        final JLabel labContactNo = new JLabel();
        txtContactNo = new JTextField();
        JLabel labEmail = new JLabel();
        txtEmail = new JTextField();
        final JLabel labWebsite = new JLabel();
        txtWebsite = new JTextField();
        JLabel labStreet = new JLabel();
        txtStreet = new JTextField();
        JLabel labTown = new JLabel();
        txtTown = new JTextField();
        final JLabel labPostcode = new JLabel();
        txtPostcode = new JTextField();
        final JLabel labAccount = new JLabel();
        txtAccount = new JTextField();
        JSeparator sep1 = new JSeparator();
        final JButton btnSave = new JButton();
        final JButton btnCancel = new JButton();
        JButton btnDelete = new JButton();
        JPanel panSuppliers = new JPanel();
        final JScrollPane scrSuppliers = new JScrollPane();
        lstSuppliers = new JList<Pair>();
        final JButton btnNew = new JButton();
        final JButton btnRefresh = new JButton();

        labName.setText("Name");

        labContactNo.setText("Contact No");

        labEmail.setText("Email");

        labWebsite.setText("Website");

        labStreet.setText("Street");

        labTown.setText("Town");

        labPostcode.setText("Postcode");

        labAccount.setText("Account No");

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

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        GroupLayout panDetailsLayout = new GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labName, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labAccount, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAccount))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labContactNo, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactNo))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labEmail, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labWebsite, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWebsite))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labStreet, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStreet))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labTown, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTown))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labPostcode, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPostcode)))
                .addGap(10, 10, 10))
            .addComponent(sep1, GroupLayout.Alignment.TRAILING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addComponent(btnSave)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(0, 207, Short.MAX_VALUE))
        );
        panDetailsLayout.setVerticalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labName)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labContactNo)
                    .addComponent(txtContactNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labEmail)
                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labWebsite)
                    .addComponent(txtWebsite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labStreet)
                    .addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labTown)
                    .addComponent(txtTown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labPostcode)
                    .addComponent(txtPostcode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labAccount)
                    .addComponent(txtAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete)))
        );

        lstSuppliers.setModel(mdlSuppliers);
        lstSuppliers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstSuppliers.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                lstSuppliersValueChanged(evt);
            }
        });
        scrSuppliers.setViewportView(lstSuppliers);

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

        GroupLayout panSuppliersLayout = new GroupLayout(panSuppliers);
        panSuppliers.setLayout(panSuppliersLayout);
        panSuppliersLayout.setHorizontalGroup(panSuppliersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrSuppliers, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
            .addGroup(panSuppliersLayout.createSequentialGroup()
                .addComponent(btnRefresh)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew))
        );
        panSuppliersLayout.setVerticalGroup(panSuppliersLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrSuppliers, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSuppliersLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnRefresh)))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panSuppliers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panSuppliers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
//
// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records
//            
//            if (!lstSuppliers.isSelectionEmpty()) {
//                int id = lstSuppliers.getSelectedValue().getKey();
//                s.executeUpdate("DELETE FROM Supplier WHERE SupplierID = " + id + ";");
//            }
//            btnRefreshActionPerformed(null);
//            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JList<Pair> lstSuppliers;
    private JTextField txtAccount;
    private JTextField txtContactNo;
    private JTextField txtEmail;
    private JTextField txtName;
    private JTextField txtPostcode;
    private JTextField txtStreet;
    private JTextField txtTown;
    private JTextField txtWebsite;
    // End of variables declaration//GEN-END:variables
}
