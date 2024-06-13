package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class MainView implements View{
    private List<View> navigation;

    public MainView() {
        navigation = new ArrayList<>();
        ActivityInsertionFormView insertionForm = new ActivityInsertionFormView();

        navigation.add(new ActivityInsertionFormView());
        navigation.add(new ActivitySearchView());
    }
    
    @Override
    public void startView() {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!quit) {
            System.out.println("\nMENU PRINCIPAL");

            System.out.println("[1] Criar Nova Tarefa");
            System.out.println("[2] Buscar tarefa");
            System.out.println("[0] Sair");


            try {
                int option = scanner.nextInt();
                
                if (option == 0) {
                    quit = true;
                } else {
                    navigation.get(option-1).startView();
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("\rOpção incorreta!");
            }
        }
        scanner.close();
    }
}