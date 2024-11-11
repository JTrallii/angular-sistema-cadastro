package plus.estoque.dto.fornecedor;

import plus.estoque.domain.fornecedor.Fornecedor;

public record DadosListagemFornecedor(


        String fornecedor,
        String nomeFantasia,
        String cnpj,
        String telefone,
        String celular,
        String email

) {

    public DadosListagemFornecedor(Fornecedor fornecedor) {
        this(
                fornecedor.getFornecedor(),
                fornecedor.getNomeFantasia(),
                fornecedor.getCnpj(),
                fornecedor.getTelefone(),
                fornecedor.getCelular(),
                fornecedor.getEmail()
        );
    }

}
