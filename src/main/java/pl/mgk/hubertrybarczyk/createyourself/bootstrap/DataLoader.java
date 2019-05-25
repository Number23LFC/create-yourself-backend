package pl.mgk.hubertrybarczyk.createyourself.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mgk.hubertrybarczyk.createyourself.model.Category;
import pl.mgk.hubertrybarczyk.createyourself.model.Celebration;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;
import pl.mgk.hubertrybarczyk.createyourself.service.CategoryService;
import pl.mgk.hubertrybarczyk.createyourself.service.CelebrationService;
import pl.mgk.hubertrybarczyk.createyourself.service.ObjectiveService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryService categoryService;
    private final ObjectiveService objectiveService;
    private final CelebrationService celebrationService;

    public DataLoader(CategoryService categoryService, ObjectiveService objectiveService, CelebrationService celebrationService) {
        this.categoryService = categoryService;
        this.objectiveService = objectiveService;
        this.celebrationService = celebrationService;
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
        category.setDescription("Description...");

        Objective objective = new Objective();
        objective.setName("Islandia");
        objective.setDescription("Wycieczka");
        objective.setCategory(category);
        objective.setFilepath("/objectives/test.jpg");
        objective.setEventDate(LocalDate.of(2018,02,20));

        Todo todo = new Todo();
        todo.setName("Bilet");
        todo.setIsDone(false);
        todo.setObjective(objective);

        Todo todo2 = new Todo();
        todo2.setName("Lot");
        todo2.setIsDone(false);
        todo2.setObjective(objective);

        objective.getTodos().add(todo);
        objective.getTodos().add(todo2);
        category.getObjectives().add(objective);

        categoryService.save(category);

        Category category2 = new Category();
        category2.setName("Kariera");
        category2.setDescription("Description 2");
        categoryService.save(category2);

        Category category3 = new Category();
        category3.setName("Sport");
        category3.setDescription("Descrption 3");
        categoryService.save(category3);

        Category category4 = new Category();
        category4.setName("Finanse");
        category4.setDescription("Description 4");
        categoryService.save(category4);

        Objective objective2 = new Objective();
        objective2.setName("Budapest");
        objective2.setDescription("Wycieczka");
        objective2.setCategory(category);
        objective2.setIsDone(true);
        objective2.setFilepath("/objectives/test2.jpg");
        objectiveService.save(objective2);

        Objective objective3 = new Objective();
        objective3.setName("Milion");
        objective3.setDescription("$$$");
        objective3.setCategory(category4);
        objective3.setFilepath("/objectives/test.jpg");
        objectiveService.save(objective3);


        try {
            Celebration c1 = new Celebration();
            c1.setDescription("Wigilia");
            c1.setDate(LocalDate.of(2018,12,24));
            System.out.println(c1.getDate() + " " + c1.getDescription());
            celebrationService.save(c1);

            Celebration c2 = new Celebration();
            c2.setDescription("Urodziny Henia");
            c2.setDate(LocalDate.of(2018,11,23));
            System.out.println(c2.getDate() + " " + c2.getDescription());
            celebrationService.save(c2);

            Celebration c3 = new Celebration();
            c3.setDescription("Urodziny Alfreda");
            c3.setDate(LocalDate.of(2018,03,22));
            System.out.println(c3.getDate() + " " + c3.getDescription());
            celebrationService.save(c3);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println("Add data");
    }
}
