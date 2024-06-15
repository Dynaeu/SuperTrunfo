package Backend;

import console.Console;
import java.util.Scanner;

public class JogoUtil {
    public static void carregarPartida() {
        Console.print("Digite o nome do arquivo para carregar: ");
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = scanner.nextLine();
        String jogoSalvo = CarregarJogatina.carregar(nomeArquivo);
        Console.println("Partida carregada do arquivo: " + jogoSalvo);
        // Logica para aplicar o estado carregado no jogo
    }
}