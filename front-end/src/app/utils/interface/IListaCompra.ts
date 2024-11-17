import { Produto, ProdutoSimplificado } from "./IProduto";



export interface ListaCompra {
  produto: ProdutoSimplificado;
  quantidade: number;
  valor_total_item: number;
}
