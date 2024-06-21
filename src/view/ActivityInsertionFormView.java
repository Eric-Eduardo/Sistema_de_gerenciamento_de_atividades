 package view;

import java.util.Scanner;

import entity.CategoryEnum;
import service.ActivityService;

public class ActivityInsertionFormView implements View {
    private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        System.out.println("FORMULÁRIO DE CADASTRO DE ATIVIDADE");
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Nome da atividade: ");
            String title = scanner.nextLine();

            System.out.print("Data inicial (no formato dd/MM/aaaa hh:mm): ");
            String startDate = scanner.nextLine();

            System.out.print("Data final (no formato dd/MM/aaaa hh:mm): ");
            String endDate = scanner.nextLine();

            System.out.println("Categoria: ");
            for (int i = 0; i < CategoryEnum.values().length; i++) {
                System.out.println("["+i+"] "+CategoryEnum.values()[i]);                 
            }

            int categoryEnum = scanner.nextInt();

            activityService.save(title, startDate, endDate, categoryEnum);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
 }