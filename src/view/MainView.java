package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class MainView implements View{
    private List<View> navigation;

    public MainView() {
        navigation = new ArrayList<>();

        navigation.add(new ActivityInsertionFormView());
        navigation.add(new ActivitySearchView());
        navigation.add(new EditActivityView());
        navigation.add(new RemoveActivityView());
    }
    
    @Override
    public void startView() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!quit) {
            System.out.println("\nMENU PRINCIPAL");

            System.out.println("[1] Criar Nova Tarefa");
            System.out.println("[2] Buscar tarefa");
            System.out.println("[3] Editar tarefa");
            System.out.println("[4] Remover tarefa");
            System.out.println("[0] Sair");


            try {
                int option = scanner.nextInt();
                
                if (option == 0) {
                    quit = true;
                } else {
                    navigation.get(option-1).startView();
                }
            } catch (InputMismatchException e) {
                System.out.println("Você deve digitar um número correspondente a uma opção.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Opção não encontrada.");
            }
        }
        scanner.close();
    }
}