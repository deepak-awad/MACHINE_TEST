package com.example.demo.Controller;

import com.example.demo.Dao.Category;
import com.example.demo.Service.categoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories")
public class categoryController {

    @Autowired
    private categoryService categoryService;
    
   // Ending Points to get paginated categories
    @GetMapping
    public List<Category> getPaginatedCategories(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "10") int size )
    {
        return categoryService.getCategorywithPagination(page, size);
    }
    
    // Store the category details
    @PostMapping
    public Category createCategory(@RequestBody Category category) 
    {
        return categoryService.createCategory(category);
    }

    // Get category details by id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) 
    {
        return categoryService.getCategoryById(id);
    }

    // Delete category details by id
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) 
    {
        categoryService.deleteCategoryById(id);
    }

    // Update category details by id
    @PutMapping("/{id}")
    public Category updateCategoryById(@PathVariable Long id, @RequestBody Category category)
    {
        return categoryService.updateCategoryById(id, category);
    }
    
//    @GetMapping("/all")
//  public List<Category> displayall()
//  {
//  	return categoryService.findAllCategory();
//  }
}
