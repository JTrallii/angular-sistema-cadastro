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
        String email1,
        String email2,

        Endereco endereco

) {

    public DadosDetalhamentoFornecedor(Fornecedor fornecedor) {
        this(fornecedor.getId(), fornecedor.getFornecedor(), fornecedor.getNomeFantasia(), fornecedor.getCnpj(), fornecedor.getTelefone(), fornecedor.getCelular(),
                fornecedor.getEmail1(), fornecedor.getEmail2(), fornecedor.getEndereco());
    }



}
