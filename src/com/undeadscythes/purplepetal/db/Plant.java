package com.undeadscythes.purplepetal.db;

/**
 *
 * @author UndeadScythes <udscythes@gmail.com>
 */
public enum Plant {
    ID("PlantID"),
    NAME("CommonName"),
    LATIN("LatinName"),
    TYPE("TypeREF"),
    LOST("Lost"),
    SUPPLIER("SupplierREF"),
    PRICE("Price"),
    TRAY_SIZE("TraySize"),
    STOCK("Stock");
    
    private final String column;
    
    private Plant(String column) {
        this.column = column;
    }
    
    @Override
    public String toString() {
        return column;
    }
}
