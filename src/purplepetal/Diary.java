package purplepetal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Logger;
import javax.swing.*; // NB code
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Displays diary entries for the status of various plants.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Diary extends PurplePanel {
    private final DefaultListModel<Pair> mldPlants = new DefaultListModel<>();
    private final DefaultComboBoxModel<Pair> mdlMonths = new DefaultComboBoxModel<>();
    private final TableCellRenderer cellRenderer;

    /**
     * Initialise components.
     */
    public Diary() {
        initComponents();
        cellRenderer = new TableCellRenderer(tabCalendar.getColumnCount());
        for (int i = 0; i < tabCalendar.getColumnCount(); i++) {
            tabCalendar.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        for (Month month : Month.values()) {
            mdlMonths.addElement(new Pair(month.getValue(), month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)));
        }
        btnTodayActionPerformed(null);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel panCalendar = new JPanel();
        JButton btnToday = new JButton();
        cmbMonth = new JComboBox<Pair>();
        spnYear = new JSpinner();
        JScrollPane scrCalendar = new JScrollPane();
        tabCalendar = new JTable();
        final JButton btnRefresh = new JButton();
        JSeparator sep3 = new JSeparator();
        JSplitPane spl1 = new JSplitPane();
        JPanel panEntries = new JPanel();
        final JScrollPane scrPlants = new JScrollPane();
        lstPlants = new JList<Pair>();
        JButton btnNew = new JButton();
        JSeparator sep2 = new JSeparator();
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
        JButton btnDelete = new JButton();
        JSeparator sep1 = new JSeparator();

        btnToday.setText("Today");
        btnToday.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTodayActionPerformed(evt);
            }
        });

        cmbMonth.setMaximumRowCount(12);
        cmbMonth.setModel(mdlMonths);
        cmbMonth.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                cmbMonthItemStateChanged(evt);
            }
        });

        spnYear.setModel(new SpinnerNumberModel());
        spnYear.setEditor(new JSpinner.NumberEditor(spnYear, "0000"));
        spnYear.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                spnYearStateChanged(evt);
            }
        });

        tabCalendar.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCalendar.setAutoscrolls(false);
        tabCalendar.setFocusable(false);
        tabCalendar.setRowSelectionAllowed(false);
        tabCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabCalendar.getTableHeader().setResizingAllowed(false);
        tabCalendar.getTableHeader().setReorderingAllowed(false);
        tabCalendar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tabCalendarMouseClicked(evt);
            }
        });
        scrCalendar.setViewportView(tabCalendar);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        GroupLayout panCalendarLayout = new GroupLayout(panCalendar);
        panCalendar.setLayout(panCalendarLayout);
        panCalendarLayout.setHorizontalGroup(panCalendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(sep3)
            .addGroup(panCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCalendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarLayout.createSequentialGroup()
                        .addComponent(btnToday)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMonth, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnYear, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrCalendar, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panCalendarLayout.setVerticalGroup(panCalendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCalendarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToday)
                    .addComponent(cmbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrCalendar, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spl1.setDividerLocation(150);

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
            .addComponent(sep2)
            .addGroup(panEntriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panEntriesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrPlants, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panEntriesLayout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panEntriesLayout.setVerticalGroup(panEntriesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panEntriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrPlants, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnNew)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spl1.setLeftComponent(panEntries);

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
            .addComponent(sep1)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labPotted, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labHardened, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(labBought, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labPlant, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPlant, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtReady, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtBought, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                        .addComponent(txtPotted, GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHardened, GroupLayout.Alignment.LEADING))
                                    .addComponent(txtLost, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete))
                            .addComponent(labReady, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                            .addComponent(labLost)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(labSold, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSold, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 176, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panDetailsLayout.setVerticalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
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
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labReady)
                    .addComponent(txtReady, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labLost)
                    .addComponent(txtLost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labSold)
                    .addComponent(txtSold, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addGap(0, 232, Short.MAX_VALUE))
        );

        spl1.setRightComponent(panDetails);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panCalendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spl1, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
            .addComponent(panCalendar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        String query = String.format("SELECT * FROM Diary WHERE Date %s;", getSQLDateRange());
        try (Statement s = createStatement();
                ResultSet rs = s.executeQuery(query)) {
            ArrayList<Integer> days = new ArrayList<>(31);
            while (rs.next()) {
                days.add(parseSQLDate(rs.getString("Date")).getDayOfMonth());
            }
            LocalDate date = getDate();
            int max = date.lengthOfMonth();
            int first = date.withDayOfMonth(1).getDayOfWeek().getValue();
            cellRenderer.marked.clear();
            cellRenderer.dimmed.clear();
            for (int i = 0; i < 42; i++) {
                int day = i + 2 - first;
                if (day < 1) {
                    tabCalendar.setValueAt(date.minusMonths(1).lengthOfMonth() + day, i / 7, i % 7);
                    cellRenderer.dimmed.add(i);
                } else if (day > max) {
                    tabCalendar.setValueAt(day - max, i / 7, i % 7);
                    cellRenderer.dimmed.add(i);
                } else {
                    if (days.contains(day)) {
                        cellRenderer.marked.add(i);
                    }
                    tabCalendar.setValueAt(day, i / 7, i % 7);
                }
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnTodayActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnTodayActionPerformed
        setDate(LocalDate.now());
    }//GEN-LAST:event_btnTodayActionPerformed

    private void setDate(LocalDate date) {
        spnYear.setValue(date.getYear());
        cmbMonth.setSelectedIndex(date.getMonthValue() - 1);
        btnRefreshActionPerformed(null);
        selectCell(tabCalendar, getCoord(date));
        tabCalendarMouseClicked(null);
    }
    
    private void lstPlantsValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstPlantsValueChanged
        if (!lstPlants.isSelectionEmpty()) {
            int plant = lstPlants.getSelectedValue().getKey();
            LocalDate date = getDate();
            String query = String.format("SELECT * FROM Diary WHERE PlantREF = %d AND Date %s;", plant, makeSQLDate(date));
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery(query)) {
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
                error(ex);
            }
        }
    }//GEN-LAST:event_lstPlantsValueChanged

    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try (Statement s = createStatement()) {
            LocalDate date = getDate();
            int bought = Integer.parseInt(txtBought.getText());
            int potted = Integer.parseInt(txtPotted.getText());
            int hardened = Integer.parseInt(txtHardened.getText());
            int ready = Integer.parseInt(txtReady.getText());
            int lost = Integer.parseInt(txtLost.getText());
            int sold = Integer.parseInt(txtSold.getText());
            if (!lstPlants.isSelectionEmpty() && getSelection(cmbPlant).getKey() == lstPlants.getSelectedValue().getKey()) {
                int plant = lstPlants.getSelectedValue().getKey();
                String query = String.format("UPDATE Diary SET " +
                    "Bought = %d, PottedOn = %d, HardenedOff = %d, ReadyForSale = %d, Lost = %d, Sold = %d " +
                    "WHERE PlantREF = %d AND Date %s;", bought, potted, hardened, ready, lost, sold, plant, makeSQLDate(date));
                s.executeUpdate(query);
            } else {
                int plant = getSelection(cmbPlant).getKey();
                String query = String.format("INSERT INTO Diary (PlantREF, Date, Bought, PottedOn, HardenedOff, ReadyForSale, Lost, Sold) VALUES (" +
                    "%d, '%s', %d, %d, %d, %d, %d, %d);", plant, makeDate(date), bought, potted, hardened, ready, lost, sold);
                s.executeUpdate(query);
            }
            s.close();
            btnRefreshActionPerformed(null);
            setDate(date);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        tabCalendarMouseClicked(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        cmbPlant.setSelectedIndex(0);
        lstPlants.clearSelection();
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
                int plant = lstPlants.getSelectedValue().getKey();
                LocalDate date = getDate();
                String query = String.format("DELETE FROM Diary WHERE PlantREF = %d AND Date %s;", plant, makeSQLDate(date));
                s.executeUpdate(query);
            }
            btnRefreshActionPerformed(null);
            btnNewActionPerformed(null);
        } catch (SQLException ex) {
            error(ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmbMonthItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
        btnRefreshActionPerformed(null);
    }//GEN-LAST:event_cmbMonthItemStateChanged

    private void spnYearStateChanged(ChangeEvent evt) {//GEN-FIRST:event_spnYearStateChanged
        btnRefreshActionPerformed(null);
    }//GEN-LAST:event_spnYearStateChanged

    private void tabCalendarMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tabCalendarMouseClicked
        setCell();
        mldPlants.clear();
        if (tabCalendar.getSelectedColumn() > -1) {
            String query = String.format("SELECT * FROM Diary JOIN Plant ON PlantID=PlantREF WHERE Date %s ORDER BY CommonName ASC;", getSQLDate());
            try (Statement s = createStatement();
                    ResultSet rs = s.executeQuery(query)) {
                while (rs.next()) {
                    mldPlants.addElement(new Pair(rs.getInt("PlantREF"), rs.getString("CommonName")));
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_tabCalendarMouseClicked

    private LocalDate getDate() {
        YearMonth ym = getYearMonth();
        int day = getDay();
        if (tabCalendar.getSelectedColumn() < 0 || day < 1 || day > ym.lengthOfMonth()) {
            return LocalDate.of(ym.getYear(), ym.getMonthValue(), 1);
        } else {
            return LocalDate.of(ym.getYear(), ym.getMonthValue(), day);
        }
    }
    
    private YearMonth getYearMonth() {
        int year = (int) spnYear.getValue();
        int month = getSelection(cmbMonth).getKey();
        return YearMonth.of(year, month);
    }
    
    private String getSQLDate() {
        if (tabCalendar.getSelectedColumn() < 0) {
            return makeSQLDate(getYearMonth());
        } else {
            return makeSQLDate(getDate());
        }
    }
    
    private String getSQLDateRange() {
        return makeSQLDate(getYearMonth());
    }
    
    private int getCoord(LocalDate date) {
        return getOffset(date) + date.getDayOfMonth();
    }
    
    private int getOffset(YearMonth ym) {
        return getOffset(LocalDate.of(ym.getYear(), ym.getMonthValue(), 1));
    }
    
    private int getOffset(LocalDate date) {
        return date.withDayOfMonth(1).getDayOfWeek().getValue() - 2;
    }
    
    private int getDay() {
        YearMonth ym = getYearMonth();
        int row = tabCalendar.getSelectedRow();
        int col = tabCalendar.getSelectedColumn();
        return (row * 7) + col - getOffset(ym);
    }
    
    private void setCell() {
        YearMonth ym = getYearMonth();
        int max = ym.lengthOfMonth();
        int day = getDay();
        if (day < 1) {
            ym = ym.minusMonths(1);
            setDate(LocalDate.of(ym.getYear(), ym.getMonth(), ym.lengthOfMonth() + day));
        } else if (day > max) {
            ym = ym.plusMonths(1);
            setDate(LocalDate.of(ym.getYear(), ym.getMonth(), day - max));
        }
        int row = tabCalendar.getSelectedRow();
        int col = tabCalendar.getSelectedColumn();
        cellRenderer.setCell(row, col);
        tabCalendar.repaint();
    }
    
    private void selectCell(JTable table, int coord) {
        int cols = table.getColumnCount();
        int row = coord / cols;
        int col = coord % cols;
        table.setColumnSelectionInterval(col, col);
        table.setRowSelectionInterval(row, row);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<Pair> cmbMonth;
    private JComboBox<Pair> cmbPlant;
    private JList<Pair> lstPlants;
    private JSpinner spnYear;
    private JTable tabCalendar;
    private JTextField txtBought;
    private JTextField txtHardened;
    private JTextField txtLost;
    private JTextField txtPotted;
    private JTextField txtReady;
    private JTextField txtSold;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Diary.class.getName());
}
