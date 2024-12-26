package plus.estoque.controller.produtos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.dto.produtos.DadosAtualizarProduto;
import plus.estoque.dto.produtos.DadosCadastroProduto;
import plus.estoque.dto.produtos.DadosDetalhamentoProduto;
import plus.estoque.dto.produtos.DadosListagemProdutos;
import plus.estoque.repository.produtos.ProdutoRepository;
import plus.estoque.service.produtos.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProduto> cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {
        Produto produto = produtoService.cadastrarProduto(dados);

        var uri = uriBuilder.path("/produtos/{id}")
                .buildAndExpand(produto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<DadosListagemProdutos>> listarTodosProdutosAtivos() {
        List<DadosListagemProdutos> produtos = produtoService.listarTodosProdutosAtivos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemProdutos>> listarTodosProdutos() {
        List<DadosListagemProdutos> produtos = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoProduto> detalharProduto(@PathVariable Long id) {
        DadosDetalhamentoProduto produto = produtoService.detalharProduto(id);

        return ResponseEntity.ok(produto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProduto> atualizar(@RequestBody @Valid DadosAtualizarProduto dados) {
        var produto = produtoRepository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Produto> excluir(@PathVariable Long id) {
        var produto = produtoRepository.getReferenceById(id);
        produto.excluir();

        return ResponseEntity.noContent().build();
    }

}






























