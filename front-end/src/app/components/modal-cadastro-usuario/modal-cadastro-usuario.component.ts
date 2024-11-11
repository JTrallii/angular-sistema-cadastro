import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-modal-cadastro-usuario',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
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

  validarNome = (nome: string): boolean => {
    if (nome.length < 4) {
      this.errorNome = "Nome deve conter pelo menos 4 caracteres.";
      return false;
    }
    this.errorNome = "";
    this.isNomeValido = true;
    return true;
  };

  validarEmail = (email: string): boolean => {
    const emailRegex = /\w{3,}@[a-zA-Z]{3,}\.[a-zA-Z]{2,}/;
    if (!emailRegex.test(email)) {
      this.errorEmail = "Email inválido.";
      this.isEmailValido = false;
      return false;
    }

    return true;

    // const emailCadastrado = usuarios.some(
    //   (usuario: ILogin) => usuario.email === email
    // );


    // if (emailCadastrado) {
    //   setErrorEmail("Email já cadastrado.");
    //   setIsEmailValido(false);
    //   return false;
    // }

    // setErrorEmail("");
    // setIsEmailValido(true);
    // return true;
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



}
