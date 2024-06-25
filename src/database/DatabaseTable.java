package database;

import entity.Entity;
import exception.DatabaseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {

    int countID;
    Map<Integer, T> items;

    public DatabaseTable() {
        items = new HashMap<>();
        countID = 1;
    }

    @Override
    public void save(T entity) throws DatabaseException {
        try {
            entity.setId(countID);
            items.put(countID, entity);
            countID++;
            System.out.println("Atividade salva!");
        } catch (Exception e) {
            throw new DatabaseException("Erro no salvamento: " + e);
        }
    }

    @Override
    public Optional<T> findById(int id) throws DatabaseException {
        List<T> values = new ArrayList<>(items.values());
        Stream<T> streamValues = values.stream().filter(t -> t.getId() == id);
        Optional<T> first = streamValues.findFirst();
        return first;
    }

    @Override
    public List<T> findAll() throws DatabaseException{
        if (this.items != null) {
            List<T> values = new ArrayList<>(items.values());
            return values;
        }

        return null;
    }

    @Override
    public void update(int id, T entity) throws DatabaseException{
        System.out.println("Realizando Update Entidade");
        items.put(id, entity);

    }

    @Override
    public void delete(int id) throws DatabaseException {
        System.out.println("Deletando Entidade");

        Optional<T> optionalEntity = findById(id);

        if (!optionalEntity.isPresent()) {
            throw new DatabaseException("Entidade não encontrada.");
        }

        Entity entity = optionalEntity.get();

        items.remove(entity.getId(), entity);

    }
}
