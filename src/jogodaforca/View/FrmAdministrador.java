/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.View;

import jogodaforca.Control.Login;
import jogodaforca.Model.Administrador;

/**
 *
 * @author kieckegard
 */
public class FrmAdministrador extends javax.swing.JFrame
{
    Administrador currentAdmin;
    Login logged;
    
    public FrmAdministrador(Login logged)
    {
        initComponents();
        this.logged = logged;
        this.currentAdmin = (Administrador)logged.getLoggedUser();
        txtAdminName.setText(currentAdmin.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        txtAdminName = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnCadPalavra = new javax.swing.JMenuItem();
        btnCrudUser = new javax.swing.JMenuItem();
        btnYourAccount = new javax.swing.JMenuItem();
        btnDeslog = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Seja bem vindo!");

        txtAdminName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAdminName.setText("Nome do Administrador");

        jMenu1.setText("Operações");

        btnCadPalavra.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        btnCadPalavra.setText("Palavras");
        btnCadPalavra.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCadPalavraActionPerformed(evt);
            }
        });
        jMenu1.add(btnCadPalavra);

        btnCrudUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.SHIFT_MASK));
        btnCrudUser.setText("Jogadores");
        btnCrudUser.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCrudUserActionPerformed(evt);
            }
        });
        jMenu1.add(btnCrudUser);

        btnYourAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        btnYourAccount.setText("Sua Conta");
        btnYourAccount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnYourAccountActionPerformed(evt);
            }
        });
        jMenu1.add(btnYourAccount);

        btnDeslog.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        btnDeslog.setText("Deslogar");
        btnDeslog.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeslogActionPerformed(evt);
            }
        });
        jMenu1.add(btnDeslog);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAdminName)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(218, 218, 218)
                .addComponent(txtAdminName)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadPalavraActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCadPalavraActionPerformed
    {//GEN-HEADEREND:event_btnCadPalavraActionPerformed
        FrmCadPalavra wordWindow = new FrmCadPalavra(currentAdmin);
        wordWindow.setVisible(true);
    }//GEN-LAST:event_btnCadPalavraActionPerformed

    private void btnYourAccountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnYourAccountActionPerformed
    {//GEN-HEADEREND:event_btnYourAccountActionPerformed
        FrmUserAccount<Administrador> fac = new FrmUserAccount(currentAdmin,this,2);
        fac.setVisible(true);
    }//GEN-LAST:event_btnYourAccountActionPerformed

    private void btnCrudUserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCrudUserActionPerformed
    {//GEN-HEADEREND:event_btnCrudUserActionPerformed
        FrmCrudUser fcu = new FrmCrudUser(currentAdmin);
        fcu.setVisible(true);
    }//GEN-LAST:event_btnCrudUserActionPerformed

    private void btnDeslogActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeslogActionPerformed
    {//GEN-HEADEREND:event_btnDeslogActionPerformed
        logged.logoff();
        this.dispose();
        FrmLogin login = new FrmLogin(logged, 2);
        login.setVisible(true);
    }//GEN-LAST:event_btnDeslogActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCadPalavra;
    private javax.swing.JMenuItem btnCrudUser;
    private javax.swing.JMenuItem btnDeslog;
    private javax.swing.JMenuItem btnYourAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel txtAdminName;
    // End of variables declaration//GEN-END:variables
}
