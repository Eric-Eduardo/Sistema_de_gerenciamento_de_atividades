package view;

// import service.ActivityService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EditActivityView implements View {
    // private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        System.out.println("EDIÇÃO DE ATIVIDADE");

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        int idEntity = -1;

        while (!quit) {

            System.out.println("Digite o nome da atividade que deseja editar (ou 0 para sair):");

            try {
                String activityName = scanner.nextLine();

                if (activityName.equals("0")) {
                    quit = true;
                    continue;
                }

                // idEntity = activityService.getIdByName(activityName);

                quit = true;

            // } catch (EntityNotFoundExceptioin e) {
            //     System.out.println("Atividade não encontrada");
            // } catch (DatabaseException e) {
            //     System.out.println("Ocorreu algum erro no banco de dados!");
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }

        quit = false;
        Scanner value = new Scanner(System.in);
        if (idEntity > -1) {
            while (!quit) {

                System.out.println("Selecione um atributo para editar:\n"
                        + "[1] Tìtulo\n"
                        + "[2] Data de início\n"
                        + "[3] Data final\n"
                        + "[4] Inserir categoria\n"
                        + "[5] Remover cateoria\n"
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
                            text = value.nextLine();
                            // activityService.updateTitle(idEntity, text);
                            break;
                        case 2:
                            text = value.nextLine();
                            // activityService.updateStartDate(idEntity, text);
                            break;
                        case 3:
                            text = value.nextLine();
                            // activityService.updateEndDate(idEntity, text);
                            break;
                        case 4:
                            text = value.nextLine();
                            // activityService.addCategory(idEntity, text);
                            break;
                        case 5:
                            text = value.nextLine();
                            // activityService.removeCategory(idEntity, text);
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }

                    if (!quit) System.out.println("Dados atualizados!");

                } catch (InputMismatchException e) {
                    System.out.println("Você deve digiar um número correspondente a uma opção.");
                }
            }
        }
        value.close();

    }
}
