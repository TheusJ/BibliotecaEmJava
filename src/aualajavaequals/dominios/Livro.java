package aualajavaequals.dominios;


// IMPORTS NECESSARIOS

import aualajavaequals.aulaequalsjava;
import java.util.Scanner;
import java.util.Iterator;

public class Livro extends aulaequalsjava{
    Scanner texto = new Scanner(System.in);
    
    // AQUI SAO OS ATRIBUTOS, APENAS O ATRIBUTO ESTOQUE QUE NAO COLOQUEI AINDA(NAO FUNCIONA AINDA)..
    private String[] nome;
    private String[] author;
    private double[] preco;
    private double[] estoque;
    private int qntdLivros;
    
    // CRIEI UM METODO PARA O MENU, SENDO ASSIM CONSIGO INTERAGIR COM A PROPRIA CLASS NO MENU
    public void menuPrincipal(){
        int menuOp, menuAlterarLivros; // DUAS VARIAVEIS DE MENU, A
                                        // PRIMEIRA PARA MENU PRINCIPAL E A SEGUNDA PARA ALTERAR LIVROS
        
                                        
                                        // MENU E SUAS OPCOES
        System.out.println("ESCOLHA AS OPCOES");
        System.out.println();
        System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
        menuOp = texto.nextInt();
        texto.nextLine();
        while (menuOp != 0) {  // CRIEI UM LOOPING COM O WHILE, PARA QUE O MENU NAO SE ENCERRE          
            switch (menuOp) {
                case 1:     // CRIEI UM SWITCH AO INVES DO IF, TENTEI DIMINUIR PARA QUE NAO FIQUE MUITO GRANDE
                    if(this.nome == null){  // ESSA OPCAO 1 É PARA COMPRA DE LIVROS
                        System.out.println("Nao temos livros disponiveis\n");
                        System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
                    menuOp = texto.nextInt();
                    
                    }else{
                        comprarLivros();
                    
                    }
                    
                    

                    break;
                    
                case 2: 
                    // ESSA OPCAO 2 É PARA ADICIONAR LIVROS OU ALTERAR, UM METODO DE ADICIONAR E ALTERAR LIVROS INTERAGE COM ELE
                    System.out.println("[1] Alterar Livros\n[2] Adicionar Livros");
                    menuAlterarLivros = texto.nextInt();
                    
                    if(menuAlterarLivros == 1){
                        if(this.nome == null){  // AQUI VERIFICO SE EXISTE ALGUM LIVRO ADICIONADO, CASO NAO COLOCO NOVAMENTE NO MENU
                                                // SO FUNCIONA SE TIVER LIVRO ADICIONADO
                            System.out.println("Nenhum Livro adicionado para alterar\n");
                            System.out.println("[1] Comprar Livros\n[2] Adicionar novos Livros\n[3] Mostrar Livros");
                            menuOp = texto.nextInt();
                            
                        
                        }else{ 
                            // AQUI É CASO JA TENHA LIVROS NA LISTA, E CHAMO O METODO DE ALTERAR LIVROS
                            alterarLivros();
                        
                        }
                        
                    
                    }else if(menuAlterarLivros == 2){ // AQUI ADICIONO OS LIVROS
                        adicionarLivros();
                        
                    
                    
                    }else {
                        System.out.println("Opcao errada!");
                        
                        System.out.println("[1] Alterar Livros\n[2] Comprar Livros");
                        menuAlterarLivros = texto.nextInt();
                    }
                    
                    break;
                    
                    
                case 3: // ESSA OPCAO É PARA MOSTRAR TODOS OS LIVROS
                        // MAS SOMENTE SE TIVER LIVROS NA LISTA, CASO NAO, ELE FAZ UMA VERIFICAÇÃO
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
        
        // AQUI É UM METODO PARA COMPRAS DE LIVROS
        
        System.out.println("Nossos livros ");
        mostrarLivrosEAutores();
        
        System.out.println();
        
        System.out.println("Selecione um livro pelo index 0 ou 1...");
        int indexLivros = texto.nextInt(); // AQUI PEÇO PARA ESCOLHER O INDEX DO LIVRO 
        
        if(indexLivros <= this.qntdLivros && indexLivros >= 0){
            // AQUI FAÇO UMA VERIFICAÇÃO SE O INDEX DO LIVRO É MENOR QUE A QUANTIDADE DE LIVROS ADICIONADOR
            // E SE É MAIOR QUE 0, CASO SIM, DÁ CONTINUIDADE PARA A COMPRA DE LIVROS
            System.out.printf("Livro escolhido %d\nLivro: %s\nValor: %f\n",indexLivros, 
                    this.nome[indexLivros], this.preco[indexLivros]);
            
            System.out.println("[1] Comprar Livro\n[2] Menu");
            int menuOp = texto.nextInt();
            texto.nextLine();
            
            
            if(menuOp == 1){
                // AQUI CONTINUA O PROCESSO DA COMPRA DE LIVROS
                // FAZENDO VERIFICAÇÃO DO MENU DE COMPRA.
                
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
                    // AQUI MOSTRA TODOS OS LIVROS 
                    mostrarLivrosEAutores();
                }
            
            }else{
                
                adicionarLivros();
            
            }
        }else{
            // AQUI É QUANDO O INDEX DO LIVRO É INVALIDO
            System.out.println("Index invalido");
            System.out.println("Adicione mais livros");
            adicionarLivros();
       }
    }
    
    public void mostrarLivrosEAutores(){
        // AQUI É O METODO PARA MOSTRAR OS LIVROS, AUTORES E SEUS VALORES
        for (int i = 0; i < nome.length; i++) {
            System.out.printf("\n\nLivros index %d: %s\n\nAuthor: %s\n\nValor do Livro: R$ %f\n",i, this.nome[i],
                    this.author[i], this.preco[i] );
            System.out.println();
        }
    
    
    }
    
    public void alterarLivros(){
         // METODO PARA ALTERAR O LIVROS JÁ EXISTENTE
        
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
            // CASO O INDEX SEJA INVALIDO
            System.out.println("Index invalido!");
            menuPrincipal();
        
        }
        
        
        
    
    }
    
    
    
    public void adicionarLivros(){
        
        // METODO PARA ADICIONAR OS LIVROS, AUTORES E SEUS VALORES.
        // CRIEI UM LOOPOING FOR, PORQUE É O USUARIO QUE ESCOLHE A QUANTIDADE DE LIVROS QUE VAO SER ADICIONADOS.
        
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

    
    

