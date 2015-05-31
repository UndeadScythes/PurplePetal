package com.undeadscythes.purplepetal.panels.suppliers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Show supplier details.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class SupplierDisplay extends SupplierPanel {
    private final int supplierID;
    private final String website;
    private final String email;
    
    /**
     * Creates new form SupplierDisplay
     * @param supplierID
     * @throws java.sql.SQLException
     */
    public SupplierDisplay(int supplierID) throws SQLException {
        super(supplierID);
        this.supplierID = supplierID;
        initComponents();
        ResultSet rs = db.getEntry(supplierID);
        String websiteString = "";
        String emailString = "";
        if (rs.next()) {
            websiteString = rs.getString("Website");
            emailString = rs.getString("ContactEmail");
            labName.setText(rs.getString("Name"));
            labContact.setText(rs.getString("ContactNo"));
            labEmail.setText(String.format("<html><a href=''>%s</a></html>", emailString));
            labWebsite.setText(String.format("<html><a href=''>%s</a></html>", websiteString));
            String address = String.format("%s, %s, %s", rs.getString("StreetName"), rs.getString("Town"), rs.getString("Postcode"));
            labStreet.setText(address);
            labAccountNo.setText("Account No: " + rs.getString("AccountNo"));
        }
        website = websiteString;
        email = emailString;
    }

    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labName = new javax.swing.JLabel();
        labAccountNo = new javax.swing.JLabel();
        labStreet = new javax.swing.JLabel();
        labContact = new javax.swing.JLabel();
        labEmail = new javax.swing.JLabel();
        labWebsite = new javax.swing.JLabel();

        labName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labName.setText("<SupplierName>");

        labAccountNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labAccountNo.setText("Account No: <AccountNo>");

        labStreet.setText("<Street>, <Town>, <PostCode>");

        labContact.setText("<ContactNo>");

        labEmail.setText("<Email>");
        labEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labEmailMouseClicked(evt);
            }
        });

        labWebsite.setText("\\<HTML><website>\\</HTML>");
        labWebsite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labWebsite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labWebsiteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labAccountNo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(labStreet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labWebsite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labAccountNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labStreet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labContact)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labWebsite)
                .addGap(0, 182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labWebsiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labWebsiteMouseClicked
        try {
            Desktop.getDesktop().browse(new URI(website));
        } catch (IOException | URISyntaxException ex) {
            error(ex);
        }
    }//GEN-LAST:event_labWebsiteMouseClicked

    private void labEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labEmailMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("mailto:" + email));
        } catch (IOException | URISyntaxException ex) {
            error(ex);
        }
    }//GEN-LAST:event_labEmailMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labAccountNo;
    private javax.swing.JLabel labContact;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labName;
    private javax.swing.JLabel labStreet;
    private javax.swing.JLabel labWebsite;
    // End of variables declaration//GEN-END:variables
}
