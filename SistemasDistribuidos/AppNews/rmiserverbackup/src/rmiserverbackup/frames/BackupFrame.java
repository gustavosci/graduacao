package rmiserverbackup.frames;

import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import rmicore.Service;
import rmiserverbackup.Backup;

public class BackupFrame extends javax.swing.JFrame {

    private static Service rm;
    private final Backup bkp = new Backup();

    public BackupFrame(Service rm) {
        this.rm = rm;
        initComponents();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_bkp = new javax.swing.JButton();
        btn_restore = new javax.swing.JButton();
        lbl_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Backup de dados");

        btn_bkp.setText("Backup");
        btn_bkp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bkpActionPerformed(evt);
            }
        });

        btn_restore.setText("Restore");
        btn_restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restoreActionPerformed(evt);
            }
        });

        lbl_title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_title.setText("Backup de dados do servidor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_title)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_bkp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_restore, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_bkp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_restore)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_bkpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bkpActionPerformed
        try {
            bkp.doBackupTopics(rm.getAllTopicsAndNews());
            JOptionPane.showMessageDialog(null, "Backup realizado com sucesso!");                
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar os dados existentes: " + ex.getMessage());                
        }
    }//GEN-LAST:event_btn_bkpActionPerformed

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        try {
            rm.restoreTopicsAndNews(bkp.restoreBackup());
            JOptionPane.showMessageDialog(null, "Backup restaurado com sucesso!");                
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao restaurar dados: " + ex.getMessage());                
        }
    }//GEN-LAST:event_btn_restoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bkp;
    private javax.swing.JButton btn_restore;
    private javax.swing.JLabel lbl_title;
    // End of variables declaration//GEN-END:variables
}
