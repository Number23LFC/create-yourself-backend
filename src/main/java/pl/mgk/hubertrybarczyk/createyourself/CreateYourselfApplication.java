package pl.mgk.hubertrybarczyk.createyourself;

import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mgk.hubertrybarczyk.createyourself.service.jpa.StorageService;

@SpringBootApplication
public class CreateYourselfApplication {

    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(CreateYourselfApplication.class, args);
    }

    public void run(String... arg) throws Exception {
        storageService.init();
    }
}
