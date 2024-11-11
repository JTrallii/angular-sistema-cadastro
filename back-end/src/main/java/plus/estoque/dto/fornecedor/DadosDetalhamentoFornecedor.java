package plus.estoque.dto.fornecedor;

import jakarta.persistence.Embedded;
import plus.estoque.domain.endereco.DadosEndereco;
import plus.estoque.domain.endereco.Endereco;
import plus.estoque.domain.fornecedor.Fornecedor;

public record DadosDetalhamentoFornecedor(

        Long id,
        String fornecedor,
        String nomeFantasia,
        String cnpj,
        String telefone,
        String celular,
        String email,

        Endereco endereco

) {

    public DadosDetalhamentoFornecedor(Fornecedor fornecedor) {
        this(fornecedor.getId(), fornecedor.getFornecedor(), fornecedor.getNomeFantasia(), fornecedor.getCnpj(), fornecedor.getTelefone(), fornecedor.getCelular(),
                fornecedor.getEmail(), fornecedor.getEndereco());
    }



}
