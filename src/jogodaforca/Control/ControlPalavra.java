package jogodaforca.Control;

import java.util.List;
import java.util.Random;
import jogodaforca.DAO.PalavraDAO;
import jogodaforca.Model.Palavra;

/**
 * Classe responsável por operações CRUD da entidade palavra, 
 * tais como, adicionar palavra, remover palavra, atualizar palavra e listar palavra, além de 
 * ter métodos para randomizar palavra, que vai ser necessário durante o jogo.
 * @author kieckegard
 */
public class ControlPalavra implements Crud<Palavra>
{
    private final List<Palavra> palavras;
    private PalavraDAO dao;
    
    /**
     * Como meu projeto tem persistência de dados no banco, então eu
     * preciso de uma instância de PalavraDAO na minha classe ControlPalavras, 
     * uma vez que eu não irei instanciar uma lista vazia, eu irei pegar todas as palavras 
     * que já estiverem persistidas no banco, e por isso, no construtor, eu instancio uma PalavraDAO
     * e minha lista 'palavras', através do método List() de PalavraDAO pega todos os objetos de palavras
     * que estão no banco.
     */
    public ControlPalavra()
    {
        dao = new PalavraDAO();
        palavras = dao.List();
    }
    
    /**
     * Método responsável por procurar e retornar uma palavra que contenha o mesmo nome passado por parâmetro.
     * @param nome String contendo nome da palavra
     * @return Caso encontre a palavra correspondente ao nome, retorna uma instancia dessa palavra. Caso contrário, retorna null.
     */
    public Palavra get(String nome)
    {
        for(Palavra p : palavras)
            if(p.getNome().equals(nome))
                return p;
        return null;
    }
    
    /**
     * Método responsável por verificar se a palavra passada por parâmetro possui um comprimento maior ou igual a 6 caracteres.
     * @param palavra Instância de Palavra
     * @return valor booleano indicando se a palavra passada por parâmetro tem 6 ou mais caracteres.
     */
    private boolean verificaPalavra(Palavra palavra)
    {
        int tamanho = palavra.getNome().length();
        return tamanho >= 6;
    }
    
    /**
     * Método responsável por adicionar palavras tanto na ArrayList quanto persistir no banco de dados.
     * @param palavra instância de Palavra a ser adicionada
     * @return valor booleano indicando se tanto a inserção na lista quanto a persistência no banco foi realizado com sucesso
     */
    @Override
    public boolean add(Palavra palavra)
    {
        if(verificaPalavra(palavra))
            return this.palavras.add(palavra) && dao.add(palavra);
        else
            return false;
    }
    
    /**
     * Método responsável por remover uma palavra tanto da ArrayList quanto do banco de dados.
     * @param palavra instância da Palavra a ser removida
     * @return valor booleano indicando se tanto a remorção da palavra na lista quanto a remorção no banco foi realizado com sucesso
     */
    @Override
    public boolean remove(Palavra palavra)
    {
        return this.palavras.remove(palavra) && dao.remove(palavra);
    }
    
    /**
     * Método responsável por remover a palavra tanto da ArrayList quanto do banco de dados através do nome da mesma.
     * @param nome - String contendo o nome da palavra a ser removida.
     * @return valor booleano indicando se tanto a remorção da palavra na lista quanto a remorção no banco foi realizado com sucesso
     */
    public boolean remove(String nome)
    {
        Palavra p = get(nome);
        if(p != null)
            return remove(p);
        return false;
    }
    
    /**
     * Método responsável por atualizar dados de uma palavra no banco de dados.
     * @param palavra instancia da Palavra a ser atualizada no banco.
     * @return valor booleano indicando se a atualização dos dados da palavra no banco foi realizado com sucesso
     */
    @Override
    public boolean update(Palavra palavra)
    {
        return dao.update(palavra);
    }
    /**
     * Método responsável por retornar todas as palavras cadastradas no sistema.
     * Ele retorna a lista interna da classe.
     * @return ArrayList contendo todas as palavras cadastradas.
     */
    @Override
    public List<Palavra> list()
    {
        return palavras;
    }
    
    /**
     * Randomiza uma palavra dentre as palavras adicionadas e a retorna.
     * @return instancia de uma Palavra aleatória.
     */
    public Palavra randomizePalavra()
    {
        Random r = new Random();
        int index = r.nextInt(palavras.size());
        return palavras.get(index);
    }
    
    /**
     * Método responsável por verificar se existem palavras cadastradas.
     * @return valor booleano indicando se existem palavras cadastras.
     */
    public boolean existemPalavras()
    {
        return !palavras.isEmpty();
    }
}
