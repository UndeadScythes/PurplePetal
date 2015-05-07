package purplepetal;

/**
 * Classifies a diary entry.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
public enum EntryType {
    /**
     * A plant related diary entry.
     */
    PLANT("Plant", "CommonName"),

    /**
     * A product related diary entry.
     */
    PRODUCT("Product", "Name"),

    /**
     * An item related diary entry.
     */
    ITEM("Item", "Name");
    
    private final String table;
    private final String sort;
    
    private EntryType(String table, String sort) {
        this.table = table;
        this.sort = sort;
    }
    
    /**
     * Get the table of objects to which this entry relates.
     * @return
     */
    public String getTable() {
        return table;
    }
    
    /**
     * Get the name of the reference column of this entity.
     * @return
     */
    public String getRef() {
        return table + "REF";
    }
    
    /**
     * Get the name of the identity column of this entity.
     * @return
     */
    public String getId() {
        return table + "ID";
    }
    
    /**
     * Get the column which sorts this table by default.
     * @return
     */
    public String getSort() {
        return sort;
    }
    
    /**
     * Get the diary table that lists this type.
     * @return
     */
    public String getDiary() {
        return table + "Diary";
    }
}
