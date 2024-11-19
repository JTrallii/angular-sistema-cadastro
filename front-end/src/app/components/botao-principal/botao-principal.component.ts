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
  @Input() color: string = "white";
  @Input() backgroundColor: string = "blue";
  @Input() fontSize: string = "16px";
  @Input() hoverColor: string = "white";
  @Input() hoverBackgroundColor: string = "darkblue";
  @Input() borda: string = "none";
  @Input() marginLeft: string = "0px";
  @Input() font_size: string = "1rem";
  @Output() onClick = new EventEmitter<void>();


  emitClick() {
    this.onClick.emit();
  }
}
