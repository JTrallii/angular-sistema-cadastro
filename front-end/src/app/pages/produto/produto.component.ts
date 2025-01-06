import { CadastrarProduto } from './../../utils/interface/ICadastrarProduto';
import { Component } from '@angular/core';
import { BotaoPrincipalComponent } from "../../components/botao-principal/botao-principal.component";
import { FormControl, FormGroup, FormsModule, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MensagemErroValidacaoComponent } from "../../components/mensagem-erro-validacao/mensagem-erro-validacao.component";
import { Produtoservice } from '../../service/produto/produto.service';
import { ILogin } from '../../utils/interface/ILogin';

@Component({
  selector: 'app-produto',
  standalone: true,
  imports: [
    BotaoPrincipalComponent,
    FormsModule,
    CommonModule,
    MensagemErroValidacaoComponent
],
  templateUrl: './produto.component.html',
  styleUrl: './produto.component.scss'
})
export class ProdutoComponent {
  texto: "#ffffff" = "#ffffff";
  salvar: "#47a138" = "#47a138";
  salvar_hover: "#267c17" = "#267c17";
  atualizar: "#3498db" = "#3498db";
  atualizar_hover: "#1b689c" = "#1b689c";
  excluir: "#ff0000" = "#ff0000";
  excluir_hover: "#da0000" = "#da0000";



  constructor(private router: Router, private service: Produtoservice) {
  }

  cadastrar(form: NgForm) {
    // Marca todos os campos como 'touched' para exibir as mensagens de erro
    this.marcarCamposComoTouched(form);

    if (form.valid) {
      this.router.navigateByUrl("/vendas");
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

  listarTodosProdutos() {
    const listar =  this.service.listarTodosProdutos().subscribe();
    console.log(listar);
  }
}
