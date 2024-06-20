package service;

import entity.Activity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CalendarService {
    private List<Activity> activities;
    private LocalDate dayMonth;
    // private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");



    public CalendarService(int month, int year) {
        this.dayMonth = LocalDate.of(year, month, 1);
        // Predicate<Activity> filter = (Activity activity) -> activity.getStartTime().getMonthValue() == month;
        // this.activities = ActivityService.getAll(filter)
    }

    public CalendarService(String date_) {
        date_ = "06/06/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
        LocalDate date = LocalDate.parse(date_, formatter);
        this.dayMonth = LocalDate.of(date.getYear(), date.getMonthValue(), 1);
        this.activities = new ArrayList<>();

        // activities.add(new Activity("Atividade 1", LocalDateTime.of(2024, 06, 12, 15, 0), LocalDateTime.of(2024, 06, 12, 16, 0)));
        // activities.add(new Activity("Atividade Matemática", LocalDateTime.of(2024, 06, 12, 16, 30), LocalDateTime.of(2024, 06, 12, 17, 30)));
        // activities.add(new Activity("Atividade de Biologia Molecular", LocalDateTime.of(2024, 06, 12, 18, 50), LocalDateTime.of(2024, 06, 12, 19, 25)));
        // activities.add(new Activity("Atividade Fundamentos Matemáticas da Computação", LocalDateTime.of(2024, 06, 12, 20, 10), LocalDateTime.of(2024, 06, 12, 20, 50)));
        // activities.add(new Activity("Atividade 3", LocalDateTime.of(2024, 06, 12, 18, 40), LocalDateTime.of(2024, 06, 12, 19, 15)));
        // activities.add(new Activity("Atividade 4", LocalDateTime.of(2024, 06, 13, 15, 0), LocalDateTime.of(2024, 06, 13, 16, 0)));
    }

    public void startView() {
        System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ " + getCell(151, " ", this.dayMonth.getMonth().name()) + " │");
        System.out.println("├─────────────────────┬─────────────────────┬─────────────────────┬─────────────────────┬─────────────────────┬─────────────────────┬─────────────────────┤\n" +
                           "│ DOMINGO             │ SEGUNDA             │ TERÇA               │ QUARTA              │ QUINTA              │ SEXTA               │ SÁBADO              │\n" +
                           "├─────────────────────┼─────────────────────┼─────────────────────┼─────────────────────┼─────────────────────┼─────────────────────┼─────────────────────┤");
    }


    public String getCell(int width, String fill, String text) {
        String line = "";
        
        line += text;
        for (int i = 0; i < width - text.length(); i++) {
            line += fill;
        }
        return line;
    }

    public String getLine(String delimiter, String preffix, String suffix, String fill) {
        List<String> lines = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            lines.add(getCell(6, fill, ""));
        }

        String line = lines.stream()
                .collect(Collectors.joining(delimiter, preffix, suffix));

        return line;
    }
}
