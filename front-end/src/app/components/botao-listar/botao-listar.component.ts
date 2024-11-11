import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-botao-listar',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './botao-listar.component.html',
  styleUrl: './botao-listar.component.scss'
})
export class BotaoListarComponent {
  @Output() onClick = new EventEmitter<void>();

  emitClick() {
    this.onClick.emit();
  }
}
