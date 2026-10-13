package aventura.modelo;

public class Pocao extends Item implements Usavel{
    private final int cura;

    public Pocao(String nome, int valor, int cura){
        super(nome, valor);
        this.cura = cura;
    }

    public int getCura(){
        return cura;
    }

    @Override
    public void usar(Personagem personagem){
        personagem.curar(cura);
        System.out.println(personagem.getNome() + " usou " + getNome() + " e recuperou " + cura + " de vida.");
    }
}