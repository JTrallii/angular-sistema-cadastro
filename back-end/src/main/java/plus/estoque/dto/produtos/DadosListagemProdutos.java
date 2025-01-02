package plus.estoque.dto.produtos;


import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.domain.produtos.enums.*;
import java.math.BigDecimal;
import java.util.List;

public record DadosListagemProdutos(


        String produto,
        String codigo_barras,
        Fornecedor fornecedor,
        String descricao,
        String marca,
        String modelo,
        String sku,
        BigDecimal preco_venda,
        BigDecimal preco_custo,
        Double estoque,
        Double estoque_minimo,
        CategoriaProduto categoriaProduto,
        Material material,
        UnidadeMedida unidade_medida
) {

    public DadosListagemProdutos(Produto produto) {
        this(produto.getProduto(), produto.getCodigo_barras(), produto.getFornecedor(), produto.getDescricao(),
                produto.getMarca(), produto.getModelo(), produto.getSku(), produto.getPreco_venda(),
                produto.getPreco_custo(), produto.getEstoque(), produto.getEstoque_minimo(),
                produto.getCategoriaProduto(), produto.getMaterial(), produto.getUnidade_medida());
    }
}






















