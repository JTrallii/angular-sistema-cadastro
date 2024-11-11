import { Component } from '@angular/core';
import { BotaoSalvarComponent } from "../../components/botao-salvar/botao-salvar.component";

@Component({
  selector: 'app-produto',
  standalone: true,
  imports: [BotaoSalvarComponent],
  templateUrl: './produto.component.html',
  styleUrl: './produto.component.scss'
})
export class ProdutoComponent {
  salvar: "salvar" = "salvar";
  atualizar: "atualizar" = "atualizar";
  excluir: "excluir" = "excluir";
}
