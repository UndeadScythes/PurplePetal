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
    private static final String version = "Flakware DBMS, v0.400";
    
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
        final JPanel panStatus = new JPanel();
        final JSeparator sep1 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new Font("Times New Roman", 3, 24)); // NOI18N
        title.setText("Purple Petal Nurseries");

        tabs.addTab("Diary", panDiary);
        tabs.addTab("Plants", panPlants);
        tabs.addTab("Suppliers", panSuppliers);
        tabs.addTab("Settings", panSettings);

        labFlakware.setHorizontalAlignment(SwingConstants.RIGHT);
        labFlakware.setText("Flakware DBMS, <version>");

        GroupLayout panStatusLayout = new GroupLayout(panStatus);
        panStatus.setLayout(panStatusLayout);
        panStatusLayout.setHorizontalGroup(panStatusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(sep1)
            .addGroup(panStatusLayout.createSequentialGroup()
                .addComponent(labStatus, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prgProgress, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labFlakware))
        );
        panStatusLayout.setVerticalGroup(panStatusLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panStatusLayout.createSequentialGroup()
                .addComponent(sep1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panStatusLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labFlakware)
                    .addComponent(labStatus, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addComponent(prgProgress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabs, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(panStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
    private final JLabel labStatus = new JLabel();
    private final Diary panDiary = new Diary();
    private final Plants panPlants = new Plants();
    private final Settings panSettings = new Settings();
    private final Suppliers panSuppliers = new Suppliers();
    private final JProgressBar prgProgress = new JProgressBar();
    // End of variables declaration//GEN-END:variables
    private static final Logger LOGGER = Logger.getLogger(PurplePetal.class.getName());
}
