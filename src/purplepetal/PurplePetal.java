package purplepetal;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*; // NB code

/**
 * Main application window of the Purple Petal DBMS.
 * 
 * @author UndeadScythes <udscythes@gmail.com>
 */
@SuppressWarnings("serial")
public class PurplePetal extends JFrame {
    private static final String version = "Flakware DBMS, v0.300";
    
    /**
     * Initialise components.
     */
    public PurplePetal() {
        initComponents();
        labFlakware.setText(version);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        final JLabel title = new JLabel();
        final JTabbedPane tabs = new JTabbedPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new Font("Times New Roman", 3, 24)); // NOI18N
        title.setText("Purple Petal Nurseries");

        tabs.addTab("Diary", panDiary);
        tabs.addTab("Plants", panPlants);
        tabs.addTab("Suppliers", panSuppliers);
        tabs.addTab("Settings", panSettings);

        labFlakware.setHorizontalAlignment(SwingConstants.RIGHT);
        labFlakware.setText("Flakware DBMS, <version>");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tabs, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labFlakware))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labFlakware, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private final JLabel labFlakware = new JLabel();
    private final Diary panDiary = new Diary();
    private final Plants panPlants = new Plants();
    private final Settings panSettings = new Settings();
    private final Suppliers panSuppliers = new Suppliers();
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(PurplePetal.class.getName());
}
