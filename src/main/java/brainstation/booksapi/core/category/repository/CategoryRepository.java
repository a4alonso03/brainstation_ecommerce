package brainstation.booksapi.core.category.repository;

import brainstation.booksapi.model.Category.Category;

import brainstation.booksapi.model.Category.CategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryDTO, Long> {
    CategoryDTO getCategoryDTOByName(String name);
}
