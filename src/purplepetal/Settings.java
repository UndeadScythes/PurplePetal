package purplepetal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * Methods to change settings and edit some features.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Settings extends PurplePanel {
    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel panSettings = new JPanel();
        JLabel labDatabase = new JLabel();
        JLabel labVAT = new JLabel();
        txtDatabase = new JTextField();
        JButton btnDatabase = new JButton();
        txtVAT = new JTextField();
        JSeparator sep1 = new JSeparator();
        JButton btnSave = new JButton();
        JPanel panButtons = new JPanel();
        JButton btnPlantTypes = new JButton();

        labDatabase.setText("Database");

        labVAT.setText("VAT");

        btnDatabase.setText("Change");

        btnSave.setText("Save");

        GroupLayout panSettingsLayout = new GroupLayout(panSettings);
        panSettings.setLayout(panSettingsLayout);
        panSettingsLayout.setHorizontalGroup(panSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(sep1)
            .addGroup(panSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panSettingsLayout.createSequentialGroup()
                        .addGroup(panSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(labDatabase, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labVAT, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panSettingsLayout.createSequentialGroup()
                                .addComponent(txtDatabase, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDatabase))
                            .addGroup(panSettingsLayout.createSequentialGroup()
                                .addComponent(txtVAT, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panSettingsLayout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panSettingsLayout.setVerticalGroup(panSettingsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labDatabase)
                    .addComponent(txtDatabase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatabase))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panSettingsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labVAT)
                    .addComponent(txtVAT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnSave)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPlantTypes.setText("Delete Plant Type");
        btnPlantTypes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPlantTypesActionPerformed(evt);
            }
        });

        GroupLayout panButtonsLayout = new GroupLayout(panButtons);
        panButtons.setLayout(panButtonsLayout);
        panButtonsLayout.setHorizontalGroup(panButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlantTypes)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panButtonsLayout.setVerticalGroup(panButtonsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlantTypes)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panSettings, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panButtons, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panSettings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panButtons, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
        try (Statement s = createStatement()) {
            s.executeUpdate(String.format("DELETE FROM PlantType WHERE PlantTypeID = %s;", type.getKey()));
        } catch (SQLException ex) {
            error(ex);
        }
        updatePlantTypesCombo();
    }//GEN-LAST:event_btnPlantTypesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField txtDatabase;
    private JTextField txtVAT;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Settings.class.getName());
}
