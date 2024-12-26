package plus.estoque.domain.produtos.enums;

import lombok.Getter;

@Getter
public enum UnidadeMedida {
    // Peso
    KG,
    GR,

    // Comprimento
    M,
    CM,
    MM,

    // Volume
    L,
    ML,

    // Quantidade
    UN,
    PCT,
    CX;
}

