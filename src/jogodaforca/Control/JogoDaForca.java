/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.Control;

/**
 * Classe com os métodos necessários para a execução de uma partida do jogo da forca.
 * @author kieckegard
 */
public interface JogoDaForca
{
    /**
     * Método que realiza uma jogada do jogo da forca recebendo uma letra como parâmetro
     * e verificando se a mesma existe na palavra randomizada da partida, caso exista, retorna true,
     * caso não exista, retorna false.
     * @param letra a letra que você jogou na jogada.
     * @return valor booleano indicando se você acertou a letra jogada.
     */
    boolean jogar(char letra);
    /**
     * Verifica se você venceu o jogo, ou seja, se você acertou todas as letras.
     * @return valor booleano indicando se você ganhou a partida.
     */
    boolean verifyWin();
    /**
     * Verifica se você perdeu a partida, ou seja, se você errou seis vezes.
     * @return valor booleano indicando se você perdeu a partida.
     */
    boolean verifyLose();
    /**
     * Método que pontua o jogador.
     */
    void pontua();
    /**
     * Retorna uma string contendo todos as letras jogadas na partida.
     * @return string contendo letras jogadas.
     */
    String viewTentativas();
    
    /**
     * Método responsável por retornar o resultado da partida seguindo o padrão do jogo
     * da forca. Por exemplo, se randomizou a palavra "Herança", inicialmente o resultado vai ser
     * "-------". Caso você acerte a letra 'a' por exemplo, o método vai retornar a string "---a--a".
     * @return String contendo o resultado da partida.
     */
    String viewResultado();
    
}
