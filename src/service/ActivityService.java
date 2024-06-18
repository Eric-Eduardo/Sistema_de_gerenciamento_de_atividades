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

            System.out.println("Acessando service da classe: "+Activity.class.getName());

            Activity activity = new Activity();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            
            Date dataInicial = formatter.parse(startDate);
            Date dataFinal = formatter.parse(endDate);
            
            activity.setTitle(title);
            activity.setStartTime(dataInicial);
            activity.setEndTime(dataFinal);

            //TODO Validações man

            CategoryEnum category = CategoryEnum.values()[categoryEnum];
            activity.addCategory(category);

            activityDAO.save(activity);
        } catch (Exception exception) {
            throw exception;
        }
    }
    
}
