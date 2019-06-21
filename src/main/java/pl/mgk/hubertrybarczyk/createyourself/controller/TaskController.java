package pl.mgk.hubertrybarczyk.createyourself.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mgk.hubertrybarczyk.createyourself.model.Task;
import pl.mgk.hubertrybarczyk.createyourself.service.TaskService;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public Set<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task findTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping("/tasks/{id}/done")
    public Task markAsDone(@PathVariable Long id) {
        Task task = taskService.findById(id);
        if (task != null) {
            task.setIsDone(true);
            this.taskService.save(task);
        }
        return task;
    }

    @GetMapping("/tasks/name={name}")
    public Task findByName(@PathVariable String name) {
        return taskService.findByName(name);
    }

    @GetMapping("/tasks/categories")
    public Set<String> getAllCategories() {
        Set<String> categories = new HashSet<>();
        Set<Task> allTasks = taskService.findAll();
        return allTasks.stream().map(Task::getCategory).collect(Collectors.toSet());
    }

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        System.out.println("DODAJE CEL: " + task);
        return taskService.save(task);
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<String> deleteCelebration(@PathVariable("id") Long id) {
        System.out.println("Delete Objective with ID = " + id + "...");
        taskService.deleteId(id);
        return new ResponseEntity<>("Objective has been deleted!", HttpStatus.OK);
    }
}
