package plus.estoque.dto.clientes;

import plus.estoque.domain.clientes.Cliente;
import plus.estoque.domain.fornecedor.Fornecedor;

public record DadosListagemClientes(
        Long id,
        Boolean ativo,
        String nome,
        String cpf,
        String rg,
        String celular,
        String telefone,
        String email1,
        String email2
) {
    public DadosListagemClientes(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getAtivo(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getRg(),
                cliente.getTelefone(),
                cliente.getCelular(),
                cliente.getEmail1(),
                cliente.getEmail2()
        );
    }
}
