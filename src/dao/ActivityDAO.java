package dao;

import database.Database;
import database.DatabaseTable;
import entity.Activity;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ActivityDAO implements DAO<Activity>{

    Database database = Database.getInstance();

    @Override
    public void save(Activity entity) {
        database.save(Activity.class, entity);
    }

    @Override
    public Optional<Activity> findById(int id) {
        Optional<Activity> activityOptional = database.findById(Activity.class, id);

        return activityOptional;
    }

    @Override
    public List<Activity> findAll() {            
        DatabaseTable<Activity> table = (DatabaseTable) database.getTables().get(Activity.class);
        return table.findAll();
    }

    @Override
    public List<Activity> findAll(Predicate<Activity> filter) {
        List<Activity> filteredActivities = this.findAll().stream()
	        .filter(filter)
	        .collect(Collectors.toList());

        if (filteredActivities.isEmpty()) {
            return null;
        }

        return filteredActivities;
    }

    @Override
    public List<Activity> findAll(Comparator<Activity> comparator) {
        return null;
    }

    @Override
    public void update(int id, Activity entity) {
        System.out.println("ActivityDAO");

        DatabaseTable<Activity> dt = (DatabaseTable<Activity>)database.getTables().get(Activity.class);
        dt.update(id, entity);

    }

    @Override
    public void delete(int id) {
        database.delete(Activity.class, id);
    }
}
