package purplepetal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 * {@link HandyPanel} extension of a {@link JPanel} for use in the PurplePetals
 * project. Contains shared models for use between tabs.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class PurplePanel extends HandyPanel {
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
    private static Connection conn;
    
    /**
     * Set the connection used to access the underlying database.
     * @param conn
     */
    public static void setConnection(Connection conn) {
        PurplePanel.conn = conn;
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
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Create and return a statement to access the database.
     * @return
     * @throws java.sql.SQLException
     */
    protected Statement createStatement() throws SQLException {
        if (conn == null) {
            throw new SQLException();
        }
        return conn.createStatement();
    }
}
