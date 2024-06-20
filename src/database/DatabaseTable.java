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
    // List<T> items;
    Map<Integer, T> items;

    public DatabaseTable() {
        items = new HashMap<>();
        countID = 1;
    }

    @Override
    public void save(T entity) {
        // Activity activity = (Activity) entity;

        try {
            entity.setId(countID);
            items.put(countID, entity);
            countID++;
            System.out.println("Atividade salva!");
        } catch (Exception e) {
            System.out.println("Erro no salvamento: " + e);
        }

        // System.out.println(">>>>>>>>>>> AQUI GLD   "+activity.getTitle());
        // System.out.println("Acessando DatabaseTable com a classe: "+entity.getClass().getSimpleName());
// TODO Coleção que simula banco
// TODO salvar linha da tabela 
        // System.out.println("Checando existência da tabela no banco(Database) e adicionado caso nao exista.");
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

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;
// import entity.Entity; // Importe sua classe de entidade específica aqui
// public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {
//     private Map<Integer, T> data = new HashMap<>();
//     private int nextId = 1;
//     @Override
//     public void save(T entity) {
//         if (entity.getId() == 0) {
//             entity.setId(nextId++);
//         }
//         data.put(entity.getId(), entity);
//     }
//     @Override
//     public Optional<T> findById(int id) {
//         T entity = data.get(id);
//         return Optional.ofNullable(entity);
//     }
//     @Override
//     public List<T> findAll() {
//         return new ArrayList<>(data.values());
//     }
//     @Override
//     public void update(int id, T entity) {
//         if (data.containsKey(id)) {
//             data.put(id, entity);
//         }
//     }
//     @Override
//     public void delete(int id) {
//         data.remove(id);
//     }
// }
