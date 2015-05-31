package com.undeadscythes.purplepetal.panels.plants;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.panels.KeyedPurplePanel;
import com.undeadscythes.purplepetal.panels.PurpleAccessPanel;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * Allows editing of plants in the database.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Plants extends PurpleAccessPanel {
    private final DefaultListModel<Pair> plantsListModel = new DefaultListModel<>();
    
    /**
     * Initialise components.
     */
    public Plants() {
        super(PlantPanel.PLANT_PARAMS);
        activateComponents();
        refresh();
        updatePlantTypesCombo();
    }

    @Override
    protected KeyedPurplePanel getDisplayPanel(int key) throws SQLException {
        return new PlantDisplay(key);
    }

    @Override
    protected KeyedPurplePanel getEditorPanel(int key) throws SQLException {
        return new PlantEditor(this);
    }

    @Override
    protected DefaultComboBoxModel<Pair> getComboBoxModel() {
        return plantsCombo;
    }
}
