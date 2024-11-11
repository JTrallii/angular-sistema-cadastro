package plus.estoque.dto.produtos;

import plus.estoque.domain.produtos.Produto;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(

        Long id,
        String produto,
        String codigoBarras,
        String fornecedor,
        String descricao,
        String marca,
        String modelo,
        String sku,
        BigDecimal precoVenda,
        BigDecimal precoCusto,
        Double qtdEstoque,
        Double qtdMinimaEstoque,
        String categoriaProduto,
        String material,
        String unidadeDimensao,
        String unidadePeso,
        String unidadeVolume

) {

    public DadosDetalhamentoProduto(Produto produto) {
        this(produto.getId(),
                produto.getProduto(),
                produto.getCodigoBarras(),
                produto.getFornecedor().getFornecedor(),
                produto.getDescricao(),
                produto.getMarca(),
                produto.getModelo(),
                produto.getSku(),
                produto.getPrecoVenda(),
                produto.getPrecoCusto(),
                produto.getQtdEstoque(),
                produto.getQtdMinimaEstoque(),
                produto.getCategoriaProduto().toString(),
                produto.getMaterial().toString(),
                produto.getUnidadeDimensao().toString(),
                produto.getUnidadePeso().toString(),
                produto.getUnidadeVolume().toString());
    }
}
