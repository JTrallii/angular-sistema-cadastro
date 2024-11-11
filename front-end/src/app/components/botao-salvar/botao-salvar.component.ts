import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-botao-salvar',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './botao-salvar.component.html',
  styleUrl: './botao-salvar.component.scss'
})
export class BotaoSalvarComponent {
  @Input() tipo: "salvar" | "atualizar" | "excluir" = "salvar";
  @Input() acaoBotao = "";
  @Output() onClick = new EventEmitter<void>();

  get buttonClasse() {
    return this.tipo === "salvar" ? "salvar" :
    this.tipo === "atualizar" ? "atualizar" :
    "excluir";
  }

  emitClick() {
    this.onClick.emit();
  }
}
