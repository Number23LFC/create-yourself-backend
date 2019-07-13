package pl.mgk.hubertrybarczyk.createyourself.controller;


import java.time.LocalDate;
import java.util.Date;
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
        updateAllCelebrationsDate();
        return celebrationService.findAll();
    }

    private void updateAllCelebrationsDate() {
        Set<Celebration> allCelebrations = celebrationService.findAll();
        for (Celebration celebration : allCelebrations) {
            LocalDate celbrationDate = celebration.getDate();
            celbrationDate = celbrationDate.withYear(LocalDate.now().getYear());
            celebration.setDate(celbrationDate);
            boolean isDone = celbrationDate.isBefore(LocalDate.now());
            celebration.setDone(isDone);
            celebrationService.save(celebration);
        }
    }

    @PostMapping("/celebrations")
    public Celebration create(@RequestBody Celebration celebration) {
        boolean isDone = celebration.getDate().isBefore(LocalDate.now());
        LocalDate updatedDate = celebration.getDate().plusDays(1);
        celebration.setDone(isDone);
        celebration.setDate(updatedDate);
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
