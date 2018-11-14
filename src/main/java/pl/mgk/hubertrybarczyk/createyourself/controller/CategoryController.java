package pl.mgk.hubertrybarczyk.createyourself.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.mgk.hubertrybarczyk.createyourself.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories/index";
    }

    @RequestMapping("/find")
    public String findCategory() {
        return "not_implemented";
    }

    @GetMapping("/{categoryId}")
    public ModelAndView showCategory(@PathVariable("categoryId") Long categoryId) {
        ModelAndView nav = new ModelAndView("categories/categoryDetails");
        nav.addObject(categoryService.findById(categoryId));
        return nav;
    }
}
