package aventura.controller;

import aventura.modelo.Inimigo;
import aventura.modelo.Missao;
import aventura.modelo.Personagem;
import aventura.service.AventuraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aventura")

public class AventuraController{
    private final AventuraService aventuraService;
    public AventuraController(AventuraService aventuraService){
        this.aventuraService = aventuraService;
    }

    @GetMapping("/status")
    public Personagem verStatus(){
        return aventuraService.getHeroi();
    }

    @GetMapping("/inimigos")
    public List<Inimigo> listarInimigos(){
        return aventuraService.getInimigos();
    }

    @GetMapping("/missoes")
    public List<Missao> listarMissoes(){
        return aventuraService.getMissoes();
    }

    @PostMapping("/atacar/{indiceInimigo}")
    public String atacar(@PathVariable int indiceInimigo){
        return aventuraService.atacarInimigo(indiceInimigo);
    }
}