import { Component } from '@angular/core';
import { PesquisarProdutoComponent } from "./pesquisar-produto/pesquisar-produto.component";
import { BotaoSalvarComponent } from "../../components/botao-salvar/botao-salvar.component";
import { BotaoListarComponent } from "../../components/botao-listar/botao-listar.component";
import { ListaVendasProdutosComponent } from "./lista-vendas-produtos/lista-vendas-produtos.component";

@Component({
  selector: 'app-vendas',
  standalone: true,
  imports: [PesquisarProdutoComponent, BotaoListarComponent, ListaVendasProdutosComponent],
  templateUrl: './vendas.component.html',
  styleUrl: './vendas.component.scss'
})
export class VendasComponent {

}
