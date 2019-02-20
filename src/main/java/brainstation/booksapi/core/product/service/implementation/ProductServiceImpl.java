package brainstation.booksapi.core.product.service.implementation;

import brainstation.booksapi.core.product.repository.ProductRepository;
import brainstation.booksapi.core.product.service.ProductService;
import brainstation.booksapi.model.Product.Product;
import brainstation.booksapi.model.Product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        ProductDTO createdProductDTO = this.productRepository.save(new ProductDTO(product));
        if(createdProductDTO != null){
            return new Product(createdProductDTO);
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductDTO> productDTOList = this.productRepository.findAll();
        if (productDTOList != null) {
            return this.productDTOListToProductList(productDTOList);
        }
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        ProductDTO returnedProductDTO = this.productRepository.findById(id).orElse(null);
        if(returnedProductDTO != null) {
            returnedProductDTO.getCategories().size();
            return new Product(returnedProductDTO);
        }
        return null;
    }

    private List<Product> productDTOListToProductList(List<ProductDTO> dtoList) {
        List<Product> productList = new ArrayList<>();
        for (ProductDTO dto : dtoList) {
            productList.add(new Product(dto));
        }
        return productList;
    }
}
