package plus.estoque.domain.clientes;

import jakarta.persistence.*;
import lombok.*;
import plus.estoque.domain.endereco.Endereco;
import plus.estoque.dto.clientes.DadosAtualizarCliente;
import plus.estoque.dto.clientes.DadosCadastroCliente;

import java.util.Optional;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String cpf;
    private String rg;
    private String celular;
    private String telefone;
    private String email1;
    private String email2;

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.rg = dados.rg();
        this.celular = dados.celular();
        this.telefone = dados.telefone();
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

    public void atualizarInformacoes(DadosAtualizarCliente dados) {
        if (dados == null) {
            throw new IllegalArgumentException("Dados para atualização não podem ser nulos");
        }

        this.ativo = atualizarCampo(dados.ativo(), this.ativo);
        this.nome = atualizarCampo(dados.nome(), this.nome);
        this.cpf = atualizarCampo(dados.cpf(), this.cpf);
        this.rg = atualizarCampo(dados.rg(), this.rg);
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

























