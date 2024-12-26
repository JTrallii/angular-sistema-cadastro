package plus.estoque.dto.produtos;


import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.domain.produtos.enums.*;
import java.math.BigDecimal;
import java.util.List;

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
        Double quantidade,
        Double qtd_minima,
        CategoriaProduto categoriaProduto,
        Material material
) {

    public DadosListagemProdutos(Produto produto) {
        this(produto.getProduto(), produto.getCodigoBarras(), produto.getFornecedor(), produto.getDescricao(),
                produto.getMarca(), produto.getModelo(), produto.getSku(), produto.getPrecoVenda(),
                produto.getPrecoCusto(), produto.getQuantidade(), produto.getQtd_minima(),
                produto.getCategoriaProduto(), produto.getMaterial());
    }
}






















