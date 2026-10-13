package aventura.modelo;

public class Arma extends Item{
    private final int dano;

    public Arma(String nome, int valor, int dano){
        super(nome, valor);
        this.dano = dano;
    }

    public int getDano(){
        return dano;
    }
}