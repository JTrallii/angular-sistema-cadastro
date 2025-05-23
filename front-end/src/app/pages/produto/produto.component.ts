
import { Component, OnInit } from '@angular/core';
import { BotaoPrincipalComponent } from '../../components/botao-principal/botao-principal.component';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MensagemErroValidacaoComponent } from '../../components/mensagem-erro-validacao/mensagem-erro-validacao.component';
import { Produtoservice } from '../../service/produto/produto.service';

@Component({
  selector: 'app-produto',
  standalone: true,
  imports: [
    BotaoPrincipalComponent,
    ReactiveFormsModule,
    FormsModule,
    CommonModule,
    MensagemErroValidacaoComponent,
  ],
  templateUrl: './produto.component.html',
  styleUrl: './produto.component.scss',
})
export class ProdutoComponent implements OnInit {
  texto: string = '#ffffff';
  salvar: string = '#47a138';
  salvar_hover: string = '#267c17';
  atualizar: string = '#3498db';
  atualizar_hover: string = '#1b689c';
  excluir: string = '#ff0000';
  excluir_hover: string = '#da0000';

  produtoForm!: FormGroup;

  constructor(
    private router: Router,
    private service: Produtoservice,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.produtoForm = this.fb.group({
      Produto: [""],
      cdg_barras_primeiro: [""],
      cdg_barras_segundo: ["", Validators.required],
      cdg_barras_terceiro: [""],
      fornecedor: [""],
      categoria_produto: [""],
      descricao: [""],
      estoque: [""],
      estoque_minimo: [""],
      preco_compra: [""],
      preco_venda: [""],
      sku: [""],
      und_medida: [""],
    });
  }

  teste() {
    console.log('Botão SALVAR clicado');
  }

  onSubmit() {
    // Marca todos os campos como 'touched' para exibir as mensagens de erro
    this.marcarCamposComoTouched();

    if (this.produtoForm.valid) {
      console.log(this.produtoForm.value);
      // this.router.navigate(["/vendas"]);
    } else {
      console.log('Formulário inválido!');
    }
  }

  marcarCamposComoTouched() {
    // Percorre todos os controles do formulário e marca como touched
    Object.keys(this.produtoForm.controls).forEach((field) => {
      const control = this.produtoForm.controls[field];
      control.markAsTouched();
    });
  }

  listarTodosProdutos() {
    const listar = this.service.listarTodosProdutos().subscribe();
    console.log(listar);
  }
}
