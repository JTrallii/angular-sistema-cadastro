import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ConsultaCepService {

  url_API = "https://viacep.com.br/ws/"
  constructor(private http: HttpClient) { }

  consultaCep(cep: string) {
    return this.http.get(`${this.url_API}${cep}/json`);
  }

  populandoEndereco(dados: any, form: NgForm): void {
    form.form.patchValue({
      endereco: dados.logradouro,
      bairro: dados.bairro,
      cidade: dados.localidade,
      uf: dados.uf
    });
  }
}
