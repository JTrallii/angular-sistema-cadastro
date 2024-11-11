import { Component } from '@angular/core';
import { PesquisarProdutoComponent } from "./pesquisar-produto/pesquisar-produto.component";
import { BotaoSalvarComponent } from "../../components/botao-salvar/botao-salvar.component";
import { BotaoListarComponent } from "../../components/botao-listar/botao-listar.component";

@Component({
  selector: 'app-vendas',
  standalone: true,
  imports: [PesquisarProdutoComponent, BotaoListarComponent],
  templateUrl: './vendas.component.html',
  styleUrl: './vendas.component.scss'
})
export class VendasComponent {

}
