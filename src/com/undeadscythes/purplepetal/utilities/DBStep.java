package com.undeadscythes.purplepetal.utilities;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.logging.OneLineFormatter;
import com.undeadscythes.purplepetal.sqlite.NullResultSet;
import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Methods for handling data access to and from a database.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
public class DBStep {
    private static final Logger LOGGER = Logger.getLogger(DBStep.class.getName());
    private static Connection c = null;
    private static Statement s = null;
    private static Container parent = null;
    
    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new OneLineFormatter());
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(handler);
    }

    /**
     * Set the connection used to access the underlying database.
     * @param parent
     * @param c
     */
    public static void setConnection(Container parent, Connection c) {
        DBStep.parent = parent;
        DBStep.c = c;
    }

    /**
     * Execute a query on the database.
     * @param query
     * @return
     */
    public static ResultSet executeQuery(String query) {
        ResultSet rs = NullResultSet.NULL;
        try {
            createStatement();
            rs = s.executeQuery(sanitise(query));
            int rows = 0;
            while (rs.next()) {
                rows++;
            }
            String msg = String.format("QUERY [%03d]: '%s'", rows, query);
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
    public static boolean entryExists(String query) {
        boolean exists = false;
        try {
            exists = executeQuery(query).next();
        } catch (SQLException ex) {
            error(ex);
        }
        return exists;
    }
    
    /**
     * Add a new entry to the table.
     * @param table
     * @param map
     * @return
     */
    public static int newEntry(String table, Map<String, Object> map) {
        String fields = String.join(", ", map.keySet());
        String values = String.join(", ", convertValues(map.values()));
        String query = String.format("INSERT INTO %s (%s) VALUES (%s);", table, fields, values);
        executeUpdate(query);
        return getInsertID();
    }
    
    /**
     * Execute an update query on the database.
     * @param query
     */
    public static void executeUpdate(String query) {
        try {
            createStatement();
            s.executeUpdate(sanitise(query));
            String msg = String.format("UPDATE     : '%s'", query);
            LOGGER.info(msg);
        } catch (SQLException ex) {
            error(ex, query);
        }
    }
    
    /**
     * Throwables cause popups and logs.
     * @param ex
     */
    public static void error(Exception ex) {
        LOGGER.log(Level.SEVERE, null, ex);
        if (c != null) {
            JOptionPane.showMessageDialog(parent, ex.getMessage(), "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Wrap a string with single quotes.
     * @param string
     * @return
     */
    @Deprecated
    public static String wrap(String string) {
        return String.format("'%s'", string);
    }

    /**
     * Update an existing entry.
     * @param table
     * @param id
     * @param map
     */
    public static void updateEntry(String table, int id, Map<String, ? extends Object> map) {
        ArrayList<String> values = new ArrayList<>(map.size());
        map.entrySet().stream().forEach((entry) -> {
            values.add(String.format("%s = %s", entry.getKey(), convertValue(entry.getValue())));
        });
        String updates = String.join(", ", values);
        String query = String.format("UPDATE %s SET %s WHERE %s = %d;", table, updates, table + "ID", id);
        executeUpdate(query);
    }
    
    /**
     * Delete a table entry with SQL.
     * @param table
     * @param ref
     * @param id
     */
    public static void deleteEntry(String table, String ref, int id) {
        String query = String.format("DELETE FROM %s WHERE %s = %d;", table, ref, id);
        executeUpdate(query);
    }
    
    private static String sanitise(String string) {
        return string; //TODO: Figure a way to sanitise strings?
    }
    
    private static void createStatement() throws SQLException {
        if (s != null && !s.isClosed()) {
            s.close();
        }
        if (c == null) {
            throw new SQLException("Connection is not yet open.");
        }
        s = c.createStatement();
    }
    
    private static void error(Exception ex, String query) {
        LOGGER.log(Level.SEVERE, "Error in SQL query, see below for more details.", ex);
        String msg = String.format("%s%n%s", query, ex.getMessage());
        if (ex.getMessage() != null) {
            JOptionPane.showMessageDialog(parent, msg, "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static int getInsertID() {
        int id = -1;
        try {
            ResultSet rs = executeQuery("SELECT last_insert_rowid();");
            rs.next();
            id = rs.getInt("last_insert_rowid()");
        } catch (SQLException ex) {
            error(ex);
        }
        return id;
    }

    private static ArrayList<String> convertValues(Collection<Object> values) {
        ArrayList<String> valueStrings = new ArrayList<>(values.size());
        values.stream().forEach((value) -> {
            valueStrings.add(convertValue(value));
        });
        return valueStrings;
    }

    private static String convertValue(Object value) {
        String valueString;
        if (value instanceof String) {
            valueString = String.format("'%s'", value);
        } else if (value instanceof Integer) {
            valueString = Integer.toString((Integer) value);
        } else if (value instanceof Float) {
            valueString = Float.toString((Float) value);
        } else {
            String string = String.format("'%s'", value.toString());
            valueString = string;
            String msg = String.format("Unknown class in value map, using %s.", string);
            error(new ClassCastException(msg));
        }
        return valueString;
    }
    
    private final String tableName;
    private final String idField;
    private final String nameField;
    private final String sortField;

    /**
     * Make a new specific db helper.
     * @param tableName
     * @param idField
     * @param nameField
     * @param sortField
     */
    public DBStep(String tableName, String idField, String nameField, String sortField) {
        this.tableName = tableName;
        this.idField = idField;
        this.nameField = nameField;
        this.sortField = sortField;
    }

    /**
     * Delete a table entry with SQL.
     * @param id
     */
    public void deleteEntry(int id) {
        String query = String.format("DELETE FROM %s WHERE %s = %d;", tableName, idField, id);
        executeUpdate(query);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet getEntry(int id) throws SQLException {
        String query = String.format("SELECT * FROM %s WHERE %s = %d;", tableName, idField, id);
        return executeQuery(query);
    }
    
    /**
     * Add a new entry to the table.
     * @param map
     * @return
     */
    public int newEntry(Map<String, Object> map) {
        return newEntry(tableName, map);
    }
    
    /**
     * Update an existing entry.
     * @param id
     * @param map
     */
    public void updateEntry(int id, Map<String, ? extends Object> map) {
        updateEntry(tableName, id, map);
    }
    
    /**
     * Get values from a table and populate a list and combo box.
     * @param list
     * @param combo
     */
    public void refreshLists(DefaultListModel<Pair> list, DefaultComboBoxModel<Pair> combo) {
        if (list != null) {
            list.clear();
        }
        if (combo != null) {
            combo.removeAllElements();
            combo.addElement(new Pair(-1, ""));
        }
        String query = String.format("SELECT %s, %s FROM %s ORDER BY %s ASC;", idField, nameField, tableName, sortField);
        try {
            ResultSet rs = executeQuery(query);
            while (rs.next()) {
                Pair pair = new Pair(rs.getInt(idField), rs.getString(nameField));
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
    
     
}
