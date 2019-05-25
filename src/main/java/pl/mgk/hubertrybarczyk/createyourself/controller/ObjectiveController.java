package pl.mgk.hubertrybarczyk.createyourself.controller;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mgk.hubertrybarczyk.createyourself.model.Category;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;
import pl.mgk.hubertrybarczyk.createyourself.service.CategoryService;
import pl.mgk.hubertrybarczyk.createyourself.service.ObjectiveService;

import java.io.IOException;
import java.util.Set;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class ObjectiveController {

    private final ObjectiveService objectiveService;
    private final CategoryService categoryService;

    public ObjectiveController(ObjectiveService objectiveService, CategoryService categoryService) {
        this.objectiveService = objectiveService;
        this.categoryService = categoryService;
    }

    @GetMapping("/objectives")
    public Set<Objective> findAll() {
        return objectiveService.findAll();
    }

    @GetMapping("/objectives/{id}")
    public Objective findObjectiveById(@PathVariable Long id) {
        return objectiveService.findById(id);
    }

    @GetMapping("/objectives/{id}/done")
    public Objective markAsDone(@PathVariable Long id) {
        Objective objective =  objectiveService.findById(id);
        objective.getTodos().forEach(todo -> todo.setIsDone(true));
        objective.setIsDone(true);
        this.objectiveService.save(objective);
        return objective;
    }

    @GetMapping("/objectives/category={name}")
    public Set<Objective> findByCategoryName(@PathVariable String name) {
        return objectiveService.findByCategoryName(name);
    }

    @PostMapping("/objectives")
    public Objective create(@RequestBody Objective objective) {
        System.out.println("DODAJE CEL: " + objective);
        System.out.println("TODOSY: " + objective.getTodos().toString());
        objective.getTodos().forEach(todo -> System.out.println(todo.getName() + " " + todo.getIsDone()));
        objective.getTodos().forEach(todo -> todo.setObjective(objective));
        Category category = categoryService.findByName(objective.getCategory().getName());
        objective.setCategory(category);
        //objective.setEventDate(objective.getEventDate().plusDays(1));
        return objectiveService.save(objective);
    }

    @DeleteMapping("objectives/{id}")
    public ResponseEntity<String> deleteCelebration(@PathVariable("id") Long id) {
        System.out.println("Delete Objective with ID = " + id + "...");
        objectiveService.deleteId(id);
        return new ResponseEntity<>("Objective has been deleted!", HttpStatus.OK);
    }

    @GetMapping("objectives/stats")
    public double doneObjectives() {
        double all = objectiveService.findAll().stream().count();
        double done = objectiveService.findAll().stream().filter(objective -> objective.isDone()).count();
        System.out.println("ALL: " + all);
        System.out.println("DONE: " + done);
        return (done/all * 100);
    }

    @GetMapping("objectives/stats/todo")
    public double todoObjectives() {
        double all = objectiveService.findAll().stream().count();
        double done = objectiveService.findAll().stream().filter(objective -> objective.isDone()).count();
        System.out.println("ALL: " + all);
        System.out.println("DONE: " + done);
        double notDone = all - done;
        return notDone;
    }


    @GetMapping("objectives/stats/all")
    public double allObjectives() {
        double all = objectiveService.findAll().stream().count();
        System.out.println("ALL: " + all);
        return (all);
    }

    @GetMapping("/objectives/{id}/todos")
    public Set<Todo> getAllObjectiveTodos(@PathVariable("id") Long id) {
        return objectiveService.findTodosByObjectiveId(id);
    }

    @GetMapping(value = "/objectives/{id}/image")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("id") Long id) throws IOException {
        Objective objective = objectiveService.findById(id);
        System.out.println("Pobieram obraz dla: " + objective.getName());
        //ClassPathResource imgFile = new ClassPathResource("images/objectives/test.jpg");
        ClassPathResource imgFile = new ClassPathResource("images/" + objective.getFilepath());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }
}
