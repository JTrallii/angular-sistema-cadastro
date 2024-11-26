import { Component } from '@angular/core';
import { ModalPagamentoComponent } from "../vendas/modal-pagamento/modal-pagamento.component";

@Component({
  selector: 'app-caixa',
  standalone: true,
  imports: [ModalPagamentoComponent],
  templateUrl: './caixa.component.html',
  styleUrl: './caixa.component.scss'
})
export class CaixaComponent {
  modal: boolean = true;
}
