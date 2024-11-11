package plus.estoque.domain.produtos.enums;

public enum UnidadePeso {
    GRAMA("G"),
    QUILOGRAMA("KG"),
    TONELADA("T");

    private final String simbolo;

    UnidadePeso(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}

