package brainstation.booksapi.model.Product;

import brainstation.booksapi.model.Category.Category;
import brainstation.booksapi.model.Category.CategoryDTO;
import brainstation.booksapi.model.Review.Review;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class Product {

    private long id;

    private String name;

    private Double price;

    private String image;

    private Set<Category> categories = new HashSet<>();

    private Set<Review> reviews = new HashSet<>();

    public Product() {};

    public Product(String name, Double price, String image, Set<Category> categories, Set<Review> reviews) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.categories = categories;
        this.reviews = reviews;
    }

    public Product(@NotNull ProductDTO productDTO){
        this.id = productDTO.getId();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.image = productDTO.getImage();
        for (CategoryDTO categoryDTO : productDTO.getCategories()) {
            this.categories.add(new Category(categoryDTO));
        }
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
