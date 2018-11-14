package pl.mgk.hubertrybarczyk.createyourself.service.jpa;

import org.springframework.stereotype.Service;
import pl.mgk.hubertrybarczyk.createyourself.model.Category;
import pl.mgk.hubertrybarczyk.createyourself.repository.CategoryRepository;
import pl.mgk.hubertrybarczyk.createyourself.repository.ObjectiveRepository;
import pl.mgk.hubertrybarczyk.createyourself.repository.TodoRepository;
import pl.mgk.hubertrybarczyk.createyourself.service.CategoryService;

import java.util.HashSet;
import java.util.Set;

@Service
// @Profile("springdatajpa")
public class CategoryJpaService implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ObjectiveRepository objectiveRepository;
    private final TodoRepository todoRepository;

    public CategoryJpaService(CategoryRepository categoryRepository, ObjectiveRepository objectiveRepository, TodoRepository todoRepository) {
        this.categoryRepository = categoryRepository;
        this.objectiveRepository = objectiveRepository;
        this.todoRepository = todoRepository;
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Set<Category> findAll() {
        Set<Category> owners = new HashSet<>();
        categoryRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Category findById(Long aLong) {
        return categoryRepository.findById(aLong).orElse(null);
    }

    @Override
    public Category save(Category object) {
        return categoryRepository.save(object);
    }

    @Override
    public void delete(Category object) {
        categoryRepository.delete(object);
    }

    @Override
    public void deleteId(Long aLong) {
        categoryRepository.deleteById(aLong);
    }
}
