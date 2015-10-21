/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.View;

import javax.swing.JOptionPane;
import jogodaforca.Control.Login;
import jogodaforca.Model.Administrador;
import jogodaforca.Model.Jogador;

/**
 *
 * @author kieckegard
 */
public class FrmLogin extends javax.swing.JFrame
{
    int type;
    Login logged;
    
    public FrmLogin(Login logged, int type)
    {
        initComponents();
        this.type = type;
        this.logged = logged;
        configButton();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        btnCadUsuario = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Usuário:");

        jLabel2.setText("Senha:");

        btnLogin.setText("Logar");
        btnLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginActionPerformed(evt);
            }
        });

        btnCadUsuario.setText("Cadastrar Jogador Novo");
        btnCadUsuario.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCadUsuarioActionPerformed(evt);
            }
        });

        btnBack.setText("Voltar");
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(btnCadUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(txtUsuario)
                    .addComponent(txtSenha)
                    .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadUsuario)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void configButton()
    {
        if(type == 2){
            btnCadUsuario.setText("Cadastrar Administrador novo");
            btnCadUsuario.setEnabled(false);
        }
            
    }
    
    private String passwordToString(char[] password)
    {
        String s_password = "";
        for(char c : password)
            s_password += c;
        return s_password;
    }
    
    private void clean_fields()
    {
        txtUsuario.setText("");
        txtSenha.setText("");
    }
    
    private void close()
    {
        this.dispose();
    }
    
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginActionPerformed
    {//GEN-HEADEREND:event_btnLoginActionPerformed
        String usuario = txtUsuario.getText();
        String senha = passwordToString(txtSenha.getPassword());
        if(type == 1)
        {
            Jogador j = (Jogador)logged.login(usuario, senha);
            if(j != null)
            {
                FrmJogador frmJogador = new FrmJogador(logged);
                frmJogador.setVisible(true);
                clean_fields();
                close();
            }
            else
                JOptionPane.showMessageDialog(this, "Usuário ou Senha incorreta.");
            
        }
        else
        {
            Administrador a = (Administrador)logged.login(usuario, senha);
            if(a != null)
            {
                FrmAdministrador frmAdministrador = new FrmAdministrador(logged);
                frmAdministrador.setVisible(true);
                clean_fields();
                close();
            }
            else
                JOptionPane.showMessageDialog(this, "Usuário ou Senha incorreta."); 
        }
        
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCadUsuarioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCadUsuarioActionPerformed
    {//GEN-HEADEREND:event_btnCadUsuarioActionPerformed
       if(type == 1)
       {
           FrmCadUser janela = new FrmCadUser(1);
           janela.setVisible(true);
       }
       else
       {
           FrmCadUser janela = new FrmCadUser(2);
           janela.setVisible(true);
       }
    }//GEN-LAST:event_btnCadUsuarioActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        this.dispose();
        FrmHome home_window = new FrmHome();
        home_window.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCadUsuario;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
