/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.Control;

import jogodaforca.Model.Usuario;

/**
 * Interface responsável pelas operações de login de um objeto.
 * @author kieckegard
 * @param <T>
 */
public interface Login<T extends Usuario>
{
    /**
     * Esse método é responsável por efetuar o login de um usuário,
     * Com o usuario e a senha passado por parâmetro o método vai percorrer 
     * um foreach e procurar um usuário que contenha esses atributos
     * @param usuario - valor String do usuario
     * @param senha - valor String da senha
     * @return Retorna uma referência do usuário que contenha os valores iguais aos passados por parâmetro, caso
     * não encontre, ele retorna null.
     */
    T login(String usuario, String senha);
    
    /**
     * método que desloga o usuário.
     * seta o usuário como nulo.
     */
    void logoff();
    
    /**
     * @return referencia do usuário logado 
     */
    T getLoggedUser();
    
    /**
     * Verifica se existem usuários cadastrados.
     * @return valor booleano indicando se existem administradores cadastrados.
     */
    boolean haveUsers();
}
