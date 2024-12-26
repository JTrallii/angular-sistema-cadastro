package plus.estoque.dto.produtos;

import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.domain.produtos.enums.CategoriaProduto;
import plus.estoque.domain.produtos.enums.Material;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(

        Long id,
        String produto,
        String codigoBarras,
        Fornecedor fornecedor,
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

    public DadosDetalhamentoProduto(Produto produto) {
        this(produto.getId(),
                produto.getProduto(),
                produto.getCodigoBarras(),
                produto.getFornecedor(),
                produto.getDescricao(),
                produto.getMarca(),
                produto.getModelo(),
                produto.getSku(),
                produto.getPrecoVenda(),
                produto.getPrecoCusto(),
                produto.getQuantidade(),
                produto.getQtd_minima(),
                produto.getCategoriaProduto(),
                produto.getMaterial());
    }
}
