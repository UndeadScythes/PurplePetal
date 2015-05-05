package purplepetal;

import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * Add and edit items.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Items extends PurplePanel {

    /**
     * Creates new form Items
     */
    public Items() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSplitPane spl1 = new JSplitPane();
        JPanel panItems = new JPanel();
        JPanel panDetails = new JPanel();

        spl1.setDividerLocation(250);

        GroupLayout panItemsLayout = new GroupLayout(panItems);
        panItems.setLayout(panItemsLayout);
        panItemsLayout.setHorizontalGroup(panItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );
        panItemsLayout.setVerticalGroup(panItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        spl1.setLeftComponent(panItems);

        GroupLayout panDetailsLayout = new GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );
        panDetailsLayout.setVerticalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        spl1.setRightComponent(panDetails);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Items.class.getName());
}
