package brainstation.booksapi.model.Review;

import brainstation.booksapi.model.Product.Product;

import javax.validation.constraints.NotNull;

public class Review {

    private Long id;

    private Product product;

    private String title;

    private String text;

    private double score;

    public Review() {}

    public Review(Product product,String title, String text, Double score) {
        this.product = product;
        this.title = title;
        this.text = text;
        this.setScore(score);
    }

    public Review(@NotNull ReviewDTO reviewDTO){
        this.id = reviewDTO.getId();
        this.product = new Product(reviewDTO.getProduct());
        this.title = reviewDTO.getTitle();
        this.text = reviewDTO.getText();
        this.score = reviewDTO.getScore();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setProduct(Product product) {
        this.product = product;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
