import { CommonModule } from "@angular/common";
import { Component, EventEmitter, Output } from "@angular/core";
import { Produto } from "../../../utils/interface/IProduto";
import { FormsModule } from "@angular/forms";

@Component({
  selector: 'app-pesquisar-produto',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './pesquisar-produto.component.html',
  styleUrl: './pesquisar-produto.component.scss'
})
export class PesquisarProdutoComponent {
  produtos: Produto[] = [
    { id: 1, nome: "Produto A", preco: 100.00, estoque: 10 },
    { id: 2, nome: "Produto B", preco: 150.35, estoque: 5 },
    { id: 3, nome: "Produto C", preco: 200.50, estoque: 20 },
  ];

  inputProduto: string = "";
  produtosFiltrados: Produto[] = [];
  @Output() produtoSelecionado = new EventEmitter<Produto>();

  onInputChange() {
    this.produtosFiltrados = this.produtos.filter(produto =>
      produto.nome.toLowerCase().includes(this.inputProduto.toLowerCase())
    );
  }

  selecionarProduto(produto: Produto) {
    this.inputProduto = produto.nome;
    this.produtoSelecionado.emit(produto);
    this.produtosFiltrados = []; // Limpa a lista após a seleção
  }

}
