package view;

import service.ActivityService;
import entity.Activity;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ActivitySearchView implements View {

    private ActivityService activityService = new ActivityService();
    
    @Override
    public void startView() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        int option;
        
        while (!quit) {
            
            System.out.println("\nATIVIDADES\n[1] Ver tudo\n[0] Sair");
            try {
                option = scanner.nextInt();

                if (option == 0) {
                    quit = true;
                } else if (option ==  1) {
                    List<Activity> activities = new ArrayList<>();
                    activities.add(new Activity("Atividade 1", new Date("12/06/2024"), new Date("12/06/2024")));
                    activities.add(new Activity("Atividade 2", new Date("13/06/2024"), new Date("15/06/2024")));
                    activities.add(new Activity("Atividade 3", new Date("14/06/2024"), new Date("16/06/2024")));
                    activities.add(new Activity("Atividade 4", new Date("15/06/2024"), new Date("17/06/2024")));
                    // List<Activity> activities = activityService.findAll();

                    TableDataView<Activity> table = new TableDataView<>();
                    table.addColumn("Título");
                    table.addColumn("Data inicial");
                    table.addColumn("Data final");

                    table.addData(activities);

                    table.startView();
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
