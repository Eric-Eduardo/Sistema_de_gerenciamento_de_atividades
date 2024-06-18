package dao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import database.DatabaseTable;
import database.DatabaseTableI;
import entity.Activity;

public class ActivityDAO implements DAO<Activity>{

    DatabaseTableI<Activity> databaseTableI = new DatabaseTable<Activity>();

    @Override
    public void save(Activity entity) {
        System.out.println("Acessando DAO da classe: "+entity.getClass().getName());

        databaseTableI.save(entity);
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
