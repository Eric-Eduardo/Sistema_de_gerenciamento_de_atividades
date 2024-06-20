 package view;

import java.util.Scanner;
import service.ActivityService;

public class ActivityInsertionFormView implements View {
    private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        
        System.out.println("FORMULÁRIO DE CADASTRO DE ATIVIDADE");
        Scanner scanner = new Scanner(System.in); // Se eu fecho o Scanner aqui, não consigo mais usar no main View

        try {
            // System.out.print("Nome da atividade: ");
            // String title = scanner.nextLine();

            // System.out.print("Data inicial (no formato dd/MM/aaaa hh:mm): ");
            // String startDate = scanner.nextLine();

            // System.out.print("Data final (no formato dd/MM/aaaa hh:mm): ");
            // String endDate = scanner.nextLine();

            // System.out.println("Categoria: ");
            // for (int i = 0; i < CategoryEnum.values().length; i++) {
            //     System.out.println("["+i+"] "+CategoryEnum.values()[i]);                 
            // }

            // int categoryEnum = scanner.nextInt();

            // activityService.save(title, startDate, endDate, categoryEnum);
            activityService.save("Atividade 1", "20/06/2024 08:00", "20/06/2024 09:00", 1);
            activityService.save("Atividade 2", "20/06/2024 10:00", "20/06/2024 12:45", 2);
            activityService.save("Atividade 3", "21/06/2024 08:00", "22/06/2024 09:00", 1);

                       

        } catch (Exception e) {
            System.out.println(e);
        }

        // scanner.close(); Tira aqui pra tu ver...
    }
 }