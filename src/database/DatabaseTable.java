package database;

import java.util.List;
import java.util.Optional;

import entity.Entity;

public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {
    private int id;
    private Database database;

    @Override
    public void save(T entity){
        database = database.getInstance();

        database.getTables().values().stream().map(table -> {
            System.out.println(table.getClass().getName());
          
            return null;
          });

          
        System.out.println("Checando existência da tabela no banco(Database) e adicionado caso nao exista.");
    }

    @Override
    public Optional<T> findById(int id) {
        
        return null;
    }
    
    @Override
    public List<T> findAll() {
        
        return null;
    }

    @Override
    public void update(int id, Entity entity){System.out.println("Realizando Update Entidade");}

    @Override
    public void delete(int id){ System.out.println("Deletando Entidade"); }
}
