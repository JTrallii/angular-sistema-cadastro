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
    if (dados == null) {
      throw new IllegalArgumentException("Dados para atualização não podem ser nulos");
    }

    this.ativo = atualizarCampo(dados.ativo(), this.ativo);
    this.fornecedor = atualizarCampo(dados.fornecedor(), this.fornecedor);
    this.nomeFantasia = atualizarCampo(dados.nomeFantasia(), this.nomeFantasia);
    this.cnpj = atualizarCampo(dados.cnpj(), this.cnpj);
    this.celular = atualizarCampo(dados.celular(), this.celular);
    this.telefone = atualizarCampo(dados.telefone(), this.telefone);
    this.email1 = atualizarCampo(dados.email1(), this.email1);
    this.email2 = atualizarCampo(dados.email2(), this.email2);

    if (dados.endereco() != null) {
      this.endereco.atualizarInformacoes(dados.endereco());
    }
  }

  private <T> T atualizarCampo(T novoValor, T valorAtual) {
    return Optional.ofNullable(novoValor).orElse(valorAtual);
  }
}
