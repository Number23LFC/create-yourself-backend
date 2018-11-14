package pl.mgk.hubertrybarczyk.createyourself.service;

import pl.mgk.hubertrybarczyk.createyourself.model.Category;

public interface CategoryService extends CrudService<Category, Long> {
    Category findByName(String name);
}
