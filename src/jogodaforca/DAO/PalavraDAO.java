/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jogodaforca.Model.Palavra;

/**
 * Classe responsável pelas operações CRUD de palavras no banco de dados.
 * @author kieckegard
 */
public class PalavraDAO implements DAO<Palavra>
{

    /**
     * Método responsável por persistir uma palavra no banco de dados.
     * @param obj
     * @return valor booleano indicando se a persistência foi realizada com sucesso!
     */
    @Override
    public boolean add(Palavra obj)
    {
        String nome = obj.getNome();
        String dica = obj.getDica();
        String sql = "INSERT INTO PALAVRA VALUES('"+nome+"','"+dica+"')";
        return Conexao.update(sql);
    }

    
    /**
     * Método responsável por remover uma palavra do banco de dados.
     * @param obj
     * @return valor booleano indicando se a remorção por realizada com sucesso.
     */
    @Override
    public boolean remove(Palavra obj)
    {
        String sql = "DELETE FROM PALAVRA WHERE NOME='"+obj.getNome()+"'";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por atualizar os dados da palavra no banco de dados usando o nome da palavra como chave primária.
     * @param obj
     * @return valor booleano indicando se a atualização foi realizada com sucesso.
     */
    @Override
    public boolean update(Palavra obj)
    {
        String nome = obj.getNome();
        String dica = obj.getDica();
        String sql = "UPDATE PALAVRA SET DICA = '"+dica+"' WHERE NOME='"+nome+"' ";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por listar todas palavras persistidas no banco de dados.
     * @return ArrayList contendo todos os administradores cadastrados.
     */
    @Override
    public java.util.List<Palavra> List()
    {
        List<Palavra> palavras = new ArrayList<>();
        String sql = "SELECT * FROM PALAVRA";
        ResultSet rs = Conexao.query(sql);
        try
        {
            while(rs.next())            
            {
                String nome = rs.getString("nome");
                String dica = rs.getString("dica");
                Palavra p = new Palavra(nome,dica);
                palavras.add(p);
            }
            return palavras;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
}
