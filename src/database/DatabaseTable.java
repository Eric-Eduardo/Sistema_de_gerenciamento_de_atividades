package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entity.Entity;

public class DatabaseTable implements DatabaseTableI {
    public void save(Entity entity){System.out.println("hey");}
    // public Optional<T> findById(int id){return Optional.of("");}
    @Override
    public Optional findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    public List<T> findAll(){return new ArrayList<>();}
    public void update(int id, Entity entity){System.out.println("Realizando Update Entidade");}
    public void delete(int id){ System.out.println("Deletando Entidade"); }
}
