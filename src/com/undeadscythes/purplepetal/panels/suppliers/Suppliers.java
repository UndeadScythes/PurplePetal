package com.undeadscythes.purplepetal.panels.suppliers;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.panels.KeyedPurplePanel;
import com.undeadscythes.purplepetal.panels.PurpleAccessPanel;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * Panel containing methods to modify suppliers.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Suppliers extends PurpleAccessPanel {
    private final DefaultListModel<Pair> mdlSuppliers = new DefaultListModel<>();

    /**
     * Initialise panel components.
     */
    public Suppliers() {
        super(SupplierPanel.SUPPLIER_PARAMS);
        activateComponents();
        refresh();
    }

    @Override
    protected KeyedPurplePanel getDisplayPanel(int key) throws SQLException {
        return new SupplierDisplay(key);
    }

    @Override
    protected KeyedPurplePanel getEditorPanel(int key) throws SQLException {
        return new SupplierEditor(this, key);
    }

    @Override
    protected DefaultComboBoxModel<Pair> getComboBoxModel() {
        return suppliersCombo;
    }
}
