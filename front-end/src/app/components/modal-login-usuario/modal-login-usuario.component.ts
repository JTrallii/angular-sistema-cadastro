import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, NgModule, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-modal-login-usuario',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './modal-login-usuario.component.html',
  styleUrl: './modal-login-usuario.component.scss'
})


export class ModalLoginUsuarioComponent {
  @Input() aberta: boolean = false;
  @Output() aoFechar = new EventEmitter<void>();
  @Output() aoEfetuarLogin = new EventEmitter<void>();
  @Output() salvarNomeUsuario = new EventEmitter<void>();

  constructor(private router: Router) {}


  email: string = "";
  senha: string = "";
  error: string = "";
  isEmailValido: boolean = false;
  isSenhaValido: boolean = false;


  resetFormulario() {
    this.email = "";
    this.senha = "";
  }

  // validaEmail(email: string): boolean {

  // }

  // validaSenha(email: string): boolean {

  // }

  // if (this.validaEmail(this.email) && this.validaSenha(this.senha)) {
  //   this.aoEfetuarLogin.emit();
  //   // Aqui você pode adicionar a navegação, se necessário
  //   // Ex: this.router.navigate(['/home/vendas']);
  // }

  handleSubmit(event: Event) {
    event.preventDefault();
    this.error = ''; // Limpa a mensagem de erro antes da validação
    this.router.navigate(['/home/vendas']);

    // if (this.validaEmail(this.email) && this.validaSenha(this.senha)) {
    //   this.aoEfetuarLogin.emit();
    //   // Aqui você pode adicionar a navegação, se necessário
    //   // Ex: this.router.navigate(['/home/vendas']);
    // }
  }
}
