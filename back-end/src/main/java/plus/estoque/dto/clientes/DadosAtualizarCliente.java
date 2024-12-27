package plus.estoque.dto.clientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import plus.estoque.domain.endereco.DadosEndereco;
import plus.estoque.domain.endereco.Endereco;

public record DadosAtualizarCliente(

        @NotNull
        Long id,
        @NotNull
        Boolean ativo,
        String nome,
        String rg,
        String cpf,
        String telefone,
        String celular,
        String email1,
        String email2,
        @Valid
        DadosEndereco endereco
) {
}
