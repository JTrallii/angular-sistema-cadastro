import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly API = "http://localhost:8080/login";

  constructor(private http: HttpClient) { }

  efetuarLogin(credenciais: {login: string, senha: string}): Observable<any> {
    return this.http.post(this.API, credenciais);
  }

}
