package view;

// import service.ActivityService;
import java.util.Scanner;

public class RemoveActivityView implements View {
    // private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        System.out.println("REMOVER ATIVIDADE");

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

                // activityService.delete(activityName);

                quit = true;

            // } catch (EntityNotFoundExceptioin e) {
            //     System.out.println("Atividade não encontrada");
            // } catch (DatabaseException e) {
            //     System.out.println("Ocorreu algum erro no banco de dados!");
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }
    }
}
