
import { Component } from '@angular/core';
import { BotaoPrincipalComponent } from "../../../components/botao-principal/botao-principal.component";
import { MensagemErroValidacaoComponent } from "../../../components/mensagem-erro-validacao/mensagem-erro-validacao.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-nota-fiscal',
  standalone: true,
  imports: [BotaoPrincipalComponent, MensagemErroValidacaoComponent, CommonModule, FormsModule],
  templateUrl: './nota-fiscal.component.html',
  styleUrl: './nota-fiscal.component.scss'
})
export class NotaFiscalComponent {
  texto: "#ffffff" = "#ffffff";
  salvar: "#47a138" = "#47a138";
  salvar_hover: "#267c17" = "#267c17";
  atualizar: "#3498db" = "#3498db";
  atualizar_hover: "#1b689c" = "#1b689c";
  excluir: "#ff0000" = "#ff0000";
  excluir_hover: "#da0000" = "#da0000";

  constructor(

    ) {}





}
