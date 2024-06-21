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

    public CalendarService(int month, int year) {
        this.dayMonth = LocalDate.of(year, month, 1);
    }

    public CalendarService(String date_) {
        date_ = "06/06/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
        LocalDate date = LocalDate.parse(date_, formatter);
        this.dayMonth = LocalDate.of(date.getYear(), date.getMonthValue(), 1);
        this.activities = new ArrayList<>();
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
