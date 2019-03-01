package brainstation.booksapi.core.product.service;

import brainstation.booksapi.model.Product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Page<Product> getAllProducts(Pageable page);

    Product getProductById(Long id);

    List<Product> getAppProductsWithFilter(String filter);
}
