 package view;

import java.util.Scanner;

public class ActivityInsertionFormView implements View {

    public void startView() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("FORMULÁRIO DE CADASTRO DE ATIVIDADE");
        
        System.out.print("Nome da atividade: ");
        String title = scanner.nextLine();

        System.out.print("Data inicial (no formato dd/mm/aaaa): ");
        String startDateStr = scanner.nextLine();

        System.out.print("Horário (no formato hh:mm): ");
        String startTimeStr = scanner.nextLine();

        System.out.print("Data final (no formato dd/mm/aaaa): ");
        String endtDateStr = scanner.nextLine();
        
        System.out.print("Horário (no formato hh:mm): ");
        String endTimeStr = scanner.nextLine();

        System.out.print("Categoria: ");
        String category = scanner.nextLine();
    }
 }