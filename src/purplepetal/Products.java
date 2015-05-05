package purplepetal;

import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * Assemble products for show and sale.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class Products extends PurplePanel {

    /**
     * Creates new form Products
     */
    public Products() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSplitPane spl1 = new JSplitPane();
        JPanel panProducts = new JPanel();
        JPanel panDetails = new JPanel();

        spl1.setDividerLocation(250);

        GroupLayout panProductsLayout = new GroupLayout(panProducts);
        panProducts.setLayout(panProductsLayout);
        panProductsLayout.setHorizontalGroup(panProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panProductsLayout.setVerticalGroup(panProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        spl1.setLeftComponent(panProducts);

        GroupLayout panDetailsLayout = new GroupLayout(panDetails);
        panDetails.setLayout(panDetailsLayout);
        panDetailsLayout.setHorizontalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );
        panDetailsLayout.setVerticalGroup(panDetailsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        spl1.setRightComponent(panDetails);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(spl1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(spl1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(Products.class.getName());
}
