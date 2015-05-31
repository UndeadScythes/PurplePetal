package com.undeadscythes.purplepetal.panels.products;

import com.undeadscythes.purplepetal.panels.KeyedPurplePanel;
import java.sql.SQLException;

/**
 * Handle products in the database.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class ProductPanel extends KeyedPurplePanel {
    /**
     * Parameters for accessing database.
     */
    static final String[] PRODUCT_PARAMS = {"Product", "ProductID", "Name", "Name"};
    
    /**
     * Make a new panel.
     * @param key
     * @throws java.sql.SQLException
     */
    public ProductPanel(int key) throws SQLException {
        super(key, PRODUCT_PARAMS);
    }
}
