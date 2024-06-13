 package view;

import java.util.Scanner;
import service.ActivityService;

public class ActivityInsertionFormView implements View {
    private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("FORMULÁRIO DE CADASTRO DE ATIVIDADE");
        
        try {
            System.out.print("Nome da atividade: ");
            String title = scanner.nextLine();

            System.out.print("Data inicial (no formato dd/MM/aaaa hh:mm): ");
            String startDate = scanner.nextLine();

            System.out.print("Data final (no formato dd/MM/aaaa hh:mm): ");
            String endDate = scanner.nextLine();

            System.out.print("Categoria: ");
            String category = scanner.nextLine();

            activityService.save(title, startDate, endDate, category);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
 }