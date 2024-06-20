package database;

import java.util.HashMap;
import java.util.Map;

import entity.Activity;
import entity.Entity;

public class Database {
    // ------------------ Singleton -----------------------
    private static Database instance;
    private Database(){}

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    // ------------------ Singleton -----------------------

    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables = new HashMap<>();

    public Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> getTables() { return tables; }


    public <T extends Entity> void save(T entity){
        if(!tables.containsKey(entity.getClass())){
            tables.put(entity.getClass(), new DatabaseTable<T>());
        }
        if(entity instanceof Activity){
            Activity activity = (Activity) entity;
            
            System.out.println(activity.getTitle());

            DatabaseTableI<? extends Activity> tabela = new HashMap<>();
            tabela = tables.get(Activity.class);
        }
        
    }

    public <T extends Entity> void delete(Class<T> clazz, int id){
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<T>());
        }
        tables.get(clazz).delete(id);
    }
}
