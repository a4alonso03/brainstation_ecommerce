package brainstation.booksapi.model.Product;

import brainstation.booksapi.model.Category.Category;
import brainstation.booksapi.model.Category.CategoryDTO;
import brainstation.booksapi.model.Review.Review;
import brainstation.booksapi.model.Review.ReviewDTO;
import brainstation.booksapi.model.UserAddress.UserAddressDTO;

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

    /**
     * el name es de la tabla intermedia
     * el join column es con el name de la columna (lo importante fué el parámetro name)
     */
    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private Set<CategoryDTO> categories = new HashSet<>();

    /**
     * El mapped by es al atributo de clase del otro lado
     */
    @OneToMany(orphanRemoval = true, mappedBy = "productDTO")
    private Set<ReviewDTO> reviews = new HashSet<>();


    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.image = product.getImage();
        for (Category category : product.getCategories()) {
            this.categories.add(new CategoryDTO(category));
        }
        for (Review review : product.getReviews()) {
            this.reviews.add(new ReviewDTO(review));
        }

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

    public Set<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewDTO> reviews) {
        this.reviews = reviews;
    }

}
