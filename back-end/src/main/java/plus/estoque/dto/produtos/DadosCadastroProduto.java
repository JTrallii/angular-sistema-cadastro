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
        String codigoBarras,
        @NotBlank
        String fornecedor,
        @NotBlank
        String descricao,
        String marca,
        String modelo,
        String sku,
        @NotNull
        BigDecimal precoVenda,
        @NotNull
        BigDecimal precoCusto,
        @NotNull
        Double quantidade,
        @NotNull
        Double qtd_minima,
        @NotNull
        CategoriaProduto categoriaProduto,
        @NotNull
        Material material,
        @NotNull
        UnidadeMedida unidadeMedida

) {}
