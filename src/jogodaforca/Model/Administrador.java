package jogodaforca.Model;

import java.time.LocalDate;
import jogodaforca.Control.ControlJogador;
import jogodaforca.Control.ControlPalavra;

/**
 * Classe Administrador que extende de Usuario e também
 * implementa Comparable.
 * @author kieckegard
 */
public class Administrador extends Usuario implements Comparable<Administrador>
{
    /**
     * 
     * @param nome
     * @param dataNascimento
     * @param email
     * @param usuario
     * @param senha 
     */
    public Administrador(String nome, LocalDate dataNascimento, String email, String usuario, String senha)
    {
        super(nome,dataNascimento,email,usuario,senha);
    }
    
    /**
     * Médoto que adiciona palavra através do ControlPalavra e da Palavra passados por parâmetro.
     * Chama o método add do ControlPalavra passando a palavra por parâmetro.
     * @param controlPalavra
     * @param palavra
     * @return valor booleano indicando se a adição da palavra foi realizada com sucesso.
     */
    public boolean addPalavra(ControlPalavra controlPalavra, Palavra palavra)
    {
        return controlPalavra.add(palavra);
    }
    
    /**
     * Método responsável por remover a palavra passada por parâmetro através do ControlPalavra.
     * É chamado o método remove() de controlPalavra passando a palavra por parâmetro e assim removendo-a.
     * @param controlPalavra
     * @param palavra
     * @return valor booleano indicando se a remorção foi feita com sucesso.
     */
    public boolean removePalavra(ControlPalavra controlPalavra, Palavra palavra)
    {
        return controlPalavra.remove(palavra);
    }
    
    /**
     * Método responsável por atualizar a palavra passada por parâmetro através do ControlPalavra.
     * É chamado o método update() de controlPalavra passando a palavra por parâmetro e assim atualizando-a.
     * @param controlPalavra
     * @param palavra
     * @return valor booleano indicando se a atualização da palavra foi feita com sucesso.
     */
    public boolean atualizaPalavra(ControlPalavra controlPalavra, Palavra palavra)
    {
        return controlPalavra.update(palavra);
    }
    
    /**
     * Método responsável por remover o jogador passado por parâmetro através do ControlJogador
     * É chamado o método remove() de controlJogador passando o jogador por parâmetro.
     * @param controlJogador
     * @param jogador
     * @return valor booleano indicando se a remorção do jogador foi feita com sucesso.
     */
    public boolean removeUser(ControlJogador controlJogador, Jogador jogador)
    {
       return controlJogador.remove(jogador);
    }
    
    /**
     * Método da interface Comparable sendo sobrescrito, assim definindo que
     * os administradores serão comparados pela idade.
     * @param administrador
     * @return 
     */
    @Override
    public int compareTo(Administrador administrador)
    {
        return super.getIdade() - administrador.getIdade();
    }
}
