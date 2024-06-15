package Frontend;

import console.Console;
import java.util.Scanner;
import Backend.SalvarJogatina;
import Backend.JogoUtil;

public class MenuPause {

    public static void mostrarOpcoes() {
        Scanner scanner = new Scanner(System.in);
        Console.limpaTela();
        while (true) {
            Console.println("                         ┌┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┐");
            Console.println("                         │                                                   │");
            Console.println("                         │ Menu Pause:                                       │");
            Console.println("                         │ 1. ==> Salvar partida em um arquivo               │");
            Console.println("                         │ 2. ==> Carregar partida de um arquivo             │");
            Console.println("                         │ 3. ==> Voltar para o Jogo                         │");
            Console.println("                         │ 4. ==> Voltar ao Menu Principal                   │");
            Console.println("                         │ Escolha uma opção:                                │");
            Console.println("                         │                                                   │");
            Console.println("                         └┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┘");

            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    salvarPartida();
                    break;
                case 2:
                    JogoUtil.carregarPartida();
                    break;
                case 3:
                    voltarParaOJogo();
                    return;
                case 4:
                    voltarAoMenuPrincipal();
                    return;
                default:
                    Console.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void salvarPartida() {
        Console.print("Digite o nome do arquivo para salvar: ");
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = scanner.nextLine();
        int totalColunas = 10;
        int totalLinhas = 10;
        String[][] fundo = new String[totalColunas][totalLinhas];
        int pontos = 100;

        for (int i = 0; i < totalColunas; i++) {
            for (int j = 0; j < totalLinhas; j++) {
                fundo[i][j] = "0";
            }
        }

        SalvarJogatina.criarSave(nomeArquivo, totalColunas, totalLinhas, fundo, pontos);
        Console.println("Partida salva em um arquivo.");
    }

    private static void voltarParaOJogo() {
        Console.println("Voltando para o jogo.");
        // Lógica para voltar para o jogo
    }

    private static void voltarAoMenuPrincipal() {
        Console.println("Voltando ao Menu Principal.");
        // Finaliza a execução do jogo atual
        System.exit(0);
    }
}