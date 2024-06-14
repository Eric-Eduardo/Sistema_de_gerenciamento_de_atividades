package dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import entity.Activity;

public class ActivityDAO implements DAO<Activity>{
    @Override
    public void save(Activity entity) {
        // TODO Metodo para lidar com a classe database
    }

    @Override
    public Optional<Activity> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Activity> findAll() {
        return null;
    }

    @Override
    public List<Activity> findAll(Predicate<Activity> filter) {
        return null;
    }

    @Override
    public List<Activity> findAll(Comparator<Activity> comparator) {
        return null;
    }

    @Override
    public void update(int id, Activity entity) {
        
    }

    @Override
    public void delete(int id) {
        
    }
    
}
