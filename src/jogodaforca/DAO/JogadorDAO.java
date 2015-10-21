package jogodaforca.DAO;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jogodaforca.Model.Jogador;

/**
 * Classe responsável pelas operações CRUD de jogadores no banco de dados.
 * @author kieckegard
 */
public class JogadorDAO implements DAO<Jogador>, PontuaDAO
{ 
    /**
     * Método responsável por persistir um jogador no banco de dados.
     * @param obj
     * @return valor booleano indicando se a persistência foi realizada com sucesso!
     */
    
    @Override
    public boolean add(Jogador obj)
    {
        String usuario = obj.getUsuario();
        String senha = obj.getSenha();
        String nome = obj.getNome();
        System.out.println(nome);
        String email = obj.getEmail();
        Date dataNascimento = Date.from(obj.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());
        String sql = "INSERT INTO JOGADOR VALUES('"+nome+"','"+dataNascimento+"','"+email+"','"+usuario+"','"+senha+"',"+obj.getPontuacao()+")";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por remover um jogador do banco de dados.
     * @param obj
     * @return valor booleano indicando se a remorção por realizada com sucesso.
     */
    
    @Override
    public boolean remove(Jogador obj)
    {
        //Deleta jogador usando email como identificador.
        String sql = "DELETE FROM JOGADOR WHERE email='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por atualizar os dados do jogador no banco de dados usando o Email como chave primária.
     * @param obj
     * @return valor booleano indicando se a atualização foi realizada com sucesso.
     */  
    @Override
    public boolean update(Jogador obj)
    {
        String nome = obj.getNome();
        String usuario = obj.getUsuario();
        String senha = obj.getSenha();
       
        String sql = "UPDATE JOGADOR SET nome='"+nome+"', usuario='"+usuario+"', senha='"+senha+"' WHERE email='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }
    
    /**
     * Método responsável por atualizar a pontuação do jogador passado por parâmetro no banco de dados.
     * @param obj
     * @return valor booleano indicando se a atualização foi feita com sucesso.
     */
    @Override
    public boolean updateScore(Jogador obj)
    {
        String sql = "UPDATE JOGADOR SET pontuacao="+obj.getPontuacao()+" WHERE EMAIL='"+obj.getEmail()+"'";
        return Conexao.update(sql);
    }

    /**
     * Método responsável por listar todos os jogadores persistidos no banco de dados.
     * @return ArrayList contendo todos os administradores cadastrados.
     */
    
    @Override
    public java.util.List<Jogador> List()
    {
        List<Jogador> jogadores = new ArrayList<>();
        String sql = "SELECT * FROM JOGADOR";
        ResultSet rs = Conexao.query(sql);
        try
        {
            while(rs.next())            
            {
                String nome = rs.getString("nome");
                Date data = rs.getDate("data_nascimento");
                LocalDate dataNascimento = LocalDate.parse(data.toString());
                String email = rs.getString("email");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                int pontuacao = rs.getInt("pontuacao");
                Jogador j = new Jogador(nome,dataNascimento,email,usuario,senha,pontuacao);
                jogadores.add(j);
            }
            return jogadores;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
