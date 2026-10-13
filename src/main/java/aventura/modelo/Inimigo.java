package aventura.modelo;

public abstract class Inimigo{
    private final String nome;
    private int vida;

    public Inimigo(String nome, int vida){
        this.nome = nome;
        this.vida = vida;
    }

    public String getNome(){
        return nome;
    }
    public int getVida(){
        return vida;
    }

    public void receberDano(int dano){
        vida -= dano;
        if (vida < 0){
            vida = 0;
        }
    }

    public boolean estaVivo(){
        return vida > 0;
    }

    public abstract void atacar(Personagem personagem);
}