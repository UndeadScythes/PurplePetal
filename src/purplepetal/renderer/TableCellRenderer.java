package purplepetal.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * For highlighting cells in a table.
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class TableCellRenderer extends DefaultTableCellRenderer {
    private static final Logger LOGGER = Logger.getLogger(TableCellRenderer.class.getName());
    
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
        if (dimmed.contains(coord)) {
            cell.setForeground(Color.LIGHT_GRAY);
        } else {
            cell.setForeground(Color.BLACK);
        }
        if (marked.contains(coord)) {
            cell.setFont(cell.getFont().deriveFont(Collections.singletonMap(TextAttribute.WEIGHT, TextAttribute.WEIGHT_ULTRABOLD)));
        } else {
            cell.setFont(cell.getFont().deriveFont(Collections.singletonMap(TextAttribute.WEIGHT, TextAttribute.WEIGHT_REGULAR)));
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
