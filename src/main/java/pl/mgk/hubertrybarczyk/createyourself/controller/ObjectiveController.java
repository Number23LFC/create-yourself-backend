package pl.mgk.hubertrybarczyk.createyourself.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.mgk.hubertrybarczyk.createyourself.model.Category;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;
import pl.mgk.hubertrybarczyk.createyourself.service.CategoryService;
import pl.mgk.hubertrybarczyk.createyourself.service.ObjectiveService;

import java.io.IOException;
import java.util.Set;
import pl.mgk.hubertrybarczyk.createyourself.service.jpa.StorageService;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class ObjectiveController {

    private final ObjectiveService objectiveService;
    private final CategoryService categoryService;
    private final StorageService storageService;

    private final Path rootLocation = Paths.get("images");
    List<String> files = new ArrayList<String>();


    public ObjectiveController(ObjectiveService objectiveService, CategoryService categoryService, StorageService storageService) {
        this.objectiveService = objectiveService;
        this.categoryService = categoryService;
        this.storageService = storageService;
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
        if (objective.getFilepath() != null) {
            File initialFile = new File(rootLocation + "/" + objective.getFilepath());
            InputStream imgFile = new FileInputStream(initialFile);
            System.out.println("PATH: " + rootLocation + "/" + objective.getFilepath());
            if (imgFile != null) {
                return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(new InputStreamResource(imgFile));
            }
        }
        return null;
    }

    private static String getFileExtension(String name) {
        String extension = "";
        try {
                extension = name.substring(name.lastIndexOf("."));
        } catch (Exception e) {
            extension = "";
        }
        System.out.println("ROZSZERZENIE: " + extension);
        return extension;

    }

    @PostMapping("/objectives/{id}/image")
    public ResponseEntity<String> handleFileUpload(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            Objective objective = objectiveService.findById(id);
            String filePath = objective.getCategory().getId() + "-" + objective.getId() + getFileExtension(file.getOriginalFilename());
            objective.setFilepath(filePath);
            storageService.store(file, filePath);
            files.add(file.getOriginalFilename());
            this.objectiveService.save(objective);
            System.out.println("Zapisuje obraz dla: " + objective.getName());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
}
