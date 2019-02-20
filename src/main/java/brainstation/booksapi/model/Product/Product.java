package brainstation.booksapi.model.Product;

import brainstation.booksapi.model.Category.Category;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private long id;

    private String name;

    private Double price;

    private String image;

    private List<Category> categories = new ArrayList<>();

    public Product() {};

    public Product(String name, Double price, String image, List<Category> categories) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.categories = categories;
    }

    public Product(@NotNull ProductDTO productDTO){
        this.id = productDTO.getId();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.image = productDTO.getImage();
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
