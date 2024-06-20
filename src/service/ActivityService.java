package service;

import dao.ActivityDAO;
import entity.Activity;
import entity.CategoryEnum;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;

public class ActivityService {

    private ActivityDAO activityDAO;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ActivityService(){
        activityDAO = new ActivityDAO();
    }

    public List<Activity> getAll() {
        List<Activity> activities = activityDAO.findAll();

        return activities;
    }

    public List<Activity> findByDay(String date) {
        LocalDate localDate = LocalDate.parse(date, dateFormatter);

        Predicate<Activity> filter = (Activity activity) -> activity.getStartTime().toLocalDate().equals(localDate);

        List<Activity> activities = activityDAO.findAll(filter);

        return activities;
    }

    public List<Activity> findByName(String title) {
        Predicate<Activity> filter = (Activity activity) -> activity.getTitle().equals(title);

        List<Activity> activities = activityDAO.findAll(filter);

        return activities;
        
    }

    public void save(String title, String startDate, String endDate, int categoryEnum) throws Exception {

        try {

            // System.out.println("Acessando service da classe: "+Activity.class.getName());
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate, formatter);
            LocalDateTime endLocalDateTime = LocalDateTime.parse(endDate, formatter);

            // System.out.println(startLocalDateTime);

            CategoryEnum category = CategoryEnum.values()[categoryEnum];
            Activity activity = new Activity(title, startLocalDateTime, endLocalDateTime, category);
            
            activityDAO.save(activity);

        } catch (Exception exception) {
            throw exception;
        }
    }

    public List<Activity> delete(String title) {
        return activityDAO.findAll((Activity activity) -> activity.getTitle().equals(title));
    }

    public void delete(int id) {
        activityDAO.delete(id);
    }

    public int getIdByName(String title) {
        
        List<Activity> activities = activityDAO.findAll((Activity activity) -> activity.getTitle().equals(title));
        if (activities.isEmpty()) {
            return -1;
        }

        return activities.get(0).getId();
    }

    public void updateTitle(int id, String newTitle) {
        System.out.println("ActivityService" + id + newTitle);
        Activity activity = activityDAO.findById(id).get();
        System.out.println(activity);
        // activity.setTitle(newTitle);
        // activityDAO.update(id, activity);
    }
    
}
