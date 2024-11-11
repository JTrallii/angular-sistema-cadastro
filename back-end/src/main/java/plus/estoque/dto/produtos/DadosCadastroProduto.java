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
        @NotNull
        Fornecedor fornecedor,
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
        Double qtdEstoque,
        @NotNull
        Double qtdMinimaEstoque,
        @NotNull
        CategoriaProduto categoriaProduto,
        Material material,
        UnidadeDimensao unidadeDimensao,
        UnidadePeso unidadePeso,
        UnidadeVolume unidadeVolume

) {
}
