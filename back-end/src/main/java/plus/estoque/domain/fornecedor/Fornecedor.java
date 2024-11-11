package plus.estoque.domain.fornecedor;

import jakarta.persistence.*;
import lombok.*;
import plus.estoque.domain.endereco.Endereco;
import plus.estoque.dto.fornecedor.DadosCadastroFornecedor;

@Table(name = "fornecedores")
@Entity(name = "Fornecedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fornecedor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String fornecedor;
        private String nomeFantasia;
        private String cnpj;
        private String telefone;
        private String celular;
        private String email;

        @Embedded
        private Endereco endereco;

    public Fornecedor(DadosCadastroFornecedor dados) {
            this.fornecedor = dados.fornecedor();
            this.nomeFantasia = dados.nomeFantasia();
            this.cnpj = dados.cnpj();
            this.telefone = dados.telefone();
            this.celular = dados.celular();
            this.email = dados.email();
            this.endereco = new Endereco(
                    dados.endereco().logradouro(),
                    dados.endereco().bairro(),
                    dados.endereco().cep(),
                    dados.endereco().numero(),
                    dados.endereco().complemento(),
                    dados.endereco().cidade(),
                    dados.endereco().uf()
            );
    }

        @Override
        public String toString() {
                return "Fornecedor{" +
                        "id=" + id +
                        ", fornecedor='" + fornecedor + '\'' +
                        ", nomeFantasia='" + nomeFantasia + '\'' +
                        ", cnpj='" + cnpj + '\'' +
                        ", telefone='" + telefone + '\'' +
                        ", celular='" + celular + '\'' +
                        ", email='" + email + '\'' +
                        ", endereco=" + endereco +
                        '}';
        }
}
