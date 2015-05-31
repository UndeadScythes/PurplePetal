package com.undeadscythes.purplepetal.panels.products;

import com.undeadscythes.purplepetal.keyables.typedpart.PartType;

/**
 * Part of a product.
 * @author UndeadScythes <udscythes@gmail.com>
 */
public enum ProductPartType implements PartType {
    /**
     * A plant.
     */
    PLANT("Plant", "CommonName", "TraySize"),

    /**
     * Some feedstock.
     */
    FEEDSTOCK("Feedstock", "Name", "PackSize");
    
    /**
     * The table containing the part.
     */
    public final String table;

    /**
     * The main name of the part.
     */
    public final String name;

    /**
     * The volume in which the part is measured.
     */
    public final String volume;
    
    private ProductPartType(String table, String name, String volume) {
        this.table = table;
        this.name = name;
        this.volume = volume;
    }
    
    private static final String FORMAT = "SELECT %s, %s, Quantity, Price, %s FROM %s JOIN %s ON %s=%s WHERE ProductREF=%d;";
    
    /**
     *
     * @param id
     * @return
     */
    public String getQuery(int id) {
        return String.format(FORMAT, getRef(), name, volume, getTableConnection(), table, getRef(), getID(), id);
    }
    
    /**
     * The string pointing to a REF.
     * @return
     */
    public String getRef() {
        return table + "REF";
    }
    
    /**
     * The sting of the connecting table.
     * @return
     */
    public String getTableConnection() {
        return "Product_" + table;
    }
    
    /**
     * String pointing to an ID.
     * @return
     */
    public String getID() {
        return table + "ID";
    }
}
