package plus.estoque.controller.fornecedor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.dto.fornecedor.DadosCadastroFornecedor;
import plus.estoque.dto.fornecedor.DadosDetalhamentoFornecedor;
import plus.estoque.dto.fornecedor.DadosListagemFornecedor;
import plus.estoque.service.fornecedor.FornecedorService;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoFornecedor> cadastrar(@RequestBody @Valid DadosCadastroFornecedor dados, UriComponentsBuilder uriBuilder) {
        Fornecedor fornecedor = fornecedorService.cadastrar(dados);

        var uri = uriBuilder.path("/fornecedores/{id}")
                .buildAndExpand(fornecedor.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoFornecedor(fornecedor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemFornecedor>>listarFornecedores(@PageableDefault(size = 10, sort = {"nomeFantasia"}) Pageable paginacao) {
        Page<DadosListagemFornecedor> page = fornecedorService.listarFornecedores(paginacao);
        return ResponseEntity.ok(page);
    }

}























