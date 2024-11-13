import { Component } from '@angular/core';
import { PesquisarProdutoComponent } from "./pesquisar-produto/pesquisar-produto.component";
import { BotaoListarComponent } from "../../components/botao-listar/botao-listar.component";
import { ListaVendasProdutosComponent } from "./lista-vendas-produtos/lista-vendas-produtos.component";
import { Produto } from '../../utils/interface/IProduto';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vendas',
  standalone: true,
  imports: [PesquisarProdutoComponent, BotaoListarComponent, ListaVendasProdutosComponent, CommonModule, FormsModule],
  templateUrl: './vendas.component.html',
  styleUrl: './vendas.component.scss'
})
export class VendasComponent {
  produto: string = ""; // Armazena o nome do produto
  estoque: number = 0; // Armazena a quantidade em estoque do produto
  quantidade: number = 1; // Valor inicial do input de quantidade
  preco: number = 0; // Armazena o preço do produto

  produtoSelecionado: Produto | null = null;


  onProdutoSelecionado(produto: Produto) {
    this.produto = produto.nome;
    this.estoque = produto.estoque; // Atualiza o valor do estoque
    this.preco = produto.preco; // Atualiza o valor do preço
    this.produtoSelecionado = produto; // Armazena o produto selecionado
  }

  get precoFormatado(): string {
    return this.preco.toFixed(2);
  }
}
