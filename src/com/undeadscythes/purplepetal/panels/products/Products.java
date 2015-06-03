package com.undeadscythes.purplepetal.panels.products;

import com.undeadscythes.purplepetal.keyables.Pair;
import com.undeadscythes.purplepetal.panels.KeyedPurplePanel;
import com.undeadscythes.purplepetal.panels.PurpleAccessPanel;
import com.undeadscythes.purplepetal.utilities.DBStep;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * Assemble products for show and sale.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class Products extends PurpleAccessPanel {
    private final DefaultListModel<Pair> mdlProducts = new DefaultListModel<>();
    
    /**
     * Creates new form Products
     */
    public Products() {
        super(ProductPanel.PRODUCT_PARAMS);
        activateComponents();
        refresh();
        try {
            calcTotals();
        } catch (SQLException ex) {
            error(ex);
        }
    }
    
    /**
     * Calculate and update totals.
     * @throws java.sql.SQLException
     */
    public final void calcTotals() throws SQLException {
        String query = "SELECT SUM(Profit * Target) AS Total FROM Product;";
        ResultSet rs = DBStep.executeQuery(query);
        if (rs.next()) {
            setFooter(String.format("Grand total: £%.02f", rs.getFloat("Total")));
        }
    }

    @Override
    protected KeyedPurplePanel getDisplayPanel(int key) throws SQLException {
        return new ProductDisplay(this, key);
    }

    @Override
    protected KeyedPurplePanel getEditorPanel(int key) throws SQLException {
        return new ProductEditor(this, key);
    }

    @Override
    protected DefaultComboBoxModel<Pair> getComboBoxModel() {
        return productsCombo;
    }
}
