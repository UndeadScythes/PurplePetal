package com.undeadscythes.purplepetal.panels;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.models.PurpleComboModel;
import com.undeadscythes.purplepetal.utilities.DBStep;
import javax.swing.JPanel;

/**
 * Extension of a {@link JPanel} for use in the PurplePetals
 * project. Contains shared models for use between tabs.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class PurplePanel extends JPanel {
    /**
     * Drop down list of suppliers.
     */
    protected static final PurpleComboModel<Pair> suppliersCombo = new PurpleComboModel<>();

    /**
     * Drop down list of products.
     */
    protected static final PurpleComboModel<Pair> productsCombo = new PurpleComboModel<>();
    
    /**
     * Drop down list of plant types.
     */
    protected static final PurpleComboModel<Pair> plantTypesCombo = new PurpleComboModel<>();
    
    /**
     * Drop down list of items.
     */
    protected static final PurpleComboModel<Pair> feedstockCombo = new PurpleComboModel<>();
    
    /**
     * Drop down list of plants.
     */
    protected static final PurpleComboModel<Pair> plantsCombo = new PurpleComboModel<>();
    
    /**
     * Drop down list of event types.
     */
    protected static final PurpleComboModel<Pair> eventTypesCombo = new PurpleComboModel<>();
    
    /**
     * Drop down list of events.
     */
    protected static final PurpleComboModel<Pair> eventsCombo = new PurpleComboModel<>();

    /**
     * DB accessor for plant types.
     */
    protected static final DBStep plantTypesDB = new DBStep("PlantType", "PlantTypeID", "Description", "Description");

    private static double VAT = 0;

    /**
     * @return the VAT
     */
    public static double getVAT() {
        return VAT;
    }

    /**
     * @param aVAT the VAT to set
     */
    public static void setVAT(double aVAT) {
        VAT = aVAT;
    }

    /**
     * Update the list of plant types.
     */
    public static void updatePlantTypesCombo() {
        plantTypesDB.refreshLists(null, plantTypesCombo);
    }

    private static String getParam(String[] params, int index) {
        String result = "";
        if (index > -1) {
            if (params.length > index) {
                result = params[index];
            } else {
                result = getParam(params, index - 1);
            }
        }
        return result;
    }

    /**
     * Database accessor.
     */
    protected final DBStep db;

    /**
     * Set parameters.
     * @param table
     * @param idField
     * @param nameField
     * @param sortField
     */
    public PurplePanel(String table, String idField, String nameField, String sortField) {
        db = new DBStep(table, idField, nameField, sortField);
    }

    /**
     * Set parameters.
     * @param params
     */
    public PurplePanel(String[] params) {
        this(getParam(params, 0), getParam(params, 1), getParam(params, 2), getParam(params, 3));
    }
    
    /**
     * Panel type setup.
     */
    public PurplePanel() {
        this("", "", "", "");
    }
    
    /**
     * Throw an error.
     * @param ex
     */
    protected void error(Exception ex) {
        DBStep.error(ex);
    }
    
}
