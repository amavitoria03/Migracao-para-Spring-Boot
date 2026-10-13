package aventura.modelo;

public class Personagem{
    private final String nome;
    private int vida;
    private int ouro;
    private final Inventario<Item> inventario;

    public Personagem(String nome){
        this.nome = nome;
        this.vida = 100;
        this.ouro = 0;
        this.inventario = new Inventario<>();
    }

    public String getNome(){
        return nome;
    }
    public int getVida(){
        return vida;
    }
    public int getOuro(){
        return ouro;
    }
    public Inventario<Item> getInventario(){
        return inventario;
    }

    public void receberDano(int dano){
        vida -= dano;
        if (vida < 0){
            vida = 0;
        }
    }

    public void curar(int quantidade){
        vida += quantidade;
        if (vida > 100){
            vida = 100;
        }
    }

    public void ganharOuro(int valor){
        ouro += valor;
    }

    public void atacar(Inimigo inimigo){
        int dano = 10;
        inimigo.receberDano(dano);
        System.out.println(nome + " atacou " + inimigo.getNome() + " causando " + dano + " de dano.");
    }

    public boolean estaVivo(){
        return vida > 0;
    }
    public void mostrarStatus(){
        System.out.println("Personagem: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Ouro: " + ouro);
        System.out.println("Itens: " + inventario.tamanho());
    }
}