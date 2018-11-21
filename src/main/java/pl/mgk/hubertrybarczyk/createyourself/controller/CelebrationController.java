package pl.mgk.hubertrybarczyk.createyourself.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mgk.hubertrybarczyk.createyourself.model.Celebration;
import pl.mgk.hubertrybarczyk.createyourself.service.CelebrationService;

import java.util.Set;

@RestController
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

    //TODO update save find etc.

}
