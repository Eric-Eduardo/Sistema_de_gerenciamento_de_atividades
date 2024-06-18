package service;

import entity.Activity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableDataService {

    private List<Activity> itemList;
    private String[] columnTitles = {"Título", "Data inicial", "Data final"};
    private int columnWidths[] = {13, 13, 13};
    private SimpleDateFormat dateFormatter= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public TableDataService() {
        itemList = new ArrayList<>();
    }

    public String getCell(int width, String fill, String text) {
        String line = "";
        line += fill + text;

        for (int i = 0; i < width - text.length(); i++) {
            line += fill;
        }
        line += fill;
        return line;
    }

    public String getLine(String delimiter, String preffix, String suffix, String[] items) {
        List<String> lines = new ArrayList<>();

        for (int i = 0; i < columnTitles.length; i++) {
            lines.add(getCell(columnWidths[i], " ", items[i]));
        }

        String line = lines.stream()
                .collect(Collectors.joining(delimiter, preffix, suffix));

        return line;
    }

    public String getLine(String delimiter, String preffix, String suffix, Activity item) {
        List<String> lines = new ArrayList<>();

        lines.add(getCell(columnWidths[0], " ", item.getTitle()));
        lines.add(getCell(columnWidths[1], " ", dateFormatter.format(item.getStartTime())));
        lines.add(getCell(columnWidths[2], " ", dateFormatter.format(item.getEndTime())));

        String line = lines.stream()
                .collect(Collectors.joining(delimiter, preffix, suffix));

        return line;
    }

    public String getLine(String delimiter, String preffix, String suffix, String fill) {
        List<String> lines = new ArrayList<>();

        for (int num : columnWidths) {
            lines.add(getCell(num, fill, ""));
        }

        String line = lines.stream()
                .collect(Collectors.joining(delimiter, preffix, suffix));

        return line;
    }

    public void startView() {
        String midline = getLine("┼", "├", "┤", "─");

        System.out.println(getLine("┬", "┌", "┐", "─"));
        System.out.println(getLine("│", "│", "│", columnTitles));

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(midline);
            System.out.println(getLine("│", "│", "│", itemList.get(i)));
        }
        System.out.println(getLine("┴", "└", "┘", "─"));
    }

    private void updateColumnWidths(Activity activity) {

        if (activity.getTitle().length() > columnWidths[0]) {
            columnWidths[0] = activity.getTitle().length();
        }

        if (activity.getStartTime().toString().length() > columnWidths[1]) {
            columnWidths[1] = activity.getStartTime().toString().length();
        }

        if (activity.getEndTime().toString().length() > columnWidths[2]) {
            columnWidths[2] = activity.getEndTime().toString().length();
        }
    }

    private void addItem(Activity item) {
        itemList.add(item);

        updateColumnWidths(item);
    }

    public void addData(List<Activity> items) {
        for (Activity item : items) {
            this.addItem(item);
        }
    }
}
