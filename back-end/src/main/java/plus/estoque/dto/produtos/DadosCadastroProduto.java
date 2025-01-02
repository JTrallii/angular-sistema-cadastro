package plus.estoque.dto.produtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.enums.*;
import java.math.BigDecimal;

public record DadosCadastroProduto(

        @NotBlank
        String produto,
        @NotBlank
        String codigo_barras,
        @NotBlank
        String fornecedor,
        @NotBlank
        String descricao,
        String marca,
        String modelo,
        String sku,
        @NotNull
        BigDecimal preco_venda,
        @NotNull
        BigDecimal preco_custo,
        @NotNull
        Double estoque,
        @NotNull
        Double estoque_minimo,
        @NotNull
        CategoriaProduto categoriaProduto,
        @NotNull
        Material material,
        @NotNull
        UnidadeMedida und_medida

) {}
