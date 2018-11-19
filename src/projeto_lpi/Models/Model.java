package projeto_lpi.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Model {
        public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Driver encontrado com sucesso");
        } catch (ClassNotFoundException e) {
            //System.out.println("Driver de conexão mysql não encontrado");
            //System.out.println(e.getStackTrace());
        }
        try {
            String url = "jdbc:mysql://localhost:3306/agencia_projetos";
            String usuario = "root";
            String senha = "unauna";
            Connection c =  DriverManager.getConnection(url, usuario, senha);
            //System.out.println("Conexão estabelecida com sucesso");
            return c;
        } catch (SQLException e) {
            System.out.println("Erro inesperado na conexão com banco de dados.");
            System.out.println(e.getStackTrace());
            throw new RuntimeException();
        }
      
    }
    public abstract Model[] listar_todos() throws SQLException;
    public abstract Model[] listar_todos_por(String nome_campo,String operador,String chave) throws SQLException;
   /* public abstract boolean inserir(Model dados) throws SQLException;*/
    public abstract boolean deletar(String nome_campo,String operador,String chave) throws SQLException;
    /*public abstract boolean atualizar(Model dados,String nome_campo,char chave) throws SQLException;*/
}
