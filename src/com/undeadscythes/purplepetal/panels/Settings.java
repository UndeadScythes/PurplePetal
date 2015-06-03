package com.undeadscythes.purplepetal.panels;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import com.undeadscythes.purplepetal.frames.PurpleFrame;
import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.panels.PurplePanel;
import com.undeadscythes.purplepetal.panels.PurplePanel;
import com.undeadscythes.purplepetal.utilities.DBStep;

/**
 * Methods to change settings and edit some features.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Settings extends PurplePanel {
    private static final String VERSION_URL = "https://github.com/UndeadScythes/PurplePetal/raw/master/src/resources/version.txt";
    private static final String JAR_URL = "https://github.com/UndeadScythes/PurplePetal/raw/master/dist/PurplePetal.jar";
    
    private boolean updateOnBoot = false;

    /**
     * Creates new form Settings
     */
    public Settings() {
        super ();
        initComponents();
        if (updateOnBoot) {
            double newVersion = checkUpdates();
            if (newVersion > 0) {
                updatePrompt(newVersion);
            }
        }
        refresh();
    }

    private void refresh() {
        refreshOnce(true);
    }
    
    private void refreshOnce(boolean first) {
        try {
            ResultSet rs = DBStep.executeQuery("SELECT * FROM Settings;");
            if (rs.next()) {
                setVAT(rs.getDouble("VAT") / 100);
                txtVAT.setText(Double.toString(getVAT() * 100));
                updateOnBoot = rs.getBoolean("CheckUpdates");
            } else {
                DBStep.executeUpdate("INSERT INTO Settings (VAT, CheckUpdates) VALUES (20, 0);");
                if (first) {
                    refreshOnce(false);
                }
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }

    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel labVAT = new javax.swing.JLabel();
        txtVAT = new javax.swing.JTextField();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JButton btnPlantTypes = new javax.swing.JButton();
        javax.swing.JButton btnUpdates = new javax.swing.JButton();
        chkUpdates = new javax.swing.JCheckBox();

        labVAT.setText("VAT (%)");

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnPlantTypes.setText("Delete Plant Type");
        btnPlantTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantTypesActionPerformed(evt);
            }
        });

        btnUpdates.setText("Check for Updates");
        btnUpdates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatesActionPerformed(evt);
            }
        });

        chkUpdates.setText("Check for updates on start up");
        chkUpdates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUpdatesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdates, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(btnPlantTypes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkUpdates)
                        .addGap(92, 92, 92))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlantTypes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdates)
                    .addComponent(chkUpdates))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labVAT)
                    .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // TODO: Implement the other editable settings in this form.
    
    private void btnPlantTypesActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPlantTypesActionPerformed
        int typeCount = plantTypesCombo.getSize();
        ArrayList<Pair> types = new ArrayList<>(typeCount);
        for (int i = 0; i < typeCount; i++) {
            Pair type = plantTypesCombo.getElementAt(i);
            types.add(new Pair(type.getKey(), type.toString()));
        }
        Pair type = (Pair) JOptionPane.showInputDialog(this, "Which plant type do you wish to delete?", "Delete Plant Type", JOptionPane.QUESTION_MESSAGE, null, types.toArray(), "");
        if (type != null) {
            DBStep.executeUpdate(String.format("DELETE FROM PlantType WHERE PlantTypeID = %s;", type.getKey()));
            updatePlantTypesCombo();
        }
    }//GEN-LAST:event_btnPlantTypesActionPerformed

    private void btnUpdatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatesActionPerformed
        double version = checkUpdates();
        if (version > 0) {
            updatePrompt(version);
        } else {
            JOptionPane.showMessageDialog(this, "Your software is up to date.", "Version check", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdatesActionPerformed

    private void updatePrompt(double version) {
        int response = JOptionPane.showConfirmDialog(this, "A new version is available, do you want to download it?", "Version check", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            try {
                FileUtils.copyURLToFile(new URL(JAR_URL), new File(String.format("PurplePetal-%01.3f.jar", version)));
                JOptionPane.showMessageDialog(this, "New version downloaded, restart the software to enable.", "Version check", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                error(ex);
            }
        }
    }
    
    private double checkUpdates() {
        double version = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(VERSION_URL).openStream(), "UTF-8"))) {
            double newVersion = Double.parseDouble(reader.readLine());
            if (newVersion > PurpleFrame.getVersion()) {
                version = newVersion;
            }
        } catch (MalformedURLException ex) {
            error(ex);
        } catch (IOException ex) {
            error(ex);
        }
        return version;
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String vatText = txtVAT.getText();
        int vatVal = 0;
        if (!vatText.isEmpty()) {
            vatVal = Integer.parseInt(vatText);
        }
        setVAT(vatVal / 100.0);
        String query = String.format("UPDATE Settings SET VAT=%d;", vatVal);
        DBStep.executeUpdate(query);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void chkUpdatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUpdatesActionPerformed
        updateOnBoot = chkUpdates.isSelected();
        String query = String.format("UPDATE Settings SET VAT=%d;", (updateOnBoot ? 1 : 0));
        DBStep.executeUpdate(query);
    }//GEN-LAST:event_chkUpdatesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkUpdates;
    private javax.swing.JTextField txtVAT;
    // End of variables declaration//GEN-END:variables
}
