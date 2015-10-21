package jogodaforca.Model;

import java.time.LocalDate;

/**
 * Classe jogador que extende de Usuário 
 * e implementa a interface Comparable.
 * @author kieckegard
 */
public class Jogador extends Usuario implements Comparable<Jogador>
{
    private int pontuacao;
    
    /**
     * 
     * @param nome
     * @param dataNascimento
     * @param email
     * @param usuario
     * @param senha
     * @param pontuacao 
     */
    public Jogador(String nome, LocalDate dataNascimento, String email, String usuario, String senha,int pontuacao)
    {
        super(nome,dataNascimento,email,usuario,senha);
        this.pontuacao = pontuacao;
    }
    
    /**
     * Soma a pontuação atual do jogador com o valor inteiro passado por parâmetro.
     * @param value valor inteiro contendo a pontuação a ser somada.
     */
    public void pontua(int value)
    {
        this.pontuacao += value;
    }
    
    /**
     * 
     * @return valor inteiro da pontuação atual do jogador
     */
    public int getPontuacao()
    {
        return pontuacao;
    }
    
    @Override
    public String toString()
    {
        return super.toString()+" |Pontuação: "+pontuacao;
    }

    /**
     * Sobrescrita do método compareTo da interface Comparable,
     * definindo que os jogadores serão comparados pela pontuação.
     * @param jogador
     * @return 
     */
    @Override
    public int compareTo(Jogador jogador)
    {
        return jogador.getPontuacao() - this.pontuacao;
    }
}
