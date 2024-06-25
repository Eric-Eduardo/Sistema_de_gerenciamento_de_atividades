package service;

import dao.ActivityDAO;
import entity.Activity;
import entity.CategoryEnum;
import exception.DAOException;
import exception.EntityNotFoundException;
import exception.InvalidDateIntervalException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ActivityService {

    private ActivityDAO activityDAO;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ActivityService(){
        activityDAO = new ActivityDAO();
    }

    public List<Activity> getAll() throws DAOException, NullPointerException {
        List<Activity> activities = null;
        try {
            activities = activityDAO.findAll();

            if(activities == null){
                throw new NullPointerException("Listagem vazia.");
            }

        } catch (DAOException e) {
            throw new DAOException("Erro ao buscar todas as tarefas.", e.getCause());
        }

        return activities;
    }

    public List<Activity> findByDay(String date) throws DAOException{
        List<Activity> activities = null;

        try {
            LocalDate localDate = LocalDate.parse(date, dateFormatter);

            Predicate<Activity> filter = (Activity activity) -> activity.getStartTime().toLocalDate().equals(localDate);
    
             activities = activityDAO.findAll(filter);    
        } catch (DAOException e) {
            throw e;
        }
        

        return activities;
    }

    public List<Activity> findByName(String title) throws DAOException {

        Predicate<Activity> filter = (Activity activity) -> activity.getTitle().equalsIgnoreCase(title);

        List<Activity> activities = activityDAO.findAll().stream().filter(filter).collect(Collectors.toList());

        // Supplier<Activity> listActiviesSupplier = (Supplier<Activity>) activities;

        // System.out.println(listActiviesSupplier);
        activities.forEach( arg0 ->  System.out.println(arg0.getTitle()));

        return activities;
        
    }

    public void save(String title, String startDate, String endDate, int categoryEnum) throws InvalidDateIntervalException {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate, formatter);
            LocalDateTime endLocalDateTime = LocalDateTime.parse(endDate, formatter);

            if (startLocalDateTime.compareTo(endLocalDateTime) > 0) {
                throw new InvalidDateIntervalException("A data Inicial não pode ser depois que a data fim.");
            }

            CategoryEnum category = CategoryEnum.values()[categoryEnum];
            Activity activity = new Activity(title, startLocalDateTime, endLocalDateTime, category);
            
            activityDAO.save(activity);

        } catch (DAOException exception) {

            System.err.println("Erro ao salvar tarefa. "+exception.getMessage());
            // exception.printStackTrace();
        } catch (DateTimeParseException exception) {
            System.err.println("Data no formato incorreto");
        }
    }

    // public List<Activity> delete(String title) {
    //     return activityDAO.findAll((Activity activity) -> activity.getTitle().equals(title));
    // }

    public void delete(int id) throws EntityNotFoundException{
        try {
            activityDAO.delete(id);    
        } catch (DAOException e) {

            System.err.println("Erro ao deletar atividade");
            throw new EntityNotFoundException("Entidade não encontrada. ", e.getCause());
        }
        
    }

    public int getIdByName(String title) throws DAOException {

        
        List<Activity> activities = activityDAO.findAll((Activity activity) -> activity.getTitle().equals(title));
        if (activities.isEmpty()) {
            return -1;
        }

        return activities.get(0).getId();
    }

    // public void updateTitle(int id, String newTitle) {
    //     TableDataService table = new TableDataService();
    //     List<Activity> listaActivities = new ArrayList<>();
    //     Optional<Activity> activity = activityDAO.findById(id);

    //     if(!activity.isPresent()){
    //         System.out.println("Atividade não encontrada! ");
    //     }else{
    //         activity.get().setTitle(newTitle);
    //         listaActivities.add(activity.get());

    //         System.out.println("Atividade atualizada com sucesso!\n ");

    //         table.addData(listaActivities);
    //         table.startView();
    //     }   
    // }

    public void update(int id, String title, String startDate_, String endDate_) throws EntityNotFoundException, InvalidDateIntervalException, DateTimeParseException {

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            

            Optional<Activity> optionalActivity = activityDAO.findById(id);
            Activity activity;

            if(!optionalActivity.isPresent()){
                throw new EntityNotFoundException("Entidade não encontrada.");
            } else {

                activity = optionalActivity.get();
                if (title != null) {
                    activity.setTitle(title);

                } else if (startDate_ != null) {
                    LocalDateTime startDate = LocalDateTime.parse(startDate_, formatter);
                    if(startDate.compareTo(activity.getEndTime()) > 0){
                        throw new InvalidDateIntervalException("A data inicial não pode ser depois da data final.");
                    }
                    activity.setStartTime(startDate);
                
                } else if (endDate_ != null) {
                    LocalDateTime endDate = LocalDateTime.parse(endDate_, formatter);
                    if(activity.getStartTime().compareTo(endDate) > 0){
                        throw new InvalidDateIntervalException("A data inicial não pode ser depois da data final.");
                    }
                    activity.setEndTime(endDate);
                }
                activityDAO.update(id, activity);    
            }

        } catch (DAOException | DateTimeParseException e) {
            System.err.println("Erro ao atualizar atividade. "+ e.getCause());
        }
        
    }
}
