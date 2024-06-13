package dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import entity.Entity;

public interface DAO <T extends Entity> {
    public void save(T entity);
    public Optional<T> findById(int id);
    public List<T> findAll();
    public List<T> findAll(Predicate<T> filter);
    public List<T> findAll(Comparator<T> comparator);
    public void update(int id, T entity);
    public void delete(int id);
}
