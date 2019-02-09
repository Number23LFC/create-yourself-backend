package pl.mgk.hubertrybarczyk.createyourself.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mgk.hubertrybarczyk.createyourself.model.Celebration;
import pl.mgk.hubertrybarczyk.createyourself.service.CelebrationService;

import java.util.Set;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class CelebrationController {

    private final CelebrationService celebrationService;

    public CelebrationController(CelebrationService celebrationService) {
        this.celebrationService = celebrationService;
    }

    @GetMapping("/celebrations")
    public Set<Celebration> findAll() {
        return celebrationService.findAll();
    }

    @PostMapping("/celebrations")
    public Celebration create(@RequestBody Celebration celebration) {
        return celebrationService.save(celebration);
    }

    @DeleteMapping("celebrations/{id}")
    public ResponseEntity<String> deleteCelebration(@PathVariable("id") Long id) {
        System.out.println("Delete Celebration with ID = " + id + "...");
        celebrationService.deleteId(id);
        return new ResponseEntity<>("Celebration has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/celebrations/{id}")
    public Celebration findCategoryById(@PathVariable Long id) {
        return celebrationService.findById(id);
    }

}
