package plus.estoque.dto.fornecedor;

import jakarta.validation.constraints.NotNull;
import plus.estoque.domain.endereco.DadosEndereco;
import plus.estoque.domain.endereco.Endereco;

public record DadosAtualizacaoFornecedor(
        @NotNull
        Long id,
        @NotNull
        Boolean ativo,
        String fornecedor,
        String nomeFantasia,
        String cnpj,
        String celular,
        String telefone,
        String email1,
        String email2,
        Endereco endereco
) {
}
