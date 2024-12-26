package plus.estoque.domain.endereco;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import plus.estoque.dto.fornecedor.DadosAtualizacaoFornecedor;

import java.util.Optional;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    @Column(length = 2)
    private String uf;

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }

    public void  atualizarInformacoes(DadosEndereco dados) {
        this.logradouro = Optional.ofNullable(dados.logradouro()).orElse(this.logradouro);
        this.numero = Optional.ofNullable(dados.numero()).orElse(this.numero);
        this.complemento = Optional.ofNullable(dados.complemento()).orElse(this.complemento);
        this.cep = Optional.ofNullable(dados.cep()).orElse(this.cep);
        this.bairro = Optional.ofNullable(dados.bairro()).orElse(this.bairro);
        this.cidade = Optional.ofNullable(dados.cidade()).orElse(this.cidade);
        this.uf = Optional.ofNullable(dados.uf()).orElse(this.uf);
    }
}

























