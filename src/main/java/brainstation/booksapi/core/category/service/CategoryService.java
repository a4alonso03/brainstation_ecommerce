package brainstation.booksapi.core.category.service;

import brainstation.booksapi.model.Category.Category;
import brainstation.booksapi.model.Category.CategoryDTO;

import java.util.List;

public interface CategoryService {

    Category createCategory(String name);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();
}
