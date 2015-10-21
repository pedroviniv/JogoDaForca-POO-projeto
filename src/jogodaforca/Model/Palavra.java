/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.Model;

/**
 * Classe palavra contendo
 * nome da palavra (nome) e a dica da palavra (dica)
 * @author kieckegard
 */
public class Palavra 
{
    private String nome;
    private String dica;
    
    /**
     * 
     * @param nome
     * @param dica 
     */
    public Palavra(String nome, String dica)
    {
        this.nome = nome;
        this.dica = dica;
    }
    
    /**
     * @return String contendo o nome da palavra 
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     * 
     * @return String contendo a dica da palavra 
     */
    public String getDica()
    {
        return dica;
    }
    
    /**
     * Muda a dica da palavra pela nova dica passada por parâmetro.
     * @param dica String contendo a dica da palavra 
     */
    public void setDica(String dica)
    {
        this.dica = dica;
    }
    
    @Override
    public String toString()
    {
        return "|Nome: "+nome+" |Dica: "+dica;
    }
}
