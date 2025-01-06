import { ConsultaCepService } from '../../service/consulta-cep/consulta-cep.service';
import { Component } from '@angular/core';
import { BotaoPrincipalComponent } from '../../components/botao-principal/botao-principal.component';
import { FormsModule, NgForm, Validators } from '@angular/forms';
import { MensagemErroValidacaoComponent } from '../../components/mensagem-erro-validacao/mensagem-erro-validacao.component';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ValidaCepDirective } from '../../directives/valida-cep.directive';
import marcarCamposComoTouched from '../../utils/marcarCamposFormulario';

@Component({
  selector: 'app-cliente',
  standalone: true,
  imports: [
    BotaoPrincipalComponent,
    FormsModule,
    MensagemErroValidacaoComponent,
    CommonModule,
    ValidaCepDirective
  ],
  providers: [],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.scss',
})
export class ClienteComponent {
  texto: '#ffffff' = '#ffffff';
  salvar: '#47a138' = '#47a138';
  salvar_hover: '#267c17' = '#267c17';
  atualizar: '#3498db' = '#3498db';
  atualizar_hover: '#1b689c' = '#1b689c';
  excluir: '#ff0000' = '#ff0000';
  excluir_hover: '#da0000' = '#da0000';

  constructor(
    private router: Router,
    private ConsultaCepService: ConsultaCepService
  ) {}

  cadastrar(form: NgForm) {
    // Marca todos os campos como 'touched' para exibir as mensagens de erro
    marcarCamposComoTouched(form);

    if (form.valid) {
      this.router.navigateByUrl('/compras');
    } else {
      console.log('Formulário inválido!');
    }
  }



  consultaCep(ev: any, form: NgForm) {
    const cep = ev.target.value;
    if(cep !== "") {
      this.ConsultaCepService.consultaCep(cep).subscribe((resultado) =>
        this.ConsultaCepService.populandoEndereco(resultado, form)
      );
    }
  }


}
