package jogodaforca.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe responsável por realizar a conexão com o banco de dados, contendo os
 * métodos para realizar update e retornar busca no banco.
 *
 * @author kieckegard
 */
public class Conexao
{

    public static String url = "jdbc:postgresql://localhost:5432/JogoDaForca";
    public static String usuario = "postgres";
    public static String senha = "123456";
    public static Connection con;
    public static Statement stm;

    public Conexao()
    {

    }

    /**
     * Método que realiza a conexão com o banco de dados postgreSQL criando a
     * Connection de acordo com a url, usuario e a senha e criando, também, o
     * statement que servirá pra realizar updates e buscas no banco.
     *
     * @return valor booleano indicando se a conexão foi feita ou não com
     * sucesso.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static boolean connect()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            stm = con.createStatement();
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    /**
     * Método resposável por realizar um update no banco de acordo com a String
     * sql passada.
     *
     * @param sql valor em String com o comando SQL
     * @return valor booleano indicando se o update foi feito com sucesso.
     */
    public static boolean update(String sql)
    {
        connect();
        try
        {
            stm.executeUpdate(sql);
            return true;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Método responsável por retornar um ResultSet com todos os dados
     * encontrados na consulta ao banco.
     *
     * @param sql valor em String com o comando SQL
     * @return ResultSet com todos os dados encontrados na consulta.
     */
    public static ResultSet query(String sql)
    {

        connect();
        ResultSet rs;
        try
        {
            rs = stm.executeQuery(sql);
            return rs;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável por fechar a Connection e fechar o statement.
     *
     * @return valor booleano indicando se o fechamento foi realizado com
     * sucesso.
     * @throws SQLException
     */
    public boolean close() throws SQLException
    {
        con.close();
        stm.close();
        return true;
    }

}
