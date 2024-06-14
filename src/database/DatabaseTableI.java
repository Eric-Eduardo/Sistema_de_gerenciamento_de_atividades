package database;

import java.util.List;
import java.util.Optional;

import entity.Entity;

public interface DatabaseTableI<T extends Entity> {
    void save(T entity);
    Optional<T> findById(int id);
    List<T> findAll();
    void update(int id, T entity);
    void delete(int id);
}