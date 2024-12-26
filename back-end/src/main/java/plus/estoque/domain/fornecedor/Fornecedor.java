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
        private String celular;
        private String telefone;
        private String email1;
        private String email2;

        @Embedded
        private Endereco endereco;

    public Fornecedor(DadosCadastroFornecedor dados) {
            this.fornecedor = dados.fornecedor();
            this.nomeFantasia = dados.nomeFantasia();
            this.cnpj = dados.cnpj();
            this.telefone = dados.telefone();
            this.celular = dados.celular();
            this.email1 = dados.email1();
            this.email2 = dados.email2();
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
}
