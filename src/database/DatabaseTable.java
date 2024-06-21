package database;

import entity.Entity;
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
    public void save(T entity) {
        try {
            entity.setId(countID);
            items.put(countID, entity);
            countID++;
            System.out.println("Atividade salva!");
        } catch (Exception e) {
            System.out.println("Erro no salvamento: " + e);
        }
    }

    @Override
    public Optional<T> findById(int id) {
        List<T> values = new ArrayList<>(items.values());
        Stream<T> streamValues = values.stream();
        Optional<T> first = streamValues.findFirst();
        return first;
    }

    @Override
    public List<T> findAll() {
        if (this.items != null) {
            List<T> values = new ArrayList<>(items.values());
            return values;
        }

        return null;
    }

    @Override
    public void update(int id, T entity) {
        System.out.println("Realizando Update Entidade");
        items.put(id, entity);

    }

    @Override
    public void delete(int id) {
        System.out.println("Deletando Entidade");
        boolean found = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(i);
                i = items.size();
                found = true;
                continue;
            }
        }

        if (!found) {
            System.out.println("Elemento não encontrado");
        } else {
            System.out.println("Elemento removido");
        }
    }
}
