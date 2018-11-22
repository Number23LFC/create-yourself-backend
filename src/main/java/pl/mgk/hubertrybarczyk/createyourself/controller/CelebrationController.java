package pl.mgk.hubertrybarczyk.createyourself.controller;


import org.springframework.web.bind.annotation.*;
import pl.mgk.hubertrybarczyk.createyourself.model.Celebration;
import pl.mgk.hubertrybarczyk.createyourself.service.CelebrationService;

import java.util.Set;

@RestController("/celebrations")
@CrossOrigin(origins = "http://localhost:4200")
public class CelebrationController {

    private final CelebrationService celebrationService;

    public CelebrationController(CelebrationService celebrationService) {
        this.celebrationService = celebrationService;
    }

    @GetMapping
    public Set<Celebration> findAll() {
        return celebrationService.findAll();
    }

    @PostMapping
    public Celebration create(@RequestBody Celebration celebration) {
        return celebrationService.save(celebration);
    }
    
    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") Long id) {
        celebrationService.deleteId(id);
    }

    //TODO update save find etc.

}
