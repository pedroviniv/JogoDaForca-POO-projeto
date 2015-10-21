package jogodaforca.DAO;

import java.util.List;

/**
 * Interface com operações CRUD de objetos no banco de dados.
 * @author kieckegard
 * @param <T>
 */
public interface DAO<T>
{
    /**
     * escritura de método que irá adicionar objetos no banco de dados.
     * @param obj
     * @return valor booleano indicando se a persistência foi realizada com sucesso.
     */
    boolean add(T obj);
    
    /**
     * escritura de método que irá remover objetos do banco de dados.
     * @param obj
     * @return valor booleano indicando se a remorção foi realizada com sucesso.
     */
    boolean remove(T obj);
    
    /**
     * escritura de método que irá atualizar dados dos objetos persistidos no banco de dados.
     * @param obj
     * @return valor booleano indicando se a atualização dos dados foi realizada com sucesso.
     */
    boolean update(T obj);
    
    /**
     * escritura de método que irá listar todos os objetos persistos no banco e retorná-los em uma lista.
     * @return lista contendo todos os objetos persistidos no banco.
     */
    List<T> List();
}
