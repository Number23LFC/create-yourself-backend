package pl.mgk.hubertrybarczyk.createyourself.controller;


import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.mgk.hubertrybarczyk.createyourself.model.Category;
import pl.mgk.hubertrybarczyk.createyourself.model.Celebration;
import pl.mgk.hubertrybarczyk.createyourself.service.CategoryService;
import sun.util.resources.cldr.teo.CalendarData_teo_KE;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public Set<Category> findAll() {
        return categoryService.findAll();
    }

    @PostMapping("/categories")
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }
}
