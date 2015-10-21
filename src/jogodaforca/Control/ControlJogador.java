package jogodaforca.Control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jogodaforca.DAO.JogadorDAO;
import jogodaforca.Model.Jogador;

/**
 *  Classe responsável pelo controle de jogadores do sistema.
 *  A classe possui uma lista de jogadores que contém todos os jogadores cadastrados,
 *  O jogador logado que contêm o jogador que está logado no momento de execução,
 *  e o JogadorDAO que é a classe que tem acesso ao banco de dados.
 * @author kieckegard
 */
public class ControlJogador implements Pesquisavel<Jogador>, Crud<Jogador>, Login<Jogador>
{
    private final List<Jogador> jogadores;
    private Jogador loggedJogador;
    private final JogadorDAO dao;
    
    /**
     * No construtor é instanciado um objeto de JogadorDAO, que vai servir pra fazer alterações no banco,
     * tais como: Persistir um novo jogador, remover um jogador e atualizar os dados de um jogador e também
     * o atributo 'jogadores' recebe uma lista contendo todos os jogadores do banco através do método list() do
     * objeto dao.
     */
    public ControlJogador()
    {
        dao = new JogadorDAO();
        jogadores = dao.List();
    }
    
    /**
     * Método responsável por adicionar um novo jogador à lista de jogadores e persistir esse mesmo jogador no banco de dados através 
     * do método add do objeto dao da classe JogadorDAO.
     * @param jogador - instancia da classe Jogador
     * @return valor booleano indicando se a inserção e a persistência foram efetuadas com sucesso. 
     */
    @Override
    public boolean add(Jogador jogador)
    {
        if(!thatEmailExists(jogador.getEmail()))
            return jogadores.add(jogador) && dao.add(jogador);
        return false;
    }
    
    /**
     * Método responsável por remover um jogador da lista de jogadores e remover também esse mesmo jogador do banco de dados.
     * @param jogador - instancia da classe Jogador
     * @return valor booleano indicando se a remorção tanto da lista quanto do banco foram efetuadas com sucesso. 
     */
    @Override
    public boolean remove(Jogador jogador)
    {
        return jogadores.remove(jogador) && dao.remove(jogador);
    }
    
    /**
     * Método responsável por atualizar os dados do jogador. Detalhe que não precisamos atualizar a lista 'jogadores' 
     * uma vez que os dados do jogador é atualizado pelo método set. Então apenas chamamos o método 'update' do dao para atualizar
     * os dados do jogador persistido no banco.
     * @param jogador - instancia da classe Jogador
     * @return booleano indicando se a atualização dos dados no banco foram efetuadas com sucesso. 
     */
    @Override
    public boolean update(Jogador jogador)
    {
        return dao.update(jogador);
    }
    
    /**
     * Método responsável por retornar um Jogador que contenha o email passado por parâmetro.
     * @param email - valor em String de um email.
     * @return caso haja um jogador com o email passado por parâmetro o método retornará uma instância deste. 
     * Caso contrário, retornará null.
     */
    public Jogador get(String email)
    {
        for(Jogador j : jogadores)
            if(j.getEmail().equals(email))
                return j;
        return null;
    }
    
    /**
     * Método responsável por remover um Jogador que contenha o email passado por parâmetro.
     * Primeiramente ele pega uma instância do jogador com o método get() dessa mesma classe, caso o método retorne um jogador
     * ele chama o método remove() dessa mesma classe passando por parâmetro a instância de jogador obtida.
     * @param email - valor em String de um email.
     * @return valor booleano. Caso a remorção seja efetuada com sucesso, retorna true. Caso contrário, retorna false.
     */
    public boolean remove(String email)
    {
        Jogador j = get(email);
        if(j != null)
            return remove(j);
        return false;
    }

    /**
     * Método responsável por retornar uma lista contendo todos os jogadores cadastrados.
     * @return list de jogadores.
     */
    @Override
    public List<Jogador> list()
    {
        return jogadores;
    }
    /**
     * Método que ordena lista de jogadores através da classe Collections, 
     * vale lembrar que a lista de jogadores dessa classe não é alterada, 
     * o método cria uma outra lista com as mesmas referências de objetos da outra 
     * e então é ordenada.
     * @return - lista contendo os jogadores ordenados.
     */
    @Override
    public List<Jogador> sort()
    {
        List<Jogador> list = new ArrayList<>();
        list.addAll(jogadores);
        Collections.sort(list);
        return list;
    }
    
    /**
     * Método responsável por realizar o login de um jogador.
     * A verificação é feita através do usuario e a senha passados por parâmetro.
     * Através de um foreach o método verífica se algum jogador possui estas credenciais.
     * @param usuario - valor em String do usuario
     * @param senha - valor em String da senha
     * @return - Caso existe um jogador com o usuario e a senha passado por parâmetro, o método retornará uma instância do jogador,
     * caso contrário, retornará null. 
     */
    @Override
    public Jogador login(String usuario, String senha)
    {
        for(Jogador jogador : jogadores)
        {
            if(jogador.getUsuario().equals(usuario) && jogador.getSenha().equals(senha))
            {
                this.loggedJogador = jogador;
                return jogador;
            }
        }
        return null;
    }
    
    /**
     * Verifica se existem jogadores cadastrados no sistema.
     * @return - valor booleano indicando se existem ou não jogadores cadastrados.
     */
    @Override
    public boolean haveUsers()
    {
        return !jogadores.isEmpty();
    }
    
    /**
     * Método responsável por deslogar o jogador setando o atributo loggedJogador como nulo.
     */
    @Override
    public void logoff()
    {
        this.loggedJogador = null;
    }
    
    /**
     * Método responsável por retornar o jogador que está logado no sistema.
     * @return instância de um jogador.
     */
    @Override
    public Jogador getLoggedUser()
    {
        return this.loggedJogador;
    }
    
     /**
     * Método responsável por verificar se o email a ser cadastrado já existe no sistema. 
     * @param email - String contendo email
     * @return valor booleano indicando se o email passado por parâmetro já existe.
     */
    public boolean thatEmailExists(String email)
    {
        for(Jogador j : jogadores)
            if(j.getEmail().equals(email))
                return true;
        return false;
    }
}
