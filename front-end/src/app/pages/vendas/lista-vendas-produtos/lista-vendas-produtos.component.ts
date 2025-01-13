import { Component, EventEmitter, Input, Output, SimpleChanges } from '@angular/core';
import {
  ItemDeCompra,
  ProdutoSimplificado,
} from '../../../utils/interface/IProduto';
import { CommonModule } from '@angular/common';
import { ListaCompra } from '../../../utils/interface/IListaCompra';

@Component({
  selector: 'app-lista-vendas-produtos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './lista-vendas-produtos.component.html',
  styleUrl: './lista-vendas-produtos.component.scss',
})
export class ListaVendasProdutosComponent {
  @Input() produto: ProdutoSimplificado | null = null;
  @Input() quantidadeDoItem: number = 0;
  @Output() valorTotalCompraEmit = new EventEmitter<number>();
  valor_total_item: number = 0;
  valor_total_compra: number = 0;


  listaDeCompras: ListaCompra[] = [];

  ngOnChanges(changes: SimpleChanges) {
    if (changes['produto'] && this.produto && this.quantidadeDoItem > 0) {
      const itemDaLista: ListaCompra = {
        produto: { ...this.produto }, // Cria uma cópia do produto
        quantidade: this.quantidadeDoItem,
        valor_total_item: this.quantidadeDoItem * this.produto.preco,
      };

      this.valor_total_compra += itemDaLista.valor_total_item;
      this.valorTotalCompraEmit.emit(this.valor_total_compra);

      this.listaDeCompras.push(itemDaLista);

      // Resetar o estado local após adicionar o produto à lista
      this.produto = null;
      this.quantidadeDoItem = 0;
    }
  }

  // calcularTotalCompra(): number {
  //   return this.listaDeCompras.reduce(
  //     (total, item) => total + item.valor_total_item,
  //     0
  //   );
  // }
}
