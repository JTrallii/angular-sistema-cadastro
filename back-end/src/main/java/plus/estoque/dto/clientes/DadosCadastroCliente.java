package plus.estoque.dto.clientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import plus.estoque.domain.endereco.DadosEndereco;

public record DadosCadastroCliente(

        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String telefone,
        @NotBlank
        String celular,
        @NotBlank
        @Email
        String email,
        @NotNull
        @Valid
        DadosEndereco endereco

) {
}
