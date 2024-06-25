package view;

import entity.Activity;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import service.ActivityService;

public class RemoveActivityView implements View {
    private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        System.out.println("REMOVER ATIVIDADE");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;

        while (!quit) {
            try {
                System.out.println("Digite o nome da atividade que deseja remover ou 0 para sair:");

                String activityName = scanner.nextLine();

                if (activityName.equals("0")) {
                    quit = true;
                    continue;
                }


                List<Activity> activities = activityService.findByName(activityName);
                
                if (activities.isEmpty()) {
                    System.out.println("Não foram encontradas atividades com o nome " + activityName);
                } else if (activities.size() > 1) {
                    System.out.println("Foram encontradas mais de uma ocorrência para " + activityName + ". Selecione o ID da atividade que deseja remover");
                    
                    for (Activity activity : activities) {
                        System.out.println("[" + activity.getId() + "]");
                        System.out.println("  Título: " + activity.getTitle());
                        System.out.println("  Data de início: " + activity.getStartTime().format(formatter));
                        System.out.println("  Título: " + activity.getEndTime().format(formatter));
                        System.out.println("  Categoria: " + activity.getCategory().name());
                    }

                    Scanner scanner2 = new Scanner(System.in);
                    int ID = scanner2.nextInt();

                    activityService.delete(ID);
                } else if (activities.size() == 1) {
                    activityService.delete(activities.get(0).getId());
                }

                quit = true;
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }
    }
}
