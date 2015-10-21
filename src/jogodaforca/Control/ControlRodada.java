package jogodaforca.Control;

import java.util.ArrayList;
import java.util.List;
import jogodaforca.DAO.JogadorDAO;
import jogodaforca.DAO.PontuaDAO;
import jogodaforca.Model.Jogador;
import jogodaforca.Model.Palavra;

/**
 * Classe responsável pelo controle do jogo da forca em si.
 * Essa classe possui os seguintes atributos:
 * dao: é uma istância da interface 
 * @author kieckegard
 */
public class ControlRodada implements JogoDaForca
{
    private PontuaDAO dao;
    private Jogador jogador;
    private Palavra palavra;
    private final char[] comparavel;
    private final List<Character> tentativas;
    private final char[] resultado;
    private int falhas;
    
    /**
     * O construtor recebe como parâmetro a palavra ja randomizadada e o jogador que vai jogar a partida.
     * Aqui instancia-se um PalavraDAO usando a referência da interface PontuaDAO, dessa forma tendo acesso 
     * apenas ao método que é realmente faz-se necessário nessa classe, o método responsável por atualizar a pontuação 
     * do Jogador no banco quando a partida é finalizada. No construtor também instancia-se os vetores "comparavel" e "resultado" 
     * com o length da palavra randomizada passada por parâmetro, instancia-se também a ArrayList "tentativas" e por fim chama os métodos
     * privados "toResultado()" e "toComparavel()" visíveis apenas a essa classe.
     * @param palavra - instância de Palavra.
     * @param jogador - instância de Jogador.
     */
    public ControlRodada(Palavra palavra, Jogador jogador)
    {
        dao = new JogadorDAO();
        this.jogador = jogador;
        this.palavra = palavra;
        resultado = new char[palavra.getNome().length()];
        comparavel = new char[palavra.getNome().length()];
        tentativas = new ArrayList<>();
        toResultado();
        toComparavel();
    }
    
    /**
     * Método responsável por acompanhar toda a partida e ficar retornando o resultado 
     * atual do jogo, por exemplo, a palavra randomizada foi "Objeto" então o resultado inicial
     * vai ser "------", caso durante a partida você insira a letra 'o' como tentativa, o método
     * vai retornar "O----o" e assim por diante.
     * @return - valor em String.
     */
    @Override
    public String viewResultado()
    {
        String result = "";
        for(int i=0;i<resultado.length;i++)
        {
            result += resultado[i];
        }
        return result;
    }
    
    /**
     * Método responsável por retornar as tentativas de letras na partida,
     * Se você jogou as letras 'a', 'e' e 'd' ele vai retornar "a e d".
     * @return - String contendo as tentativas do jogo.
     */
    @Override
    public String viewTentativas()
    {
        String attempts = "";
        for(Character c : tentativas)
        {
            attempts += " "+c;
        }
        return attempts;
    }
    
    /**
     * Método responsável por transformar o nome randomizado na partida em uma String
     * escondendo os caracteres e mostrando apenas a quantidade de caracteres da mesma
     * separadas por um espaço caso a palavra seja composta.
     * Por exemplo, a palavra randomizada foi "Banco de dados" a conversão será 
     * dessa forma: "----- -- -----".
     */
    private void toResultado()
    {
        String nome = palavra.getNome();
        for(int i=0;i<nome.length();i++)
        {
            if(nome.charAt(i) != ' ')
                resultado[i] = '-';
            else 
                resultado[i] = ' ';
        }
    }
    
    /**
     * Uma vez que não há como você modificar um char específico de uma String sem usar
     * StringBuilder, esse método serve para que a array 'comparavel' pegue todos os chars
     * da palavra randomizada.
     */
    private void toComparavel()
    {
        String nome = palavra.getNome();
        for(int i=0;i<nome.length();i++)
            comparavel[i] = nome.charAt(i);
    }
    
    /**
     * Esse método é responsável por verificar se você acertou a letra passada por parâmetro e atualizar a array 'resultado'
     * de forma que substitua exatamente na mesma posição da array 'comparavel' o char que você acertou pelo char '-'.
     * um atributo cont verifica quantas letras iguais a que você colocou existem na palavra, se você tiver acertado mais que 0 então
     * retornará true, se não, retornará false e incrementará o atributo falhas.
     * @param letra - character da letra que você jogou.
     * @return valor booleano indicando se você acertou pelo menos uma das letras da palavra.
     */
    @Override
    public boolean jogar(char letra)
    {
        tentativas.add(letra);
        String nome = palavra.getNome();
        int acertos = 0;
        
        for(int i=0;i<comparavel.length;i++)
        {
            if(Character.toUpperCase(letra) == Character.toUpperCase(comparavel[i]))
            {
                resultado[i] = comparavel[i];
                comparavel[i] = 0;
                acertos++;
            }
        }
        
        if(acertos > 0)
            return true;
        else
        {
            falhas++;
            return false;
        }
    }
    
    /**
     * Método responsável por verificar se você acertou todas as letras da palavra randomizada.
     * Caso você tenha acertado todas as letras o método pontua() automaticamente é chamado.
     * @return valor booleando indicando se você venceu o jogo.
     */
    @Override
    public boolean verifyWin()
    {
        String nome = palavra.getNome();
        int cont = 0;
        
        for(int i=0;i<resultado.length;i++)
            if(resultado[i] == nome.charAt(i))
                cont++;
        
        if(cont == nome.length())
        {
            pontua();
            return true;
        }
        return false;
    }
    
    /**
     * Método responsável por pontuar o jogador após ele ter ganhado o jogo.
     * Caso ele tenha errado mais de 4 vezes a pontuação default (20) é decrementada pela quantidade
     * de falhas do jogador. Caso o jogador tenha errado menos de 4 vezes, a quantidade de falhas é multiplicada 
     * por 2 e então é decrementada da pontuação default (20).
     */
    @Override
    public void pontua()
    {
        int score = 20;
        if ( falhas > 4 )
        {
            score = score - falhas;
        }
        else
        {
            score = score - (falhas*2);
        }
        jogador.pontua(score);
        dao.updateScore(jogador);
    }
    
    /**
     * Verifica se o jogador perdeu o jogo.
     * O limite de falhas é 6. Errando 6 ou mais o jogador automaticamente perde.
     * @return valor booleano indicando se você perdeu ou não o jogo.
     */
    @Override
    public boolean verifyLose()
    {
        return falhas == 6;
    }
    
    /**
     * Método responsável por retornar a palavra randomizada.
     * @return instância de Palavra.
     */
    public Palavra getPalavra()
    {
        return palavra;
    }
    
    /**
     * Método responsável por retornar sua quantidade de erros.
     * @return valor inteiro referente a quantidade de erros.
     */
    public int getFalhas()
    {
        return falhas;
    }
}
