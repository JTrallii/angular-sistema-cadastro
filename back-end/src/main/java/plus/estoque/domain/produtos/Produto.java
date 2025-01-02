package plus.estoque.domain.produtos;

import jakarta.persistence.*;
import lombok.*;
import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.enums.*;
import plus.estoque.dto.produtos.DadosAtualizarProduto;
import plus.estoque.dto.produtos.DadosCadastroProduto;
import java.math.BigDecimal;
import java.util.Optional;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Boolean ativo;

    @Column(nullable = false)
    private String produto;

    @Column(nullable = false, unique = true)
    private String codigo_barras;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    private String sku;

    @Column(nullable = false)
    private Double estoque_minimo;

    @Column(nullable = false)
    private Double estoque;

    @Enumerated(EnumType.STRING)
    private UnidadeMedida und_medida;

    @Column(nullable = false)
    private BigDecimal preco_custo;

    @Column(nullable = false)
    private BigDecimal preco_venda;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoriaProduto;

    private String marca;
    private String modelo;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Material material;


    public Produto(DadosCadastroProduto dados) {
            this.produto = dados.produto();
            this.codigo_barras = dados.codigo_barras();
            this.fornecedor = getFornecedor();
            this.descricao = dados.descricao();
            this.marca = dados.marca();
            this.modelo = dados.modelo();
            this.sku = dados.sku();
            this.preco_venda = dados.preco_venda();
            this.preco_custo = dados.preco_custo();
            this.estoque = dados.estoque();
            this.estoque_minimo = dados.estoque_minimo();
            this.categoriaProduto = CategoriaProduto.fromDescricao(dados.categoriaProduto().getDescricao());
            this.material = Material.fromDescricao(dados.material().getDescricao());
            this.ativo = true;
        }


    public void atualizarInformacoes(DadosAtualizarProduto dados) {
        if (dados != null) {
            this.produto = Optional.ofNullable(dados.produto()).orElse(this.produto);
            this.codigo_barras = Optional.ofNullable(dados.codigoBarras()).orElse(this.codigo_barras);
            this.descricao = Optional.ofNullable(dados.descricao()).orElse(this.descricao);
            this.marca = Optional.ofNullable(dados.marca()).orElse(this.marca);
            this.modelo = Optional.ofNullable(dados.modelo()).orElse(this.modelo);
            this.sku = Optional.ofNullable(dados.sku()).orElse(this.sku);
            this.preco_venda = Optional.ofNullable(dados.precoVenda()).orElse(this.preco_venda);
            this.preco_custo = Optional.ofNullable(dados.precoCusto()).orElse(this.preco_custo);
            this.estoque = Optional.ofNullable(dados.quantidade()).orElse(this.estoque);
            this.estoque_minimo = Optional.ofNullable(dados.qtd_minima()).orElse(this.estoque_minimo);
            this.categoriaProduto = Optional.ofNullable(dados.categoriaProduto()).orElse(this.categoriaProduto);
            this.material = Optional.ofNullable(dados.material()).orElse(this.material);
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
























