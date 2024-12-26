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

    @Setter
    private Boolean ativo;

    @Column(nullable = false)
    private String produto;

    @Column(nullable = false, unique = true)
    private String codigoBarras;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    private String sku;

    @Column(nullable = false)
    private Double qtd_minima;

    @Column(nullable = false)
    private Double quantidade;

    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;

    @Column(nullable = false)
    private BigDecimal precoCusto;

    @Column(nullable = false)
    private BigDecimal precoVenda;

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
            this.codigoBarras = dados.codigoBarras();
            this.fornecedor = getFornecedor();
            this.descricao = dados.descricao();
            this.marca = dados.marca();
            this.modelo = dados.modelo();
            this.sku = dados.sku();
            this.precoVenda = dados.precoVenda();
            this.precoCusto = dados.precoCusto();
            this.quantidade = dados.quantidade();
            this.qtd_minima = dados.qtd_minima();
            this.categoriaProduto = CategoriaProduto.fromDescricao(dados.categoriaProduto().getDescricao());
            this.material = Material.fromDescricao(dados.material().getDescricao());
            this.ativo = true;
        }


    public void atualizarInformacoes(DadosAtualizarProduto dados) {
        if (dados != null) {
            this.produto = Optional.ofNullable(dados.produto()).orElse(this.produto);
            this.codigoBarras = Optional.ofNullable(dados.codigoBarras()).orElse(this.codigoBarras);
            this.descricao = Optional.ofNullable(dados.descricao()).orElse(this.descricao);
            this.marca = Optional.ofNullable(dados.marca()).orElse(this.marca);
            this.modelo = Optional.ofNullable(dados.modelo()).orElse(this.modelo);
            this.sku = Optional.ofNullable(dados.sku()).orElse(this.sku);
            this.precoVenda = Optional.ofNullable(dados.precoVenda()).orElse(this.precoVenda);
            this.precoCusto = Optional.ofNullable(dados.precoCusto()).orElse(this.precoCusto);
            this.quantidade = Optional.ofNullable(dados.quantidade()).orElse(this.quantidade);
            this.qtd_minima = Optional.ofNullable(dados.qtd_minima()).orElse(this.qtd_minima);
            this.categoriaProduto = Optional.ofNullable(dados.categoriaProduto()).orElse(this.categoriaProduto);
            this.material = Optional.ofNullable(dados.material()).orElse(this.material);
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
























