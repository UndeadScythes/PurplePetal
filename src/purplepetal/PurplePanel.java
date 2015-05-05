package purplepetal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * {@link HandyPanel} extension of a {@link JPanel} for use in the PurplePetals
 * project. Contains shared models for use between tabs.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class PurplePanel extends JPanel {
    /**
     * Drop down list of suppliers.
     */
    protected static final DefaultComboBoxModel<Pair> suppliersCombo = new DefaultComboBoxModel<>();

    /**
     * Drop down list of plant types.
     */
    protected static final DefaultComboBoxModel<Pair> plantTypesCombo = new DefaultComboBoxModel<>();
    
    /**
     * Drop down list of plants.
     */
    protected static final DefaultComboBoxModel<Pair> plantsCombo = new DefaultComboBoxModel<>();
    private static final Logger LOGGER = Logger.getLogger(PurplePanel.class.getName());
    private static Connection c;
    
    /**
     * Create a date form "= 'DATE'" usable within an SQL query.
     * @param date
     * @return
     */
    public static String makeSQLDate(LocalDate date) {
        return "= '" + makeDate(date.getYear(), date.getMonthValue(), date.getDayOfMonth()) + "'";
    }
    
    /**
     * {@link PurplePanel#makeSQLDate}
     * @param date
     * @return
     */
    public static String makeSQLDate(YearMonth date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        return "BETWEEN '" + makeDate(year, month, 1) + "' AND '" + makeDate(year, month, 31) + "'";
    }
    
    /**
     * Parse an SQL date value into its three parts.
     * @param date
     * @return
     */
    public static LocalDate parseSQLDate(String date) {
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
    public static String makeDate(LocalDate date) {
        return String.format("%04d-%02d-%02d", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }

    
    /**
     * Generate an SQL date value from the parts.
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String makeDate(int year, int month, int day) {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    
    /**
     * Set the connection used to access the underlying database.
     * @param conn
     */
    public static void setConnection(Connection conn) {
        PurplePanel.c = conn;
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
     * Update the list of plant types.
     */
    protected void updatePlantTypesCombo() {
        plantTypesCombo.removeAllElements();
        plantTypesCombo.addElement(new Pair(-1, ""));
        try (Statement s = createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM PlantType;")) {
            while (rs.next()) {
                plantTypesCombo.addElement(new Pair(rs.getInt("PlantTypeID"), rs.getString("Description")));
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
    protected Statement createStatement() throws SQLException {
        if (c == null) {
            throw new SQLException();
        }
        return c.createStatement();
    }
    
    /**
     * Throwables cause popups and logs.
     * @param ex
     */
    protected void error(Exception ex) {
        LOGGER.log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning!", JOptionPane.WARNING_MESSAGE);
    }
}
