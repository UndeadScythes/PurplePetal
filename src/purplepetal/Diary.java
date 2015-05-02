package purplepetal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Displays diary entries for the status of various plants.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Diary extends PurplePanel {
    private final DefaultListModel<Pair> mdlDates = new DefaultListModel<>();
    private final DefaultListModel<Pair> mldPlants = new DefaultListModel<>();
    private final DefaultComboBoxModel<Pair> mdlMonths = new DefaultComboBoxModel<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    /**
     * Initialise components.
     */
    public Diary() {
        initComponents();
        for (Month month : Month.values()) {
            mdlMonths.addElement(new Pair(month.getValue() - 1, month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)));
        }
        btnTodayActionPerformed(null);
        btnRefreshActionPerformed(null);
        btnTodayActionPerformed(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel panDetails = new JPanel();
        final JLabel labPlant = new JLabel();
        final JLabel labBought = new JLabel();
        final JLabel labPotted = new JLabel();
        final JLabel labHardened = new JLabel();
        final JLabel labReady = new JLabel();
        final JLabel labLost = new JLabel();
        final JLabel labSold = new JLabel();
        txtBought = new JTextField();
        txtPotted = new JTextField();
        txtHardened = new JTextField();
        txtReady = new JTextField();
        txtLost = new JTextField();
        txtSold = new JTextField();
        cmbPlant = new JComboBox<Pair>();
        JButton btnSave = new JButton();
        JButton btnCancel = new JButton();
        btnDelete = new JButton();
        JPanel panCalendar = new JPanel();
        JButton btnToday = new JButton();
        cmbMonth = new JComboBox<Pair>();
        spnYear = new JSpinner();
        final JScrollPane scrDates = new JScrollPane();
        lstDates = new JList<Pair>();
        final JButton btnRefresh = new JButton();
        JPanel panEntries = new JPanel();
        final JScrollPane scrPlants = new JScrollPane();
        lstPlants = new JList<Pair>();
        JButton btnNew = new JButton();

        labPlant.setText("Plant");

        labBought.setText("Bought");

        labPotted.setText("Potted on");

        labHardened.setText("Hardened off");

        labReady.setText("Ready for sale");

        labLost.setText("Lost");

        labSold.setText("Sold");

        txtBought.setText("0");

        txtPotted.setText("0");

        txtHardened.setText("0");

        txtReady.setText("0");

        txtLost.setText("0");

        txtSold.setText("0");

        cmbPlant.setModel(plantsCombo);

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
                .addComponent(btnDelete))
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labBought, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labPotted, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                            .addComponent(labHardened, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(txtBought, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPotted, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHardened, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPlant, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panDetailsLayout.createSequentialGroup()
                            .addComponent(labSold, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSold, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.LEADING, panDetailsLayout.createSequentialGroup()
                            .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(labReady, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labLost, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtReady, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(txtLost))))
                    .addComponent(labPlant)))
        );
        panDetailsLayout.setVerticalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labPlant)
                    .addComponent(cmbPlant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBought, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labBought))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPotted, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPotted))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labHardened)
                    .addComponent(txtHardened, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtReady, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labReady))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labLost)
                    .addComponent(txtLost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labSold)
                    .addComponent(txtSold, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addGap(0, 0, 0))
        );

        btnToday.setText("Today");
        btnToday.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTodayActionPerformed(evt);
            }
        });

        cmbMonth.setModel(mdlMonths);
        cmbMonth.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                cmbMonthItemStateChanged(evt);
            }
        });

        spnYear.setModel(new SpinnerDateModel(new Date(), new Date(1114939920000L), new Date(2692780320000L), Calendar.YEAR));
        spnYear.setEditor(new JSpinner.DateEditor(spnYear, "yyyy"));
        spnYear.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                spnYearStateChanged(evt);
            }
        });

        lstDates.setModel(mdlDates);
        lstDates.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                lstDatesValueChanged(evt);
            }
        });
        scrDates.setViewportView(lstDates);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        GroupLayout panCalendarLayout = new GroupLayout(panCalendar);
        panCalendar.setLayout(panCalendarLayout);
        panCalendarLayout.setHorizontalGroup(panCalendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarLayout.createSequentialGroup()
                .addComponent(btnToday)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMonth, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnYear, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
            .addComponent(btnRefresh)
            .addComponent(scrDates, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panCalendarLayout.setVerticalGroup(panCalendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCalendarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToday)
                    .addComponent(cmbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrDates)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh))
        );

        lstPlants.setModel(mldPlants);
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

        GroupLayout panEntriesLayout = new GroupLayout(panEntries);
        panEntries.setLayout(panEntriesLayout);
        panEntriesLayout.setHorizontalGroup(panEntriesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrPlants, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnNew)
        );
        panEntriesLayout.setVerticalGroup(panEntriesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panEntriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrPlants)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panCalendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panEntries, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panDetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 201, Short.MAX_VALUE))
                    .addComponent(panCalendar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panEntries, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lstDatesValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstDatesValueChanged
        mldPlants.clear();
        if (!lstDates.isSelectionEmpty()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime((Date) spnYear.getValue());
            int year = cal.get(Calendar.YEAR);
            int month = getSelection(cmbMonth).getKey();
            int day = lstDates.getSelectedValue().getKey();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Diary JOIN Plant ON PlantID=PlantREF WHERE Date = " +
                    "'"+ year + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d", day) + "';")) {
                while (rs.next()) {
                    mldPlants.addElement(new Pair(rs.getInt("DiaryID"), rs.getString("CommonName")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lstDatesValueChanged

    private void btnRefreshActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Calendar cal = Calendar.getInstance();
        mdlDates.clear();
        cal.setTime((Date) spnYear.getValue());
        int year = cal.get(Calendar.YEAR);
        int month = getSelection(cmbMonth).getKey();
        try (Statement s = createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM Diary WHERE Date BETWEEN " +
                    "'" + year + "-" + String.format("%02d", month + 1) + "-01' AND " +
                    "'" + year + "-" + String.format("%02d", month + 1) + "-31';")) {
            ArrayList<Integer> days = new ArrayList<>(31);
            while (rs.next()) {
                cal.setTime(dateFormat.parse(rs.getString("Date")));
                days.add(cal.get(Calendar.DAY_OF_MONTH));
            }
            cal.set(year, month, 1);
            int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int day = 1; day <= max; day++) {
                cal.set(year, month, day);
                if (days.contains(day)) {
                    mdlDates.addElement(new Pair(day, day + ", " + cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH) + " ***"));
                } else {
                    mdlDates.addElement(new Pair(day, day + ", " + cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH)));
                }
            }
        } catch (SQLException | ParseException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTodayActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnTodayActionPerformed
        Calendar cal = Calendar.getInstance();
        spnYear.setValue(cal.getTime());
        cmbMonth.setSelectedIndex(cal.get(Calendar.MONTH));
        btnRefreshActionPerformed(null);
        lstDates.setSelectedIndex(cal.get(Calendar.DAY_OF_MONTH) - 1);
        lstDatesValueChanged(null);
    }//GEN-LAST:event_btnTodayActionPerformed

    private void lstPlantsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            int id = lstPlants.getSelectedValue().getKey();
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery("SELECT * FROM Diary WHERE DiaryID = " + id + ";")) {
                while (rs.next()) {
                    selectKey(cmbPlant, rs.getInt("PlantREF"));
                    txtBought.setText(Integer.toString(rs.getInt("Bought")));
                    txtPotted.setText(Integer.toString(rs.getInt("PottedOn")));
                    txtHardened.setText(Integer.toString(rs.getInt("HardenedOff")));
                    txtReady.setText(Integer.toString(rs.getInt("ReadyForSale")));
                    txtLost.setText(Integer.toString(rs.getInt("Lost")));
                    txtSold.setText(Integer.toString(rs.getInt("Sold")));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lstPlantsValueChanged

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try (Statement s = createStatement()) {
            Calendar cal = Calendar.getInstance();
            cal.setTime((Date) spnYear.getValue());
            int year = cal.get(Calendar.YEAR);
            int month = getSelection(cmbMonth).getKey();
            int day = lstDates.getSelectedValue().getKey();
            int plant = getSelection(cmbPlant).getKey();
            int bought = Integer.parseInt(txtBought.getText());
            int potted = Integer.parseInt(txtPotted.getText());
            int hardened = Integer.parseInt(txtHardened.getText());
            int ready = Integer.parseInt(txtReady.getText());
            int lost = Integer.parseInt(txtLost.getText());
            int sold = Integer.parseInt(txtSold.getText());
            if (lstPlants.isSelectionEmpty()) {
                s.executeUpdate("INSERT INTO Diary (PlantREF, Date, Bought, PottedOn, HardenedOff, ReadyForSale, Lost, Sold) VALUES (" +
                    plant + ", " +
                    "'" + year + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d", day) + "', " +
                    bought + ", " +
                    potted + ", " +
                    hardened + ", " +
                    ready + ", " +
                    lost + ", " +
                    sold + ");");
            } else {
                int id = lstPlants.getSelectedValue().getKey();
                s.executeUpdate("UPDATE Diary SET " +
                    "PlantREF = " + plant + ", " +
                    "Bought = " + bought + ", " +
                    "PottedOn = " + potted + ", " +
                    "HardenedOff = " + hardened + ", " +
                    "ReadyForSale = " + ready + ", " +
                    "Lost = " + lost + ", " +
                    "Sold = " + sold + " " +
                    "WHERE DiaryID = " + id + ";");
            }
            s.close();
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        lstDatesValueChanged(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        cmbPlant.setSelectedIndex(0);
        txtBought.setText("0");
        txtPotted.setText("0");
        txtHardened.setText("0");
        txtReady.setText("0");
        txtLost.setText("0");
        txtSold.setText("0");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try (Statement s = createStatement()) {
            if (!lstPlants.isSelectionEmpty()) {
                int id = lstPlants.getSelectedValue().getKey();
                s.executeUpdate("DELETE FROM Diary WHERE DiaryID = " + id + ";");
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmbMonthItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
        btnRefreshActionPerformed(null);
    }//GEN-LAST:event_cmbMonthItemStateChanged

    private void spnYearStateChanged(ChangeEvent evt) {//GEN-FIRST:event_spnYearStateChanged
        btnRefreshActionPerformed(null);
    }//GEN-LAST:event_spnYearStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnDelete;
    private JComboBox<Pair> cmbMonth;
    private JComboBox<Pair> cmbPlant;
    private JList<Pair> lstDates;
    private JList<Pair> lstPlants;
    private JSpinner spnYear;
    private JTextField txtBought;
    private JTextField txtHardened;
    private JTextField txtLost;
    private JTextField txtPotted;
    private JTextField txtReady;
    private JTextField txtSold;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Diary.class.getName());
}
