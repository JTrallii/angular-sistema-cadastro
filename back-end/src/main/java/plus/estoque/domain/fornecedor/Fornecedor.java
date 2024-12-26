package plus.estoque.domain.fornecedor;

import jakarta.persistence.*;
import lombok.*;
import plus.estoque.domain.endereco.DadosEndereco;
import plus.estoque.domain.endereco.Endereco;
import plus.estoque.dto.fornecedor.DadosAtualizacaoFornecedor;
import plus.estoque.dto.fornecedor.DadosCadastroFornecedor;

import java.util.Optional;

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
        private Boolean ativo;
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

    public void atualizarInformacoes(DadosAtualizacaoFornecedor dados) {
            this.fornecedor = Optional.ofNullable(dados.fornecedor()).orElse(this.fornecedor);
            this.nomeFantasia = Optional.ofNullable(dados.nomeFantasia()).orElse(this.nomeFantasia);
            this.cnpj = Optional.ofNullable(dados.cnpj()).orElse(this.cnpj);
            this.telefone = Optional.ofNullable(dados.telefone()).orElse(this.telefone);
            this.celular = Optional.ofNullable(dados.celular()).orElse(this.celular);
            this.email1 = Optional.ofNullable(dados.email1()).orElse(this.email1);
            this.email2 = Optional.ofNullable(dados.email2()).orElse(this.email2);
            this.endereco = Optional.ofNullable(dados.endereco()).orElse(this.endereco);
    }

        public void excluir() {
            this.ativo = false;
        }
}
