package projeto_lpi.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Projeto_model extends Model{
    private final Connection conn = getConnection();
    public int id_projeto;
    public String instituicao;
    public String area_pesquisa;
    public int id_instituicao;
    public int id_area_pesquisa;
    public String titulo;
    public int duracao;
    public float orcamento;
    @Override
    public Projeto_model[] listar_todos() throws SQLException { 
        String query = "select pro.id_projeto,inst.nome,area.area_pesquisa,pro.titulo,pro.duracao,pro.orcamento from projeto pro natural join area_pesquisa area natural join instituicao inst order by pro.id_projeto asc;";
        int tamanho = 64;
        Projeto_model[] resultado = new Projeto_model[tamanho];

        int counter = 0;  
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            counter = 0;
            
            while (rs.next())
            {
                 resultado[counter] = new Projeto_model();
                 resultado[counter].id_projeto = rs.getInt("id_projeto");
                 resultado[counter].instituicao = rs.getString("nome");
                 resultado[counter].area_pesquisa = rs.getString("area_pesquisa");
                 resultado[counter].titulo = rs.getString("titulo");
                 resultado[counter].duracao = rs.getInt("duracao");
                 resultado[counter].orcamento = rs.getFloat("orcamento");
                 counter++;
            }
        }
        if(counter !=0){
            return resultado;
        }
        else{
            return null;
        }
    }
    
    @Override
    public Projeto_model[] listar_todos_por(String nome_campo, String operador, String chave) throws SQLException {
        String query = "select pro.id_projeto,inst.nome,area.area_pesquisa,pro.titulo,pro.duracao,pro.orcamento from projeto pro natural join area_pesquisa area natural join instituicao inst where "+nome_campo+" "+operador+" "+chave+" order by pro.id_projeto asc;";
      //System.out.println(query);
        int tamanho = 32;
        Projeto_model[] resultado = new Projeto_model[tamanho];

        int counter = 0;  
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            counter = 0;
            while (rs.next())
            {
                 resultado[counter] = new Projeto_model();
                 resultado[counter].id_projeto = rs.getInt("id_projeto");
                 resultado[counter].instituicao = rs.getString("nome");
                 resultado[counter].area_pesquisa = rs.getString("area_pesquisa");
                 resultado[counter].titulo = rs.getString("titulo");
                 resultado[counter].duracao = rs.getInt("duracao");
                 resultado[counter].orcamento = rs.getFloat("orcamento");
                 counter++;
            }
        }
        if(counter !=0){
            return resultado;
        }
        else{
            return null;
        }
    }
    public boolean inserir(Projeto_model dados) throws SQLException {
        int instituicao = 0;
        char aspas = '"';
        /*String query = "Insert into Projeto(id_instituicao,id_area_pesquisa,titulo,duracao,orcamento)values('"+dados.id_instituicao+"','"+dados.id_area_pesquisa+"',"+
                            aspas+ dados.titulo +aspas+",'"+dados.duracao+"','"+dados.orcamento+"');";*/
           String query = "insert into Projeto(id_instituicao,id_area_pesquisa,titulo,duracao,orcamento)values(?,?,?,?,?)";
            try (PreparedStatement  st = conn.prepareStatement(query)) {
                st.setInt (1, dados.id_instituicao);
                st.setInt (2, dados.id_area_pesquisa);
                st.setString (3, dados.titulo);
                st.setInt (4, dados.duracao);
                st.setFloat (5, dados.orcamento);
                st.execute();  
                return true;
            }
            catch(Exception e){
                return false;
            }
    }

    @Override
    public boolean deletar(String nome_campo, String operador,String chave) throws SQLException {
        String query = "delete from Projeto where "+nome_campo+" "+operador+" "+chave+" ;";
        System.out.println(query);
        Statement st = conn.createStatement();
        try(ResultSet rs =st.executeQuery(query)){
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
