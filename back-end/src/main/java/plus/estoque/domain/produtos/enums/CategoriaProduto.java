package plus.estoque.domain.produtos.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoriaProduto {
    ELETRONICOS("Eletrônicos"),
    ROUPAS_E_ACESSORIOS("Roupas e Acessórios"),
    ALIMENTOS_E_BEBIDAS("Alimentos e Bebidas"),
    MOVEIS("Móveis"),
    ELETRODOMESTICOS("Eletrodomésticos"),
    BRINQUEDOS_E_JOGOS("Brinquedos e Jogos"),
    LIVROS("Livros"),
    FERRAMENTAS_E_MATERIAIS_DE_CONSTRUCAO("Ferramentas e Materiais de Construção"),
    PRODUTOS_DE_BELEZA_E_CUIDADOS_PESSOAIS("Produtos de Beleza e Cuidados Pessoais"),
    CASA_E_COZINHA("Casa e Cozinha"),
    CALCADOS("Calçados");

    private final String descricao;

    CategoriaProduto(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return descricao;
    }

    // Método para pegar o enum pelo nome da descrição
    @JsonCreator
    public static CategoriaProduto fromDescricao(String descricao) {
        for (CategoriaProduto categoria : CategoriaProduto.values()) {
            if (categoria.getDescricao().equalsIgnoreCase(descricao)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria não encontrada: " + descricao);
    }
}

