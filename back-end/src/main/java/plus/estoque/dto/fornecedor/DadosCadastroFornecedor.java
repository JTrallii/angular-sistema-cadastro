package plus.estoque.dto.fornecedor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import plus.estoque.domain.endereco.DadosEndereco;

public record DadosCadastroFornecedor(

        @NotBlank
        String fornecedor,
        String nomeFantasia,
        @NotBlank
        @Pattern(regexp = "\\d{14}")
        String cnpj,
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
