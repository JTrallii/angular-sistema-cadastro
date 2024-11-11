package plus.estoque.domain.vendas;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import plus.estoque.domain.produtos.Produto;
import java.math.BigDecimal;

@Entity(name = "Item_Venda")
@Table(name = "itens_venda")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Double quantidade;

    private BigDecimal precoUnitario;

    private BigDecimal precoTotal;

    public ItemVenda(Venda venda, Produto produto, Double quantidade) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPrecoVenda();
        this.precoTotal = this.precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
