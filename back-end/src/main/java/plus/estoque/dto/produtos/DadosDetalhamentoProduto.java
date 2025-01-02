package plus.estoque.dto.produtos;

import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.domain.produtos.enums.CategoriaProduto;
import plus.estoque.domain.produtos.enums.Material;
import plus.estoque.domain.produtos.enums.UnidadeMedida;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(

        Long id,
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
        UnidadeMedida und_medida
) {

    public DadosDetalhamentoProduto(Produto produto) {
        this(produto.getId(),
                produto.getProduto(),
                produto.getCodigo_barras(),
                produto.getFornecedor(),
                produto.getDescricao(),
                produto.getMarca(),
                produto.getModelo(),
                produto.getSku(),
                produto.getPreco_venda(),
                produto.getPreco_custo(),
                produto.getEstoque(),
                produto.getEstoque_minimo(),
                produto.getCategoriaProduto(),
                produto.getMaterial(),
                produto.getUnidade_medida());
    }
}
