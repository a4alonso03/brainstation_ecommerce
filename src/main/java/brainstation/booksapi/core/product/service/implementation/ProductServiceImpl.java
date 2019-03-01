package brainstation.booksapi.core.product.service.implementation;

import brainstation.booksapi.core.category.repository.CategoryRepository;
import brainstation.booksapi.core.product.repository.ProductRepository;
import brainstation.booksapi.core.product.service.ProductService;
import brainstation.booksapi.model.Category.Category;
import brainstation.booksapi.model.Category.CategoryDTO;
import brainstation.booksapi.model.Product.Product;
import brainstation.booksapi.model.Product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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
    public Page<Product> getAllProducts(Pageable page) {
        return this.productRepository.findAll(page).map(Product::new);
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

    @Override
    public List<Product> getAppProductsWithFilter(String filter) {
        CategoryDTO categoryDTO = this.categoryRepository.getCategoryDTOByName(filter);
        categoryDTO.getProductList().size();
        Set<ProductDTO> productDTOList = categoryDTO.getProductList();
        List<Product> products = new LinkedList<>();
        for (ProductDTO productDTO : productDTOList) {
            products.add(new Product(productDTO));
        }

        return products;
    }
}
