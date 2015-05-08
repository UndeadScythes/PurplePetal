package purplepetal.panel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import purplepetal.OneLineFormatter;
import purplepetal.Pair;

/**
 * Panel for handling data access to and from the database.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class DataPanel extends HandyPanel {
    private static final Logger LOGGER = Logger.getLogger(DataPanel.class.getName());
    private static Connection c;
    private Statement s;
    
    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new OneLineFormatter());
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(handler);
    }

    /**
     * Set the connection used to access the underlying database.
     * @param c
     */
    public static void setConnection(Connection c) {
        DataPanel.c = c;
    }
    
    private final String tableName;
    private final String idField;
    private final String nameField;
    private final String sortField;

    /**
     * Set up all the necessary fields for the underlying table.
     * @param table
     * @param idField
     * @param nameField
     * @param sortField
     */
    public DataPanel(String table, String idField, String nameField, String sortField) {
        this.tableName = table;
        this.idField = idField;
        this.nameField = nameField;
        this.sortField = sortField;
    }
    
    /**
     * Set up all the necessary fields for the underlying table.
     * @param table
     * @param idField
     * @param nameField
     */
    public DataPanel(String table, String idField, String nameField) {
        this.tableName = table;
        this.idField = idField;
        this.nameField = nameField;
        this.sortField = nameField;
    }
    
    /**
     * Execute a query on the database.
     * @param query
     * @return
     */
    protected ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            s = createStatement();
            rs = s.executeQuery(query);
            int rows = 0;
            while (rs.next()) {
                rows++;
            }
            String msg = String.format("%03d rows from %s", rows, query);
            LOGGER.info(msg);
            rs = s.executeQuery(query);
        } catch (SQLException ex) {
            error(ex, query);
        }
        return rs;
    }
    
    /**
     * Check if a query generates any entry results.
     * @param query
     * @return
     */
    protected boolean entryExists(String query) {
        boolean exists = false;
        try {
            exists = executeQuery(query).next();
        } catch (SQLException ex) {
            error(ex);
        }
        return exists;
    }
    
    /**
     * Execute an update query on the database.
     * @param query
     */
    protected void executeUpdate(String query) {
        try (Statement s = createStatement()) {
            s.executeQuery(query);
        } catch (SQLException ex) {
            error(ex, query);
        }
    }
    
    /**
     * Throwables cause popups and logs.
     * @param ex
     */
    protected void error(Exception ex) {
        LOGGER.log(Level.SEVERE, null, ex);
        if (ex.getMessage() != null) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * {@link refreshListsX#refreshLists} with sort = name.
     * @param list
     * @param combo
     * @param table
     * @param keyField
     * @param valueField
     */
    protected void refreshLists(DefaultListModel<Pair> list, DefaultComboBoxModel<Pair> combo, String table, String keyField, String valueField) {
        refreshLists(list, combo, table, keyField, valueField, valueField);
    }
    
    /**
     * Draw parameters from properties.
     * @param list
     * @param combo
     */
    protected void refreshLists(DefaultListModel<Pair> list, DefaultComboBoxModel<Pair> combo) {
        refreshLists(list, combo, tableName, idField, nameField, sortField);
    }
    
    /**
     * Delete a table entry with SQL.
     * @param id
     */
    protected void deleteEntry(int id) {
        executeQuery(String.format("DELETE FROM %s WHERE %s = %d;", tableName, idField, id));
    }
    
    /**
     *
     * @param id
     * @return
     */
    protected ResultSet getEntry(int id) {
        String query = String.format("SELECT * FROM %s WHERE %s = %d;", tableName, idField, id);
        return executeQuery(query);
    }
    
    /**
     * Wrap a string with single quotes.
     * @param string
     * @return
     */
    protected String wrap(String string) {
        return String.format("'%s'", string);
    }
    
    /**
     * Add a new entry to the table.
     * @param map
     * @return
     */
    protected int newEntry(Map<String, String> map) {
        String fields = String.join(", ", map.keySet());
        String values = String.join(", ", map.values());
        String query = String.format("INSERT INTO %s (%s) VALUES (%s);", tableName, fields, values);
        executeUpdate(query);
        return getInsertID();
    }
    
    /**
     * Update an existing entry.
     * @param id
     * @param map
     */
    protected void updateEntry(int id, Map<String, String> map) {
        ArrayList<String> values = new ArrayList<>(map.size());
        map.entrySet().stream().forEach((entry) -> {
            values.add(String.format("%s = %s", entry.getKey(), entry.getValue()));
        });
        String updates = String.join(", ", values);
        String query = String.format("UPDATE %s SET %s WHERE %s = %d;", tableName, updates, idField, id);
        executeUpdate(query);
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
    private void refreshLists(DefaultListModel<Pair> list, DefaultComboBoxModel<Pair> combo, String table, String keyField, String valueField, String orderField) {
        if (list != null) {
            list.clear();
        }
        if (combo != null) {
            combo.removeAllElements();
            combo.addElement(new Pair(-1, ""));
        }
        String query = String.format("SELECT %s, %s FROM %s ORDER BY %s ASC;", keyField, valueField, table, orderField);
        ResultSet rs = executeQuery(query);
        try {
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
            error(ex);
        }
    }
    
    /**
     * Create and return a statement to access the database.
     * @return
     * @throws java.sql.SQLException
     */
    private Statement createStatement() throws SQLException {
        if (s != null && !s.isClosed()) {
            s.close();
        }
        if (c == null) {
            throw new SQLException();
        }
        return c.createStatement();
    }
    
    /**
     * SQLK query throwables cause popups and logs.
     * @param ex
     * @param query
     */
    private void error(Exception ex, String query) {
        LOGGER.log(Level.SEVERE, null, ex);
        String msg = String.format("%s\n%s", query, ex.getMessage());
        if (ex.getMessage() != null) {
            JOptionPane.showMessageDialog(this, msg, "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }

    private int getInsertID() {
        int id = -1;
        ResultSet rs = executeQuery("SELECT last_insert_rowid();");
        try {
            rs.next();
            id = rs.getInt("last_insert_rowid()");
        } catch (SQLException ex) {
            error(ex);
        }
        return id;
    }
}
