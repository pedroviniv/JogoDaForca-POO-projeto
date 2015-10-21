/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jogodaforca.Control.ControlMain;
import jogodaforca.Control.Login;

/**
 *
 * @author kieckegard
 */
public class FrmHome extends javax.swing.JFrame
{
    
    Login login_jogador = ControlMain.getControlJogador();
    Login login_admin = ControlMain.getControlAdministrador();
    
    public FrmHome()
    {
        lookandfell();
        initComponents();
    }
    
    private void lookandfell()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(FrmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    private void close()
    {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jProgressBar1 = new javax.swing.JProgressBar();
        btnAdmin = new javax.swing.JButton();
        btnJogador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdmin.setText("Administrador");
        btnAdmin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAdminActionPerformed(evt);
            }
        });

        btnJogador.setText("Jogador");
        btnJogador.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnJogadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJogadorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnJogadorActionPerformed
    {//GEN-HEADEREND:event_btnJogadorActionPerformed
        if(login_jogador.haveUsers())
        {
            //abre login
            FrmLogin login = new FrmLogin(login_jogador,1);
            login.setVisible(true);
            close();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Não há jogadores cadastrados ainda.");
            if (JOptionPane.showConfirmDialog(null, "Você deseja cadastrar um novo Jogador?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                FrmCadUser cadWindows = new FrmCadUser(1);
                cadWindows.setVisible(true);
            } 
        }
    }//GEN-LAST:event_btnJogadorActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAdminActionPerformed
    {//GEN-HEADEREND:event_btnAdminActionPerformed
        if(login_admin.haveUsers())
        {
            //abre login
            FrmLogin login = new FrmLogin(login_admin,2);
            login.setVisible(true);
            close();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Não há administradores cadastrados ainda.");
            if (JOptionPane.showConfirmDialog(null, "Você deseja cadastrar um novo Administrador?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                FrmCadUser cadWindows = new FrmCadUser(2);
                cadWindows.setVisible(true);
            } 
        }
    }//GEN-LAST:event_btnAdminActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnJogador;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
