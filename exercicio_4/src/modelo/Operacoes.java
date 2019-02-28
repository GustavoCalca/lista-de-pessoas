package modelo;

import java.util.Scanner;

public class Operacoes {
    
    private Scanner scanner = new Scanner(System.in);
    private Mapa inicio;
    
    public Operacoes(){
        this.inicio = null;
    }
    
    public boolean estaVazia(){
        if (this.inicio == null)
            return true;
        else{
            System.out.println("A lista está vazia.");
            return false;
        }
    }
    
    public void adicionar(String cpf, Tipo valor)
    {
        Mapa mapa = new Mapa(valor,cpf);
        mapa.setProximo(this.inicio);
        this.inicio = mapa;
    }
    
    public boolean remover(String cpf){
        if (!this.estaVazia()){
            Mapa atual, anterior;
            atual = this.inicio;
            anterior = null;
            while(atual != null){
                if(cpf.equals(atual.getChave())){
                    if(anterior == null){
                        this.inicio = this.inicio.getProximo();
                        return true;
                    }
                    else{
                        anterior.setProximo(atual.getProximo());
                        return true;
                    }
                }
                anterior = atual;
                atual = atual.getProximo();
            }
            return false;
        }
        else
            return false;
    }
    
    public boolean alterar(String cpf, Tipo valor){
        if(!this.estaVazia()){
            Mapa atual = this.inicio;
            while(atual != null){
                if(cpf.equals(atual.getChave())){
                    atual.setValor(valor);
                    return true;
                }
                atual = atual.getProximo();
            }
            return false;
        }
        else
            return false;
    }
    
    public boolean buscar(String cpf){
        if(!this.estaVazia()){
            Mapa atual = this.inicio;
            while(atual != null){
                if(cpf.equals(atual.getChave())){
                    System.out.println("--------------------");
                    System.out.printf("\nCPF: %s\nNOME: %s\nIDADE: %d\n", atual.getChave(), atual.getNomeAtual(), atual.getIdadeAtual());
                    return true;
                }
                else
                    atual = atual.getProximo();
            }
            return false;
        }
        else
            return false;
    }
    
    public void imprimir(){
        Mapa atual = this.inicio;
        while(atual!=null){
            System.out.println("--------------------");
            System.out.printf("\nCPF: %s\nNOME: %s\nIDADE: %d\n", atual.getChave(), atual.getNomeAtual(), atual.getIdadeAtual());
            atual = atual.getProximo();
        }
    }
    
    public void aplicacao(){
        int i = 0;
        loop:
        while(i == 0){
            System.out.println("\n--------------------\nAPLICAÇÃO MAPA:");
            System.out.println("Operações:\n-ADICIONAR\n-BUSCAR\n-REMOVER\n-ALTERAR\n-IMPRIMIR\n-SAIR");
            String cpf, nome;
            int idade;
            String operacao = scanner.next();
            scanner.nextLine();
            switch(operacao){
                case "ADICIONAR":
                    System.out.print("\nCPF:");
                    cpf = scanner.next();
                    System.out.print("\nNOME:");
                    nome = scanner.next();
                    System.out.print("\nIDADE:");
                    idade = scanner.nextInt();
                    if(this.buscar(cpf) != true){
                        Tipo tipo = new Tipo(cpf, nome, idade);
                        this.adicionar(tipo.getCpf(), tipo);
                    }
                    else
                        System.out.println("CPF já existente");
                    break;
                case "BUSCAR":
                    System.out.print("CPF:");
                    cpf = scanner.next();
                    this.buscar(cpf);
                    if(this.buscar(cpf) != true)
                        System.out.println("Contato não encontrado");
                    break;
                case "REMOVER":
                    System.out.println("CPF:");
                    cpf = scanner.next();
                    this.remover(cpf);
                    if(this.remover(cpf) == true)
                        System.out.println("Contato removido");
                    else
                        System.out.println("Contato não encontrado");
                    break;
                case "ALTERAR":
                    System.out.print("CPF: ");
                    cpf = scanner.next();
                    this.buscar(cpf);
                    if(this.buscar(cpf) == false)
                        System.out.println("CPF não encontrado");
                    else{
                        System.out.print("\n--------------------\nNOVO NOME:");
                        nome = scanner.next();
                        System.out.print("\nNOVA IDADE:");
                        idade = scanner.nextInt();
                        Tipo tipo = new Tipo(cpf, nome, idade);
                        this.alterar(cpf, tipo);
                    }
                    break;
                case "IMPRIMIR":
                    this.imprimir();
                    break;
                case "SAIR":
                    System.out.println("\n--------------------\nSaindo do sistema...");
                    i = 1;
                    continue loop;
                default:
                    System.out.println("Valor incorreto");
                    break;
            }
            loop2:
            do{
            System.out.println("\n--------------------\nDeseja continuar na aplicação?\n0-SIM\n1-NAO");
            i = scanner.nextInt();
            if((i > 1) || (i < 0))
                System.out.println("Valor incorreto");
            else
                if(i == 1){
                System.out.println("Saindo do sistema...");
                break loop2;
            }
            }while((i > 1) || (i < 0));
        }
    }
}
