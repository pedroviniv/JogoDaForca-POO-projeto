/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.DAO;

import jogodaforca.Model.Jogador;

/**
 * Interface com responsável por atualizar a pontuação do jogador.
 * @author kieckegard
 */
public interface PontuaDAO
{   
    /**
     * Método responsável por atualizar a pontuação do jogador no banco de dados.
     * @param jogador instancia de um Jogador
     * @return valor booleano indicando se o update foi realizado com sucesso.
     */
    boolean updateScore(Jogador jogador);
}
