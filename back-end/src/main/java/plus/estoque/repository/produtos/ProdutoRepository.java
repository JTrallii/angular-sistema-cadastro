package plus.estoque.repository.produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import plus.estoque.domain.produtos.Produto;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findById(Long id);
}
