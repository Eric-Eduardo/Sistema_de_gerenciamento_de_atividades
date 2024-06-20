// package database;

// import java.util.List;
// import java.util.Optional;

// import entity.Activity;
// import entity.Entity;

// public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {
//     int countID;
//     List<T> listaDeTabela;
    

//     @Override
//     public void save(Entity entity){

//         if(entity instanceof Activity){
//             Activity activity = (Activity) entity;
            
//             System.out.println(">>>>>>>>>>> AQUI GLD   "+activity.getTitle());

//         }
        
//         System.out.println("Acessando DatabaseTable com a classe: "+entity.getClass().getSimpleName());
        
// // TODO Coleção que simula banco
// // TODO salvar linha da tabela 
          
//         System.out.println("Checando existência da tabela no banco(Database) e adicionado caso nao exista.");
//     }

//     @Override
//     public Optional<T> findById(int id) {
        
//         return null;
//     }
    
//     @Override
//     public List<T> findAll() {
        
//         return null;
//     }

//     @Override
//     public void update(int id, Entity entity){System.out.println("Realizando Update Entidade");}

//     @Override
//     public void delete(int id){ System.out.println("Deletando Entidade"); }
// }








import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import entity.Entity; // Importe sua classe de entidade específica aqui

public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {
    private Map<Integer, T> data = new HashMap<>();
    private int nextId = 1;

    @Override
    public void save(T entity) {
        if (entity.getId() == 0) {
            entity.setId(nextId++);
        }
        data.put(entity.getId(), entity);
    }

    @Override
    public Optional<T> findById(int id) {
        T entity = data.get(id);
        return Optional.ofNullable(entity);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void update(int id, T entity) {
        if (data.containsKey(id)) {
            data.put(id, entity);
        }
    }

    @Override
    public void delete(int id) {
        data.remove(id);
    }
}