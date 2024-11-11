package plus.estoque.dto.produtos;

import jakarta.validation.constraints.NotBlank;
import plus.estoque.domain.produtos.Produto;
import java.time.LocalDateTime;


public record DadosListaVendasProdutos(

        @NotBlank
        LocalDateTime dataVenda,
        @NotBlank
        Double valorTotalVenda,
        @NotBlank
        Produto listaProdutos

        ) {
}
