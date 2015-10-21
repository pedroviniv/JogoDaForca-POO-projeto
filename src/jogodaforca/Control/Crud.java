/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.Control;

import java.util.List;

/**
 * Interface responsável pelas operações de CRUD de um objeto qualquer.
 * @author kieckegard
 * @param <T>
 */
public interface Crud<T>
{
    /**
     * Método que responsável por retornar List contendo objetos.
     * @return List de Objetos.
     */
    List<T> list();
    /**
     * Método responsável por adicionar um objeto à uma lista.
     * @param obj instância de um Objeto
     * @return valor booleano indicando se a inserção foi realizada com sucesso.
     */
    boolean add(T obj);
    /**
     * Método responsável por remover um objeto de uma lista.
     * @param obj instância de um objeto.
     * @return valor booleano indicando se a remorção do objeto foi realizada com sucesso.
     */
    boolean remove(T obj);
    /**
     * Método responsável por atualizar os dados de um objeto qualquer no banco de dados.
     * @param obj instância de um objeto.
     * @return valor booleano indicando se a atualização dos dados foi realizada com sucesso.
     */
    boolean update(T obj);
}
