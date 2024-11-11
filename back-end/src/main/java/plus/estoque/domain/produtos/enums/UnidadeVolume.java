package plus.estoque.domain.produtos.enums;

public enum UnidadeVolume {
    MILILITRO("ML"),

    LITRO("L");

    private final String simbolo;

    UnidadeVolume(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}

