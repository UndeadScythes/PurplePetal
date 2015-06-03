package com.undeadscythes.purplepetal.panels.feedstock;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.panels.KeyedPurplePanel;
import com.undeadscythes.purplepetal.panels.PurpleAccessPanel;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * Add and edit items.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Feedstock extends PurpleAccessPanel {
    private final DefaultListModel<Pair> mdlItems = new DefaultListModel<>();
    
    /**
     * Creates new form Items
     */
    public Feedstock() {
        super(FeedstockPanel.ITEM_PARAMS);
        activateComponents();
        refresh();
    }

    @Override
    protected KeyedPurplePanel getDisplayPanel(int key) throws SQLException {
        return new FeedstockDisplay(key);
    }

    @Override
    protected KeyedPurplePanel getEditorPanel(int key) throws SQLException {
        return new FeedstockEditor(this, key);
    }

    @Override
    protected DefaultComboBoxModel<Pair> getComboBoxModel() {
        return feedstockCombo;
    }
}
