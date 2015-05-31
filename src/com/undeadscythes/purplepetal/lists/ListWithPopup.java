package com.undeadscythes.purplepetal.lists;

import com.undeadscythes.purplepetal.keyables.Keyable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JPopupMenu;

/**
 * A list with an associated popup menu.
 * @author UndeadScythes <udscythes@gmail.com>
 * @param <T>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class ListWithPopup<T extends Keyable> extends JList<T> {
    private JPopupMenu menu;
    
    /**
     * Make a new list.
     */
    public ListWithPopup() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                showPopup(evt);
            }
            @Override
            public void mouseReleased(MouseEvent evt) {
                showPopup(evt);
            }
        });
    }
    
    /**
     * Set the menu to popup.
     * @param menu
     */
    public void setMenu(JPopupMenu menu) {
        this.menu = menu;
    }
    
    /**
     * Check and show popup menu.
     * @param evt
     */
    public void showPopup(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            int row = locationToIndex(evt.getPoint());
            if (row < 0 || !getCellBounds(row, row).contains(evt.getPoint())) {
                clearSelection();
            } else {
                setSelectedIndex(row);
            }
            menu.show(this, evt.getX(), evt.getY());
        }
    }
}
