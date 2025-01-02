package plus.estoque.dto.produtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import plus.estoque.domain.produtos.Produto;

import java.util.List;


public record DadosProdutosParaVenda(



        @NotNull
        Double preco_venda,
        @NotBlank
        String produto,

        @NotBlank
        List<Produto> produtos

) {



}
