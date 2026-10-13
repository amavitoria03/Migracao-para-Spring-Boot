package aventura.modelo;

public class Goblin extends Inimigo{
    private final int dano;

    public Goblin(String nome){
        super(nome, 30);
        this.dano = 5;
    }

    @Override
    public void atacar(Personagem personagem){
        personagem.receberDano(dano);
        System.out.println(getNome() + " atacou " + personagem.getNome() + " causando " + dano + " de dano.");
    }
}