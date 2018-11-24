package pl.mgk.hubertrybarczyk.createyourself.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.service.ObjectiveService;

import java.util.Set;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class ObjectiveController {

    private final ObjectiveService objectiveService;

    public ObjectiveController(ObjectiveService objectiveService) {
        this.objectiveService = objectiveService;
    }

    @GetMapping("/objectives")
    public Set<Objective> findAll() {
        return objectiveService.findAll();
    }

    @PostMapping("/objectives")
    public Objective create(@RequestBody Objective objective) {
        return objectiveService.save(objective);
    }

    @DeleteMapping("objectives/{id}")
    public ResponseEntity<String> deleteCelebration(@PathVariable("id") Long id) {
        System.out.println("Delete Objective with ID = " + id + "...");
        objectiveService.deleteId(id);
        return new ResponseEntity<>("Objective has been deleted!", HttpStatus.OK);
    }

}
