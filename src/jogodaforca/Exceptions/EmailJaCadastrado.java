/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.Exceptions;

/**
 *
 * @author kieckegard
 */
public class EmailJaCadastrado extends Exception
{
    public EmailJaCadastrado()
    {
        super("Já existe um usuário com esse E-mail.");
    }
}
