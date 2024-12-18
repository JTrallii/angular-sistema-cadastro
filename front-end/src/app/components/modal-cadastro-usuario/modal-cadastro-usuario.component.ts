import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import marcarCamposComoTouched from '../../utils/marcarCamposFormulario';
import { MensagemErroValidacaoComponent } from "../mensagem-erro-validacao/mensagem-erro-validacao.component";
import { BotaoPrincipalComponent } from "../botao-principal/botao-principal.component";

@Component({
  selector: 'app-modal-cadastro-usuario',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MensagemErroValidacaoComponent,
    BotaoPrincipalComponent
],
  templateUrl: './modal-cadastro-usuario.component.html',
  styleUrl: './modal-cadastro-usuario.component.scss'
})



export class ModalCadastroUsuarioComponent {

  @Input() aberta: boolean = false;
  @Output() aoFechar = new EventEmitter<void>();

  nome = "";
  email = "";
  senha = "";
  isNomeValido = false;
  isEmailValido = false;
  isSenhaValido = false;
  errorNome = "";
  errorEmail = "";
  errorSenha = "";
  formSubmetido = false;
  branco: "#ecf0f1" = "#ecf0f1"; // Define explicitamente o tipo literal
  verde: "#47a138" = "#47a138"; // Define explicitamente o tipo literal
  verde_hover = "#267c17"

  constructor(
    private router: Router
  ) {}

  resetFormulario() {
    this.nome = "";
    this.email = "";
    this.senha = "";
    this.isNomeValido = false;
    this.isEmailValido = false;
    this.isSenhaValido = false;
    this.errorNome = "";
    this.errorEmail = "";
    this.errorSenha = "";
    this.formSubmetido = false;
  };



  get buttonClasseNome() {
    return this.formSubmetido === !this.isNomeValido ? "invalido" : ""
  }

  get buttonClasseEmail() {
    return this.formSubmetido === !this.isEmailValido ? "invalido" : ""
  }

  get buttonClasseSenha() {
    return this.formSubmetido === !this.isSenhaValido ? "invalido" : ""
  }

  cadastrar(form: NgForm) {
    // Marca todos os campos como 'touched' para exibir as mensagens de erro
    marcarCamposComoTouched(form);

    if (form.valid) {
      this.router.navigateByUrl('/compras');
    } else {
      console.log('Formulário inválido!');
    }
  }



}
