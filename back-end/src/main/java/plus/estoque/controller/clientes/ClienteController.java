package plus.estoque.controller.clientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import plus.estoque.domain.clientes.Cliente;
import plus.estoque.dto.clientes.DadosAtualizarCliente;
import plus.estoque.dto.clientes.DadosCadastroCliente;
import plus.estoque.dto.clientes.DadosListagemClientes;
import plus.estoque.service.clientes.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemClientes> cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
        Cliente cliente = clienteService.cadastrar(dados);

        var uri = uriBuilder.path("/clientes/id")
            .buildAndExpand(cliente.getId())
            .toUri();

        return ResponseEntity.created(uri).body(new DadosListagemClientes(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemClientes> detalharCliente(@PathVariable Long id) {
        DadosListagemClientes cliente = clienteService.detalharCliente(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemClientes>> listarTodosClientes() {
        List<DadosListagemClientes> clientes = clienteService.listarTodosClientes();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<DadosListagemClientes>> listarTodosClientesAtivos() {
        List<DadosListagemClientes> clientes = clienteService.listarTodosClientesAtivo();

        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosListagemClientes> atualizarCliente(@RequestBody @Valid DadosAtualizarCliente dados) {
        var cliente = clienteService.atualizarCliente(dados);

        return ResponseEntity.ok(new DadosListagemClientes(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Cliente> excluir(@PathVariable Long id) {
        clienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}

















