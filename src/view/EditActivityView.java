package view;

import entity.Activity;
import entity.CategoryEnum;
import exception.EntityNotFoundException;
import exception.InvalidDateIntervalException;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import service.ActivityService;

public class EditActivityView implements View {
    private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        System.out.println("EDIÇÃO DE ATIVIDADE");

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        int idEntity = -1;
        Activity activity = null;

        while (!quit) {

            System.out.println("Digite o Titulo da atividade que deseja editar (ou 0 para sair):");

            try {
                String activityName = scanner.nextLine();

                if (activityName.equals("0")) {
                    quit = true;
                    continue;
                }

                List<Activity> activities = activityService.findByName(activityName);
                if (activities.isEmpty()) {
                    System.out.println("Atividade não encontrada!");
                } else {
                    activity = activities.get(0);
                    idEntity = activity.getId();
                    quit = true;
                } 

            } catch (Exception e) {
                System.out.println("Erro: " + e);
            }
        }

        quit = false;
        Scanner value = new Scanner(System.in);

        if (activity != null) {
            while (!quit) {
                System.out.println("Preencha na ordem:\n "+
                          "Pressione Enter quando não quiser inserir alteração.\n");
                          
                try {
                    int category;
                    String title = "";
                    String startDate_ = "";
                    String endDate_ = "";


                    try {
                        System.out.println("[1] Título\n");  
                        title = scanner.nextLine();

                        System.out.println("[2] Data de início\n"); 
                        startDate_ = scanner.nextLine();

                        System.out.println("[3] Data final\n");
                        endDate_ = scanner.nextLine();

                        System.out.println("[4] Cateoria (Em número): \n");
                        for (int i = 0; i < CategoryEnum.values().length; i++) {
                            System.out.println("["+i+"] "+CategoryEnum.values()[i]);                 
                        }

                        category = scanner.nextInt();

                        CategoryEnum categoryEnum = CategoryEnum.values()[category];


                        activityService.update(idEntity, title, startDate_, endDate_, categoryEnum);
                    } catch (EntityNotFoundException | InvalidDateIntervalException e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }

                    quit = true;
                } catch (InputMismatchException e) {
                    System.out.println("Você deve digiar um número correspondente a uma opção.");
                } catch (Exception e) {
                    System.out.println("Erro na atualização do objeto");
                }
            }
        }
    }
}
