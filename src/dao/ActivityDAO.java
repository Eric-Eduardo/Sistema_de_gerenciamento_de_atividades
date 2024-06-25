package dao;

import database.Database;
import entity.Activity;
import exception.DAOException;
import exception.DatabaseException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ActivityDAO implements DAO<Activity>{

    Database database = Database.getInstance();

    @Override
    public void save(Activity entity) throws DAOException {
        try {
            database.save(Activity.class, entity);
            
        } catch (DatabaseException e) {
            throw new DAOException("Erro durante processo de salvamento: ", e);
        }
    }

    @Override
    public Optional<Activity> findById(int id) throws DAOException{
        Optional<Activity> activityOptional = null;

        try {
            activityOptional = database.findById(Activity.class, id);
        } catch (DatabaseException e) {
            throw new DAOException("Erro ao buscar por id: "+id, e);
        }

        return activityOptional;
    }

    @Override
    public List<Activity> findAll() throws DAOException{
        List<Activity> listActivities = null;

        try {

            listActivities = database.findAll(Activity.class);    

            if (listActivities == null) {
                throw new NullPointerException("Listagem vazia.");
            }
            
        } catch (DatabaseException e) {
            throw new DAOException("Erro ao buscar todas as atividades: ", e);
        }            
        
        return listActivities;
    }

    @Override
    public List<Activity> findAll(Predicate<Activity> filter) throws DAOException{
        List<Activity> filteredActivities = null;

        try {
            filteredActivities = database.findAll(Activity.class).stream()
	        .filter(filter)
	        .collect(Collectors.toList());     
        } catch (DatabaseException e) {
            throw new DAOException("Erro na busca com predicado: "+filter.toString(), e);
        }

        return filteredActivities;
    }

    @Override
    public List<Activity> findAll(Comparator<Activity> comparator) throws DAOException {
        List<Activity> comparetedActivities = null;

        try {
            comparetedActivities = database.findAll(Activity.class).stream().sorted(comparator).collect(Collectors.toList());
        } catch (DatabaseException e) {
            throw new DAOException("Erro na busca com predicado: "+comparator.toString(), e);
        }

        return comparetedActivities;
    }

    @Override
    public void update(int id, Activity entity) throws DAOException {

        try {
            database.update(entity, id);
        } catch (DatabaseException e) {
            throw new DAOException("Erro ao atualizar atividade: ", e);
        }

    }

    @Override
    public void delete(int id) throws DAOException{
        try {
            database.delete(Activity.class, id);
        } catch (DatabaseException e) {
            throw new DAOException("Erro ao encontrar entidade com o id: "+id, e);
        }
    }
}
