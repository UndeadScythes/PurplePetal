package purplepetal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import purplepetal.panel.PurplePanel;

/**
 * Main application window of the Purple Petal DBMS.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class PurplePetal extends JFrame {
    private static double version = 0;
    
    /**
     * Initialise components.
     */
    public PurplePetal() {
        initComponents();
        try {
            version = Double.parseDouble(new BufferedReader(new InputStreamReader(PurplePetal.class.getResourceAsStream("/resources/version.txt"))).readLine());
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
        }
        labFlakware.setText(String.format("Flakware DBMS, v%01.3f", version));
        if (PurplePanel.UPDATE) {
            double newVersion = panSettings.checkUpdates();
            if (newVersion > 0) {
                panSettings.updatePrompt(newVersion);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        final javax.swing.JLabel title = new javax.swing.JLabel();
        final javax.swing.JTabbedPane tabs = new javax.swing.JTabbedPane();
        final purplepetal.panel.tab.Diary panDiary = new purplepetal.panel.tab.Diary();
        final purplepetal.panel.tab.Products panProducts = new purplepetal.panel.tab.Products();
        final purplepetal.panel.tab.Plants panPlants = new purplepetal.panel.tab.Plants();
        final purplepetal.panel.tab.Items panItems = new purplepetal.panel.tab.Items();
        final purplepetal.panel.tab.Suppliers panSuppliers = new purplepetal.panel.tab.Suppliers();
        final javax.swing.JPanel panStatus = new javax.swing.JPanel();
        final javax.swing.JSeparator sep1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Purple Petal Nurseries");

        title.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        title.setText("Purple Petal Nurseries");

        tabs.addTab("Diary", panDiary);
        tabs.addTab("Products", panProducts);
        tabs.addTab("Plants", panPlants);
        tabs.addTab("Items", panItems);
        tabs.addTab("Suppliers", panSuppliers);
        tabs.addTab("Settings", panSettings);

        labFlakware.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labFlakware.setText("Flakware DBMS, <version>");

        javax.swing.GroupLayout panStatusLayout = new javax.swing.GroupLayout(panStatus);
        panStatus.setLayout(panStatusLayout);
        panStatusLayout.setHorizontalGroup(
            panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panStatusLayout.createSequentialGroup()
                .addComponent(labStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prgProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labFlakware))
            .addComponent(sep1)
        );
        panStatusLayout.setVerticalGroup(
            panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panStatusLayout.createSequentialGroup()
                .addComponent(sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(prgProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labFlakware, javax.swing.GroupLayout.Alignment.TRAILING)))
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
                .addComponent(tabs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Run application.
     * @param args
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            Class.forName("org.sqlite.JDBC");
            PurplePanel.setConnection(DriverManager.getConnection("jdbc:sqlite:PurplePetal.db"));
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PurplePetal().setVisible(true);
            }
        });
    }
    
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
    private final purplepetal.panel.tab.Settings panSettings = new purplepetal.panel.tab.Settings();
    private final javax.swing.JProgressBar prgProgress = new javax.swing.JProgressBar();
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(PurplePetal.class.getName());
}
