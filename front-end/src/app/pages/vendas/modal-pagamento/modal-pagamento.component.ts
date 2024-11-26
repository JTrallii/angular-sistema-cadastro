import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-modal-pagamento',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule
  ],
  templateUrl: './modal-pagamento.component.html',
  styleUrl: './modal-pagamento.component.scss'
})
export class ModalPagamentoComponent {
  @Input() aberta: boolean = false;
  @Output() aoFechar = new EventEmitter<void>();

  formasDePagamento = [
    "DINHEIRO À VISTA",
    "DEPÓSITO BANCÁRIO",
    "PIX",
    "TRANSFERÊNCIA BANCÁRIA",
    "CREDIÁRIO",
    "CASHBACK"
  ];

  formaPagamentoSelecionada: string | null = null; // Inicialmente, nenhuma forma de pagamento está selecionada

  selecionarForma(forma: string): void {
    this.formaPagamentoSelecionada = forma;
  }
}
