package view;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import database.TableDataI;

public class TableDataView <T extends TableDataI> {
    private String tableTitle;
    private List<T> itemList;
    private List<String> columnTitles;
    private Map<String, Integer> columnWidths;

    public TableDataView() {
        this.itemList = new ArrayList<>();
        this.columnWidths = new LinkedHashMap<>();
        this.columnTitles = new ArrayList<>();
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

    public String getLine(String delimiter, String preffix, String suffix, List<String> items) {
        List<String> lines = new ArrayList<>();

        for (String item : items) {
            lines.add(getCell(columnWidths.get(item), " ", item));
        }

        String line = lines.stream()
                .collect(Collectors.joining(delimiter, preffix, suffix));

        return line;
    }

    public String getLine(String delimiter, String preffix, String suffix, T item) {
        List<String> lines = new ArrayList<>();

        for (String key : columnWidths.keySet()) {
            lines.add(getCell(columnWidths.get(key), " ", item.conversionTableColumns().get(key)));
        }

        String line = lines.stream()
                .collect(Collectors.joining(delimiter, preffix, suffix));

        return line;
    }

    public String getLine(String delimiter, String preffix, String suffix, String fill) {
        List<String> lines = new ArrayList<>();

        for (String key : columnWidths.keySet()) {
            lines.add(getCell(columnWidths.get(key), fill, ""));
        }

        String line = lines.stream()
                .collect(Collectors.joining(delimiter, preffix, suffix));

        return line;
    }

    public void startView() {
        if (!columnTitles.isEmpty()) {
            String midline = getLine("┼", "├", "┤", "─");
            System.out.println(getLine("┬", "┌", "┐", "─"));
            System.out.println(getLine("│", "│", "│", columnTitles));

            for (T item : itemList) {
                System.out.println(midline);
                System.out.println(getLine("│", "│", "│", item));
            }
            System.out.println(getLine("┴", "└", "┘", "─"));
        }
    }

    private void updatecolumnWidths(String key, int value) {
        if (columnWidths.getOrDefault(key, 0) < value) {
            columnWidths.put(key, value);
        }
    }

    public void addItem(T item) {
        itemList.add(item);

        Map<String, String> mapa = item.conversionTableColumns();
        for (String key : mapa.keySet()) {
            updatecolumnWidths(key, mapa.get(key).length());
        }
    }

    public void addData(List<T> items) {
        for (T item : items) {
            this.addItem(item);
        }
    }

    public void addColumn(String title) {
        columnTitles.add(title);
        updatecolumnWidths(title, title.length());
    }

    public void setTableTitle(String title) {
        this.tableTitle = title;
    }

    public String getTabelTitle() {
        return this.tableTitle;
    }
}
