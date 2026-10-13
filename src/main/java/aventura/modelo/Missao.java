package aventura.modelo;

public class Missao{
    private final String titulo;
    private final String descricao;
    private EstadoMissao estado;
    private final Inimigo alvo;
    private final Item recompensa;
    private final int ouroRecompensa;

    public Missao(String titulo, String descricao, Inimigo alvo, Item recompensa, int ouroRecompensa){
        this.titulo = titulo;
        this.descricao = descricao;
        this.alvo = alvo;
        this.recompensa = recompensa;
        this.ouroRecompensa = ouroRecompensa;
        this.estado = EstadoMissao.PENDENTE;
    }

    public String getTitulo(){
        return titulo;
    }
    public EstadoMissao getEstado(){
        return estado;
    }
    public Inimigo getAlvo(){
        return alvo;
    }
    public Item getRecompensa(){
        return recompensa;
    }
    public int getOuroRecompensa(){
        return ouroRecompensa;
    }

    public void concluir(Personagem personagem){
        if(estado == EstadoMissao.CONCLUIDA){
            return;
        }
        estado = EstadoMissao.CONCLUIDA;
        personagem.ganharOuro(ouroRecompensa);
        personagem.getInventario().adicionar(recompensa);
        System.out.println("Missão concluída: " + titulo);
        System.out.println("Recompensa: " + ouroRecompensa + " moedas");
        System.out.println(recompensa.getNome());
    }
}