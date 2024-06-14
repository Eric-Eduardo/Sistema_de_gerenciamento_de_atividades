package database;

import java.util.HashMap;
import java.util.Map;

import entity.Entity;

public class Database {
    // ------------------ Singleton -----------------------
    private static Database instance;
    private Database(){}

    public Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    // ------------------ Singleton -----------------------

    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables = new HashMap<>();

    public Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> getTables() { return tables; }

    public <T extends Entity> void delete(Class<T> clazz, int id){
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        }
    }
}