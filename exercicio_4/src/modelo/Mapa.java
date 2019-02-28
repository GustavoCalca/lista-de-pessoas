package modelo;

public class Mapa <Valor> {

    private Valor valor;
    private String cpf = new String();
    private Mapa proximo;
    
    public Mapa(Valor valor, String cpf){
        this.setChave(cpf);
        this.setValor(valor);
        this.setProximo(null);
    }
    
    public int getIdadeAtual(){
        if(valor instanceof Tipo){
            Tipo obj = (Tipo) valor;
            return obj.getIdade();
        }
        return 0;
    }
    
    public String getNomeAtual(){
        if(valor instanceof Tipo){
            Tipo obj = (Tipo) valor;
            return obj.getNome();
        }
        return "";
    }
    
    public Valor getValor(){
        return valor;
    }
    
    public void setValor(Valor valor){
        this.valor = valor;
    }
    
    public String getChave(){
        return cpf;
    }
    
    public void setChave(String cpf){
        this.cpf = cpf;
    }
    
    public Mapa getProximo(){
        return proximo;
    }
    
    public void setProximo(Mapa proximo){
        this.proximo = proximo;
    }
}
