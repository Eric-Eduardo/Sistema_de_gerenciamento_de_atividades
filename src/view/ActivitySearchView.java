package view;

import entity.Activity;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import service.ActivityService;
import service.GanttChartService;
import service.TableDataService;

public class ActivitySearchView implements View {

    private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        int option;

        List<Activity> activities = null;

        while (!quit) {

            System.out.println("\nATIVIDADES\n[1] Ver tudo\n[2] Ver dia\n[0] Sair");
            try {
                option = scanner.nextInt();

                if (option == 0) {
                    quit = true;
                } else if (option == 1) {
                    
                    try {
                        activities = activityService.getAll();
                        if(activities.size() == 0){
                            throw new Exception("Listagem vazia.");
                        }
                        TableDataService table = new TableDataService();
                        table.addData(activities);
                        table.startView();
                    } catch (Exception e) {
                        System.err.println("Erro durante a listagem: "+e.getCause());
                    }

                } else if (option == 2) {

                    try {
                        Scanner scanner2 = new Scanner(System.in);
                        String date = scanner2.nextLine();
                        
                        activities = activityService.findByDay(date);
                        
                        if (activities != null) {
                            System.out.println("[1] Visualizar diagrama de Gantt\n[2] Visualizar mês");
                            String visualizationOption = scanner2.nextLine();
    
                            switch (visualizationOption) {
                                case "1":
                                    GanttChartService gantChart = new GanttChartService(activities);
                                    gantChart.startView();
                                    break;
                                case "2":
                                    Activity activity = activities.get(0);
                                    Predicate<Activity> filterPredicate = activityFilter -> activityFilter.getStartTime().getMonth().compareTo(activity.getStartTime().getMonth()) == 0;
                                    List<Activity> listActivities = activityService.getAll(filterPredicate);
                                    TableDataService table = new TableDataService();
                                    table.addData(listActivities);
                                    table.startView();
                                    break;
                            }
                        } else {
                            System.out.println("Não foram encontradas atividades nesta data!");
                        }
                        System.out.println("Informe a data: ");
                        
                    } catch (Exception e) {
                        System.err.println("Erro durante busca por data: "+ e.getCause());
                    }

                } else {
                    System.out.println("Opção inesistente");
                }

            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("\rEntrada incorreta");
            }
        }
    }
}
