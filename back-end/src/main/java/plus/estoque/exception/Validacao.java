package plus.estoque.exception;

public class Validacao extends RuntimeException{
    public Validacao(String messagem) {
        super(messagem);
    }
}
