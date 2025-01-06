import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ILogin } from '../../utils/interface/ILogin';

@Injectable({
  providedIn: 'root'
})
export class Produtoservice {

  private readonly API = "http://localhost:8080/login";

  constructor(private http: HttpClient) { }

  listarTodosProdutos(): Observable<ILogin> {
    return this.http.get<ILogin>(this.API)
  }

}
