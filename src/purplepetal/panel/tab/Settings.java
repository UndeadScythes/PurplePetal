package purplepetal.panel.tab;

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
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import purplepetal.Pair;
import purplepetal.PurplePetal;
import purplepetal.panel.PurplePanel;

/**
 * Methods to change settings and edit some features.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Settings extends PurplePanel {
    private static final String VERSION_URL = "https://github.com/UndeadScythes/PurplePetal/raw/master/src/resources/version.txt";
    private static final String JAR_URL = "https://github.com/UndeadScythes/PurplePetal/raw/master/dist/PurplePetal.jar";
    /**
     * Creates new form Settings
     */
    public Settings() {
        super ("Settings", "SettingsID", "");
        initComponents();
        refresh();
    }

    @Override
    protected final void refresh() {
        try {
            ResultSet rs = executeQuery("SELECT * FROM Settings;");
            if (rs.next()) {
                VAT = rs.getDouble("VAT") / 100;
                txtVAT.setText(Double.toString(VAT * 100));
            } else {
                VAT = 0.2;
                txtVAT.setText("20");
                btnSaveActionPerformed(null);
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }

    @Override
    protected void clear() {
        
    }

    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel panSettings = new javax.swing.JPanel();
        javax.swing.JLabel labVAT = new javax.swing.JLabel();
        txtVAT = new javax.swing.JTextField();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JLabel labPercent = new javax.swing.JLabel();
        javax.swing.JButton btnPlantTypes = new javax.swing.JButton();
        javax.swing.JButton btnUpdates = new javax.swing.JButton();
        chkUpdates = new javax.swing.JCheckBox();

        labVAT.setText("VAT");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        labPercent.setText("%");

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

        javax.swing.GroupLayout panSettingsLayout = new javax.swing.GroupLayout(panSettings);
        panSettings.setLayout(panSettingsLayout);
        panSettingsLayout.setHorizontalGroup(
            panSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSettingsLayout.createSequentialGroup()
                        .addComponent(btnUpdates)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkUpdates))
                    .addComponent(btnPlantTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panSettingsLayout.createSequentialGroup()
                        .addComponent(labVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labPercent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panSettingsLayout.setVerticalGroup(
            panSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlantTypes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdates)
                    .addComponent(chkUpdates))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labVAT)
                    .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPercent)
                    .addComponent(btnSave))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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
            executeUpdate(String.format("DELETE FROM PlantType WHERE PlantTypeID = %s;", type.getKey()));
            updatePlantTypesCombo();
        }
    }//GEN-LAST:event_btnPlantTypesActionPerformed

    private void btnUpdatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatesActionPerformed
        try {
            double version = Double.parseDouble(new BufferedReader(new InputStreamReader(new URL(VERSION_URL).openStream())).readLine());
            if (version > PurplePetal.getVersion()) {
                int response = JOptionPane.showConfirmDialog(this, "A new version is available, do you want to download it?", "Version check", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    FileUtils.copyURLToFile(new URL(JAR_URL), new File(String.format("PurplePetal-%01.3f.jar", version)));
                    JOptionPane.showMessageDialog(this, "New version downloaded, restart the software to enable.", "Version check", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Your software is up to date.", "Version check", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (MalformedURLException ex) {
            error(ex);
        } catch (IOException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnUpdatesActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String vatText = txtVAT.getText();
        int vatVal = 0;
        if (!vatText.isEmpty()) {
            vatVal = Integer.parseInt(vatText);
        }
        VAT = vatVal / 100.0;
        String query = String.format("UPDATE Settings SET VAT=%d;", vatVal);
        executeUpdate(query);
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkUpdates;
    private javax.swing.JTextField txtVAT;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Settings.class.getName());
}
