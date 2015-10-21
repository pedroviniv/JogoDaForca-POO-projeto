/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.Control;

/**
 * Classe responsável por retornar as instâncias dos controladores seguindo
 * o padrão Singleton, o que garante que nunca precisaremos instanciar um novo 
 * controlador e também que o mesmo nunca será nulo.
 * Vale lembrar que todos os métodos são estáticos, logo, não se faz necessário
 * a istância de um objeto dessa classe, uma vez que os métodos podem ser acessados
 * diretamente da classe.
 * @author kieckegard
 */
public class ControlMain
{
    private static  ControlAdministrador controlAdministrador; 
    private static  ControlJogador controlJogador;
    private static  ControlPalavra controlPalavra;

    
    /**
     * Método responsável por retornar instância do Controlador de Adminsitradores.
     * @return instância de ControlAdministrador
     */
    public static ControlAdministrador getControlAdministrador()
    {
        if(controlAdministrador == null)
            controlAdministrador = new ControlAdministrador();
        return controlAdministrador;
    }

    /**
     * Método responsável por retornar instância do Controlador de Jogadores.
     * @return instância de ControlJogador
     */
    public static ControlJogador getControlJogador()
    {
        if(controlJogador == null)
            controlJogador = new ControlJogador();
        return controlJogador;
    }

    /**
     * Método responsável por retornar instância do Controlador de Palavras.
     * @return instância de ControlPalavra
     */
    public static ControlPalavra getControlPalavra()
    {
        if(controlPalavra == null)
            controlPalavra = new ControlPalavra();
        return controlPalavra;
    }
}