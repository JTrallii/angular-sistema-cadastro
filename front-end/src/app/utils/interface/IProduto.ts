

export interface Produto {
  id?: number;
  nome: string;
  preco: number;
  estoque: number;
}

export interface ProdutoSimplificado {
  nome: string;
  preco: number;
}

export interface ItemDeCompra {
  produto: ProdutoSimplificado;
  quantidade: number;
}
