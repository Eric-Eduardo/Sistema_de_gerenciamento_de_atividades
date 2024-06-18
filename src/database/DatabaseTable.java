package database;

import java.util.List;
import java.util.Optional;

import entity.Entity;

public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {
    private int id;

    @Override
    public void save(T entity){
        System.out.println("Acessando DatabaseTable com a classe: "+entity.getClass().getSimpleName());
        Database database = Database.getInstance();

        database.save(entity.getClass(), id);

          
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
