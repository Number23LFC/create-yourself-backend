package pl.mgk.hubertrybarczyk.createyourself.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mgk.hubertrybarczyk.createyourself.model.Category;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;
import pl.mgk.hubertrybarczyk.createyourself.service.CategoryService;
import pl.mgk.hubertrybarczyk.createyourself.service.ObjectiveService;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryService categoryService;
    private final ObjectiveService objectiveService;

    public DataLoader(CategoryService categoryService, ObjectiveService objectiveService) {
        this.categoryService = categoryService;
        this.objectiveService = objectiveService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = categoryService.findAll().size();

        if (count == 0 ){
            loadData();
        }
    }

    private void loadData() {
        Category category = new Category();
        category.setName("Podróże");
        category.setDescription("Wycieczki małe i duże");

        Objective objective = new Objective();
        objective.setName("Islandia");
        objective.setDescription("Wycieczka");
        objective.setCategory(category);

        Todo todo = new Todo();
        todo.setName("Bilet");
        todo.setDone(false);
        todo.setObjective(objective);

        objective.getTodos().add(todo);
        category.getObjectives().add(objective);

        categoryService.save(category);

        Category category2 = new Category();
        category2.setName("Kariera");
        categoryService.save(category2);

        Category category3 = new Category();
        category3.setName("Sport");
        categoryService.save(category3);

        Category category4 = new Category();
        category4.setName("Finanse");
        categoryService.save(category4);

        Objective objective2 = new Objective();
        objective2.setName("Budapest");
        objective2.setDescription("Wycieczka");
        objective2.setCategory(category);
        objectiveService.save(objective2);

        System.out.println("Add data");
    }
}
