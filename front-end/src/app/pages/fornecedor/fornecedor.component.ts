import { Component } from '@angular/core';
import { BotaoSalvarComponent } from "../../components/botao-salvar/botao-salvar.component";

@Component({
  selector: 'app-fornecedor',
  standalone: true,
  imports: [BotaoSalvarComponent],
  templateUrl: './fornecedor.component.html',
  styleUrl: './fornecedor.component.scss'
})
export class FornecedorComponent {
  salvar: "salvar" = "salvar";
  atualizar: "atualizar" = "atualizar";
  excluir: "excluir" = "excluir";
}
