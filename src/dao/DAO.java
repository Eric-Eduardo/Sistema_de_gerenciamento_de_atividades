package dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import entity.Entity;
import exception.DAOException;

public interface DAO <T extends Entity> {
    public void save(T entity) throws DAOException;
    public Optional<T> findById(int id) throws DAOException;
    public List<T> findAll() throws DAOException;
    public List<T> findAll(Predicate<T> filter) throws DAOException;
    public List<T> findAll(Comparator<T> comparator) throws DAOException;
    public void update(int id, T entity) throws DAOException;
    public void delete(int id) throws DAOException;
}
