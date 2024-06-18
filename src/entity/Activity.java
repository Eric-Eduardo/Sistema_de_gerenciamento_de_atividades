package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Activity extends Entity {
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<CategoryEnum> categories;

    

    public Activity() {
        categories = new ArrayList<>();
    }

    public Activity(String title, LocalDateTime startTime, LocalDateTime endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void addCategory(CategoryEnum category) {
        categories.add(category);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public List<CategoryEnum> getCategories() {
        return categories;
    }
    public void setCategories(List<CategoryEnum> categories) {
        this.categories = categories;
    }
}
