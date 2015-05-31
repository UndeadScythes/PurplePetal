package com.undeadscythes.purplepetal.renderers;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * For highlighting cells in a table.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class TableCellRenderer extends DefaultTableCellRenderer {
    /**
     * Cells whose font color should be dim.
     */
    public final ArrayList<Integer> dimmed = new ArrayList<>(31);

    /**
     * Cells whos font should be bold.
     */
    public final ArrayList<Integer> marked = new ArrayList<>(31);
    private int selected = -1;
    private final int cols;
    
    /**
     * Set the number of columns in the table.
     * @param cols
     */
    public TableCellRenderer(int cols) {
        super();
        this.cols = cols;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int coord = row * cols + column;
        if (coord == selected) {
            cell.setBackground(Color.PINK);
        } else {
            cell.setBackground(Color.WHITE);
        }
        if (marked.contains(coord)) {
            cell.setForeground(Color.RED);
        } else if (dimmed.contains(coord)) {
            cell.setForeground(Color.LIGHT_GRAY);
        } else {
            cell.setForeground(Color.BLACK);
        }
        return cell;
    }
    
    /**
     * Set the selected cell.
     * @param row
     * @param col
     */
    public void setCell(int row, int col) {
        selected = row * cols + col;
    }
}
