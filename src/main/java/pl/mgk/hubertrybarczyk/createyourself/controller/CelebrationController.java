package pl.mgk.hubertrybarczyk.createyourself.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mgk.hubertrybarczyk.createyourself.service.CelebrationService;

@Controller
@RequestMapping("/celebration")
public class CelebrationController {

    private final CelebrationService celebrationService;

    public CelebrationController(CelebrationService celebrationService) {
        this.celebrationService = celebrationService;
    }


}
