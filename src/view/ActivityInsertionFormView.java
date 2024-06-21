 package view;

import java.util.Scanner;
import service.ActivityService;

public class ActivityInsertionFormView implements View {
    private ActivityService activityService = new ActivityService();

    @Override
    public void startView() {
        System.out.println("FORMULÁRIO DE CADASTRO DE ATIVIDADE");
        Scanner scanner = new Scanner(System.in);

        try {
            activityService.save("Atividade 1", "20/06/2024 08:00", "20/06/2024 09:00", 1);               
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 }