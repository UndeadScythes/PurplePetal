package com.undeadscythes.purplepetal.panels.suppliers;

import com.undeadscythes.purplepetal.panels.KeyedPurplePanel;
import java.sql.SQLException;

/**
 * Handles supplier database manipulation.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class SupplierPanel extends KeyedPurplePanel {
    /**
     * Parameters for accessing database.
     */
    static final String[] SUPPLIER_PARAMS = {"Supplier", "SupplierID", "Name"};
    
    /**
     * Make new panel.
     * @param key
     * @throws java.sql.SQLException
     */
    public SupplierPanel(int key) throws SQLException {
        super(key, SUPPLIER_PARAMS);
    }
}
