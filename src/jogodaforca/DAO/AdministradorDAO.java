/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jogodaforca.Model.Administrador;

/**
 * Classe responsável por operações CRUD da entidade Administrador no Banco de
 * dados.
 *
 * @author kieckegard
 */
public class AdministradorDAO implements DAO<Administrador>
{

    /**
     * Método responsável por persistir um adiministrador no banco de dados.
     *
     * @param obj
     * @return valor booleano indicando se a persistência foi realizada com
     * sucesso!
     */
    @Override
    public boolean add(Administrador obj)
    {
        String usuario = obj.getUsuario();
        String senha = obj.getSenha();
        String nome = obj.getNome();
        String email = obj.getEmail();
        Date dataNascimento = Date.from(obj.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());
        String sql = "INSERT INTO ADMINISTRADOR VALUES('" + nome + "','" + dataNascimento + "','" + email + "','" + usuario + "','" + senha + "')";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por remover um administrador do banco de dados.
     *
     * @param obj
     * @return valor booleano indicando se a remorção por realizada com sucesso.
     */
    @Override
    public boolean remove(Administrador obj)
    {
        //Deleta administrador usando o usuario e a senha como chave primária.
        String sql = "DELETE FROM ADMINISTRADOR WHERE email='" + obj.getEmail() + "'";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por atualizar os dados do administrador no banco de
     * dados usando o Email como chave primária.
     *
     * @param obj
     * @return valor booleano indicando se a atualização foi realizada com
     * sucesso.
     */
    @Override
    public boolean update(Administrador obj)
    {

        String sql = "UPDATE ADMINISTRADOR SET senha='" + obj.getSenha() + "' WHERE email='" + obj.getEmail() + "'";

        return Conexao.update(sql);

    }

    /**
     * Método responsável por listar todos os administradores persistidos no
     * banco de dados.
     *
     * @return ArrayList contendo todos os administradores cadastrados.
     */
    @Override
    public java.util.List<Administrador> List()
    {
        List<Administrador> administradores = new ArrayList<>();
        String sql = "SELECT * FROM ADMINISTRADOR";
        ResultSet rs = Conexao.query(sql);
        try
        {
            while (rs.next())
            {
                String nome = rs.getString("nome");
                Date data = rs.getDate("data_nascimento");
                LocalDate dataNascimento = LocalDate.parse(data.toString());
                String email = rs.getString("email");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                Administrador a = new Administrador(nome, dataNascimento, email, usuario, senha);
                administradores.add(a);
            }
            return administradores;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

}
