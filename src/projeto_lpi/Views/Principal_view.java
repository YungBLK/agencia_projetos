package projeto_lpi.Views;
import java.sql.SQLException;
import projeto_lpi.Controllers.Projeto_controller;
import projeto_lpi.Models.Projeto_model;


public class Principal_view {
    static java.util.Scanner sc = new java.util.Scanner(System.in);
    static Projeto_controller instancia_projeto_controller = new Projeto_controller();
    static public void print_start(){
        System.out.println("Seja Bem vindo !!!\n"
                + "Ao nosso sistema de gerenciamento de projetos\n"
                + "Para onde você deseja ir jovem forasteiro??\n"
                + "'help' ou 'menu' a qualquer momento te lista as operações\n");
    }
    static public void print_menu() throws SQLException{
        System.out.println("!!! Você está no menu Geral !!!\n"
                         + "'Projetos' ---- Operações com projetos\n"
                         + "'exit'     ---- Finaliza A execução");
        String escrito = sc.nextLine();
        switch(escrito){
         case "help"        :   print_menu();break;
         case "Projetos"    :   print_menu_projeto();break;
         case "projetos"    :   print_menu_projeto();break;
         case "exit"        :   sair();break;

         
         default:System.out.println("Oops não entendi oq você disse\n\n");print_menu();break;
        } 
    }
    static public void print_menu_projeto() throws SQLException{
        System.out.println("!!! Você está no menu de Projetos !!!\n"
                         + "'Inserir' ----  Inserir um novo projeto\n"
                         + "'Listar'  ----  Mostra todos os projetos\n"
                         + "'Pesquisar' --  Pesquisa um projeto\n"
                         + "'Deletar'   --  Deletar  um projeto\n"
                         + "'exit'     ---  Finaliza A execução");
        String escrito = sc.nextLine();
        switch(escrito){
         case "help"    :  print_menu()     ;break;
         case "Inserir" :  inserir_projeto();continuar();print_menu_projeto();break;
         case "inserir" :  inserir_projeto();continuar();print_menu_projeto();break;
         case "Listar"  :  listar_todos()   ;continuar();print_menu_projeto();break;
         case "listar"  :  listar_todos()   ;continuar();print_menu_projeto();break;
         case "Pesquisar": pesquisar()   ;continuar();print_menu_projeto();break;
         case "pesquisar": pesquisar()   ;continuar();print_menu_projeto();break;
         case "Deletar": deletar()     ;continuar();print_menu_projeto();break;
         case "deletar": deletar()     ;continuar();print_menu_projeto();break;
         case "exit"    :  sair()           ;break;
         
         default:System.out.println("Oops não entendi oq você disse\n\n");print_menu_projeto();break;
        }  
    }
    static public void sair(){
        System.out.println("");
    }
    static public void continuar(){
        System.out.println("Precione qualquer tecla para continuar");
        sc.nextLine();
    }
    static public void printar_linha(){
        System.out.println("\n_________________________________________\n");
    }
    static public void inserir_projeto() throws SQLException{
        Projeto_model dados = new Projeto_model();
        printar_linha();
        System.out.println("Digite o Titulo do projeto:");
        dados.titulo = sc.nextLine();
        
        printar_linha();
        System.out.println("Digite o id da  instituicao do projeto:");
        dados.id_instituicao = sc.nextInt();
        
        printar_linha();
        System.out.println("Digite o id da area de pesquisa:");
        dados.id_area_pesquisa = sc.nextInt();
        
        printar_linha();
        System.out.println("Digite a duracao do projeto em meses:");
        dados.duracao = sc.nextInt();
        
        printar_linha();
        System.out.println("Digite o Orcamento do projeto em reais:");
        dados.orcamento = sc.nextFloat();
        
       instancia_projeto_controller.inserir(dados);
       instancia_projeto_controller.listar_todos_por("titulo","=",dados.titulo);
    }
    static public void listar_todos() throws SQLException{
        System.out.println("\n\nListando todos os projetos:");
        instancia_projeto_controller.listar_todos();
    }
    static public void pesquisar() throws SQLException{
        
        System.out.println("Ok... Vamos Pesquisar\n"
                           + "Qual campo você quer bustar?? \n"
                           + "(titulo?)(istituicao?)(area_pesquisa?)(id_projeto?)   ??");
        String campo = sc.nextLine();
        
        System.out.println("\nQual operador (=,>,<,!=,like)");
        String operador = sc.nextLine();
        
        System.out.println("\nQual o valor ????\nOu Qual o %valor%?? ;)");
        String chave = sc.nextLine();
        
        System.out.println("\n\nListando Pesquisa:");
        instancia_projeto_controller.listar_todos_por(campo,operador,chave);
    }
    public static void deletar() throws SQLException{
        System.out.println("Ok... Vamos Apagar\n"
                           + "Qual campo você quer bustar ??\n"
                           + "(titulo?)(id_projeto?)   ??");
        String campo = sc.nextLine();
        
        System.out.println("\nQual operador ( = , > , < , != , like )");
        String operador = sc.nextLine();
        
        System.out.println("\nQual o valor ????\nOu Qual o %valor%?? ;)");
        String chave = sc.nextLine();
        
        System.out.println("\n\nApagando Projeto:");
        System.out.println("\n\nListando todos os  Projetos:");
        instancia_projeto_controller.deletar(campo,operador,chave);
    }
    public static void main(String[] args) throws SQLException{
       print_start();
       print_menu();
    }
}
