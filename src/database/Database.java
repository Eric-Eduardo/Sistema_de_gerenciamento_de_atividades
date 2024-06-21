package database;

import entity.Activity;
import entity.Entity;
import java.util.HashMap;
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
    
    public <T extends Entity> void save(Class<T> clazz, T entity){
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<T>());
        }

        if(entity instanceof Activity){

            ((DatabaseTable<T>)tables.get(clazz)).save(entity);

        }
        
    }

    public <T extends Entity> void delete(Class<T> clazz, int id){
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<T>());
        }
        tables.get(clazz).delete(id);
    }

    public <T extends Entity> Optional<T> findById(Class<T> clazz, int id) {
        Optional<T> option = ((DatabaseTable<T>)tables.get(clazz)).findById(id);

        return option;
    }
}
