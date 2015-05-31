package com.undeadscythes.purplepetal.panels;

import java.sql.SQLException;

/**
 * Purple panel with a key!
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class KeyedPurplePanel extends PurplePanel {
    /**
     * The key.
     */
    protected final int key;
    
    /**
     * Set the key.
     * @param key_
     * @throws java.sql.SQLException
     */
    public KeyedPurplePanel(int key_) throws SQLException {
        key = key_;
    }
    
    /**
     * Set the key.
     * @param key_
     * @param params
     * @throws java.sql.SQLException
     */
    public KeyedPurplePanel(int key_, String[] params) throws SQLException {
        super(params);
        key = key_;
    }
}
