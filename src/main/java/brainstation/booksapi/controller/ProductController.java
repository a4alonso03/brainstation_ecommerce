package brainstation.booksapi.controller;


import brainstation.booksapi.core.product.service.ProductService;
import brainstation.booksapi.exceptions.RestExceptionInterceptor;
import brainstation.booksapi.model.Product.Product;
import brainstation.booksapi.util.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@NotNull ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse> createProduct(@Validated(RestExceptionInterceptor.class) @RequestBody Product product){
        Product createdProduct = this.productService.createProduct(product);
        if(createdProduct == null){
            return new ResponseEntity<>(new CustomResponse("Could not create product with name: " + product.getName(), null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CustomResponse("ok", createdProduct), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse> getAllProducts(Pageable pageable){
        Page<Product> productPageToReturn = this.productService.getAllProducts(pageable);
        if (productPageToReturn == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't return all products", null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CustomResponse("ok", productPageToReturn), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getProductById(@PathVariable("id")Long id){
        Product retrievedProduct = this.productService.getProductById((id));
        if(retrievedProduct == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't find product with id: " + id, null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CustomResponse("ok", retrievedProduct), HttpStatus.OK);
    }

    @GetMapping("/filter/{filter}")
    public ResponseEntity<CustomResponse> getAllProductsOfFilter(@PathVariable("filter") String filter){
        List<Product> retrievedProducts = this.productService.getAppProductsWithFilter(filter);
        if(retrievedProducts == null){
            return new ResponseEntity<>(new CustomResponse("Couldn't get all products with filter", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CustomResponse("ok", retrievedProducts), HttpStatus.OK);
    }

}
