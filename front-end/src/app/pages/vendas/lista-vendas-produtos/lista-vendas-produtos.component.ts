import { Component, Input, SimpleChanges } from '@angular/core';
import { Produto } from '../../../utils/interface/IProduto';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-vendas-produtos',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './lista-vendas-produtos.component.html',
  styleUrl: './lista-vendas-produtos.component.scss'
})
export class ListaVendasProdutosComponent {
  @Input() produto: Produto | null = null;
  @Input() quantidade: number = 0;


  listaDeProdutos: Produto[] = []; // Lista para armazenar os produtos

  ngOnChanges(changes: SimpleChanges) {
    //changes['produto'] verifica se houve alguma alteração específica na propriedade @Input chamada produto.
    if (changes['produto'] && this.produto) {
      // Verifica se o produto é diferente de null e adiciona à lista
      
      this.listaDeProdutos.push(this.produto);
    }
  }
}
