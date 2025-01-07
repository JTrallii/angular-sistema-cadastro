import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { MenuPrincipalComponent } from './components/menu-principal/menu-principal.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PaginaPrincipalComponent } from "./pages/pagina-inicial/pagina-inicial.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HeaderComponent,
    FooterComponent,
    MenuPrincipalComponent,
    CommonModule,
    FormsModule,
    PaginaPrincipalComponent
],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'sistema-cadastro';
  loginEfetuado: boolean = false;

  mostrarMenu(status: boolean): void {
    this.loginEfetuado = status;
  }
}
