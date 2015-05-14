package purplepetal.panel;

import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import purplepetal.Pair;

/**
 * {@link HandyPanel} extension of a {@link JPanel} for use in the PurplePetals
 * project. Contains shared models for use between tabs.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class PurplePanel extends DataPanel {
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

    /**
     * Global VAT value.
     */
    protected static double VAT = 0;
    
    /**
     * Check for updates on startup.
     */
    public static boolean UPDATE = false;
    
    private static final Logger LOGGER = Logger.getLogger(PurplePanel.class.getName());

    /**
     * Set parameters.
     * @param table
     * @param idField
     * @param nameField
     * @param sortField
     */
    public PurplePanel(String table, String idField, String nameField, String sortField) {
        super(table, idField, nameField, sortField);
    }

    /**
     * Set parameters.
     * @param table
     * @param idField
     * @param nameField
     */
    public PurplePanel(String table, String idField, String nameField) {
        super(table, idField, nameField, nameField);
    }
    
    /**
     * Update the list of plant types.
     */
    protected void updatePlantTypesCombo() {
        refreshLists(null, plantTypesCombo, "PlantType", "PlantTypeID", "Description");
    }
}
