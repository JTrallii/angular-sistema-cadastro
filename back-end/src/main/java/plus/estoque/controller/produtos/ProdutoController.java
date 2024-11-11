package plus.estoque.controller.produtos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import plus.estoque.domain.produtos.Produto;
import plus.estoque.dto.produtos.DadosCadastroProduto;
import plus.estoque.dto.produtos.DadosDetalhamentoProduto;
import plus.estoque.service.produtos.ProdutoService;

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

}
