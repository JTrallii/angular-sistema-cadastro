package plus.estoque.service.produtos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.dto.produtos.DadosAtualizarProduto;
import plus.estoque.dto.produtos.DadosCadastroProduto;
import plus.estoque.dto.produtos.DadosDetalhamentoProduto;
import plus.estoque.dto.produtos.DadosListagemProdutos;
import plus.estoque.repository.fornecedor.FornecedorRepository;
import plus.estoque.repository.produtos.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Produto cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados) {
        //Procura o fornecedor pelo nome passado no cadastro do produto, achando ele, retorna o
        //fornecedor com todos os seus atributos
        Fornecedor fornecedor = fornecedorRepository.findByFornecedor(dados.fornecedor())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado !"));

        Produto produto = new Produto(dados);
        produto.setAtivo(true);
        produto.setFornecedor(fornecedor);  // Associando o fornecedor encontrado

        produtoRepository.save(produto);
        String codigo_interno = String.format("%04d", produto.getId());
        produto.setCodigo_interno(codigo_interno);

        return produtoRepository.save(produto);
    }

    public List<DadosListagemProdutos> listarTodosProdutosAtivos() {
        return produtoRepository.findAllByAtivoTrue() // Retorna Optional<List<Produto>>
                .orElse(List.of()) // Substitui por uma lista vazia caso esteja vazio
                .stream() // Converte a lista em um stream
                .map(DadosListagemProdutos::new) // Mapeia Produto para DadosListagemProdutos
                .toList(); // Converte de volta para lista
    }

    public List<DadosListagemProdutos> listarTodosProdutos() {
        return produtoRepository.findAll() // Retorna Optional<List<Produto>>
                .stream() // Converte a lista em um stream
                .map(DadosListagemProdutos::new) // Mapeia Produto para DadosListagemProdutos
                .toList(); // Converte de volta para lista
    }


    public DadosDetalhamentoProduto detalharProduto(@PathVariable Long id) {
        var produto = produtoRepository.getReferenceById(id);
        return new DadosDetalhamentoProduto(produto);
    }

    public Produto atualizarProduto(@RequestBody @Valid DadosAtualizarProduto dados) {
        var produto = produtoRepository.getReferenceById(dados.id());

        Fornecedor fornecedor = fornecedorRepository.findByFornecedor(dados.fornecedor())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado !"));

        produto.atualizarInformacoes(dados);
        produto.setFornecedor(fornecedor);
        return produto;
    }

    public void excluirProduto(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            Produto produtoExcluido = produto.get();
            produtoExcluido.setAtivo(false);
            produtoRepository.save(produtoExcluido);
        }
    }



}






























