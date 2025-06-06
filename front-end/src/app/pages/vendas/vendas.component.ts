import { Component } from '@angular/core';
import { PesquisarProdutoComponent } from './pesquisar-produto/pesquisar-produto.component';
import { ListaVendasProdutosComponent } from './lista-vendas-produtos/lista-vendas-produtos.component';
import { Produto, ProdutoSimplificado } from '../../utils/interface/IProduto';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BotaoPrincipalComponent } from "../../components/botao-principal/botao-principal.component";

@Component({
  selector: 'app-vendas',
  standalone: true,
  imports: [
    PesquisarProdutoComponent,
    ListaVendasProdutosComponent,
    CommonModule,
    FormsModule,
    BotaoPrincipalComponent,
],
  templateUrl: './vendas.component.html',
  styleUrl: './vendas.component.scss',
})
export class VendasComponent {
  texto: string = "#ffffff";
  salvar: string = "#47a138";
  salvar_hover: string = "#267c17";
  botao_listar: string = "#17202a";
  botao_listar_hover: string = "#0c1116";
  font_size: string = "1.2rem";
  estoque: number = 0; // Armazena a quantidade em estoque do produto
  quantidade: number = 1; // Valor inicial do input de quantidade
  preco: number = 0; // Armazena o preço do produto
  quantidadeMaior: boolean = false;
  quantidadeDoItem: number = 0;
  totalCompra: number = 0;

  produtoSelecionado: Produto | null = null;

  // Estrutura para enviar apenas um produto por vez
  produto: ProdutoSimplificado | null = null;

  onProdutoSelecionado(produto: Produto) {
    this.estoque = produto.estoque; // Atualiza o valor do estoque
    this.preco = produto.preco; // Atualiza o valor do preço
    this.produtoSelecionado = produto; // Armazena o produto selecionado
  }

  get precoFormatado(): string {
    return this.preco.toFixed(2);
  }

  setQuantidade(quantidadeItem: number): boolean {
    if (this.produtoSelecionado) {
      //validação para garantir que a quantidade do item é maior que a quantidade de estoque
      if (quantidadeItem > this.produtoSelecionado.estoque || quantidadeItem === 0) {
        this.quantidade = 0;
        this.quantidadeMaior = true;
        return false;
      } else {
        this.quantidade = quantidadeItem;
        this.quantidadeMaior = false;
        return true;
      }
    }
    return true;
  }

  adicionarProduto() {
    if (this.produtoSelecionado && this.quantidade > 0) {
      this.produto = {
        nome: this.produtoSelecionado.nome,
        preco: this.produtoSelecionado.preco,
      };
      // Certifique-se de que a quantidade é um número
      this.quantidadeDoItem = Number(this.quantidade);

      // Resetar os campos no pai
      this.produtoSelecionado = null;
      this.quantidade = 1; // Quantidade inicial para o próximo produto
      this.estoque = 0;
      this.preco = 0;
    }
  }

  atualizarTotalCompra(valorAtualizado: number) {
    this.totalCompra = Number(valorAtualizado); // Recebe o valor atualizado do filho
  }
}
