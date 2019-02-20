package brainstation.booksapi.model.Category;

import brainstation.booksapi.exceptions.CustomRestExceptionHandler;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


public class Category {

    private long id;

    @NotNull(groups = {CustomRestExceptionHandler.class}, message = "A name is required when creating a category")
    private String name;

    public long getId() {
        return id;
    }

    public Category(){}

    public Category(CategoryDTO dto){
        this.name = dto.getName();
    }

    public Category(String name) {
        this.name = name;
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
}
