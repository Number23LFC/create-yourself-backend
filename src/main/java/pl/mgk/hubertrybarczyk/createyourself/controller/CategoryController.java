package pl.mgk.hubertrybarczyk.createyourself.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mgk.hubertrybarczyk.createyourself.model.Category;
import pl.mgk.hubertrybarczyk.createyourself.service.CategoryService;

import java.util.Set;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public Set<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category findCategoryById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/categories")
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping("categories/{id}")
    public ResponseEntity<String> deleteCelebration(@PathVariable("id") Long id) {
        System.out.println("Delete Celebration with ID = " + id + "...");
        categoryService.deleteId(id);
        return new ResponseEntity<>("Celebration has been deleted!", HttpStatus.OK);
    }
}
