


export interface CadastrarProduto {
  id: number,
  produto: string,
  fornecedor: string,
  codigo_barras: string,
  sku: string,
  estoque_minimo: number,
  estoque: number,
  unidade_medida: string,
  preco_custo: number,
  preco_venda: number,
  categoriaProduto: string,
  marca: string,
  modelo: string,
  descricao: string,
  material: string,
}
