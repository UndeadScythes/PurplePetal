package purplepetal.panel.tab;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import purplepetal.Pair;
import purplepetal.panel.PurplePanel;
import purplepetal.renderer.TableCellRenderer;

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

        javax.swing.JPanel panCalendar = new javax.swing.JPanel();
        javax.swing.JButton btnToday = new javax.swing.JButton();
        cmbMonth = new javax.swing.JComboBox<Pair>();
        spnYear = new javax.swing.JSpinner();
        javax.swing.JScrollPane scrCalendar = new javax.swing.JScrollPane();
        tabCalendar = new javax.swing.JTable();
        final javax.swing.JButton btnRefresh = new javax.swing.JButton();
        javax.swing.JSeparator sep3 = new javax.swing.JSeparator();
        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        javax.swing.JPanel panEntries = new javax.swing.JPanel();
        final javax.swing.JScrollPane scrPlants = new javax.swing.JScrollPane();
        lstPlants = new javax.swing.JList<Pair>();
        javax.swing.JButton btnNew = new javax.swing.JButton();
        javax.swing.JSeparator sep2 = new javax.swing.JSeparator();
        javax.swing.JPanel panDetails = new javax.swing.JPanel();
        final javax.swing.JLabel labPlant = new javax.swing.JLabel();
        final javax.swing.JLabel labBought = new javax.swing.JLabel();
        final javax.swing.JLabel labPotted = new javax.swing.JLabel();
        final javax.swing.JLabel labHardened = new javax.swing.JLabel();
        final javax.swing.JLabel labReady = new javax.swing.JLabel();
        final javax.swing.JLabel labLost = new javax.swing.JLabel();
        final javax.swing.JLabel labSold = new javax.swing.JLabel();
        txtBought = new javax.swing.JTextField();
        txtPotted = new javax.swing.JTextField();
        txtHardened = new javax.swing.JTextField();
        txtReady = new javax.swing.JTextField();
        txtLost = new javax.swing.JTextField();
        txtSold = new javax.swing.JTextField();
        cmbPlant = new javax.swing.JComboBox<Pair>();
        javax.swing.JButton btnSave = new javax.swing.JButton();
        javax.swing.JButton btnCancel = new javax.swing.JButton();
        javax.swing.JButton btnDelete = new javax.swing.JButton();
        javax.swing.JSeparator sep1 = new javax.swing.JSeparator();

        btnToday.setText("Today");
        btnToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodayActionPerformed(evt);
            }
        });

        cmbMonth.setMaximumRowCount(12);
        cmbMonth.setModel(mdlMonths);
        cmbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMonthItemStateChanged(evt);
            }
        });

        spnYear.setModel(new javax.swing.SpinnerNumberModel());
        spnYear.setEditor(new javax.swing.JSpinner.NumberEditor(spnYear, "0000"));
        spnYear.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnYearStateChanged(evt);
            }
        });

        tabCalendar.setModel(new javax.swing.table.DefaultTableModel(
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
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabCalendar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabCalendar.getTableHeader().setResizingAllowed(false);
        tabCalendar.getTableHeader().setReorderingAllowed(false);
        tabCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabCalendarMouseClicked(evt);
            }
        });
        scrCalendar.setViewportView(tabCalendar);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panCalendarLayout = new javax.swing.GroupLayout(panCalendar);
        panCalendar.setLayout(panCalendarLayout);
        panCalendarLayout.setHorizontalGroup(
            panCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep3)
            .addGroup(panCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarLayout.createSequentialGroup()
                        .addComponent(btnToday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnYear, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panCalendarLayout.setVerticalGroup(
            panCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToday)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spl1.setDividerLocation(150);

        lstPlants.setModel(mldPlants);
        lstPlants.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlantsValueChanged(evt);
            }
        });
        scrPlants.setViewportView(lstPlants);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panEntriesLayout = new javax.swing.GroupLayout(panEntries);
        panEntries.setLayout(panEntriesLayout);
        panEntriesLayout.setHorizontalGroup(
            panEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep2)
            .addGroup(panEntriesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panEntriesLayout.createSequentialGroup()
                        .addComponent(btnNew)
                        .addGap(0, 76, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panEntriesLayout.setVerticalGroup(
            panEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEntriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrPlants, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnNew)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(sep1)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labPotted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labHardened, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(labBought, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labPlant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPlant, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtReady, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtBought, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                        .addComponent(txtPotted, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHardened, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txtLost, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panDetailsLayout.createSequentialGroup()
                        .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete))
                            .addComponent(labReady, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labLost)
                            .addGroup(panDetailsLayout.createSequentialGroup()
                                .addComponent(labSold, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSold, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 176, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panDetailsLayout.setVerticalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPlant)
                    .addComponent(cmbPlant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBought, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labBought))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPotted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labPotted))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labHardened)
                    .addComponent(txtHardened, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labReady)
                    .addComponent(txtReady, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labLost)
                    .addComponent(txtLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSold)
                    .addComponent(txtSold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addGap(0, 232, Short.MAX_VALUE))
        );

        spl1.setRightComponent(panDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spl1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
            .addComponent(panCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records
           
            
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
    private javax.swing.JComboBox<Pair> cmbMonth;
    private javax.swing.JComboBox<Pair> cmbPlant;
    private javax.swing.JList<Pair> lstPlants;
    private javax.swing.JSpinner spnYear;
    private javax.swing.JTable tabCalendar;
    private javax.swing.JTextField txtBought;
    private javax.swing.JTextField txtHardened;
    private javax.swing.JTextField txtLost;
    private javax.swing.JTextField txtPotted;
    private javax.swing.JTextField txtReady;
    private javax.swing.JTextField txtSold;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Diary.class.getName());
}
