import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-botao-header',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './botao-header.component.html',
  styleUrl: './botao-header.component.scss'
})
export class BotaoHeaderComponent {
  @Input() tipo: "primario" | "secundario" = "primario";
  @Input() acaoBotao = "";
  @Output() onClick = new EventEmitter<void>();

  get buttonClasse() {
    return this.tipo === "primario" ? "btn__primario" : "btn__secundario";
  }

  emitClick() {
    this.onClick.emit();
  }
}
