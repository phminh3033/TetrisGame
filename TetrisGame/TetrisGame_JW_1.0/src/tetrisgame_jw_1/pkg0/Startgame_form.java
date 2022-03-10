package tetrisgame_jw_1.pkg0;

import javax.swing.JOptionPane;

public class Startgame_form extends javax.swing.JFrame {

    public Startgame_form() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_startgame = new javax.swing.JButton();
        b_leaderboard = new javax.swing.JButton();
        b_quit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TETRIS GAME!!!");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        b_startgame.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b_startgame.setText("Start Game");
        b_startgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_startgameActionPerformed(evt);
            }
        });

        b_leaderboard.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b_leaderboard.setText("Leaderboard");
        b_leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_leaderboardActionPerformed(evt);
            }
        });

        b_quit.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b_quit.setText("Quit");
        b_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_quitActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tetrislogo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(b_startgame)
                    .addComponent(b_leaderboard)
                    .addComponent(b_quit))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(b_startgame)
                .addGap(18, 18, 18)
                .addComponent(b_leaderboard)
                .addGap(18, 18, 18)
                .addComponent(b_quit)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_startgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_startgameActionPerformed
        this.setVisible(false);
        TetrisGame_JW_10.start();
    }//GEN-LAST:event_b_startgameActionPerformed

    private void b_leaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_leaderboardActionPerformed
        this.setVisible(false);
        TetrisGame_JW_10.showLeaderboard();
    }//GEN-LAST:event_b_leaderboardActionPerformed

    private void b_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_quitActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you sure you want to exit?", "⚠Warning!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        else this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_b_quitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "Do you sure you want to exit?", "⚠Warning!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        else this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Startgame_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Startgame_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Startgame_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Startgame_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Startgame_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_leaderboard;
    private javax.swing.JButton b_quit;
    private javax.swing.JButton b_startgame;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
