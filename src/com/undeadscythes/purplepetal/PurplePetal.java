package com.undeadscythes.purplepetal;

import com.undeadscythes.purplepetal.frames.PurpleFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UndeadScythes <udscythes@gmail.com>
 */
public class PurplePetal {
    private static final Logger LOGGER = Logger.getLogger(PurplePetal.class.getName());

    /**
     * Run application.
     * @param args
     */
    @SuppressWarnings(value = "Convert2Lambda")
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

        PurpleFrame pp = new PurpleFrame("PurplePetal.db");
        //pp.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                pp.setVisible(true);
            }
        });
    }
}
