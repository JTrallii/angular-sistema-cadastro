import { Component } from '@angular/core';
import { BotaoSalvarComponent } from "../../components/botao-salvar/botao-salvar.component";

@Component({
  selector: 'app-cliente',
  standalone: true,
  imports: [BotaoSalvarComponent],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.scss'
})
export class ClienteComponent {
  salvar: "salvar" = "salvar";
  atualizar: "atualizar" = "atualizar";
  excluir: "excluir" = "excluir";
}
