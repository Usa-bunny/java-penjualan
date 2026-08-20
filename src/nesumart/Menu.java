package nesumart;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Menu extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());

    public Menu() {
        initComponents();
        
        mainPanel.setLayout(new BorderLayout());
        showPanel(new Kasir());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Home = new javax.swing.JMenu();
        kasirMenu = new javax.swing.JMenuItem();
        productMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 813, Short.MAX_VALUE)
        );

        Home.setText("Home");

        kasirMenu.setText("Kasir");
        kasirMenu.addActionListener(this::kasirMenuActionPerformed);
        Home.add(kasirMenu);

        productMenu.setText("Manage Product");
        productMenu.addActionListener(this::productMenuActionPerformed);
        Home.add(productMenu);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(this::exitMenuActionPerformed);
        Home.add(exitMenu);

        jMenuBar1.add(Home);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kasirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirMenuActionPerformed
        showPanel(new Kasir());
    }//GEN-LAST:event_kasirMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed

    private void productMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productMenuActionPerformed
        showPanel(new Product());
    }//GEN-LAST:event_productMenuActionPerformed

    private void showPanel(JPanel panel){
        mainPanel.removeAll();
        mainPanel.add(panel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> new Menu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Home;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem kasirMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem productMenu;
    // End of variables declaration//GEN-END:variables

}
