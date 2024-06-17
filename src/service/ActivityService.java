package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import dao.ActivityDAO;
import entity.Activity;
import entity.CategoryEnum;

public class ActivityService {

    private ActivityDAO activityDAO;

    public ActivityService(){
        activityDAO = new ActivityDAO();
    }

    public void save(String title, String startDate, String endDate, int categoryEnum) throws Exception{
        try {
            Activity activity = new Activity();

            activity.setTitle(title);
            Date dateTeste = new Date();
            
            // TODO Trata data antes de setar na entidade a ser salva.
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm", Locale.getDefault());

            Date dataInicial = formatter.parse(startDate);
            // activity.setStartTime(startDate);
            // activity.setEndTime(endDate);
            
            // if(categoryEnum > 3 || categoryEnum < 0){
                
            // }

            CategoryEnum category = CategoryEnum.values()[categoryEnum];
            activity.addCategory(category);

            activityDAO.save(activity);
        } catch (Exception exception) {
            throw exception;
        }
    }
    
}
