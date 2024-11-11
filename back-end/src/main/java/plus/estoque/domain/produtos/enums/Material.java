package plus.estoque.domain.produtos.enums;

public enum Material {
    MADEIRA("Madeira"),
    METAL("Metal"),
    PLASTICO("Plástico"),
    VIDRO("Vidro"),
    CERAMICA("Cerâmica"),
    TECIDO("Tecido"),
    COURO("Couro"),
    PAPEL("Papel"),
    BORRACHA("Borracha");

    private final String descricao;

    Material(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

