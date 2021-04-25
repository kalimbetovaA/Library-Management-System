package kz.iitu.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.iitu.demo.entity.Category;
import kz.iitu.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
@Api(value = "Category Controller", description = "Controller that allows to interact with Category object")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "To get all Categories from the database", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("")
    public List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @ApiOperation(value = "To get specific Category by its Id", response = Category.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Category object"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }


    @ApiOperation(value = "To Create a new Category in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    }
    )
    @PostMapping("")
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }

    @ApiOperation(value = "To Update Category by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Category category) {
        categoryService.updateCategory(id, category);
    }

    @ApiOperation(value = "To Delete a Category by its Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }


}
