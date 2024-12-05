import { Component } from '@angular/core';
import { BotaoPrincipalComponent } from "../../components/botao-principal/botao-principal.component";
import { FormControl, FormGroup, FormsModule, NgForm, Validators } from '@angular/forms';
import { MensagemErroValidacaoComponent } from "../../components/mensagem-erro-validacao/mensagem-erro-validacao.component";
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cliente',
  standalone: true,
  imports: [
    BotaoPrincipalComponent,
    FormsModule,
    MensagemErroValidacaoComponent,
    CommonModule
],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.scss'
})
export class ClienteComponent {
  texto: "#ffffff" = "#ffffff";
  salvar: "#47a138" = "#47a138";
  salvar_hover: "#267c17" = "#267c17";
  atualizar: "#3498db" = "#3498db";
  atualizar_hover: "#1b689c" = "#1b689c";
  excluir: "#ff0000" = "#ff0000";
  excluir_hover: "#da0000" = "#da0000";


  constructor(private router: Router) {
  }

  cadastrar(form: NgForm) {
    // Marca todos os campos como 'touched' para exibir as mensagens de erro
    this.marcarCamposComoTouched(form);

    if (form.valid) {
      this.router.navigateByUrl("/compras");
    } else {
      console.log('Formulário inválido!');
    }
  }

  marcarCamposComoTouched(form: NgForm) {
    // Percorre todos os controles do formulário e marca como touched
    Object.keys(form.controls).forEach(field => {
      const control = form.controls[field];
      control.markAsTouched();
    });
  }
}
