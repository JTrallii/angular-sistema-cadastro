package plus.estoque.service.clientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import plus.estoque.domain.clientes.Cliente;
import plus.estoque.dto.clientes.DadosAtualizarCliente;
import plus.estoque.dto.clientes.DadosCadastroCliente;
import plus.estoque.dto.clientes.DadosListagemClientes;
import plus.estoque.repository.clientes.ClienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente cadastrar(@RequestBody @Valid DadosCadastroCliente dados) {
        Cliente cliente = new Cliente(dados);
        clienteRepository.save(cliente);
        return cliente;
    }

    public DadosListagemClientes detalharCliente(@PathVariable Long id) {
        var cliente = clienteRepository.getReferenceById(id);
        return new DadosListagemClientes(cliente);
    }

    public List<DadosListagemClientes> listarTodosClientes() {
        return clienteRepository.findAll()
          .stream()
          .map(DadosListagemClientes::new)
          .toList();

    }

    public List<DadosListagemClientes> listarTodosClientesAtivo() {
        return clienteRepository.findAllByAtivoTrue()
          .orElse(List.of())
          .stream()
          .map(DadosListagemClientes::new)
          .toList();
    }

    public Cliente atualizarCliente(@RequestBody @Valid DadosAtualizarCliente dados) {
        var cliente = clienteRepository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
        return cliente;
    }

    public void excluir(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if (cliente.isPresent()) {
            Cliente clienteExcluido = cliente.get();
            clienteExcluido.setAtivo(false);
            clienteRepository.save(clienteExcluido);
        }
    }
}


























