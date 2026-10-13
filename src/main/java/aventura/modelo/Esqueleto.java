package aventura.modelo;

public class Esqueleto extends Inimigo{
    private final int dano;

    public Esqueleto(String nome){
        super(nome, 50);
        this.dano = 8;
    }

    @Override
    public void atacar(Personagem personagem){
        int danoTotal = dano + 2;
        personagem.receberDano(danoTotal);
        System.out.println(getNome() + " atacou " + personagem.getNome() + " causando " + danoTotal + " de dano.");
    }
}