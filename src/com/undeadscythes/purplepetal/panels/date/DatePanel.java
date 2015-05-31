package com.undeadscythes.purplepetal.panels.date;

import java.awt.Component;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.renderers.TableCellRenderer;
import com.undeadscythes.purplepetal.utilities.Swingers;

/**
 * A calendar with selectable dates.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class DatePanel extends JPanel {
    /**
     * ISO-ish standard date format.
     */
    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("uuuu-MM-dd");
    private transient DateListener listener = new NullListener();
    private final DefaultComboBoxModel<Pair> mdlMonths = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<Pair> mdlYears = new DefaultComboBoxModel<>();
    private final TableCellRenderer cellRenderer;
    
    private boolean refresh = false;
    
    /**
     * Creates new form DatePanel
     */
    public DatePanel() {
        initComponents();
        cellRenderer = new TableCellRenderer(tabCalendar.getColumnCount());
        for (int i = 0; i < tabCalendar.getColumnCount(); i++) {
            tabCalendar.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        for (Month month : Month.values()) {
            mdlMonths.addElement(new Pair(month.getValue(), month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)));
        }
        int year = LocalDate.now().getYear();
        for (int i = year - 5; i < year + 15; i++) {
            mdlYears.addElement(new Pair(year, Integer.toString(year)));
        }
        refresh = true;
    }
    
    /**
     * Link the parent listener.
     * @param listener
     */
    public void link(DateListener listener) {
        this.listener = listener;
    }
    
    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton btnToday = new javax.swing.JButton();
        cmbMonth = new javax.swing.JComboBox<Pair>();
        cmbYear = new javax.swing.JComboBox<Pair>();
        javax.swing.JScrollPane scrCalendar = new javax.swing.JScrollPane();
        tabCalendar = new javax.swing.JTable();

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

        cmbYear.setModel(mdlYears);
        cmbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbYearItemStateChanged(evt);
            }
        });

        scrCalendar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrCalendar.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnToday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToday)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodayActionPerformed
        setNow();
    }//GEN-LAST:event_btnTodayActionPerformed

    private void cmbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
        refresh();
    }//GEN-LAST:event_cmbMonthItemStateChanged

    private void tabCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabCalendarMouseClicked
        setCell();
    }//GEN-LAST:event_tabCalendarMouseClicked

    private void cmbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbYearItemStateChanged
        refresh();
    }//GEN-LAST:event_cmbYearItemStateChanged

    /**
     * Set the calendar to today's date.
     */
    public final void setNow() {
        setDate(LocalDate.now());
    }
    
    /**
     * Set the calendar to the given date.
     * @param date
     */
    public void setDate(LocalDate date) {
        Swingers.setSelectedItem(cmbYear, date.getYear());
        cmbMonth.setSelectedIndex(date.getMonthValue() - 1);
        refresh();
        selectCell(getCoord(date));
        tabCalendarMouseClicked(null);
    }
    
    /**
     * Refresh the days of the calendar.
     */
    public void refresh() {
        if (refresh) {
            LocalDate date = getDate();
            int max = date.lengthOfMonth();
            int first = date.withDayOfMonth(1).getDayOfWeek().getValue();
            cellRenderer.marked.clear();
            cellRenderer.dimmed.clear();
            listener.getMarkers(getYearMonth());
            for (int i = 0; i < 42; i++) {
                int day = i + 2 - first;
                if (day < 1) {
                    tabCalendar.setValueAt(date.minusMonths(1).lengthOfMonth() + day, i / 7, i % 7);
                    cellRenderer.dimmed.add(i);
                } else if (day > max) {
                    tabCalendar.setValueAt(day - max, i / 7, i % 7);
                    cellRenderer.dimmed.add(i);
                } else {
                    tabCalendar.setValueAt(day, i / 7, i % 7);
                }
            }
        }
    }
    
    /**
     * Highlight the given day.
     * @param day
     */
    public void highlightDay(int day) {
        cellRenderer.marked.add(day);
    }
    
    /**
     * Get the year/month selected by the calendar.
     * @return
     */
    public YearMonth getYearMonth() {
        int year = Swingers.getSelectedItem(cmbYear).getKey();
        int month = Swingers.getSelectedItem(cmbMonth).getKey();
        return YearMonth.of(year, month);
    }
    
    /**
     * Get the selected date of the calendar.
     * @return
     */
    public LocalDate getDate() {
        YearMonth ym = getYearMonth();
        int day = getDay();
        if (tabCalendar.getSelectedColumn() < 0 || day < 1 || day > ym.lengthOfMonth()) {
            return LocalDate.of(ym.getYear(), ym.getMonthValue(), 1);
        } else {
            return LocalDate.of(ym.getYear(), ym.getMonthValue(), day);
        }
    }
    
    /**
     * Get the selected date as a string.
     * @return
     */
    public String getDateString() {
        return getDate().format(DTF);
    }
    
    /**
     * Check that a valid day has been selected.
     * @return
     */
    public boolean daySelected() {
        return tabCalendar.getSelectedColumn() > -1;
    }

    /**
     * Poke the calendar.
     */
    public void poke() {
        setCell();
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
        listener.dateSelected(getDate());
    }
    
    private int getDay() {
        YearMonth ym = getYearMonth();
        int row = tabCalendar.getSelectedRow();
        int col = tabCalendar.getSelectedColumn();
        return (row * 7) + col - getOffset(ym);
    }
    
    private int getOffset(LocalDate date) {
        return date.withDayOfMonth(1).getDayOfWeek().getValue() - 2;
    }
    
    private int getOffset(YearMonth ym) {
        return getOffset(LocalDate.of(ym.getYear(), ym.getMonthValue(), 1));
    }
    
    private int getCoord(LocalDate date) {
        return getOffset(date) + date.getDayOfMonth();
    }
    
    private void selectCell(int coord) {
        int cols = tabCalendar.getColumnCount();
        int row = coord / cols;
        int col = coord % cols;
        tabCalendar.setColumnSelectionInterval(col, col);
        tabCalendar.setRowSelectionInterval(row, row);
    }
    
    /**
     * Get a date from a popup.
     * @param parent
     * @return
     */
    public static LocalDate getDate(Component parent) {
        DatePanel panel = new DatePanel();
        panel.setNow();
        JOptionPane.showMessageDialog(parent, panel, "Select a date", JOptionPane.QUESTION_MESSAGE);
        return panel.getDate();
    }
    
    /**
     * Get a date from a popup.
     * @param parent
     * @return
     */
    public static String getDateString(Component parent) {
        return getDate(parent).format(DTF);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Pair> cmbMonth;
    private javax.swing.JComboBox<Pair> cmbYear;
    private javax.swing.JTable tabCalendar;
    // End of variables declaration//GEN-END:variables
}
