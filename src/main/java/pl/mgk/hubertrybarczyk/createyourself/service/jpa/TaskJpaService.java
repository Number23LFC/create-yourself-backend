package pl.mgk.hubertrybarczyk.createyourself.service.jpa;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import pl.mgk.hubertrybarczyk.createyourself.model.Objective;
import pl.mgk.hubertrybarczyk.createyourself.model.Task;
import pl.mgk.hubertrybarczyk.createyourself.model.Todo;
import pl.mgk.hubertrybarczyk.createyourself.repository.ObjectiveRepository;
import pl.mgk.hubertrybarczyk.createyourself.repository.TaskRepository;
import pl.mgk.hubertrybarczyk.createyourself.repository.TodoRepository;
import pl.mgk.hubertrybarczyk.createyourself.service.TaskService;
import pl.mgk.hubertrybarczyk.createyourself.service.TodoService;

@Service
//@Profile("springdatajpa")
public class TaskJpaService implements TaskService {

    private final TaskRepository taskRepository;

    public TaskJpaService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Set<Task> findAll() {
        Set<Task> tasks = new HashSet<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Set<Task> findByCategory(String category) {
        Set<Task> tasks = new HashSet<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks.stream().filter(obj -> obj.getCategory().equalsIgnoreCase(category)).collect(Collectors.toSet());
    }

    public Task findByName(String name) {
        return taskRepository.findByName(name);
    }


    @Override
    public Task findById(Long aLong) {
        return taskRepository.findById(aLong).orElse(null);
    }

    @Override
    public Task save(Task object) {
        return taskRepository.save(object);
    }

    @Override
    public void delete(Task object) {
        taskRepository.delete(object);
    }

    @Override
    public void deleteId(Long aLong) {
        taskRepository.deleteById(aLong);
    }
}
