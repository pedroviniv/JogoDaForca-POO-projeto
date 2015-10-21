/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.Control;

import java.util.List;

/**
 * Interface que terá métodos apenas para listar objetos e ordená-los.
 * @author kieckegard
 * @param <T>
 */
public interface Pesquisavel<T>
{
    /**
     * Método que retorna uma lista de objetos.
     * @return lista de objetos.
     */
    List<T> list();
    /**
     * Método que retorna uma lista ordenada de objetos.
     * @return lista ordenada de objetos.
     */
    List<T> sort();
}
