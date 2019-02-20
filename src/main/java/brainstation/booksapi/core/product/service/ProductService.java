package brainstation.booksapi.core.product.service;

import brainstation.booksapi.model.Product.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);


}
