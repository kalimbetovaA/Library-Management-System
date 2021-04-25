package kz.iitu.demo.service.impl;

import kz.iitu.demo.entity.Category;
import kz.iitu.demo.repository.CategoryRepository;
import kz.iitu.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }


    @Override
    public void updateCategory(Long id, Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isPresent()) {
            Category dbCategory = categoryOptional.get();
            dbCategory.setName(category.getName());

            categoryRepository.save(dbCategory);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(id);
        }
    }
}

