package aventura.excecoes;

public class ItemNaoEncontrado extends Exception{
    public ItemNaoEncontrado(String mensagem){
        super(mensagem);
    }
}