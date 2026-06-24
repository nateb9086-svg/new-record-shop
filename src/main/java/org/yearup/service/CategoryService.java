package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.Category;
import org.yearup.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CategoryService
{
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories()
    {
        // get all categories
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(int categoryId)
    {
        // get category by id
        return categoryRepository.findById(categoryId);
    }


    //public Category create(Category category)
    public Category addCategory(Category category)
    {
        // create a new category
        return categoryRepository.save(category);
    }

    public Category updateCategory(int categoryId, Category category)
    {
        // update category and return the updated category
        category.setCategoryId(categoryId);
        return categoryRepository.save(category);
    }

    public void deleteCategory(int categoryId)
    {
        // delete category
        categoryRepository.deleteById(categoryId);
    }
}