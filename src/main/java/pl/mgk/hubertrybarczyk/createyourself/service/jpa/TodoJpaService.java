package pl.mgk.hubertrybarczyk.createyourself.service.jpa;

import org.springframework.stereotype.Service;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;
import pl.mgk.hubertrybarczyk.createyourself.repository.ObjectiveRepository;
import pl.mgk.hubertrybarczyk.createyourself.repository.TodoRepository;
import pl.mgk.hubertrybarczyk.createyourself.service.TodoService;

import java.util.HashSet;
import java.util.Set;

@Service
//@Profile("springdatajpa")
public class TodoJpaService implements TodoService {
    
    private final TodoRepository todoRepository;
    private final ObjectiveRepository objectiveRepository;

    public TodoJpaService(TodoRepository TodoRepository, ObjectiveRepository objectiveRepository) {
        this.todoRepository = TodoRepository;
        this.objectiveRepository = objectiveRepository;
    }

    @Override
    public Set<Todo> findAll() {
        Set<Todo> todos = new HashSet<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    public Set<Todo> findByObjective(Long id) {
        Objective objective = objectiveRepository.findById(id).orElse(null);
        Set<Todo> todos = objective.getTodos();
        return todos;
    }

    @Override
    public Todo findById(Long aLong) {
        return todoRepository.findById(aLong).orElse(null);
    }

    @Override
    public Todo save(Todo object) {
        return todoRepository.save(object);
    }

    @Override
    public void delete(Todo object) {
        todoRepository.delete(object);
    }

    @Override
    public void deleteId(Long aLong) {
        todoRepository.deleteById(aLong);
    }

    public Set<Todo> findByObjective(Objective objective) {
        return todoRepository.findAllByObjective(objective);
    }
}
