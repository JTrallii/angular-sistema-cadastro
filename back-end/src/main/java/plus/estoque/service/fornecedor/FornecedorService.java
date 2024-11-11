package plus.estoque.service.fornecedor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import plus.estoque.domain.fornecedor.Fornecedor;
import plus.estoque.dto.fornecedor.DadosCadastroFornecedor;
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

    public List<DadosListagemFornecedor> converteDados(List<Fornecedor> fornecedores) {
        return fornecedores.stream()
                .map(f -> new DadosListagemFornecedor(f.getFornecedor(), f.getNomeFantasia(),
                        f.getCnpj(), f.getTelefone(), f.getCelular(), f.getEmail()))
                .collect(Collectors.toList());
    }

    public Page<DadosListagemFornecedor> listarFornecedores(Pageable paginacao) {
        return fornecedorRepository.findAll(paginacao).map(DadosListagemFornecedor::new);
    }

}





























