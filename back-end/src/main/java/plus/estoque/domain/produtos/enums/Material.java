package plus.estoque.domain.produtos.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

    // Método para pegar o enum pelo nome da descrição
    @JsonCreator
    public static Material fromDescricao(String descricao) {
        for (Material material : Material.values()) {
            if (material.getDescricao().equalsIgnoreCase(descricao)) {
                return material;
            }
        }
        throw new IllegalArgumentException("Categoria não encontrada: " + descricao);
    }
    @JsonValue
    public String getDescricaoJson() {
        return descricao;
    }
}

