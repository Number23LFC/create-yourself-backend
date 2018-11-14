package pl.mgk.hubertrybarczyk.createyourself.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mgk.hubertrybarczyk.createyourself.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
