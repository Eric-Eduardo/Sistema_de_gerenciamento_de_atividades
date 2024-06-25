package view;

import entity.Activity;
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
                    // idEntity = activity.getId();
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
                System.out.println("Selecione um atributo para editar:\n"
                        + "[1] Tìtulo\n"
                        + "[2] Data de início\n"
                        + "[3] Data final\n"
                        + "[4] Cateoria\n"
                        + "[0] Sair"
                );

                try {
                    int option = scanner.nextInt();
                    String text;
                    switch (option) {
                        case 0:
                            quit = true;
                            break;
                        case 1:
                            System.out.println("\nDigite o novo titulo: ");
                            text = value.nextLine();
                            activityService.update(activity.getId(), text, null, null);

                            // try {
                            //     activityService.update(idEntity, "", "", "");
                            // } catch (EntityNotFoundException | InvalidDateIntervalException e) {
                            //     System.err.println(e.getMessage());
                            //     // e.printStackTrace();
                            // }
                            break;
                        case 2:
                            System.out.println("\nDigite a nova data de início no formato \"dd/MM/aaaa hh:mm\": ");
                            text = value.nextLine();
                            activityService.update(activity.getId(), null, text, null);
                            break;
                        case 3:
                            
                            System.out.println("\nDigite a nova data final no formato \"dd/MM/aaaa hh:mm\": ");
                            text = value.nextLine();
                            activityService.update(activity.getId(), null, null, text);
                            break;
                        case 4:
                            // text = value.nextLine();
                            System.out.println("Funcionalidade em construção...");
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Você deve digiar um número correspondente a uma opção.");
                } catch (Exception e) {
                    System.out.println("Erro na atualização do objeto");
                }
            }
        }
    }
}
