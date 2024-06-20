package service;

import entity.Activity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GanttChartService {
    private List<Activity> activities;
    private LocalDate date;
    private int titleColumnWidth = 0;

    DateTimeFormatter dayOfWeekFormatter = DateTimeFormatter.ofPattern("EEEE");
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    
    public GanttChartService(List<Activity> activities) {
        this.activities = activities;
        date = activities.get(0).getStartTime().toLocalDate();
        updateTitleColumnWidth();
    }

    public void startView() {
        System.out.println("\n\n");
        System.out.println(dayOfWeekFormatter.format(date).toUpperCase() + " " + dateFormatter.format(date));
        System.out.print(getCell(titleColumnWidth-2, " ", ""));
        System.err.println(" " + getTimeLineView());

        System.out.print(" " + getCell(titleColumnWidth, " ", ""));
        System.out.println(getLine("┼", "├", "┤", "─"));

        for (Activity activity : activities) {
            System.out.println(getCell(titleColumnWidth, " ", activity.getTitle()) + " " + getGanttChartLine(activity.getStartTime().toLocalTime(), activity.getEndTime().toLocalTime()));
        }

        System.out.println(getCell(titleColumnWidth, " ", "") + " " + getLine("┴", "└", "┘", "─"));
    }

    private String getGanttChartLine(LocalTime startTime, LocalTime endTime) {
        LocalTime time = LocalTime.of(startTime.getHour(), 0);
        LocalTime endHour = endTime;
        if (endTime.getMinute() > 0) {
            endHour = LocalTime.of(endTime.getHour()+1, 0);
        }

        
        int timeInterval = endHour.getHour() - startTime.getHour();
        int hour = 0;
        String line = "";
        while (hour < startTime.getHour()) {
            line += "│      ";
            hour++;
        }

        for (int i = 0; i < timeInterval; i++) {
            line += "│";

            for (int a = 0; a < 6; a++) {
                if ((time.isAfter(startTime) || time.equals(startTime)) && time.isBefore(endTime)) {
                    line += "█";
                } else {
                    line += " ";
                }

                time = time.plusMinutes(10);
            }
        }
        line += "│";

        hour = endHour.getHour();

        while (hour%24 > 0) {
            line += "      │";
            hour++;
        }
        
        return line;
    }

    private String getTimeLineView() {
        String timeLine = "";
        LocalTime time = LocalTime.of(0, 0);

        for (int i = 0; i <= 24; i++) {
            timeLine += time.format(timeFormatter) + "  ";
            time = time.plusHours(1);
        }

        return timeLine;
    }

    public String getCell(int width, String fill, String text) {
        String line = "";
        
        for (int i = 0; i < width - text.length(); i++) {
            line += fill;
        }
        line += text;
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

    private void updateTitleColumnWidth() {
        int width;
        for (Activity activity : activities) {
            width = activity.getTitle().length();
            if (width > titleColumnWidth) {
                titleColumnWidth = width;
            }
        }
    }
}
