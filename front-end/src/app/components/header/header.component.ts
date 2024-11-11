import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ModalLoginUsuarioComponent } from "../modal-login-usuario/modal-login-usuario.component";
import { ModalCadastroUsuarioComponent } from "../modal-cadastro-usuario/modal-cadastro-usuario.component";
import { CommonModule } from '@angular/common';
import { BotaoHeaderComponent } from '../botao-header/botao-header.component';


@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    CommonModule,
    ModalLoginUsuarioComponent,
    ModalCadastroUsuarioComponent,
    BotaoHeaderComponent
],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  modalLoginUsuario = false;
  modalCadastroUsuario = false;
  usuario = "";
  usuarioLogado = false;
  login = "login";
  cadastro = "cadastro"
  primario: "primario" = "primario"; // Define explicitamente o tipo literal "primario"
  secundario: "secundario" = "secundario"; // Define explicitamente o tipo literal "secundario"

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
    this.router.navigate(['/home']);
  }

  aoEfetuarLogout() {
    this.usuarioLogado = false;
    this.router.navigate(['/']);
  }

  // salvarNomeUsuario(usuarioEncontrado: string) {
  //   this.usuario = usuarioEncontrado;
  // }

}
