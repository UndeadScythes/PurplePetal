package com.undeadscythes.purplepetal.panels;

import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 * A root pane for content switching.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings({"serial", "ClassWithoutLogger"})
public class PurpleRoot extends JRootPane {
    /**
     * Clear the contents of the panel.
     */
    public void clear() {
        setContentPane(new JPanel());
    }
}
