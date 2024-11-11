package plus.estoque.domain.vendas;


import jakarta.persistence.*;
import lombok.*;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.domain.vendas.enums.FormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Table(name = "vendas")
@Entity(name = "Venda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataVenda;
    private BigDecimal valorTotalVenda = BigDecimal.ZERO;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemVenda> itensVenda = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    public void adicionarItem(Produto produto, Double quantidade) {
        ItemVenda itemVenda = new ItemVenda(this, produto, quantidade);
        this.itensVenda.add(itemVenda);
        this.valorTotalVenda = this.valorTotalVenda.add(itemVenda.getPrecoTotal());
    }

}


























