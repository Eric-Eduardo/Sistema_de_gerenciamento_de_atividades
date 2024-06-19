package view;

// import service.ActivityService;
import entity.Activity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import service.GanttChartService;
import service.TableDataService;

public class ActivitySearchView implements View {

    // private ActivityService activityService = new ActivityService();
    @Override
    public void startView() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        int option;

        List<Activity> activities = new ArrayList<>();

        activities.add(new Activity("Atividade 1", LocalDateTime.of(2024, 06, 12, 15, 0), LocalDateTime.of(2024, 06, 12, 16, 0)));
        activities.add(new Activity("Atividade Matemática", LocalDateTime.of(2024, 06, 12, 16, 30), LocalDateTime.of(2024, 06, 12, 17, 30)));
        activities.add(new Activity("Atividade de Biologia Molecular", LocalDateTime.of(2024, 06, 12, 18, 50), LocalDateTime.of(2024, 06, 12, 19, 25)));
        activities.add(new Activity("Atividade Fundamentos Matemáticas da Computação", LocalDateTime.of(2024, 06, 12, 20, 10), LocalDateTime.of(2024, 06, 12, 20, 50)));
        activities.add(new Activity("Atividade 3", LocalDateTime.of(2024, 06, 12, 18, 40), LocalDateTime.of(2024, 06, 12, 19, 15)));
        activities.add(new Activity("Atividade 4", LocalDateTime.of(2024, 06, 13, 15, 0), LocalDateTime.of(2024, 06, 13, 16, 0)));
        // List<Activity> activities = activityService.findAll();

        while (!quit) {

            System.out.println("\nATIVIDADES\n[1] Ver tudo\n[2] Ver dia\n[0] Sair");
            try {
                option = scanner.nextInt();

                if (option == 0) {
                    quit = true;
                } else if (option == 1) {
                    // List<Activity> activities = new ArrayList<>();
                    TableDataService table = new TableDataService();
                    table.addData(activities);
                    table.startView();

                } else if (option == 2) {
                    System.out.println("Informe o dia: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String day = scanner2.nextLine();
                    System.out.println(day);
                    // Activity activity = ActivityService.getDay(dia);
                    List<Activity> activitiesOfTheDay = new ArrayList<>();
                    activitiesOfTheDay.add(activities.get(0));
                    activitiesOfTheDay.add(activities.get(1));
                    activitiesOfTheDay.add(activities.get(2));
                    activitiesOfTheDay.add(activities.get(3));
                    GanttChartService gantChart = new GanttChartService(activitiesOfTheDay);
                    gantChart.startView();

                } else {
                    System.out.println("Opção inesistente");
                }

            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("\rEntrada incorreta");
            }
        }
        // scanner.close();
    }
}
