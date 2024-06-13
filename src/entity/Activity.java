package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import view.TableDataI;

public class Activity implements TableDataI{
    private Long clienteDaTarefaId;
    private String title;
    private Date startTime;
    private Date endTime;
    private List<Category> categories;

    

    public Activity() {
        categories = new ArrayList<>();
    }

    public Activity(String title, Date startTime, Date endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override 
    public Map<String, String> conversionTableColumns() {
        Map<String, String> mapa = new LinkedHashMap<>();
        mapa.put("Título", title);
        mapa.put("Data inicial", startTime.toString());
        mapa.put("Data final", endTime.toString());
        return mapa;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
