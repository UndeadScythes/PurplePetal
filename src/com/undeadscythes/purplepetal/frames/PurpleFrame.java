package com.undeadscythes.purplepetal.frames;

import com.undeadscythes.purplepetal.panels.Diary;
import com.undeadscythes.purplepetal.panels.Settings;
import com.undeadscythes.purplepetal.panels.feedstock.Feedstock;
import com.undeadscythes.purplepetal.panels.plants.Plants;
import com.undeadscythes.purplepetal.panels.products.Products;
import com.undeadscythes.purplepetal.panels.suppliers.Suppliers;
import com.undeadscythes.purplepetal.utilities.DBStep;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Main application window of the Purple Petal DBMS.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class PurpleFrame extends JFrame {
    private static double version = 0;
    
    /**
     * Init components and open db.
     * @param db
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public PurpleFrame(String db) {
        try {
            Class.forName("org.sqlite.JDBC");
            DBStep.setConnection(this, DriverManager.getConnection(String.format("jdbc:sqlite:%s", db)));
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        initComponents();
        fetchVersion();
        tabs.add(new Products(), "Products");
        tabs.add(new Feedstock(), "Feedstock");
        tabs.add(new Plants(), "Plants");
        tabs.add(new Suppliers(), "Suppliers");
        tabs.add(new Diary(), "Diary");
        tabs.add(new Settings(), "Settings");
    }
    
    private void fetchVersion() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(PurpleFrame.class.getResourceAsStream("/resources/version.txt"), "UTF-8"))) {
            version = Double.parseDouble(reader.readLine());
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
        }
        labFlakware.setText(String.format("Flakware DBMS, v%01.3f", version));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        final javax.swing.JLabel title = new javax.swing.JLabel();
        final javax.swing.JPanel panStatus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Purple Petal Nurseries");

        title.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        title.setText("Purple Petal Nurseries");

        labFlakware.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labFlakware.setText("Flakware DBMS, <version>");

        javax.swing.GroupLayout panStatusLayout = new javax.swing.GroupLayout(panStatus);
        panStatus.setLayout(panStatusLayout);
        panStatusLayout.setHorizontalGroup(
            panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(prgProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labFlakware)
                .addGap(11, 11, 11))
        );
        panStatusLayout.setVerticalGroup(
            panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panStatusLayout.createSequentialGroup()
                .addGroup(panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prgProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labFlakware)
                    .addComponent(labStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(panStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Get the version of this instance of PurplePetal.
     * @return
     */
    public static double getVersion() {
        return version;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private final javax.swing.JLabel labFlakware = new javax.swing.JLabel();
    private final javax.swing.JLabel labStatus = new javax.swing.JLabel();
    private final javax.swing.JProgressBar prgProgress = new javax.swing.JProgressBar();
    private final javax.swing.JTabbedPane tabs = new javax.swing.JTabbedPane();
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(PurpleFrame.class.getName());
}
