package database;

import java.util.HashMap;
import java.util.Map;

import entity.Entity;

public class Database {
    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables = new HashMap<>();

    public <T extends Entity> void delete(Class<T> clazz, int id){
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable());
        }
    }
}
