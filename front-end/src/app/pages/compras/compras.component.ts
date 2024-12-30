import { Component } from '@angular/core';
import { BotaoPrincipalComponent } from "../../components/botao-principal/botao-principal.component";
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-compras',
  standalone: true,
  imports: [BotaoPrincipalComponent, RouterModule, RouterOutlet],
  templateUrl: './compras.component.html',
  styleUrl: './compras.component.scss'
})
export class ComprasComponent {
  texto: "#ffffff" = "#ffffff";
  botao_listar: string = "#17202a";
  botao_listar_hover: string = "#0c1116";
  font_size: string = "1.2rem";
}


