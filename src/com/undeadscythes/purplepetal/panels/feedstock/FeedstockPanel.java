package com.undeadscythes.purplepetal.panels.feedstock;

import com.undeadscythes.purplepetal.panels.KeyedPurplePanel;
import java.sql.SQLException;

/**
 * Handling item database related commands.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class FeedstockPanel extends KeyedPurplePanel {
    /**
     * Parameters for accessing database.
     */
    static final String[] ITEM_PARAMS = {"Feedstock", "FeedstockID", "Name", "Name"};

    /**
     * Set up a new panel.
     * @param key
     * @throws java.sql.SQLException
     */
    public FeedstockPanel(int key) throws SQLException {
        super(key, ITEM_PARAMS);
    }
}
