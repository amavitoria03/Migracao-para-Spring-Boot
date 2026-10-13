package aventura.service;

import aventura.excecoes.ItemNaoEncontrado;
import aventura.modelo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AventuraService{

    private final Personagem heroi = new Personagem("Aventureiro");
    private final List<Inimigo> inimigos = new ArrayList<>();
    private final List<Missao> missoes = new ArrayList<>();

    public AventuraService(){
        Pocao pocao = new Pocao("Poção de Cura", 20, 30);
        inimigos.add(new Goblin("Goblin da Floresta"));
        inimigos.add(new Esqueleto("Esqueleto Guerreiro"));

        missoes.add(new Missao("Problemas na Floresta", "Derrote o Goblin", inimigos.get(0), pocao, 25));
        missoes.add(new Missao("Ossos Antigos", "Derrote o Esqueleto", inimigos.get(1), new Arma("Espada", 50, 5), 35));
    }

    public Personagem getHeroi(){
        return heroi;
    }

    public List<Inimigo> getInimigos(){
        return inimigos;
    }

    public List<Missao> getMissoes(){
        return missoes;
    }

    public String atacarInimigo(int indiceInimigo){
        if (indiceInimigo < 0 || indiceInimigo >= inimigos.size()) {
            return "Inimigo nao encontrado!";
        }
        Inimigo inimigo = inimigos.get(indiceInimigo);
        if (!inimigo.estaVivo()){
            return inimigo.getNome() + " ja esta derrotado.";
        }

        heroi.atacar(inimigo);
        
        String resultado = heroi.getNome() + " atacou " + inimigo.getNome() + ". Vida restante do inimigo: " + inimigo.getVida();

        if (!inimigo.estaVivo()){
            resultado += ". " + inimigo.getNome() + " foi derrotado!";
            verificarMissoes(inimigo);
        }
        else{
            inimigo.atacar(heroi);
            resultado += ". " + inimigo.getNome() + " contra-atacou! Vida do heroi: " + heroi.getVida();
        }
        return resultado;
    }

    private void verificarMissoes(Inimigo inimigo){
        for (Missao m : missoes){
            if (m.getAlvo() == inimigo && m.getEstado() == EstadoMissao.PENDENTE){
                m.concluir(heroi);
            }
        }
    }
}