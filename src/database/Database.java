package database;

import entity.Entity;
import exception.DatabaseException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Database {

    // ------------------ Singleton -------------------- //

    private static Database instance;
    private Database(){}

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    // ------------------ Singleton -------------------- //

    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables = new HashMap<>();
    public Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> getTables() { return tables; }
    
    public <T extends Entity> void save(Class<T> clazz, T entity) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<T>());
        }

        ((DatabaseTable<T>) tables.get(clazz)).save(entity);

    }

    public <T extends Entity> void update(T entity, int id) throws DatabaseException{
        if(!tables.containsKey(entity.getClass())){
            tables.put(entity.getClass(), new DatabaseTable<T>());
        }

        ((DatabaseTable<T>) tables.get(entity.getClass())).update(id, entity);

    }

    public <T extends Entity> void delete(Class<T> clazz, int id) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<T>());
        }
        tables.get(clazz).delete(id);
    }

    public <T extends Entity> Optional<T> findById(Class<T> clazz, int id) throws DatabaseException{

        Optional<T> option = ((DatabaseTable<T>)tables.get(clazz)).findById(id);

        return option;
    }

    public <T extends Entity> List<T> findAll(Class<T> clazz) throws DatabaseException {

        List<T> list = ((DatabaseTable<T>)tables.get(clazz)).findAll();

        return list;
    }

}
