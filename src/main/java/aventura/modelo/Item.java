package aventura.modelo;

public abstract class Item{
    private final String nome;
    private final int valor;

    public Item(String nome, int valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome(){
        return nome;
    }
    public int getValor(){
        return valor;
    }
}