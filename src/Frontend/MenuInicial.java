package Frontend;

import Backend.Baralho;
import Backend.Jogo;
import Backend.Jogador;
import console.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Backend.JogoUtil;

public class MenuInicial {
    public static void mostrarOpcoes() {
        Scanner scanner = new Scanner(System.in);
        while (true) { 
            Console.limpaTela();
            Console.println("                         ┌┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┐");
            Console.println("                         │            ⦊⦊⦊⦊⦊⦊⦊⦊⦊ SUPER TRUNFO ⦉⦉⦉⦉⦉⦉⦉⦉⦉             │");
            Console.println("                         │                                                         │");
            Console.println("                         │                  Escolha uma opcao:                     │");
            Console.println("                         │      1.       >> Iniciar novo jogo <<                   │");
            Console.println("                         │      2. >> Carregar partida a partir de um arquivo <<   │");
            Console.println("                         │      3.         >> Sair do jogo <<                      │");
            Console.println("                         │                                                         │");
            Console.println("                         │            ⦊⦊⦊⦊⦊⦊⦊⦊⦊ SUPER TRUNFO ⦉⦉⦉⦉⦉⦉⦉⦉⦉             │"); 
            Console.println("                         └┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┘");
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    iniciarNovoJogo();
                    break;
                case 2:
                    JogoUtil.carregarPartida();
                    break;
                case 3:
                    sairDoJogo();
                    return; // Sai do loop e termina o método
                default:
                    Console.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void iniciarNovoJogo() {
        Console.limpaTela();
        Scanner scanner = new Scanner(System.in);

        Console.println("Quantos jogadores?");
        int numeroJogadores = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        List<Jogador> jogadores = new ArrayList<>();
        for (int i = 1; i <= numeroJogadores; i++) {
            Console.limpaTela();
            Console.print("Nome do Jogador " + i + ": ");
            String nome = scanner.nextLine();
            jogadores.add(new Jogador(nome));
        }

        if (numeroJogadores < 2) {
            jogadores.add(new Jogador("Máquina"));
        }

        Baralho baralho = new Baralho();
        baralho.geraBaralho();
        baralho.embaralhar();

        Jogo jogo = new Jogo(jogadores, baralho);
        jogo.distribuirCartas();

        boolean jogoFinalizado = false;
        while (!jogoFinalizado) {
            jogoFinalizado = jogo.jogarRodada();
        }

        Jogador vencedor = jogo.getVencedor();
        if (vencedor != null) {
            Console.println("O vencedor do jogo é: " + vencedor.getNome());
        }
    }

    private static void sairDoJogo() {
        Console.println("Saindo do jogo.");
        System.exit(0);
    }
}