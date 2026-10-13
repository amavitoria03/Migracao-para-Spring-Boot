package aventura.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario<T>{
    private List<T> itens = new ArrayList<>();

    public void adicionar(T item){
        itens.add(item);
    }

    public boolean remover(T item){
        return itens.remove(item);
    }

    public T procurar(T item){
        int posicao = itens.indexOf(item);
        if (posicao >= 0){
            return itens.get(posicao);
        }
        return null;
    }

    public List<T> listar(){
        return List.copyOf(itens);
    }

    public int tamanho(){
        return itens.size();
    }

    public boolean estaVazio(){
        return itens.isEmpty();
    }
}