package jogodaforca.Model;

import java.time.LocalDate;

/**
 * Classe abstrata usuário que herda de pessoa,
 * tem atributo usuario e senha.
 * @author kieckegard
 */
public abstract class Usuario extends Pessoa
{
    private final String usuario;
    private String senha;
    
    /**
     * herda construtor de Pessoa e recebe novos valores de usuario e senha.
     * @param nome
     * @param dataNascimento
     * @param email
     * @param usuario
     * @param senha 
     */
    public Usuario(String nome, LocalDate dataNascimento, String email, String usuario, String senha)
    {
        super(nome,dataNascimento,email);
        this.usuario = usuario;
        this.senha = senha;
    }
    
    /**
     * @return String contendo o usuario.
     */
    public String getUsuario()
    {
        return usuario;
    }

    /**
     * 
     * @return String contendo a senha. 
     */
    public String getSenha()
    {
        return senha;
    }

    /**
     * Modifica a senha do usuario pela nova senha passada por parametro.
     * @param senha String contendo a senha
     */
    public void setSenha(String senha)
    {
        this.senha = senha;
    }
    
    /**
     * Método responsável por verificar se o usuario e a senha passados por parâmetros são
     * iguais ao usuario e senha desse objeto.
     * @param usuario String contendo o usuario
     * @param senha string contendo a senha
     * @return valor booleano indicando se os dados são ou não iguais.
     */
    public boolean autentication(String usuario, String senha)
    {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }
  
    @Override
    public String toString()
    {
        return super.toString()+" |Usuário: "+usuario;
    }
    
    
}
