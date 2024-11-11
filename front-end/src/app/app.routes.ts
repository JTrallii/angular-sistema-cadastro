import { Routes } from '@angular/router';
import { ProdutoComponent } from './pages/produto/produto.component';
import { ClienteComponent } from './pages/cliente/cliente.component';
import { FornecedorComponent } from './pages/fornecedor/fornecedor.component';
import { VendasComponent } from './pages/vendas/vendas.component';
import { CaixaComponent } from './pages/caixa/caixa.component';
import { ComprasComponent } from './pages/compras/compras.component';
import { AdministracaoComponent } from './pages/administracao/administracao.component';

export const routes: Routes = [
  {
    path: "produtos",
    component: ProdutoComponent
  },
  {
    path: "cliente",
    component: ClienteComponent
  },
  {
    path: "fornecedor",
    component: FornecedorComponent
  },
  {
    path: "vendas",
    component: VendasComponent
  },
  {
    path: "caixa",
    component: CaixaComponent
  },
  {
    path: "compras",
    component: ComprasComponent
  },
  {
    path: "administracao",
    component: AdministracaoComponent
  }
];
