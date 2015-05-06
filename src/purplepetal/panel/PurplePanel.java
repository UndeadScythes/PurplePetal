package purplepetal.panel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import purplepetal.Pair;

/**
 * {@link HandyPanel} extension of a {@link JPanel} for use in the PurplePetals
 * project. Contains shared models for use between tabs.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class PurplePanel extends DataPanel {
    /**
     * Drop down list of suppliers.
     */
    protected static final DefaultComboBoxModel<Pair> suppliersCombo = new DefaultComboBoxModel<>();

    /**
     * Drop down list of products.
     */
    protected static final DefaultComboBoxModel<Pair> productsCombo = new DefaultComboBoxModel<>();
    
    /**
     * Drop down list of plant types.
     */
    protected static final DefaultComboBoxModel<Pair> plantTypesCombo = new DefaultComboBoxModel<>();
    
    /**
     * Drop down list of items.
     */
    protected static final DefaultComboBoxModel<Pair> itemsCombo = new DefaultComboBoxModel<>();
    
    /**
     * Drop down list of plants.
     */
    protected static final DefaultComboBoxModel<Pair> plantsCombo = new DefaultComboBoxModel<>();
    private static final Logger LOGGER = Logger.getLogger(PurplePanel.class.getName());
    
    /**
     * Update the list of plant types.
     */
    protected void updatePlantTypesCombo() {
        plantTypesCombo.removeAllElements();
        plantTypesCombo.addElement(new Pair(-1, ""));
        try (Statement s = createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM PlantType ORDER BY Description ASC;")) {
            while (rs.next()) {
                plantTypesCombo.addElement(new Pair(rs.getInt("PlantTypeID"), rs.getString("Description")));
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }
}
