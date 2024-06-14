package service;

import dao.ActivityDAO;
import entity.Activity;

public class ActivityService {

    private ActivityDAO activityDAO;

    public ActivityService(){
        activityDAO = new ActivityDAO();
    }

    public void save(String title, String startDate, String endDate, String category){
        Activity activity = new Activity();

        activity.setTitle(title);
        
        // TODO Trata data antes de setar na entidade a ser salva.
        // activity.setStartTime(startDate);
        // activity.setEndTime(endDate);
        

        // TODO Tratar criação da categoria
        // activity.addCategory(category);

        activityDAO.save(activity);
    }
    
}
