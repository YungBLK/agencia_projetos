/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_lpi.Controllers;
import java.sql.SQLException;
import projeto_lpi.Models.Projeto_model;


public class Projeto_controller extends Controller {
    Projeto_model isntancia_projeto_model = new Projeto_model();
    
    
    
    public void listar_todos() throws SQLException{
        Projeto_model[] lista_projetos = isntancia_projeto_model.listar_todos();
        this.renderizar(lista_projetos);
    }
    public void listar_todos_por(String nome_campo,String operador,String chave) throws SQLException{
        char aspas = '"';
        switch(nome_campo){
            case "Titulo":nome_campo="pro."+nome_campo;       chave = aspas+chave+aspas;break;
            case "titulo":nome_campo="pro."+nome_campo;       chave = aspas+chave+aspas;break;
            case "Instituicao":nome_campo="inst.nome";   chave = aspas+chave+aspas;break;
            case "instituicao":nome_campo="inst.nome";   chave = aspas+chave+aspas;break;
            case "Area_pesquisa":nome_campo="area."+nome_campo;chave = aspas+chave+aspas;break;
            case "area_pesquisa":nome_campo="area."+nome_campo;chave = aspas+chave+aspas;break;
            case "Id_projeto":nome_campo="pro."+nome_campo;chave= "'"+chave+"'";break;
            case "id_projeto":nome_campo="pro."+nome_campo;chave= "'"+chave+"'";break;
        }
        Projeto_model[] lista_projetos = isntancia_projeto_model.listar_todos_por(nome_campo,operador,chave);
        this.renderizar(lista_projetos);
    }
    public void inserir(Projeto_model dados) throws SQLException{
       boolean result =  isntancia_projeto_model.inserir(dados);
    }

    public void deletar(String nome_campo,String operador,String chave) throws SQLException{
        char aspas = '"';
        switch(nome_campo){
            case "Titulo":nome_campo=""+nome_campo;    chave = aspas+chave+aspas;break;
            case "titulo":nome_campo=""+nome_campo;    chave = aspas+chave+aspas;break;
            case "Id_projeto":nome_campo=""+nome_campo;chave= "'"+chave+"'";break;
            case "id_projeto":nome_campo=""+nome_campo;chave= "'"+chave+"'";break;
        }
        boolean result = isntancia_projeto_model.deletar(nome_campo,operador,chave);
        Projeto_model[] lista_projetos = isntancia_projeto_model.listar_todos();
        this.renderizar(lista_projetos);
    }
    
    
    
    public void renderizar(Projeto_model[] lista) {
        System.out.format("|----------------------------------------------------------------------------------------------|\n");
        System.out.format("|    id_projeto   |   instituicao    |   area_pesquisa    |  titulo  |  duracao  |  orcamento  |\n");
        System.out.format("|-----------------+------------------+--------------------+----------+-----------+-------------|\n");
        String instituicao;            
        for (Projeto_model projeto : lista) {
            if (projeto != null) {
                System.out.format("|        %s        |        %s         |         %s          |    %s     |   %s M     |     %s    |\n", projeto.id_projeto,projeto.instituicao,
                        projeto.area_pesquisa,projeto.titulo,projeto.duracao,projeto.orcamento);
            }
        }
        System.out.format("|----------------------------------------------------------------------------------------------|\n");
    }
}
