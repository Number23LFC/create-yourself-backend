package pl.mgk.hubertrybarczyk.createyourself.service;

import pl.mgk.hubertrybarczyk.createyourself.model.Objective;

import java.util.Set;

public interface ObjectiveService extends CrudService<Objective, Long> {
    Set<Objective> findByCategoryName(String categoryName);
}
