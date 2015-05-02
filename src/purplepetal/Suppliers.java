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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        final JPanel panDetails = new JPanel();
        final JLabel labName = new JLabel();
        final JLabel labContact = new JLabel();
        final JLabel labWebsite = new JLabel();
        final JLabel labAddress = new JLabel();
        final JLabel labAccount = new JLabel();
        txtAccount = new JTextField();
        txtAddress = new JTextField();
        txtWebsite = new JTextField();
        txtContact = new JTextField();
        txtName = new JTextField();
        final JButton btnSave = new JButton();
        final JButton btnCancel = new JButton();
        btnDelete = new JButton();
        JPanel panSuppliers = new JPanel();
        final JScrollPane scrSuppliers = new JScrollPane();
        lstSuppliers = new JList<Pair>();
        final JButton btnNew = new JButton();
        final JButton btnRefresh = new JButton();

        labName.setText("Name");

        labContact.setText("Contact");

        labWebsite.setText("Website");

        labAddress.setText("Address");

        labAccount.setText("AccountNo");

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
                .addComponent(btnSave)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addComponent(labAccount)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAccount))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labName, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labContact, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtContact)
                            .addComponent(txtName)))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labWebsite, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labAddress, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtWebsite)
                            .addComponent(txtAddress)))))
        );
        panDetailsLayout.setVerticalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labName)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labContact)
                    .addComponent(txtContact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labWebsite)
                    .addComponent(txtWebsite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labAddress)
                    .addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labAccount)
                    .addComponent(txtAccount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(scrSuppliers)
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
                .addContainerGap(605, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panSuppliers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lstSuppliersValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstSuppliersValueChanged
        if (!lstSuppliers.isSelectionEmpty()) {
            int id = lstSuppliers.getSelectedValue().getKey();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Supplier WHERE SupplierID = " + id + ";")) {
                while (rs.next()) {
                    txtName.setText(rs.getString("Name"));
                    txtContact.setText(rs.getString("Contact"));
                    txtWebsite.setText(rs.getString("Website"));
                    txtAddress.setText(rs.getString("Address"));
                    txtAccount.setText(rs.getString("AccountNo"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lstSuppliersValueChanged

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try (Statement s = createStatement()) {
            String[] data = new String[5];
            data[0] = txtName.getText();
            data[1] = txtContact.getText();
            data[2] = txtWebsite.getText();
            data[3] = txtAddress.getText();
            data[4] = txtAccount.getText();
            if (lstSuppliers.isSelectionEmpty()) {
                s.executeUpdate("INSERT INTO Supplier (Name, Contact, Website, Address, AccountNo) VALUES (" +
                        "'" + data[0] + "', " +
                        "'" + data[1] + "', " +
                        "'" + data[2] + "', " +
                        "'" + data[3] + "', " +
                        "'" + data[4] + "');");
            } else {
                int id = lstSuppliers.getSelectedValue().getKey();
                s.executeUpdate("UPDATE Supplier SET " +
                        "Name = '" + data[0] + "', " +
                        "Contact = '" + data[1] + "', " +
                        "Website = '" + data[2] + "', " +
                        "Address = '" + data[3] + "', " +
                        "AccountNo = '" + data[4] + "' " +
                        "WHERE SupplierID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstSuppliersValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        lstSuppliers.clearSelection();
        txtName.setText("");
        txtContact.setText("");
        txtWebsite.setText("");
        txtAddress.setText("");
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
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try (Statement s = createStatement()) {
            if (!lstSuppliers.isSelectionEmpty()) {
                int id = lstSuppliers.getSelectedValue().getKey();
                s.executeUpdate("DELETE FROM Supplier WHERE SupplierID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnDelete;
    private JList<Pair> lstSuppliers;
    private JTextField txtAccount;
    private JTextField txtAddress;
    private JTextField txtContact;
    private JTextField txtName;
    private JTextField txtWebsite;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Suppliers.class.getName());
}
