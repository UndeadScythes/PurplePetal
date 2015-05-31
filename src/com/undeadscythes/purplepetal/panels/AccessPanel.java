package com.undeadscythes.purplepetal.panels;

import com.undeadscythes.purplepetal.filters.ExtensionFilter;
import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.utilities.Swingers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 * Panel with a list and display split view.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class AccessPanel extends PurplePanel {
    private int selectedKey;
    
    /**
     * Set parameters.
     * @param params
     */
    protected AccessPanel(String[] params) {
        super(params);
    }
    
    /**
     * Call the initialiser for all components.
     */
    protected void activateComponents() {
        initComponents();
        lstList.setMenu(mnuListMenu);
        setFooter("");
    }
    
    /**
     * Set the footer text.
     * @param text
     */
    protected void setFooter(String text) {
        labFooter.setText(text);
    }

    /**
     * Set the selected key.
     * @param key
     */
    public void setSelectedKey(int key) {
        ListModel<Pair> listModel = getListModel();
        lstList.clearSelection();
        if (key > -1) {
            for (int i = 0; i < listModel.getSize(); i++) {
                if (listModel.getElementAt(i).getKey() == key) {
                    lstList.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            panShared.clear();
        }
    }
    
    /**
     * Set the selected key.
     */
    public void setSelectedKey() {
        setSelectedKey(-1);
    }
    
    /**
     * Clear the shared panel.
     */
    protected void loadPanel() {
        loadPanel(null);
    }
    
    /**
     * Load a panel into the shared area.
     * @param panel
     */
    protected void loadPanel(PurplePanel panel) {
        if (panel == null) {
            panShared.clear();
        } else {
            panShared.setContentPane(panel);
        }
        revalidate();
    }
    
    private void importData() {
        JFileChooser fc = new JFileChooser();
        ExtensionFilter csv = new ExtensionFilter(".csv", "Comma seperated data");
        fc.addChoosableFileFilter(csv);
        fc.setFileFilter(csv);
        int val = fc.showOpenDialog(this);
        if (val == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                if (line != null) {
                    String[] splits = line.split(",");
                    int cols = splits.length;
                    String msg = String.format("Use first row as data headers?%n\"%s\"", line);
                    int useFirstRow = JOptionPane.showConfirmDialog(this, msg);
                    String[] headerSplits = {};
                    if (useFirstRow == JOptionPane.NO_OPTION) {
                        String headers = JOptionPane.showInputDialog(this, "Please enter the fields names, seperated by commas:");
                        headerSplits = headers.split(",");
                        if (headerSplits.length != cols) {
                            throw new InstantiationException("Incorrect number of headers chosen for the given data.");
                        }
                    } else if (useFirstRow == JOptionPane.YES_OPTION) {
                        headerSplits = splits;
                        line = reader.readLine();
                    }
                    if (useFirstRow != JOptionPane.CANCEL_OPTION) {
                        while (line != null) {
                            splits = line.split(",");
                            HashMap<String, Object> values = new HashMap<>(cols);
                            for (int i = 0; i < splits.length; i++) {
                                String value = splits[i];
                                if (value.matches("\\d(\\.\\d+)?")) {
                                    values.put(headerSplits[i], Float.parseFloat(value));
                                } else {
                                    values.put(headerSplits[i], value);
                                }
                            }
                            db.newEntry(values);
                            line = reader.readLine();
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                error(ex);
            } catch (IOException | InstantiationException ex) {
                error(ex);
            }
            refresh();
        }
    }
    
    /**
     * Fired when the list value has changed.
     * @param key
     */
    protected abstract void updateSelection(int key);
    
    /**
     * Create a new entry.
     */
    protected abstract void newEntry();

    /**
     * Refresh the list.
     */
    protected abstract void refresh();
    
    /**
     * Get the model used to define the list.
     * @return
     */
    protected abstract ListModel<Pair> getListModel();
    
    /**
     * Delete the selected item.
     * @param key
     */
    protected abstract void delete(int key);
    
    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuListMenu = new javax.swing.JPopupMenu();
        itmImport = new javax.swing.JMenuItem();
        javax.swing.JPopupMenu.Separator itmSep1 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem itmNew = new javax.swing.JMenuItem();
        javax.swing.JMenuItem itmRefresh = new javax.swing.JMenuItem();
        itmSep2 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem itmDelete = new javax.swing.JMenuItem();
        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        javax.swing.JPanel panList = new javax.swing.JPanel();
        final javax.swing.JScrollPane scrList = new javax.swing.JScrollPane();
        lstList = new com.undeadscythes.purplepetal.lists.ListWithPopup<Pair>();
        javax.swing.JPanel panRight = new javax.swing.JPanel();
        panShared = new com.undeadscythes.purplepetal.panels.PurpleRoot();
        labFooter = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        itmImport.setText("Import data");
        itmImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmImportActionPerformed(evt);
            }
        });
        mnuListMenu.add(itmImport);
        mnuListMenu.add(itmSep1);

        itmNew.setText("New");
        itmNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmNewActionPerformed(evt);
            }
        });
        mnuListMenu.add(itmNew);

        itmRefresh.setText("Refresh");
        itmRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRefreshActionPerformed(evt);
            }
        });
        mnuListMenu.add(itmRefresh);
        mnuListMenu.add(itmSep2);

        itmDelete.setText("Delete");
        itmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmDeleteActionPerformed(evt);
            }
        });
        mnuListMenu.add(itmDelete);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        spl1.setDividerLocation(250);

        lstList.setModel(getListModel());
        lstList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstListMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstListMouseReleased(evt);
            }
        });
        lstList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstListValueChanged(evt);
            }
        });
        scrList.setViewportView(lstList);

        javax.swing.GroupLayout panListLayout = new javax.swing.GroupLayout(panList);
        panList.setLayout(panListLayout);
        panListLayout.setHorizontalGroup(
            panListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrList, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );
        panListLayout.setVerticalGroup(
            panListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrList, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        spl1.setLeftComponent(panList);

        labFooter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labFooter.setText("<footer text>");

        javax.swing.GroupLayout panRightLayout = new javax.swing.GroupLayout(panRight);
        panRight.setLayout(panRightLayout);
        panRightLayout.setHorizontalGroup(
            panRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panShared, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(panRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panRightLayout.setVerticalGroup(
            panRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRightLayout.createSequentialGroup()
                .addComponent(panShared, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labFooter))
        );

        spl1.setRightComponent(panRight);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spl1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lstListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstListValueChanged
        int key = Swingers.getSelectedKey(lstList);
        if (key != selectedKey) {
            updateSelection(key);
            selectedKey = key;
        }
    }//GEN-LAST:event_lstListValueChanged

    private void itmNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmNewActionPerformed
        newEntry();
    }//GEN-LAST:event_itmNewActionPerformed

    private void itmRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_itmRefreshActionPerformed

    private void itmImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmImportActionPerformed
        importData();
    }//GEN-LAST:event_itmImportActionPerformed

    private void itmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmDeleteActionPerformed
        delete(Swingers.getSelectedKey(lstList));
    }//GEN-LAST:event_itmDeleteActionPerformed

    private void lstListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstListMousePressed
        lstList.showPopup(evt);
    }//GEN-LAST:event_lstListMousePressed

    private void lstListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstListMouseReleased
        lstList.showPopup(evt);
    }//GEN-LAST:event_lstListMouseReleased
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmImport;
    private javax.swing.JPopupMenu.Separator itmSep2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labFooter;
    private com.undeadscythes.purplepetal.lists.ListWithPopup<Pair> lstList;
    private javax.swing.JPopupMenu mnuListMenu;
    private com.undeadscythes.purplepetal.panels.PurpleRoot panShared;
    // End of variables declaration//GEN-END:variables
}
