import view.MainView;

public class Main {
    public static void main(String[] args) {
        MainView mainView = new MainView();

        System.out.println("\r\n" + //
                        "┌─────────┐ ┌─────────┐ ┌───────────┐ \r\n" + //
                        "│  ┌──────┘ │  ┌──────┘ │  ┌─────┐  │\r\n" + //
                        "│  └──────┐ │  │┌─────┐ │  └─────┘  │\r\n" + //
                        "└──────┐  │ │  │└──┐  │ │  ┌─────┐  │\r\n" + //
                        "┌──────┘  │ │  └───┘  │ │  │     │  │\r\n" + //
                        "└─────────┘ └─────────┘ └──┘     └──┘\r\n" + //
                        "\r\n" + //
                        "SISTEMA DE GERENCIAMENTE DE ATIVIDADES");
        mainView.startView();
    }
}
