package jogodaforca.Control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jogodaforca.DAO.AdministradorDAO;
import jogodaforca.Model.Administrador;

/**
 *  Classe responsável pelo controle de Administradores do sistema.
 *  A classe possui uma lista de administradores que contém todos os administradores cadastrados,
 *  O administrador logado que contêm o administrador que está logado no momento de execução,
 *  e o AdministradorDAO que é a classe que tem acesso ao banco de dados.
 * @author kieckegard
 */
public class ControlAdministrador implements Pesquisavel<Administrador>, Crud<Administrador>, Login<Administrador>
{
    /**
     * Atributos da classe,
     * dao é uma referencia a classe AdministradorDAO,
     * administradores é uma lista de administradores cadastrados;
     * loggedAdmin é um objeto de Administrador que guarda a referência do administrador logado
     * 
     */
    private List<Administrador> administradores;
    private Administrador loggedAdmin;
    private AdministradorDAO dao;
    
    /**
     * a lista administradores pega automaticamente os administradores que estiverem persistidos
     * no banco através do método List() de dao.
     */
    public ControlAdministrador()
    {
        dao = new AdministradorDAO();
        administradores = dao.List();
    }
    
    /**
     * 
     * @param administrador
     * método responsável por adicionar um objeto de Administrador na lista de administradores e
     * persistir as informações desse objeto no banco.
     * @return valor booleano indicando se a inserção na lista e a persistencia no banco foram feitas com sucesso! 
     */
    @Override
    public boolean add(Administrador administrador)
    {
        if(!thatEmailExists(administrador.getEmail()))
            return administradores.add(administrador) && dao.add(administrador);
        return false;
    }
    
    /**
     * Método responsável por verificar se o email a ser cadastrado já existe no sistema. 
     * @param email - String contendo email
     * @return valor booleano indicando se o email passado por parâmetro já existe.
     */
    public boolean thatEmailExists(String email)
    {
        for(Administrador a : administradores)
            if(a.getEmail().equals(email))
                return true;
        return false;
    }
    
    /**
     * 
     * Método que retorna um objeto de Administrador de acordo com o usuario e a senha passado por parâmetro.
     * @param usuario
     * @param senha
     * @return Objeto de Administrador 
     */
    public Administrador get(String usuario, String senha)
    {
        for(Administrador administrador : administradores)
            if(administrador.getUsuario().equals(usuario) && administrador.getSenha().equals(senha))
                return administrador;
        return null;
    }
    

    /**
     * Chama método update do objeto dao passando o administrador por parâmetro
     * @param administrador
     * @return valor booleano indicando se a chamada de método foi efetuada com sucesso
     */
    @Override
    public boolean update(Administrador administrador)
    {
        return dao.update(administrador);
    }
    
    /**
     * Método que retorna lista de administradores cadastrados.
     * @return lista de aministradores 
     */
    @Override
    public List<Administrador> list()
    {
        return administradores;
    }
    
    /**
     * Método que ordena lista de administradores através da classe Collections
     * Vale lembrar que a lista interna de administradores dessa classe não é alterada,
     * o método cria uma outra lista com as mesmas referências de objetos da lista interna e então
     * ordena a mesma.
     * @return retorna lista de administradores ordenada.
     */
    @Override
    public List<Administrador> sort()
    {
        List<Administrador> list = new ArrayList<>();
        list.addAll(administradores);
        Collections.sort(list);
        return list;
    }
    
    /**
     * 
     * @param usuario
     * @param senha
     * @return 
     */
    @Override
    public Administrador login(String usuario, String senha)
    {
        for(Administrador a : administradores)
            if(a.getUsuario().equals(usuario) && a.getSenha().equals(senha))
            {
                this.loggedAdmin = a;
                return loggedAdmin;
            }
        return null;
    }
    
    /**
     * método que desloga o administrador.
     * seta o atributo loggedAdmin como null.
     */
    @Override
    public void logoff()
    {
        this.loggedAdmin = null;
    }
    
    /**
     * @return referencia de administrador logado 
     */
    @Override
    public Administrador getLoggedUser()
    {
        return this.loggedAdmin;
    }
    
    /**
     * Verifica se existem administradores cadastrados.
     * @return valor booleano indicando se existem administradores cadastrados.
     */
    @Override
    public boolean haveUsers()
    {
        return !administradores.isEmpty();
    }
    
    @Override
    public boolean remove(Administrador a)
    {
        if(a.equals(loggedAdmin))
            return administradores.remove(a) && dao.remove(a);
        else
            return false;
    }
}