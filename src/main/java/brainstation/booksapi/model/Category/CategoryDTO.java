package brainstation.booksapi.model.Category;

import brainstation.booksapi.model.Product.ProductDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "CategoryDTO")
@Table(name = "category")
public class CategoryDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<ProductDTO> productList = new HashSet<>();

    public CategoryDTO() { }

    public CategoryDTO(Category category){
        this.name = category.getName();
    }

    public CategoryDTO(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(Set<ProductDTO> productList) {
        this.productList = productList;
    }
}
