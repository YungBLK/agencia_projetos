package projeto_lpi.Models;
import java.sql.Date;
import java.sql.SQLException;


public class Usuario_model extends Model{
    private char id_tipo_usuario;
    private char id_sexo;
    private int id_instituicao;
    private String nome;
    private String cpf;
    private String rg;
    private Date nascimento;

    
        public Usuario_model Listar_Usuarios(){
        Usuario_model usuario_model = null;
        
        
        return usuario_model;
    }

    @Override
    public Model[] listar_todos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model[] listar_todos_por(String nome_campo, String operador, String chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(String nome_campo, char chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
