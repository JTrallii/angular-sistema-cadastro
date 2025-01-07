import { Routes } from '@angular/router';
import { ProdutoComponent } from './pages/produto/produto.component';
import { ClienteComponent } from './pages/cliente/cliente.component';
import { FornecedorComponent } from './pages/fornecedor/fornecedor.component';
import { VendasComponent } from './pages/vendas/vendas.component';
import { CaixaComponent } from './pages/caixa/caixa.component';
import { ComprasComponent } from './pages/compras/compras.component';
import { AdministracaoComponent } from './pages/administracao/administracao.component';
import { ListaVendasProdutosComponent } from './pages/vendas/lista-vendas-produtos/lista-vendas-produtos.component';
import { NotaFiscalComponent } from './pages/compras/nota-fiscal/nota-fiscal.component';
import { PaginaPrincipalComponent } from './pages/pagina-inicial/pagina-inicial.component';

export const routes: Routes = [

  { path: "",
    redirectTo: "/home",
    pathMatch: "full"
  },
  {
    path: "home",
    component: PaginaPrincipalComponent
  },
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
    component: VendasComponent,
    children: [
      {
        path: "listar-vendas",
        component: ListaVendasProdutosComponent
      }
    ]
  },
  {
    path: "caixa",
    component: CaixaComponent
  },
  {
    path: "compras",
    component: ComprasComponent,
    children:[
      {
        path: "nota-fiscal",
        component: NotaFiscalComponent
      }
    ]
  },
  {
    path: "administracao",
    component: AdministracaoComponent
  }
];
