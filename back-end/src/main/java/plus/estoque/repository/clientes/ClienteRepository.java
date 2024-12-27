package plus.estoque.repository.clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import plus.estoque.domain.clientes.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<List<Cliente>> findAllByAtivoTrue();

}
