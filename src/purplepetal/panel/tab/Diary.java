package purplepetal.panel.tab;

// TODO: Finally remove txtLost and refactor txtLostX -> txtLost

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
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
import purplepetal.Entry;
import purplepetal.EntryType;
import purplepetal.Pair;
import purplepetal.Part;
import purplepetal.panel.PurplePanel;
import purplepetal.renderer.TableCellRenderer;

/**
 * Displays diary entries for the status of various plants.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Diary extends PurplePanel {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd");
    
    private final DefaultListModel<Entry> mdlEntries = new DefaultListModel<>();
    private final DefaultComboBoxModel<Pair> mdlMonths = new DefaultComboBoxModel<>();
    private final TableCellRenderer cellRenderer;
    private boolean refresh = false;

    /**
     * Initialise components.
     */
    public Diary() {
        super("", "", "Date");
        initComponents();
        cellRenderer = new TableCellRenderer(tabCalendar.getColumnCount());
        for (int i = 0; i < tabCalendar.getColumnCount(); i++) {
            tabCalendar.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        for (Month month : Month.values()) {
            mdlMonths.addElement(new Pair(month.getValue(), month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)));
        }
        btnTodayActionPerformed(null);
        refresh = true;
        refresh();
    }

    @Override
    protected void clear() {
        clearFields(cmbPlant, cmbProduct, cmbItem);
        lstEntries.clearSelection();
        setFields("0", txtPlantBought, txtPotted, txtHardened, txtReady, txtSold, txtItemBought, txtPlantDelivered, txtItemDelivered, txtLost);
    }

    @SuppressWarnings({"unchecked", "Convert2Diamond", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JSplitPane spl1 = new javax.swing.JSplitPane();
        javax.swing.JPanel panEntries = new javax.swing.JPanel();
        final javax.swing.JScrollPane scrEntries = new javax.swing.JScrollPane();
        lstEntries = new javax.swing.JList<Entry>();
        javax.swing.JPanel panCalendar = new javax.swing.JPanel();
        javax.swing.JButton btnToday = new javax.swing.JButton();
        cmbMonth = new javax.swing.JComboBox<Pair>();
        spnYear = new javax.swing.JSpinner();
        javax.swing.JScrollPane scrCalendar = new javax.swing.JScrollPane();
        tabCalendar = new javax.swing.JTable();
        javax.swing.JPanel panDetails = new javax.swing.JPanel();
        tabDetails = new javax.swing.JTabbedPane();
        panPlant = new javax.swing.JPanel();
        final javax.swing.JLabel labPlant = new javax.swing.JLabel();
        cmbPlant = new javax.swing.JComboBox<Pair>();
        txtPlantBought = new javax.swing.JTextField();
        final javax.swing.JLabel labPlantBought = new javax.swing.JLabel();
        javax.swing.JButton btnPlantSave = new javax.swing.JButton();
        javax.swing.JButton btnPlantCancel = new javax.swing.JButton();
        javax.swing.JButton btnPlantDelete = new javax.swing.JButton();
        javax.swing.JSeparator sep1 = new javax.swing.JSeparator();
        javax.swing.JButton btnPlantNew = new javax.swing.JButton();
        javax.swing.JLabel labPlantDelivered = new javax.swing.JLabel();
        txtPlantDelivered = new javax.swing.JTextField();
        labLost = new javax.swing.JLabel();
        txtLost = new javax.swing.JTextField();
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
        panItem = new javax.swing.JPanel();
        cmbItem = new javax.swing.JComboBox<Pair>();
        javax.swing.JLabel labItem = new javax.swing.JLabel();
        javax.swing.JLabel labItemBought = new javax.swing.JLabel();
        txtItemBought = new javax.swing.JTextField();
        javax.swing.JButton btnItemSave = new javax.swing.JButton();
        javax.swing.JButton btnItemCancel = new javax.swing.JButton();
        javax.swing.JButton btnItemDelete = new javax.swing.JButton();
        javax.swing.JSeparator sep5 = new javax.swing.JSeparator();
        javax.swing.JButton btnItemNew = new javax.swing.JButton();
        javax.swing.JLabel labItemDelivered = new javax.swing.JLabel();
        txtItemDelivered = new javax.swing.JTextField();

        spl1.setDividerLocation(250);

        lstEntries.setModel(mdlEntries);
        lstEntries.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntriesValueChanged(evt);
            }
        });
        scrEntries.setViewportView(lstEntries);

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

        javax.swing.GroupLayout panCalendarLayout = new javax.swing.GroupLayout(panCalendar);
        panCalendar.setLayout(panCalendarLayout);
        panCalendarLayout.setHorizontalGroup(
            panCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCalendarLayout.createSequentialGroup()
                        .addComponent(btnToday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnYear, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(scrCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panEntriesLayout = new javax.swing.GroupLayout(panEntries);
        panEntries.setLayout(panEntriesLayout);
        panEntriesLayout.setHorizontalGroup(
            panEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrEntries, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(panCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panEntriesLayout.setVerticalGroup(
            panEntriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panEntriesLayout.createSequentialGroup()
                .addComponent(panCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrEntries, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
        );

        spl1.setLeftComponent(panEntries);

        labPlant.setText("Plant");

        cmbPlant.setModel(plantsCombo);

        txtPlantBought.setText("0");

        labPlantBought.setText("Bought");

        btnPlantSave.setText("Save");
        btnPlantSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantSaveActionPerformed(evt);
            }
        });

        btnPlantCancel.setText("Cancel");
        btnPlantCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantCancelActionPerformed(evt);
            }
        });

        btnPlantDelete.setText("Delete");
        btnPlantDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantDeleteActionPerformed(evt);
            }
        });

        btnPlantNew.setText("New");
        btnPlantNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlantNewActionPerformed(evt);
            }
        });

        labPlantDelivered.setText("Delivered");

        txtPlantDelivered.setText("0");

        labLost.setText("Lost");

        txtLost.setText("0");

        javax.swing.GroupLayout panPlantLayout = new javax.swing.GroupLayout(panPlant);
        panPlant.setLayout(panPlantLayout);
        panPlantLayout.setHorizontalGroup(
            panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep1)
            .addGroup(panPlantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPlantLayout.createSequentialGroup()
                        .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labPlantDelivered, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labPlantBought, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(labPlant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labLost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPlant, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtLost, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPlantDelivered, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPlantBought, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))))
                    .addGroup(panPlantLayout.createSequentialGroup()
                        .addComponent(btnPlantSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlantCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlantDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPlantNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPlantLayout.setVerticalGroup(
            panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPlantLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPlant)
                    .addComponent(cmbPlant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPlantBought)
                    .addComponent(txtPlantBought, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labPlantDelivered)
                    .addComponent(txtPlantDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labLost)
                    .addComponent(txtLost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panPlantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlantCancel)
                    .addComponent(btnPlantSave)
                    .addComponent(btnPlantDelete)
                    .addComponent(btnPlantNew))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        tabDetails.addTab("Plant", panPlant);

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
                .addContainerGap(37, Short.MAX_VALUE))
        );

        tabDetails.addTab("Product", panProduct);

        cmbItem.setModel(itemsCombo);

        labItem.setText("Item");

        labItemBought.setText("Bought");

        txtItemBought.setText("0");

        btnItemSave.setText("Save");
        btnItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemSaveActionPerformed(evt);
            }
        });

        btnItemCancel.setText("Cancel");
        btnItemCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemCancelActionPerformed(evt);
            }
        });

        btnItemDelete.setText("Delete");
        btnItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemDeleteActionPerformed(evt);
            }
        });

        btnItemNew.setText("New");
        btnItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemNewActionPerformed(evt);
            }
        });

        labItemDelivered.setText("Delivered");

        txtItemDelivered.setText("0");

        javax.swing.GroupLayout panItemLayout = new javax.swing.GroupLayout(panItem);
        panItem.setLayout(panItemLayout);
        panItemLayout.setHorizontalGroup(
            panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep5)
            .addGroup(panItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panItemLayout.createSequentialGroup()
                        .addComponent(labItemDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panItemLayout.createSequentialGroup()
                        .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panItemLayout.createSequentialGroup()
                                .addComponent(btnItemSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnItemCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnItemDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnItemNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panItemLayout.createSequentialGroup()
                                .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panItemLayout.createSequentialGroup()
                                        .addComponent(labItem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panItemLayout.createSequentialGroup()
                                        .addComponent(labItemBought, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(26, 26, 26)))
                                .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtItemBought, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                        .addComponent(txtItemDelivered, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panItemLayout.setVerticalGroup(
            panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labItem)
                    .addComponent(cmbItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labItemBought)
                    .addComponent(txtItemBought, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labItemDelivered)
                    .addComponent(txtItemDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnItemCancel)
                    .addComponent(btnItemNew)
                    .addComponent(btnItemDelete)
                    .addComponent(btnItemSave))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        tabDetails.addTab("Item", panItem);

        javax.swing.GroupLayout panDetailsLayout = new javax.swing.GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabDetails)
        );
        panDetailsLayout.setVerticalGroup(
            panDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabDetails, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        spl1.setRightComponent(panDetails);

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

    @Override
    protected final void refresh() {
        if (refresh) {
            ArrayList<Integer> days = new ArrayList<>(31);
            for (EntryType type : EntryType.values()) {
                days.addAll(checkDiary(type));
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
        }
    }
    
    private ArrayList<Integer> checkDiary(EntryType type) {
        String query = String.format("SELECT * FROM %s WHERE Date %s;", type.getDiary(), getSQLDateRange());
        ArrayList<Integer> days = new ArrayList<>(31);
        try {
            ResultSet rs = executeQuery(query);
            while (rs.next()) {
                days.add(LocalDate.parse(rs.getString("Date")).getDayOfMonth());
            }
        } catch (SQLException ex) {
            error(ex);
        }
        return days;
    }
    
    private void btnTodayActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnTodayActionPerformed
        setDate(LocalDate.now());
    }//GEN-LAST:event_btnTodayActionPerformed

    private void setDate(LocalDate date) {
        spnYear.setValue(date.getYear());
        cmbMonth.setSelectedIndex(date.getMonthValue() - 1);
        refresh();
        selectCell(tabCalendar, getCoord(date));
        tabCalendarMouseClicked(null);
    }
    
    private void lstEntriesValueChanged(ListSelectionEvent evt) {//GEN-FIRST:event_lstEntriesValueChanged
        if (!lstEntries.isSelectionEmpty()) {
            Entry entry = lstEntries.getSelectedValue();
            EntryType type = entry.getType();
            LocalDate date = getDate();
            String query = String.format("SELECT * FROM %s WHERE %s = %d AND Date %s;", type.getDiary(), type.getRef(), entry.getKey(), genSQLDateEqualX(date));
            try {
                ResultSet rs = executeQuery(query);
                switch (type) {
                    case PLANT:
                        tabDetails.setSelectedComponent(panPlant);
                        while (rs.next()) {
                            comboSelectKey(cmbPlant, rs.getInt("PlantREF"));
                            txtPlantBought.setText(Integer.toString(rs.getInt("Bought")));
                            txtPlantDelivered.setText(Integer.toString(rs.getInt("Delivered")));
                            txtLost.setText(Integer.toString(rs.getInt("Lost")));
                        }
                        break;
                    case PRODUCT:
                        tabDetails.setSelectedComponent(panProduct);
                        while (rs.next()) {
                            comboSelectKey(cmbProduct, rs.getInt("ProductREF"));
                            txtPotted.setText(Integer.toString(rs.getInt("PottedOn")));
                            txtHardened.setText(Integer.toString(rs.getInt("HardenedOff")));
                            txtReady.setText(Integer.toString(rs.getInt("ReadyForSale")));
                            txtSold.setText(Integer.toString(rs.getInt("Sold")));
                        }
                        break;
                    case ITEM:
                        tabDetails.setSelectedComponent(panItem);
                        while (rs.next()) {
                            comboSelectKey(cmbItem, rs.getInt("ItemREF"));
                            txtItemBought.setText(Integer.toString(rs.getInt("Bought")));
                            txtItemDelivered.setText(Integer.toString(rs.getInt("Delivered")));
                        }
                        break;
                }
            } catch (SQLException ex) {
                error(ex);
            }
        }
    }//GEN-LAST:event_lstEntriesValueChanged

    private void btnPlantSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPlantSaveActionPerformed
        LocalDate date = getDate();
        int delivered = Integer.parseInt(txtPlantDelivered.getText());
        int lost = Integer.parseInt(txtLost.getText());
        int bought = Integer.parseInt(txtPlantBought.getText());
        if (!lstEntries.isSelectionEmpty() && comboGetSelection(cmbPlant).getKey() == lstEntries.getSelectedValue().getKey()) {
            int plant = lstEntries.getSelectedValue().getKey();
            String query = String.format("UPDATE PlantDiary SET " +
                "Bought = %d " +
                "Delivered = %d" + 
                "Lost = %d" +
                "WHERE PlantREF = %d AND Date %s;", bought, delivered, lost, plant, genSQLDateEqualX(date));
            executeUpdate(query);
        } else {
            int plant = comboGetSelection(cmbPlant).getKey();
            String query = String.format("INSERT INTO Diary (PlantREF, Date, Bought, Delivered, Lost) VALUES (" +
                "%d, '%s', %d, %d, %d);", plant, date.format(dtf), bought, delivered, lost);
            executeUpdate(query);
        }
        refresh();
        setDate(date);
        clear();
    }//GEN-LAST:event_btnPlantSaveActionPerformed

    private void btnPlantCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPlantCancelActionPerformed
        tabCalendarMouseClicked(null);
    }//GEN-LAST:event_btnPlantCancelActionPerformed

    private void btnPlantNewActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPlantNewActionPerformed
        clear();
    }//GEN-LAST:event_btnPlantNewActionPerformed

    private void btnPlantDeleteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnPlantDeleteActionPerformed
        JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records

        if (!lstEntries.isSelectionEmpty()) {
            int plant = lstEntries.getSelectedValue().getKey();
            LocalDate date = getDate();
            String query = String.format("DELETE FROM PlantDiary WHERE PlantREF = %d AND Date = '%s';", plant, date.format(dtf));
            executeUpdate(query);
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnPlantDeleteActionPerformed

    private void cmbMonthItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
        refresh();
    }//GEN-LAST:event_cmbMonthItemStateChanged

    private void spnYearStateChanged(ChangeEvent evt) {//GEN-FIRST:event_spnYearStateChanged
        refresh();
    }//GEN-LAST:event_spnYearStateChanged

    private void tabCalendarMouseClicked(MouseEvent evt) {//GEN-FIRST:event_tabCalendarMouseClicked
        setCell();
        mdlEntries.clear();
        if (tabCalendar.getSelectedColumn() > -1) {
            for (EntryType type : EntryType.values()) {
                checkDay(type);
            }
        }
    }//GEN-LAST:event_tabCalendarMouseClicked

    private void checkDay(EntryType type) {
        String query = String.format("SELECT * FROM %s JOIN %s ON %s=%s WHERE Date %s ORDER BY %s ASC;",
                type.getDiary(), type.getTable(), type.getId(), type.getRef(), getSQLDate(), type.getSort());
        try {
            ResultSet rs = executeQuery(query);
            while (rs.next()) {
                Pair pair = new Pair(rs.getInt(type.getRef()), rs.getString(type.getSort()));
                switch (type) {
                    case PLANT:
                        int plantCount = rs.getInt("Bought") - rs.getInt("Lost");
                        mdlEntries.addElement(new Entry(new Part(pair, plantCount), type));
                        break;
                    case ITEM:
                        mdlEntries.addElement(new Entry(new Part(pair, rs.getInt("Bought")), type));
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
    
    private void btnItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemSaveActionPerformed
        LocalDate date = getDate();
        int bought = Integer.parseInt(txtItemBought.getText());
        int delivered = Integer.parseInt(txtItemDelivered.getText());
        if (!lstEntries.isSelectionEmpty() && comboGetSelection(cmbItem).getKey() == lstEntries.getSelectedValue().getKey()) {
            int item = lstEntries.getSelectedValue().getKey();
            String query = String.format("UPDATE ItemDiary SET " +
                "Bought = %d " +
                "Delivered = %d" +
                "WHERE ItemREF = %d AND Date = '%s';", bought, delivered, item, date.format(dtf));
            executeUpdate(query);
        } else {
            int item = comboGetSelection(cmbItem).getKey();
            String query = String.format("INSERT INTO ItemDiary (ItemREF, Date, Bought, Delivered) VALUES (" +
                "%d, '%s', %d, %d);", item, date.format(dtf), bought, delivered);
            executeUpdate(query);
        }
        refresh();
        setDate(date);
        clear();
    }//GEN-LAST:event_btnItemSaveActionPerformed

    private void btnItemCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemCancelActionPerformed
        tabCalendarMouseClicked(null);
    }//GEN-LAST:event_btnItemCancelActionPerformed

    private void btnItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemDeleteActionPerformed
        JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records

        if (!lstEntries.isSelectionEmpty()) {
            int item = lstEntries.getSelectedValue().getKey();
            LocalDate date = getDate();
            String query = String.format("DELETE FROM ItemDiary WHERE ItemREF = %d AND Date = '%s';", item, date.format(dtf));
            executeUpdate(query);
        }
        clearAndRefresh();
    }//GEN-LAST:event_btnItemDeleteActionPerformed

    private void btnProductSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductSaveActionPerformed
        LocalDate date = getDate();
        int potted = Integer.parseInt(txtPotted.getText());
        int hardened = Integer.parseInt(txtHardened.getText());
        int ready = Integer.parseInt(txtReady.getText());
        int sold = Integer.parseInt(txtSold.getText());
        if (!lstEntries.isSelectionEmpty() && comboGetSelection(cmbProduct).getKey() == lstEntries.getSelectedValue().getKey()) {
            int product = lstEntries.getSelectedValue().getKey();
            String query = String.format("UPDATE ProductDiary SET " +
                "PottedOn = %d, HardenedOff = %d, ReadyForSale = %d, Sold = %d " +
                "WHERE ProductREF = %d AND Date = '%s';", potted, hardened, ready, sold, product, date.format(dtf));
            executeUpdate(query);
        } else {
            int product = comboGetSelection(cmbProduct).getKey();
            String query = String.format("INSERT INTO ProductDiary (ProductREF, Date, PottedOn, HardenedOff, ReadyForSale, Sold) VALUES (" +
                "%d, '%s', %d, %d, %d, %d);", product, date.format(dtf), potted, hardened, ready, sold);
            executeUpdate(query);
        }
        refresh();
        setDate(date);
        clear();
    }//GEN-LAST:event_btnProductSaveActionPerformed

    private void btnProductCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductCancelActionPerformed
        tabCalendarMouseClicked(null);
    }//GEN-LAST:event_btnProductCancelActionPerformed

    private void btnProductDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductDeleteActionPerformed
            JOptionPane.showMessageDialog(this, "This action has not been fully implemented yet.");

// TODO: Implement a check for records referencing this supplier and ask for
// confirmation of cascade delete or a supplier to replace in the records
            
            if (!lstEntries.isSelectionEmpty()) {
                int product = lstEntries.getSelectedValue().getKey();
                LocalDate date = getDate();
                String query = String.format("DELETE FROM ProductDiary WHERE ProductREF = %d AND Date = '%s';", product, date.format(dtf));
                executeUpdate(query);
            }
            clearAndRefresh();
    }//GEN-LAST:event_btnProductDeleteActionPerformed

    private void btnItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemNewActionPerformed
        clear();
    }//GEN-LAST:event_btnItemNewActionPerformed

    private void btnProductNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductNewActionPerformed
        clear();
    }//GEN-LAST:event_btnProductNewActionPerformed

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
        int month = comboGetSelection(cmbMonth).getKey();
        return YearMonth.of(year, month);
    }
    
    private String getSQLDate() {
        if (tabCalendar.getSelectedColumn() < 0) {
            return genSQLDateRangeX(getYearMonth());
        } else {
            return genSQLDateEqualX(getDate());
        }
    }
    
    private String getSQLDateRange() {
        return genSQLDateRangeX(getYearMonth());
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
    private javax.swing.JComboBox<Pair> cmbItem;
    private javax.swing.JComboBox<Pair> cmbMonth;
    private javax.swing.JComboBox<Pair> cmbPlant;
    private javax.swing.JComboBox<Pair> cmbProduct;
    private javax.swing.JLabel labLost;
    private javax.swing.JList<Entry> lstEntries;
    private javax.swing.JPanel panItem;
    private javax.swing.JPanel panPlant;
    private javax.swing.JPanel panProduct;
    private javax.swing.JSpinner spnYear;
    private javax.swing.JTable tabCalendar;
    private javax.swing.JTabbedPane tabDetails;
    private javax.swing.JTextField txtHardened;
    private javax.swing.JTextField txtItemBought;
    private javax.swing.JTextField txtItemDelivered;
    private javax.swing.JTextField txtLost;
    private javax.swing.JTextField txtPlantBought;
    private javax.swing.JTextField txtPlantDelivered;
    private javax.swing.JTextField txtPotted;
    private javax.swing.JTextField txtReady;
    private javax.swing.JTextField txtSold;
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Diary.class.getName());
}
