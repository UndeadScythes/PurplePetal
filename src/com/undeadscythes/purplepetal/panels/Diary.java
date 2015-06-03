package com.undeadscythes.purplepetal.panels;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.keyables.Part;
import com.undeadscythes.purplepetal.keyables.entry.Entry;
import com.undeadscythes.purplepetal.keyables.entry.EntryType;
import com.undeadscythes.purplepetal.panels.date.DateListener;
import com.undeadscythes.purplepetal.utilities.DBStep;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

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

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panCalendar = new com.undeadscythes.purplepetal.panels.date.DatePanel();
        panComments = new javax.swing.JPanel();
        btnProductSave = new javax.swing.JButton();
        btnProductCancel = new javax.swing.JButton();
        btnProductDelete = new javax.swing.JButton();
        btnProductNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout panCommentsLayout = new javax.swing.GroupLayout(panComments);
        panComments.setLayout(panCommentsLayout);
        panCommentsLayout.setHorizontalGroup(
            panCommentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCommentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCommentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panCommentsLayout.createSequentialGroup()
                        .addComponent(btnProductSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProductCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProductDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProductNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panCommentsLayout.setVerticalGroup(
            panCommentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panCommentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panCommentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductCancel)
                    .addComponent(btnProductSave)
                    .addComponent(btnProductDelete)
                    .addComponent(btnProductNew))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(panCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    private void btnProductNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductNewActionPerformed
    }//GEN-LAST:event_btnProductNewActionPerformed

    private void btnProductDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductDeleteActionPerformed
        JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

        // TODO: Implement a check for records referencing this supplier and ask for
        // confirmation of cascade delete or a supplier to replace in the records

        refresh();
    }//GEN-LAST:event_btnProductDeleteActionPerformed

    private void btnProductCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductCancelActionPerformed
        panCalendar.poke();
    }//GEN-LAST:event_btnProductCancelActionPerformed

    private void btnProductSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductSaveActionPerformed
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
    private javax.swing.JButton btnProductCancel;
    private javax.swing.JButton btnProductDelete;
    private javax.swing.JButton btnProductNew;
    private javax.swing.JButton btnProductSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private com.undeadscythes.purplepetal.panels.date.DatePanel panCalendar;
    private javax.swing.JPanel panComments;
    // End of variables declaration//GEN-END:variables
}
