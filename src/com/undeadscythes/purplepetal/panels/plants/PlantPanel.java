package com.undeadscythes.purplepetal.panels.plants;

import com.undeadscythes.purplepetal.panels.KeyedPurplePanel;
import java.sql.SQLException;

/**
 * Panels for editing plants.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class PlantPanel extends KeyedPurplePanel {
    /**
     * Parameters for accessing database.
     */
    static final String[] PLANT_PARAMS = {"Plant", "PlantID", "CommonName", "CommonName"};
    
    /**
     * Get a new plant panel.
     * @param key
     * @throws java.sql.SQLException
     */
    public PlantPanel(int key) throws SQLException {
        super(key, PLANT_PARAMS);
    }
}
