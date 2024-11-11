package plus.estoque.domain.produtos.enums;

public enum UnidadeDimensao {
    MILIMETRO("MM"),
    CENTIMETRO("CM"),
    METRO("M"),
    POLEGADA("IN");

    private final String simbolo;

    UnidadeDimensao(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}

