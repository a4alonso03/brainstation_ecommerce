package brainstation.booksapi.core.category.service.implementation;

import brainstation.booksapi.core.category.repository.CategoryRepository;
import brainstation.booksapi.core.category.service.CategoryService;
import brainstation.booksapi.model.Category.Category;
import brainstation.booksapi.model.Category.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String name) {
        CategoryDTO createdCategoryDTO = this.categoryRepository.save(new CategoryDTO(name));
        if(createdCategoryDTO != null){
            return new Category(createdCategoryDTO);
        }
        return null;
    }

    @Override
    public Category getCategoryById(Long id) {
        CategoryDTO retrievedCategoryDTO = this.categoryRepository.findById(id).orElse(null);
        if(retrievedCategoryDTO != null){
            return new Category(retrievedCategoryDTO);
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        List<CategoryDTO> categoryDTOList = this.categoryRepository.findAll();
        if(categoryDTOList != null){
            return dtoListToModelList(categoryDTOList);
        }
        return null;
    }

    private List<Category> dtoListToModelList(@NotNull List<CategoryDTO> dtoList){
        List<Category> categoryList = new ArrayList<>();
        for (CategoryDTO dto : dtoList) {
            categoryList.add(new Category(dto));
        }
        return categoryList;
    }
}
