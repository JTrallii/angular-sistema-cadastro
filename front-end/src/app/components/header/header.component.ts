import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ModalLoginUsuarioComponent } from '../modal-login-usuario/modal-login-usuario.component';
import { ModalCadastroUsuarioComponent } from '../modal-cadastro-usuario/modal-cadastro-usuario.component';
import { CommonModule } from '@angular/common';
import { BotaoPrincipalComponent } from '../botao-principal/botao-principal.component';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    CommonModule,
    ModalLoginUsuarioComponent,
    ModalCadastroUsuarioComponent,
    BotaoPrincipalComponent,
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent implements OnInit {
  @Output() loginEfetuado = new EventEmitter<boolean>();

  modalLoginUsuario = false;
  modalCadastroUsuario = false;
  usuario = '';
  usuarioLogado = false;
  login = 'login';
  cadastro = 'cadastro';
  branco: string = '#ecf0f1'; // Define explicitamente o tipo literal
  verde: string = '#47a138'; // Define explicitamente o tipo literal
  preto: string = '#17202a';
  transparente: string = 'transparent';
  font_size: string = '1.3rem';
  borda: string = '3px solid #47a138';
  marginLeft: string = '1rem';

  ngOnInit(): void {
    const token = localStorage.getItem("token");
    if (token) {
      this.usuarioLogado = true;
      this.loginEfetuado.emit(true);
    }
  }

  constructor(private router: Router) {}

  abrirModalLogin() {
    this.modalLoginUsuario = true;
  }

  fecharModalLogin() {
    this.modalLoginUsuario = false;
  }

  abrirModalCadastro() {
    this.modalCadastroUsuario = true;
  }

  fecharModalCadastro() {
    this.modalCadastroUsuario = false;
  }

  aoEfetuarLogin() {
    this.modalLoginUsuario = false;
    this.usuarioLogado = true;
    localStorage.setItem('token', 'true'); // ou o valor real do token se houver
    this.loginEfetuado.emit(true);
    this.router.navigate(['/dashboard']);
  }

  aoEfetuarLogout() {
    this.usuarioLogado = false;
    this.loginEfetuado.emit(false);
    localStorage.removeItem('token');
    this.router.navigate(['/home']);
  }

  receberNomeUsuario(nome: string) {
    this.usuario = nome; // Atualiza o nome do usuário logado
  }
}
