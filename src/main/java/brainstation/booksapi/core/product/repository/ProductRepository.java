package brainstation.booksapi.core.product.repository;

import brainstation.booksapi.model.Product.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDTO, Long> {



}
