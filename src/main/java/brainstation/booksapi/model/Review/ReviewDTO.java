package brainstation.booksapi.model.Review;

import brainstation.booksapi.model.Product.Product;
import brainstation.booksapi.model.Product.ProductDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "ReviewDTO")
@Table(name = "product_review")
public class ReviewDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * El join column es a la columna de mi tabla
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductDTO productDTO;

    private String title;

    private String text;

    private Double score;

    public ReviewDTO() {}

    public ReviewDTO(@NotNull Review review){
        this.id = review.getId();
        //this.productDTO = new ProductDTO(review.getProduct());
        this.title = review.getTitle();
        this.text = review.getText();
        this.score = review.getScore();
    }

    public ReviewDTO(Product product, String title, String text, Double score) {
        this.productDTO = new ProductDTO(product);
        this.title = title;
        this.text = text;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return productDTO;
    }

    public void setProduct(ProductDTO product) {
        this.productDTO = product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
