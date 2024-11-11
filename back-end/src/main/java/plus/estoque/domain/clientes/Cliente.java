package plus.estoque.domain.clientes;

import jakarta.persistence.*;
import lombok.*;
import plus.estoque.domain.endereco.Endereco;

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
    private String nome;
    private String cpf;
    private String telefone;
    private String celular;
    private String email;

    @Embedded
    private Endereco endereco;

}
