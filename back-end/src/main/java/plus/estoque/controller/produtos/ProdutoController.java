package plus.estoque.controller.produtos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.dto.produtos.DadosCadastroProduto;
import plus.estoque.dto.produtos.DadosDetalhamentoProduto;
import plus.estoque.dto.produtos.DadosListagemProdutos;
import plus.estoque.service.produtos.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProduto> cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {
        Produto produto = produtoService.cadastrarProduto(dados);

        var uri = uriBuilder.path("/produtos/{id}")
                .buildAndExpand(produto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
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

}
