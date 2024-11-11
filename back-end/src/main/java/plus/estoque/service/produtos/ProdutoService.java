package plus.estoque.service.produtos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.dto.produtos.DadosAtualizarProduto;
import plus.estoque.dto.produtos.DadosCadastroProduto;
import plus.estoque.dto.produtos.DadosDetalhamentoProduto;
import plus.estoque.dto.produtos.DadosListagemProdutos;
import plus.estoque.repository.produtos.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados) {
        var produto = new Produto(dados);
        produtoRepository.save(produto);
        return produto;
    }

    public List<DadosListagemProdutos> listarProdutos() {
        return produtoRepository.findAll()
                .stream()
                .map(DadosListagemProdutos::new)
                .toList();
    }

    public Produto atualizarProduto(@RequestBody @Valid DadosAtualizarProduto dados) {
        var produto = produtoRepository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);
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

    public DadosDetalhamentoProduto detalharProduto(@PathVariable Long id) {
        var produto = produtoRepository.getReferenceById(id);
        return new DadosDetalhamentoProduto(produto);
    }

}






























