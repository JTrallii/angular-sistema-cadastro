package plus.estoque.dto.fornecedor;

import plus.estoque.domain.fornecedor.Fornecedor;

public record DadosListagemFornecedor(

        Long id,
        String fornecedor,
        String nomeFantasia,
        String cnpj,
        String telefone,
        String celular,
        String email1,
        String email2

) {

    public DadosListagemFornecedor(Fornecedor fornecedor) {
        this(
                fornecedor.getId(),
                fornecedor.getFornecedor(),
                fornecedor.getNomeFantasia(),
                fornecedor.getCnpj(),
                fornecedor.getTelefone(),
                fornecedor.getCelular(),
                fornecedor.getEmail1(),
                fornecedor.getEmail2()
        );
    }

}
