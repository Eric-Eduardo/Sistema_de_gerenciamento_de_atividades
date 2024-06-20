package entity;

import java.time.LocalDateTime;

public class Activity extends Entity {
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private CategoryEnum category;

    public Activity(String title, LocalDateTime startTime, LocalDateTime endTime, CategoryEnum category) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.category = category;
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
    public CategoryEnum getCategory() {
        return this.category;
    }
    public void setCategories(CategoryEnum category) {
        this.category = category;
    }
}
