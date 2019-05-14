package pl.mgk.hubertrybarczyk.createyourself.service.jpa;

import org.springframework.stereotype.Service;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;
import pl.mgk.hubertrybarczyk.createyourself.repository.ObjectiveRepository;
import pl.mgk.hubertrybarczyk.createyourself.service.ObjectiveService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
//@Profile("springdatajpa")
public class ObjectiveJpaService implements ObjectiveService {

    private final ObjectiveRepository objectiveRepository;

    public ObjectiveJpaService(ObjectiveRepository objectiveRepository) {
        this.objectiveRepository = objectiveRepository;
    }

    @Override
    public Set<Objective> findAll() {
        Set<Objective> objectives = new HashSet<>();
        objectiveRepository.findAll().forEach(objectives::add);
        return objectives;
    }

    @Override
    public Objective findById(Long aLong) {
        return objectiveRepository.findById(aLong).orElse(null);
    }

    @Override
    public Objective save(Objective object) {
        return objectiveRepository.save(object);
    }

    @Override
    public void delete(Objective object) {
        objectiveRepository.delete(object);
    }

    @Override
    public void deleteId(Long aLong) {
        objectiveRepository.deleteById(aLong);
    }

    public Set<Objective> findByCategoryName(String categoryName) {
        Set<Objective> objectives = new HashSet<>();
        objectiveRepository.findAll().forEach(objectives::add);
        return objectives.stream().filter(obj -> obj.getCategory().getName().equalsIgnoreCase(categoryName)).collect(Collectors.toSet());
    }

    public Set<Todo> findTodosByObjectiveId(Long id) {
        Objective objective = objectiveRepository.findById(id).orElse(null);
        Set <Todo> todos = new HashSet<>();
        if (objective != null) {
            todos = objective.getTodos();
        }
        return todos;
    }
}
