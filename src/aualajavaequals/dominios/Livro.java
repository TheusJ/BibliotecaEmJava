package aualajavaequals.dominios;




import aualajavaequals.aulaequalsjava;
import java.util.Scanner;
import java.util.Iterator;

public class Livro extends aulaequalsjava{
    Scanner texto = new Scanner(System.in);
    
    
    private String[] nome;
    private String[] author;
    private double[] preco;
    private double[] estoque;
    private int qntdLivros;
    
    
    public void menuPrincipal(){
        int menuOp, menuAlterarLivros; // DUAS VARIAVEIS DE MENU, A
                                        // PRIMEIRA PARA MENU PRINCIPAL E A SEGUNDA PARA ALTERAR LIVROS
        
        System.out.println("ESCOLHA AS OPCOES");
        System.out.println();
        System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
        menuOp = texto.nextInt();
        texto.nextLine();
        while (menuOp != 0) {            
            switch (menuOp) {
                case 1:
                    if(this.nome == null){
                        System.out.println("Nao temos livros disponiveis\n");
                        System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
                    menuOp = texto.nextInt();
                    
                    }else{
                        comprarLivros();
                    
                    }
                    
                    

                    break;
                    
                case 2:
                    System.out.println("[1] Alterar Livros\n[2] Adicionar Livros");
                    menuAlterarLivros = texto.nextInt();
                    
                    if(menuAlterarLivros == 1){
                        if(this.nome == null){
                            System.out.println("Nenhum Livro adicionado para alterar\n");
                            System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
                            menuOp = texto.nextInt();
                            
                        
                        }else{
                            alterarLivros();
                        
                        }
                        
                    
                    }else if(menuAlterarLivros == 2){
                        adicionarLivros();
                        
                    
                    
                    }else {
                        System.out.println("Opcao errada!");
                        
                        System.out.println("[1] Alterar Livros\n[2] Comprar Livros");
                        menuAlterarLivros = texto.nextInt();
                    }
                    
                    break;
                    
                    
                case 3:
                    if(this.nome == null){
                        System.out.println("Voce precisa adicionar livros para mostrar-los.\n");
                        System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
                        menuOp = texto.nextInt();
                    
                    }else{
                        mostrarLivrosEAutores();
                        System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
                        menuOp = texto.nextInt();
                    
                    }
                    
                    
                    
                    
                    
                    break;
                default:
                    
                    
                    System.out.println("Programa fechado");
            }
        }
    
    
    }
    
    
    public void comprarLivros(){
        
        
        System.out.println("Nossos livros ");
        mostrarLivrosEAutores();
        
        System.out.println();
        
        System.out.println("Selecione um livro pelo index 0 ou 1...");
        int indexLivros = texto.nextInt();
        
        if(indexLivros <= this.qntdLivros && indexLivros >= 0){
            System.out.printf("Livro escolhido %d\nLivro: %s\nValor: %f\n",indexLivros, 
                    this.nome[indexLivros], this.preco[indexLivros]);
            
            System.out.println("[1] Comprar Livro\n[2] Menu");
            int menuOp = texto.nextInt();
            texto.nextLine();
            
            if(menuOp == 1){
                System.out.println("Quantidade de livros: ");
                double qntdCompras = texto.nextDouble();
                texto.nextLine();
                
                qntdCompras = qntdCompras * this.preco[indexLivros];
                
                System.out.printf("Valor: R$ %f",qntdCompras);
                
                System.out.println("Confirma a compra?\n[1] Sim\n[2] Nao");
                int confirmarCompra = texto.nextInt();
                
                if(confirmarCompra == 1){
                    System.out.println("Compra realizada com sucesso!");
                    aulaequalsjava aula = new aulaequalsjava();
                    System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
                    int menuOp1 = texto.nextInt();
                    texto.nextLine();
                
                }else{
                    mostrarLivrosEAutores();
                }
            
            }else{
                adicionarLivros();
            
            }
        }else{
            System.out.println("Index invalido");
            System.out.println("Adicione mais livros");
            adicionarLivros();
       }
    }
    
    public void mostrarLivrosEAutores(){
        for (int i = 0; i < nome.length; i++) {
            System.out.printf("\n\nLivros index %d: %s\n\nAuthor: %s\n\nValor do Livro: R$ %f\n",i, this.nome[i],
                    this.author[i], this.preco[i] );
            System.out.println();
        }
    
    
    }
    
    public void alterarLivros(){
         
        
        System.out.println("Escolha o index do livro: ");
        int indexLivros = texto.nextInt();
        if(indexLivros <= qntdLivros && indexLivros >= 0){
            
            System.out.printf("O index escolhido foi %d", indexLivros);
            System.out.printf("\nDigite um novo nome para o Livro %d: ",indexLivros);
            this.nome[indexLivros] = texto.nextLine();
            
            texto.nextLine();
            
            System.out.println();
            
            System.out.printf("Digite o nome do Author %d: ", indexLivros);
            this.author[indexLivros] = texto.nextLine();
            System.out.println();
            
            System.out.printf("Digite o Valor do Livro %d:  ", indexLivros);
            this.preco[indexLivros] = texto.nextDouble();
            
            texto.nextLine();
            
            
                           
                
        }else{
            System.out.println("Index invalido!");
            menuPrincipal();
        
        }
        
        
        
    
    }
    
    
    
    public void adicionarLivros(){
        
        
        
        System.out.println("QUANTOS LIVROS?");
        this.qntdLivros = texto.nextInt();
        texto.nextLine();
        
        this.nome = new String[this.qntdLivros];
        this.author = new String[this.qntdLivros];
        this.preco = new double[this.qntdLivros];
        
        for (int i = 0; i< this.qntdLivros; i++) {
            System.out.printf("Digite o nome do Livro %d: ", i);
            this.nome[i] = texto.nextLine();
            
            System.out.printf("\nDigite o Author do Livro %d: ", i);
            this.author[i] = texto.nextLine();
            
            System.out.printf("\nDigite o valor do Livro %d: ", i);
            this.preco[i] = texto.nextDouble();
            texto.nextLine();
            
            System.out.println("\nLIVROS ADICIONADOS\n");
            menuPrincipal();
            break;
        }
        
        
        
    
    
    }



}

    
    

