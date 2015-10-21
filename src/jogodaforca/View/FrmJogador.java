/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.View;

import javax.swing.JOptionPane;
import jogodaforca.Control.ControlMain;
import jogodaforca.Control.Login;
import jogodaforca.Model.Jogador;

/**
 *
 * @author kieckegard
 */
public class FrmJogador extends javax.swing.JFrame
{
    Jogador currentPlayer;
    Login logged;
    
    public FrmJogador(Login logged)
    {
        initComponents();
        this.logged = logged;
        this.currentPlayer = (Jogador)logged.getLoggedUser();
        txtPlayerName.setText(currentPlayer.getNome());
        txtScore.setText(String.valueOf(currentPlayer.getPontuacao()));
    }
    
    public void load_janela()
    {
        txtScore.setText(String.valueOf(currentPlayer.getPontuacao()));
        txtPlayerName.setText(currentPlayer.getNome());
    }
    
    private boolean verificaPalavras()
    {
        
        return ControlMain.getControlPalavra().existemPalavras();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        txtPlayerName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtScore = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnStartGame = new javax.swing.JMenuItem();
        btnSeeRanking = new javax.swing.JMenuItem();
        btnMyAccount = new javax.swing.JMenuItem();
        btnLogoff = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Seja bem vindo!");

        txtPlayerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPlayerName.setText("Nome do Jogador");

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        txtScore.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtScore.setForeground(new java.awt.Color(0, 255, 51));
        txtScore.setText("00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Score");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtScore))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(txtScore)
                .addGap(24, 24, 24))
        );

        jMenu1.setText("Ações");

        btnStartGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.SHIFT_MASK));
        btnStartGame.setText("Jogar");
        btnStartGame.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnStartGameActionPerformed(evt);
            }
        });
        jMenu1.add(btnStartGame);

        btnSeeRanking.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        btnSeeRanking.setText("Ver Ranking");
        btnSeeRanking.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSeeRankingActionPerformed(evt);
            }
        });
        jMenu1.add(btnSeeRanking);

        btnMyAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        btnMyAccount.setText("Sua Conta");
        btnMyAccount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnMyAccountActionPerformed(evt);
            }
        });
        jMenu1.add(btnMyAccount);

        btnLogoff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        btnLogoff.setText("Deslogar");
        btnLogoff.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLogoffActionPerformed(evt);
            }
        });
        jMenu1.add(btnLogoff);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtPlayerName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(txtPlayerName)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeeRankingActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSeeRankingActionPerformed
    {//GEN-HEADEREND:event_btnSeeRankingActionPerformed
        FrmRanking frmRanking = new FrmRanking();
        frmRanking.setVisible(true);
    }//GEN-LAST:event_btnSeeRankingActionPerformed

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStartGameActionPerformed
    {//GEN-HEADEREND:event_btnStartGameActionPerformed
        if(verificaPalavras())
        {
            FrmInGame frmInGame = new FrmInGame(currentPlayer,this);
            frmInGame.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(this, "Não existem palavras cadastradas.");
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLogoffActionPerformed
    {//GEN-HEADEREND:event_btnLogoffActionPerformed
        logged.logoff();
        this.dispose();
        FrmLogin login = new FrmLogin(logged, 1);
        login.setVisible(true);
    }//GEN-LAST:event_btnLogoffActionPerformed

    private void btnMyAccountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnMyAccountActionPerformed
    {//GEN-HEADEREND:event_btnMyAccountActionPerformed
        FrmUserAccount<Jogador> fca = new FrmUserAccount(currentPlayer,this,1);
        fca.setVisible(true);
    }//GEN-LAST:event_btnMyAccountActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnLogoff;
    private javax.swing.JMenuItem btnMyAccount;
    private javax.swing.JMenuItem btnSeeRanking;
    private javax.swing.JMenuItem btnStartGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtPlayerName;
    private javax.swing.JLabel txtScore;
    // End of variables declaration//GEN-END:variables
}
