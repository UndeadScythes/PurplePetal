package com.undeadscythes.purplepetal.panels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import com.undeadscythes.purplepetal.keyables.entry.Entry;
import com.undeadscythes.purplepetal.keyables.entry.EntryType;
import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.keyables.Part;
import com.undeadscythes.purplepetal.panels.date.DateListener;
import com.undeadscythes.purplepetal.panels.date.DateListener;
import com.undeadscythes.purplepetal.keyables.entry.Entry;
import com.undeadscythes.purplepetal.keyables.entry.EntryType;
import com.undeadscythes.purplepetal.panels.PurplePanel;
import com.undeadscythes.purplepetal.utilities.DBStep;
import com.undeadscythes.purplepetal.utilities.Swingers;

/**
 * Displays diary entries for the status of various plants.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Diary extends PurplePanel implements DateListener {
    private final DefaultListModel<Entry> mdlEntries = new DefaultListModel<>();

    /**
     * Initialise components.
     */
    public Diary() {
        initComponents();
        panCalendar.setNow();
        panCalendar.refresh();
    }

    @Override
    public void dateSelected(LocalDate date) {
        mdlEntries.clear();
        if (panCalendar.daySelected()) {
            for (EntryType type : EntryType.values()) {
                checkDay(type);
            }
        }
    }

    @Override
    public void getMarkers(YearMonth ym) {
        ArrayList<Integer> days = new ArrayList<>(31);
        for (EntryType type : EntryType.values()) {
            days.addAll(checkDiary(type));
        }
        int first = ym.atDay(1).getDayOfWeek().getValue();
        for (int i = 0; i < 42; i++) {
            int day = i + 2 - first;
            if (days.contains(day)) {
                panCalendar.highlightDay(i);
            }
        }
    }
    
    private void refresh() {
        panCalendar.refresh();
    }

    private void clear() {
        Swingers.clearSelection(cmbProduct);
        lstEntries.clearSelection();
        Swingers.setText("0", txtPotted, txtHardened, txtReady, txtSold);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        javax.swing.JPanel panEntries = new javax.swing.JPanel();
        final javax.swing.JScrollPane scrEntries = new javax.swing.JScrollPane();
        lstEntries = new javax.swing.JList<Entry>();
        panCalendar = new com.undeadscythes.purplepetal.panels.date.DatePanel();
        panProduct = new javax.swing.JPanel();
        javax.swing.JLabel labProduct = new javax.swing.JLabel();
        cmbProduct = new javax.swing.JComboBox<Pair>();
        txtPotted = new javax.swing.JTextField();
        final javax.swing.JLabel labPotted = new javax.swing.JLabel();
        final javax.swing.JLabel labHardened = new javax.swing.JLabel();
        final javax.swing.JLabel labReady = new javax.swing.JLabel();
        final javax.swing.JLabel labSold = new javax.swing.JLabel();
        txtSold = new javax.swing.JTextField();
        txtReady = new javax.swing.JTextField();
        txtHardened = new javax.swing.JTextField();
        javax.swing.JButton btnProductSave = new javax.swing.JButton();
        javax.swing.JButton btnProductCancel = new javax.swing.JButton();
        javax.swing.JButton btnProductDelete = new javax.swing.JButton();
        javax.swing.JSeparator sep4 = new javax.swing.JSeparator();
        javax.swing.JButton btnProductNew = new javax.swing.JButton();

        spl1.setDividerLocation(250);

        lstEntries.setModel(mdlEntries);
        lstEntries.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntriesValueChanged(evt);
            }
        });
        scrEntries.setViewportView(lstEntries);

        javax.swing.GroupLayout panEntriesLayout = new javax.swing.GroupLayout(panEntries);
        panEntries.setLayout(panEntriesLayout);
        panEntriesLayout.setHorizontalGroup(
            panEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrEntries, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panEntriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panEntriesLayout.setVerticalGroup(
            panEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEntriesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrEntries, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
        );

        spl1.setLeftComponent(panEntries);

        labProduct.setText("Product");

        cmbProduct.setModel(productsCombo);

        txtPotted.setText("0");

        labPotted.setText("Potted on");

        labHardened.setText("Hardened off");

        labReady.setText("Ready for sale");

        labSold.setText("Sold");

        txtSold.setText("0");

        txtReady.setText("0");

        txtHardened.setText("0");

        btnProductSave.setText("Save");
        btnProductSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductSaveActionPerformed(evt);
            }
        });

        btnProductCancel.setText("Cancel");
        btnProductCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductCancelActionPerformed(evt);
            }
        });

        btnProductDelete.setText("Delete");
        btnProductDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductDeleteActionPerformed(evt);
            }
        });

        btnProductNew.setText("New");
        btnProductNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panProductLayout = new javax.swing.GroupLayout(panProduct);
        panProduct.setLayout(panProductLayout);
        panProductLayout.setHorizontalGroup(
            panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep4)
            .addGroup(panProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panProductLayout.createSequentialGroup()
                        .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labReady, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(labHardened, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labSold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtReady, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(txtHardened, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSold)))
                    .addGroup(panProductLayout.createSequentialGroup()
                        .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labPotted, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(labProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPotted, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panProductLayout.createSequentialGroup()
                        .addComponent(btnProductSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProductCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProductDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProductNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panProductLayout.setVerticalGroup(
            panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labProduct)
                    .addComponent(cmbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPotted)
                    .addComponent(txtPotted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labHardened)
                    .addComponent(txtHardened, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labReady)
                    .addComponent(txtReady, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSold)
                    .addComponent(txtSold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductCancel)
                    .addComponent(btnProductSave)
                    .addComponent(btnProductDelete)
                    .addComponent(btnProductNew))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spl1.setRightComponent(panProduct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private ArrayList<Integer> checkDiary(EntryType type) {
        String query = String.format("SELECT * FROM %s WHERE Date %s;", type.getDiary(), getSQLDateRange());
        ArrayList<Integer> days = new ArrayList<>(31);
        try {
            ResultSet rs = DBStep.executeQuery(query);
            while (rs.next()) {
                days.add(LocalDate.parse(rs.getString("Date")).getDayOfMonth());
            }
        } catch (SQLException ex) {
            error(ex);
        }
        return days;
    }
    
    private void lstEntriesValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstEntriesValueChanged
        if (!lstEntries.isSelectionEmpty()) {
            Entry entry = lstEntries.getSelectedValue();
            EntryType type = entry.getType();
            LocalDate date = panCalendar.getDate();
            String query = String.format("SELECT * FROM %s WHERE %s = %d AND Date %s;", type.getDiary(), type.getRef(), entry.getKey(), genSQLDateEqualX(date));
            try {
                ResultSet rs = DBStep.executeQuery(query);
                switch (type) {
                    case PRODUCT:
                        while (rs.next()) {
                            Swingers.setSelectedItem(cmbProduct, rs.getInt("ProductREF"));
                            txtPotted.setText(Integer.toString(rs.getInt("PottedOn")));
                            txtHardened.setText(Integer.toString(rs.getInt("HardenedOff")));
                            txtReady.setText(Integer.toString(rs.getInt("ReadyForSale")));
                            txtSold.setText(Integer.toString(rs.getInt("Sold")));
                        }
                        break;
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstEntriesValueChanged

    private void btnProductNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductNewActionPerformed
        clear();
    }//GEN-LAST:event_btnProductNewActionPerformed

    private void btnProductDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductDeleteActionPerformed
        JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

        // TODO: Implement a check for records referencing this supplier and ask for
        // confirmation of cascade delete or a supplier to replace in the records

        if (!lstEntries.isSelectionEmpty()) {
            int product = lstEntries.getSelectedValue().getKey();
            String date = panCalendar.getDateString();
            String query = String.format("DELETE FROM ProductDiary WHERE ProductREF = %d AND Date = '%s';", product, date);
            DBStep.executeUpdate(query);
        }
        clear();
        refresh();
    }//GEN-LAST:event_btnProductDeleteActionPerformed

    private void btnProductCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductCancelActionPerformed
        panCalendar.poke();
    }//GEN-LAST:event_btnProductCancelActionPerformed

    private void btnProductSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductSaveActionPerformed
        LocalDate date = panCalendar.getDate();
        String dateString = panCalendar.getDateString();
        int potted = Integer.parseInt(txtPotted.getText());
        int hardened = Integer.parseInt(txtHardened.getText());
        int ready = Integer.parseInt(txtReady.getText());
        int sold = Integer.parseInt(txtSold.getText());
        if (!lstEntries.isSelectionEmpty() && Swingers.getSelectedKey(cmbProduct) == lstEntries.getSelectedValue().getKey()) {
            int product = lstEntries.getSelectedValue().getKey();
            String query = String.format("UPDATE ProductDiary SET " +
                "PottedOn = %d, HardenedOff = %d, ReadyForSale = %d, Sold = %d " +
                "WHERE ProductREF = %d AND Date = '%s';", potted, hardened, ready, sold, product, dateString);
            DBStep.executeUpdate(query);
        } else {
            int product = Swingers.getSelectedKey(cmbProduct);
            String query = String.format("INSERT INTO ProductDiary (ProductREF, Date, PottedOn, HardenedOff, ReadyForSale, Sold) VALUES (" +
                "%d, '%s', %d, %d, %d, %d);", product, dateString, potted, hardened, ready, sold);
            DBStep.executeUpdate(query);
        }
        refresh();
        panCalendar.setDate(date);
        clear();
    }//GEN-LAST:event_btnProductSaveActionPerformed

    private void checkDay(EntryType type) {
        String query = String.format("SELECT * FROM %s JOIN %s ON %s=%s WHERE Date %s ORDER BY %s ASC;",
                type.getDiary(), type.getTable(), type.getId(), type.getRef(), getSQLDate(), type.getSort());
        try {
            ResultSet rs = DBStep.executeQuery(query);
            while (rs.next()) {
                Pair pair = new Pair(rs.getInt(type.getRef()), rs.getString(type.getSort()));
                switch (type) {
                    case PLANT:
                        int plantCount = rs.getInt("Bought")  + rs.getInt("Delivered") - rs.getInt("Lost");
                        mdlEntries.addElement(new Entry(new Part(pair, plantCount), type));
                        break;
                    case ITEM:
                        int itemCount = rs.getInt("Bought") + rs.getInt("Delivered");
                        mdlEntries.addElement(new Entry(new Part(pair, itemCount), type));
                        break;
                    case PRODUCT:
                        int prodCount = rs.getInt("PottedOn") - rs.getInt("Sold");
                        mdlEntries.addElement(new Entry(new Part(pair, prodCount), type));
                        break;
                }
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }
    
    /**
     * Create a date form "= 'DATE'" usable within an SQL query.
     * @param date
     * @return
     */
    private String genSQLDateEqualX(LocalDate date) {
        return "= '" + genSQLDateX(date.getYear(), date.getMonthValue(), date.getDayOfMonth()) + "'";
    }
    
    /**
     * {@link PurplePanel#genSQLDateEqual}
     * @param date
     * @return
     */
    private String genSQLDateRangeX(YearMonth date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        return "BETWEEN '" + genSQLDateX(year, month, 1) + "' AND '" + genSQLDateX(year, month, 31) + "'";
    }
    
    private String getSQLDate() {
        if (panCalendar.daySelected()) {
            return genSQLDateRangeX(panCalendar.getYearMonth());
        } else {
            return genSQLDateEqualX(panCalendar.getDate());
        }
    }
    
    private String getSQLDateRange() {
        return genSQLDateRangeX(panCalendar.getYearMonth());
    }
    

    /**
     * Generate an SQL date value from the parts.
     * @param year
     * @param month
     * @param day
     * @return
     */
    private String genSQLDateX(int year, int month, int day) {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Pair> cmbProduct;
    private javax.swing.JList<Entry> lstEntries;
    private com.undeadscythes.purplepetal.panels.date.DatePanel panCalendar;
    private javax.swing.JPanel panProduct;
    private javax.swing.JTextField txtHardened;
    private javax.swing.JTextField txtPotted;
    private javax.swing.JTextField txtReady;
    private javax.swing.JTextField txtSold;
    // End of variables declaration//GEN-END:variables
}
