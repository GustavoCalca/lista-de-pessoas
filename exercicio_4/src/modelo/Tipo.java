package modelo;

public class Tipo {
    private String cpf = new String();
    private int idade;
    private String nome = new String();
    
    public Tipo(String cpf, String nome, int idade){
        this.setCpf(cpf);
        this.setNome(nome);
        this.setIdade(idade);
    }
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
