import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../service/login/login.service';
import { response } from 'express';

@Component({
  selector: 'app-modal-login-usuario',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './modal-login-usuario.component.html',
  styleUrl: './modal-login-usuario.component.scss',
})
export class ModalLoginUsuarioComponent {
  @Input() aberta: boolean = false;
  @Output() aoFechar = new EventEmitter<void>();
  @Output() aoEfetuarLogin = new EventEmitter<void>();
  @Output() nomeUsuario = new EventEmitter<string>();
  formlogin!: FormGroup;
  usuario = "";
  error: string = "";

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.formlogin = this.formBuilder.group({
      login: ["", [Validators.required]],
      senha: ["", [Validators.required]],
    });
  }

  resetFormulario() {
    this.formlogin.reset();
  }

  efetuarLogin() {
          this.nomeUsuario.emit(this.usuario);
          this.aoEfetuarLogin.emit();
          this.router.navigateByUrl("/dashboard");
    // if (this.formlogin.valid) {
    //   const { login, senha } = this.formlogin.value;
    //   const credenciais = { login, senha };

    //   this.loginService.efetuarLogin(credenciais).subscribe({
    //     next: (response) => {
    //       localStorage.setItem("token", response.tokenJWT);
    //       this.usuario = response.nome;
    //       this.nomeUsuario.emit(this.usuario);
    //       this.aoEfetuarLogin.emit();
    //       this.router.navigateByUrl("/dashboard");
    //     },
    //     error: (erro) => console.error(erro),
    //   });

    //   this.resetFormulario();
    // }
  }
}
