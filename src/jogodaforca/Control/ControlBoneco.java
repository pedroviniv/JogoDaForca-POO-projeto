package jogodaforca.Control;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Classe responsável pelas imagens do bonequinho do jodo da forca.
 * O atributo vetor de String contêm o diretório de todas as imagens necessárias para o joguinho.
 * @author kieckegard
 */
public class ControlBoneco
{
    private final String[] imagens;
    /**
     * Construtor responsável por instanciar o vetor de String com todos os diretórios
     * das imagens necessárias para o jogo.
     */
    public ControlBoneco()
    { 
        imagens = new String[] 
        {  
            "Imagens/001.png",
            "Imagens/002.png",
            "Imagens/003.png",
            "Imagens/004.png",
            "Imagens/005.png",
            "Imagens/006.png",
            "Imagens/007.png",
        };
    }
    
    /**
     * Método responsável por retornar uma ImageIcon contendo a imagem que será mostrada de acordo com a quantidade de falhas
     * que o jogador cometer enquanto estiver jogando. Caso ele tenha errado 2 vezes, ou seja, não tenha acertado a letra duas vezes
     * o método vai retornar a imagem 2 da posição 2 do vetor, se tiver errado 5 vezes vai mostrar a imagem da posição 5 do vetor.
     * @param "falha", variável inteira indicando a quantidade de erros do jogador.
     * @return instância de ImageIcon contendo a imagem a ser mostrada.
     */
    public ImageIcon getImage(int falha)
    {
        Image image;
        try
        { 
            image = ImageIO.read(new File(imagens[falha]));
            ImageIcon imageIcon = new ImageIcon(image);
            return imageIcon;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
