package com.undeadscythes.purplepetal.panels;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.utilities.Swingers;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 * An access panel for the purple family.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public abstract class PurpleAccessPanel extends AccessPanel {
    private final DefaultListModel<Pair> listModel = new DefaultListModel<>();
    
    /**
     * Initialise panel components.
     * @param params
     */
    public PurpleAccessPanel(String[] params) {
        super(params);
        activateComponents();
        refresh();
    }

    /**
     * Get a new sub panel.
     * @param key
     * @return
     * @throws java.sql.SQLException
     */
    protected abstract KeyedPurplePanel getDisplayPanel(int key) throws SQLException;
    
    /**
     * Get a new sub panel.
     * @param key
     * @return
     * @throws java.sql.SQLException
     */
    protected abstract KeyedPurplePanel getEditorPanel(int key) throws SQLException;
    
    /**
     * Get a combo box for updating.
     * @return
     */
    protected abstract DefaultComboBoxModel<Pair> getComboBoxModel();
    
    @Override
    protected final void updateSelection(int key) {
        try {
            if (key > -1) {
                loadPanel(getDisplayPanel(key));
            } else {
                loadPanel();
            }
        } catch (SQLException ex) {
            error(ex);
        }
    }

    @Override
    protected final void newEntry() {
        try {
            loadPanel(getEditorPanel(-1));
        } catch (SQLException ex) {
            error(ex);
        }
    }

    @Override
    protected final ListModel<Pair> getListModel() {
        return listModel;
    }

    @Override
    public final void refresh() {
        db.refreshLists(listModel, getComboBoxModel());
    }

    @Override
    protected final void delete(int key) {
        db.deleteEntry(key);
        Swingers.removeItem(listModel, key);
        Swingers.removeItem(getComboBoxModel(), key);
    }
}
