package kz.iitu.demo.service;

import kz.iitu.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCategories();

    public Category findCategoryById(Long id);

    public void createCategory(Category category);

    public void updateCategory(Long id, Category category);

    public void deleteCategory(Long id);

}
