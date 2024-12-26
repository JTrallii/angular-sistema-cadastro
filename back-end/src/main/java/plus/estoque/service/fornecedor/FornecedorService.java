package plus.estoque.service.fornecedor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.dto.fornecedor.DadosCadastroFornecedor;
import plus.estoque.dto.fornecedor.DadosDetalhamentoFornecedor;
import plus.estoque.dto.fornecedor.DadosListagemFornecedor;
import plus.estoque.repository.fornecedor.FornecedorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor cadastrar(@Valid DadosCadastroFornecedor dados) {
        var fornecedor = new Fornecedor(dados);
        fornecedorRepository.save(fornecedor);
        return fornecedor;
    }

    public List<DadosListagemFornecedor> listarTodosFornecedores() {
        return fornecedorRepository.findAll()
                .stream()
                .map(DadosListagemFornecedor::new)
                .toList();
    }

    public DadosDetalhamentoFornecedor detalhamentoFornecedor(@PathVariable Long id) {
        var fornecedor = fornecedorRepository.getReferenceById(id);
        return new DadosDetalhamentoFornecedor(fornecedor);
    }

    public Page<DadosListagemFornecedor> listarFornecedores(Pageable paginacao) {
        return fornecedorRepository.findAll(paginacao).map(DadosListagemFornecedor::new);
    }

}





























