import { Component } from '@angular/core';
import { BotaoPrincipalComponent } from "../../components/botao-principal/botao-principal.component";

@Component({
  selector: 'app-administracao',
  standalone: true,
  imports: [BotaoPrincipalComponent],
  templateUrl: './administracao.component.html',
  styleUrl: './administracao.component.scss'
})
export class AdministracaoComponent {
  texto: "#ffffff" = "#ffffff";
  botao_listar: string = "#17202a";
  botao_listar_hover: string = "#0c1116";
  font_size: string = "1.2rem";
}
