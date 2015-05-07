package purplepetal.panel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import purplepetal.Keyable;
import purplepetal.Pair;

/**
 * Panel for handling data access to and from the database.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class DataPanel extends JPanel {
    private static final Logger LOGGER = Logger.getLogger(DataPanel.class.getName());
    private static Connection c;

    /**
     * Set the connection used to access the underlying database.
     * @param c
     */
    public static void setConnection(Connection c) {
        DataPanel.c = c;
    }
    
    /**
     * Create a date form "= 'DATE'" usable within an SQL query.
     * @param date
     * @return
     */
    protected static String makeSQLDate(LocalDate date) {
        return "= '" + makeDate(date.getYear(), date.getMonthValue(), date.getDayOfMonth()) + "'";
    }
    /**
     * {@link PurplePanel#makeSQLDate}
     * @param date
     * @return
     */
    protected static String makeSQLDate(YearMonth date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        return "BETWEEN '" + makeDate(year, month, 1) + "' AND '" + makeDate(year, month, 31) + "'";
    }
    
    /**
     * Parse an SQL date value into its three parts.
     * @param date
     * @return
     */
    protected static LocalDate parseSQLDate(String date) {
        String[] parts = date.split("-");
        int[] output = new int[3];
        for (int i = 0; i < 3; i++) {
            output[i] = Integer.parseInt(parts[i]);
        }
        return LocalDate.of(output[0], output[1], output[2]);
    }
    
    /**
     * Generate an SQL date value from the parts.
     * @param date
     * @return
     */
    protected static String makeDate(LocalDate date) {
        return String.format("%04d-%02d-%02d", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }
    
    /**
     * Generate an SQL date value from the parts.
     * @param year
     * @param month
     * @param day
     * @return
     */
    protected static String makeDate(int year, int month, int day) {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    
    /**
     * Create and return a statement to access the database.
     * @return
     * @throws java.sql.SQLException
     */
    protected Statement createStatement() throws SQLException {
        if (c == null) {
            throw new SQLException();
        }
        return c.createStatement();
    }
    
    /**
     * Given key-value {@link Pair} based {@link JComboBox}, select a certain
     * index with the given key.
     * @param comboBox
     * @param key
     */
    protected void selectKey(JComboBox<Pair> comboBox, int key) {
        comboBox.setSelectedIndex(0);
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).getKey() == key) {
                comboBox.setSelectedIndex(i);
            }
        }
    }
    
    /**
     * Return the {@link Pair} selected in a combo box.
     * @param comboBox
     * @return
     */
    protected Pair getSelection(JComboBox<Pair> comboBox) {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }

    /**
     * Throwables cause popups and logs.
     * @param ex
     */
    protected void error(Exception ex) {
        LOGGER.log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning!", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * SQLK query throwables cause popups and logs.
     * @param ex
     * @param query
     */
    protected void error(Exception ex, String query) {
        LOGGER.log(Level.SEVERE, null, ex);
        String msg = String.format("%s\n%s", query, ex.getMessage());
        JOptionPane.showMessageDialog(this, msg, "Warning!", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Get values from a table and populate a list and combo box.
     * @param list
     * @param combo
     * @param table
     * @param keyField
     * @param valueField
     * @param orderField
     */
    protected void refresh(DefaultListModel<Pair> list, DefaultComboBoxModel<Pair> combo, String table, String keyField, String valueField, String orderField) {
        if (list != null) {
            list.clear();
        }
        if (combo != null) {
            combo.removeAllElements();
            combo.addElement(new Pair(-1, ""));
        }
        String query = String.format("SELECT %s, %s FROM %s ORDER BY %s ASC;", keyField, valueField, table, orderField);
        try (Statement s = createStatement();
                ResultSet rs = s.executeQuery(query)) {
            while (rs.next()) {
                Pair pair = new Pair(rs.getInt(keyField), rs.getString(valueField));
                if (list != null) {
                    list.addElement(pair);
                }
                if (combo != null) {
                    combo.addElement(pair);
                }
            }
        } catch (SQLException ex) {
            error(ex, query);
        }
    }

    /**
     *
     * @param list
     * @param combo
     * @param table
     * @param keyField
     * @param valueField
     */
    protected void refresh(DefaultListModel<Pair> list, DefaultComboBoxModel<Pair> combo, String table, String keyField, String valueField) {
        refresh(list, combo, table, keyField, valueField, valueField);
    }

    /**
     *
     * @param list
     * @param combo
     * @param table
     * @param valueField
     */
    protected void refresh(DefaultListModel<Pair> list, DefaultComboBoxModel<Pair> combo, String table, String valueField) {
        refresh(list, combo, table, table + "ID", valueField, valueField);
    }

    /**
     *
     * @param list
     * @param combo
     * @param table
     */
    protected void refresh(DefaultListModel<Pair> list, DefaultComboBoxModel<Pair> combo, String table) {
        String valueField = table + "Name";
        refresh(list, combo, table, table + "ID", valueField, valueField);
    }
    
    /**
     * Set the text of the fields to "".
     * @param fields
     */
    protected void clear(JTextField... fields) {
        set("", fields);
    }
    
    /**
     * Clear the list selections.
     * @param lists
     */
    protected void clear(JList... lists) {
        for (JList list : lists) {
            list.clearSelection();
        }
    }
    
    /**
     * Clear the combo selections.
     * @param combos
     */
    protected void clear(JComboBox... combos) {
        for (JComboBox combo : combos) {
            if (combo.getItemCount() > 0) {
                combo.setSelectedIndex(0);
            }
        }
    }
    
    /**
     * Set the text of the fields to text.
     * @param text
     * @param fields
     */
    protected void set(String text, JTextField... fields) {
        for (JTextField field : fields) {
            field.setText(text);
        }
    }
    
    /**
     * Remove the item from the list with this key.
     * @param list
     * @param key
     */
    protected void remove(DefaultListModel<? extends Keyable> list, int key) {
        int index = getIndex(list, key);
        if (index > -1) {
            list.remove(index);
        }
    }
    
    /**
     * Returns the index of the item with a given key in the list.
     * @param list
     * @param key
     * @return
     */
    protected int getIndex(DefaultListModel<? extends Keyable> list, int key) {
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Replace (or add) the item with this key with the value given.
     * @param <T>
     * @param list
     * @param key
     * @param value
     */
    protected <T extends Keyable> void replace(DefaultListModel<T> list, int key, T value) {
        int index = getIndex(list, key);
        if (index > -1) {
            list.remove(index);
            list.add(index, value);
        } else {
            list.addElement(value);
        }
    }
}
