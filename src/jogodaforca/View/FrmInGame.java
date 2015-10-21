/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.View;

import java.awt.Color;
import javax.swing.JOptionPane;
import jogodaforca.Control.ControlPalavra;
import jogodaforca.Control.ControlRodada;
import jogodaforca.Model.Jogador;
import jogodaforca.Model.Palavra;
import javax.swing.ImageIcon;
import jogodaforca.Control.ControlBoneco;

/**
 *
 * @author kieckegard
 */
public class FrmInGame extends javax.swing.JFrame
{

    ControlPalavra cp;
    ControlRodada cr;
    Palavra p;
    Jogador jogador;
    FrmJogador janelaJogador;
    ControlBoneco cb;

    public FrmInGame(Jogador j, FrmJogador janelaJogador)
    {
        cb = new ControlBoneco();
        cp = new ControlPalavra();
        initComponents();
        this.janelaJogador = janelaJogador;
        jogador = j;
        p = cp.randomizePalavra();
        cr = new ControlRodada(p, j);
        txtDica.setText(p.getDica());
        load_result();
        JOptionPane.showMessageDialog(null, "A partida começou. A dica da palavra é: " + p.getDica());
        atualizaForca(0);
        jPanelPalavra.setVisible(true);
    }

    private void load_result()
    {
        txtResultado.setText(cr.viewResultado());
        txtTentativas.setText(cr.viewTentativas());
    }

    private void close()
    {
        this.dispose();
    }
    
    
    private void atualizaForca(int falhas)
    {
        
        ImageIcon ia = cb.getImage(falhas);
        jLabelImage.setIcon(ia);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnBack = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        txtChar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDica = new javax.swing.JLabel();
        jPanelPalavra = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtResultado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtTentativas = new javax.swing.JLabel();
        txtLog = new javax.swing.JLabel();
        jLabelImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });

        btnPlay.setText("Jogar");
        btnPlay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPlayActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Dica:");

        txtDica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDica.setForeground(new java.awt.Color(0, 102, 102));
        txtDica.setText("Dica da palavra");

        jPanelPalavra.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Palavra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 204, 0))); // NOI18N

        txtResultado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtResultado.setText("Palavra oculta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(txtResultado)
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtResultado)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tentativas"));

        txtTentativas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTentativas.setForeground(new java.awt.Color(0, 102, 102));
        txtTentativas.setText("Dica da palavra");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTentativas)
                .addGap(72, 72, 72))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtTentativas)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPalavraLayout = new javax.swing.GroupLayout(jPanelPalavra);
        jPanelPalavra.setLayout(jPanelPalavraLayout);
        jPanelPalavraLayout.setHorizontalGroup(
            jPanelPalavraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPalavraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPalavraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelPalavraLayout.setVerticalGroup(
            jPanelPalavraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPalavraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        txtLog.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLog.setText("LOG");

        jLabelImage.setText("BonecoDisplay");
        jLabelImage.setPreferredSize(new java.awt.Dimension(126, 154));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDica))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(txtChar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(52, 52, 52)
                                .addComponent(txtLog)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelPalavra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtDica))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPalavra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(txtChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLog))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPlayActionPerformed
    {//GEN-HEADEREND:event_btnPlayActionPerformed
        if (cr.verifyWin() == false && cr.verifyLose() == false)
        {
            if (txtChar.getText().length() > 1)
            {
                JOptionPane.showMessageDialog(this, "Você só pode inserir letras.");
            }
            else if (txtChar.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Por favor, insira uma letra.");
            }
            else
            {
                if (cr.jogar(txtChar.getText().charAt(0)))
                {
                    txtChar.setText("");
                    txtLog.setForeground(Color.green);
                    txtLog.setText("Você acertou!");
                    load_result();
                    if (cr.verifyWin())
                    {
                        JOptionPane.showMessageDialog(this, "Você venceu! Sua pontuação é: " + jogador.getPontuacao());
                        btnPlay.setEnabled(false);
                        this.janelaJogador.load_janela();
                    }
                }
                else
                {
                    txtLog.setForeground(Color.red);
                    txtLog.setText("Você errou!");
                    atualizaForca(cr.getFalhas());
                    load_result();
                    if (cr.verifyLose())
                    {
                        JOptionPane.showMessageDialog(this, "Você perdeu, a palavra era: "+cr.getPalavra().getNome());
                        btnPlay.setEnabled(false);
                        this.janelaJogador.load_janela();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        this.janelaJogador.load_janela();
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelPalavra;
    private javax.swing.JTextField txtChar;
    private javax.swing.JLabel txtDica;
    private javax.swing.JLabel txtLog;
    private javax.swing.JLabel txtResultado;
    private javax.swing.JLabel txtTentativas;
    // End of variables declaration//GEN-END:variables
}
