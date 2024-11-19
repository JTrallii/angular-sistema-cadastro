import { Component } from '@angular/core';
import { BotaoSalvarComponent } from "../../components/botao-salvar/botao-salvar.component";
import { BotaoPrincipalComponent } from "../../components/botao-principal/botao-principal.component";

@Component({
  selector: 'app-produto',
  standalone: true,
  imports: [BotaoSalvarComponent, BotaoPrincipalComponent],
  templateUrl: './produto.component.html',
  styleUrl: './produto.component.scss'
})
export class ProdutoComponent {
  texto: "#ffffff" = "#ffffff";
  salvar: "#47a138" = "#47a138";
  salvar_hover: "#267c17" = "#267c17";
  atualizar: "#3498db" = "#3498db";
  atualizar_hover: "#1b689c" = "#1b689c";
  excluir: "#ff0000" = "#ff0000";
  excluir_hover: "#da0000" = "#da0000";
}
