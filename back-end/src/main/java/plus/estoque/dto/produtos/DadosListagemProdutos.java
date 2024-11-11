package plus.estoque.dto.produtos;


import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.domain.produtos.enums.*;
import java.math.BigDecimal;

public record DadosListagemProdutos(


        String produto,
        String codigoBarras,
        Fornecedor fornecedor,
        String descricao,
        String marca,
        String modelo,
        String sku,
        BigDecimal precoVenda,
        BigDecimal precoCusto,
        Double qtdEstoque,
        Double qtdMinimaEstoque,
        CategoriaProduto categoriaProduto,
        Material material,
        UnidadeDimensao unidadeDimensao,
        UnidadePeso unidadePeso,
        UnidadeVolume unidadeVolume

) {

    public DadosListagemProdutos(Produto produto) {
        this(produto.getProduto(), produto.getCodigoBarras(), produto.getFornecedor(), produto.getDescricao(),
                produto.getMarca(), produto.getModelo(), produto.getSku(), produto.getPrecoVenda(),
                produto.getPrecoCusto(), produto.getQtdEstoque(), produto.getQtdMinimaEstoque(),
                produto.getCategoriaProduto(), produto.getMaterial(),
                produto.getUnidadeDimensao(), produto.getUnidadePeso(),
                produto.getUnidadeVolume());
    }

}






















