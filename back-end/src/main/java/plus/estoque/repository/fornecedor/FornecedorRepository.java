package plus.estoque.repository.fornecedor;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import plus.estoque.domain.fornecedor.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
