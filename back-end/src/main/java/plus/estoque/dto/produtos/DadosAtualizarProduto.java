package plus.estoque.dto.produtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.enums.*;
import java.math.BigDecimal;

public record DadosAtualizarProduto(

        @NotNull
        Long id,
        @NotNull
        Boolean ativo,
        String produto,
        String codigoBarras,
        String fornecedor,
        String descricao,
        String marca,
        String modelo,
        String sku,
        BigDecimal precoVenda,
        BigDecimal precoCusto,
        Double quantidade,
        Double qtd_minima,
        CategoriaProduto categoriaProduto,
        Material material

) {
}
