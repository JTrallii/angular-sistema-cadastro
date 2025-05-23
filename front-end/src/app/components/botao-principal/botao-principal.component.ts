import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-botao-principal',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './botao-principal.component.html',
  styleUrl: './botao-principal.component.scss',
})
export class BotaoPrincipalComponent {
  hoverOn: boolean = false;
  @Input() texto: string = "#ffffff"
  @Input() color: string = "#47a138";
  @Input() backgroundColor: string = "#267c17";
  @Input() font_size: string = "16px";
  @Input() hoverColor: string = "#47a138";
  @Input() hoverBackgroundColor: string = "#267c17";
  @Input() borda: string = "none";
  @Input() marginLeft: string = "0px";
  @Output() onClick = new EventEmitter<void>();

  emitClick() {
    this.onClick.emit();
  }
}

