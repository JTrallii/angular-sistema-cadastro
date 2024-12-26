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
import plus.estoque.dto.fornecedor.DadosAtualizacaoFornecedor;
import plus.estoque.dto.fornecedor.DadosCadastroFornecedor;
import plus.estoque.dto.fornecedor.DadosDetalhamentoFornecedor;
import plus.estoque.dto.fornecedor.DadosListagemFornecedor;
import plus.estoque.repository.fornecedor.FornecedorRepository;
import plus.estoque.service.fornecedor.FornecedorService;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoFornecedor> cadastrar(@RequestBody @Valid DadosCadastroFornecedor dados, UriComponentsBuilder uriBuilder) {
        Fornecedor fornecedor = fornecedorService.cadastrar(dados);

        var uri = uriBuilder.path("/fornecedores/{id}")
                .buildAndExpand(fornecedor.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoFornecedor(fornecedor));
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<DadosListagemFornecedor>> listarTodosFornecedoresAtivos() {
        List<DadosListagemFornecedor> fornecedores = fornecedorService.listarTodosFornecedoresAtivos();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemFornecedor>> listarTodosFornecedores() {
        List<DadosListagemFornecedor> fornecedores = fornecedorService.listarTodosFornecedores();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoFornecedor> detalharFornecedor(@PathVariable Long id) {
        DadosDetalhamentoFornecedor fornecedor = fornecedorService.detalhamentoFornecedor(id);
        return ResponseEntity.ok(fornecedor);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoFornecedor> atualizarFornecedor(@RequestBody @Valid DadosAtualizacaoFornecedor dados) {
        var fornecedor = fornecedorRepository.getReferenceById(dados.id());

        fornecedor.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoFornecedor(fornecedor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Fornecedor> exluir(@PathVariable Long id) {
        var fornecedor = fornecedorRepository.getReferenceById(id);

        fornecedor.excluir();
        return ResponseEntity.noContent().build();
    }

//    @GetMapping
//    public ResponseEntity<Page<DadosListagemFornecedor>>listarFornecedores(@PageableDefault(size = 10, sort = {"nomeFantasia"}) Pageable paginacao) {
//        Page<DadosListagemFornecedor> page = fornecedorService.listarFornecedores(paginacao);
//        return ResponseEntity.ok(page);
//    }

}























