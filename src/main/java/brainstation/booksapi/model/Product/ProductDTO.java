package brainstation.booksapi.model.Product;

import brainstation.booksapi.model.Category.CategoryDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ProductDTO")
@Table(name = "product")
public class ProductDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Double price;

    private String image;

    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = {@JoinColumn(referencedColumnName = "id")},
                                    inverseJoinColumns = {@JoinColumn (referencedColumnName = "id")})
    private Set<CategoryDTO> categories = new HashSet<>();

    public ProductDTO (){}

    public ProductDTO(Product product){
        this.name = product.getName();
        this.price = product.getPrice();
        this.image = product.getImage();
    }

    public ProductDTO(String name, Double price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDTO> categories) {
        this.categories = categories;
    }
}
