package pl.mgk.hubertrybarczyk.createyourself.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mgk.hubertrybarczyk.createyourself.model.Celebration;

public interface CelebrationRepository extends CrudRepository<Celebration, Long> {
}