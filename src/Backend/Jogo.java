package Backend;

import Frontend.MenuPause;
import console.Console;
import console.Tecla;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Jogo {
    private List<Jogador> jogadores;
    private Baralho baralho;

    public Jogo(List<Jogador> jogadores, Baralho baralho) {
        this.jogadores = jogadores;
        this.baralho = baralho;
    }

    public void distribuirCartas() {
        if (baralho.getSize() < jogadores.size() * 3) {
            Console.println("Não há cartas suficientes no baralho para distribuir.");
            return;
        }

        for (Jogador jogador : jogadores) {
            for (int i = 0; i < 3; i++) {
                jogador.adicionarCarta(baralho.getCartaByIndex(i + (jogadores.indexOf(jogador) * 3)));
            }
        }
    }

    public boolean jogarRodada() {
        Console.limpaTela();
        Scanner scanner = new Scanner(System.in);

        // Mostrar cartas de cada jogador
        if (jogadores.size() == 1) {
            jogadores.get(0).mostrarCartas();
        } else {
            for (Jogador jogador : jogadores) {
                Console.println("-------------------");
                jogador.mostrarCartas();
            }
            Console.println("-------------------");
        }

        int escolha1 = obterEscolha(jogadores.get(0));
        Carta carta1 = jogadores.get(0).getCartas().get(escolha1);

        int escolha2;
        Carta carta2;

        if (jogadores.size() > 1) {
            escolha2 = obterEscolha(jogadores.get(1));
            carta2 = jogadores.get(1).getCartas().get(escolha2);
        } else {
            escolha2 = ThreadLocalRandom.current().nextInt(0, jogadores.get(0).getCartas().size());
            carta2 = jogadores.get(0).getCartas().get(escolha2); // Máquina escolhe uma carta aleatória
        }
        if (carta1 == null || carta2 == null) {
            Console.println("Erro ao obter as cartas dos jogadores.");
            return false;
        }

        Jogador vencedorRodada = determinarVencedorRodada(carta1, carta2);

        if (vencedorRodada != null) {
            Console.println("O vencedor da rodada é: " + vencedorRodada.getNome());
            vencedorRodada.adicionarPonto();
            if (vencedorRodada.getPontos() == 2) {
                Console.println("Aperte Enter para continuar.");
                Console.getTecla();
                return true; // Alguém ganhou o jogo
                
            }
        }
              
        Console.println("Aperte Enter para continuar.");
        Console.getTecla();
        Console.limpaTela();
                      
        jogadores.get(0).removerCarta(escolha1);
        jogadores.get(1).removerCarta(escolha2);

        return false; // O jogo continua
    }

    private int obterEscolha(Jogador jogador) {
        
        
            String numeroCartas="1";
            if (jogador.getCartas().size()==3){
                numeroCartas += ",2 ou 3";
            } else if (jogador.getCartas().size()==2){
                numeroCartas += " ou 2";
            }               
            Console.println(jogador.getNome() + ", escolha uma carta para jogar ("+numeroCartas+"), ou P para pausar.");
            
        return processarEscolha();
    }
private int processarEscolha (){
    Tecla escolha = Console.getTecla();
          
       if (escolha==Tecla.NUM_1){
           Console.println("1"); 
           return 0;
       } 
       if (escolha==Tecla.NUM_2){           
           Console.println("2"); 
           return 1;       
       }
       if (escolha==Tecla.NUM_3){
           Console.println("3");
           return 2;          
       }       
       if (escolha==Tecla.P){
           MenuPause.mostrarOpcoes();
           Console.limpaTela();
       }
       return processarEscolha();
}
    
    private Jogador determinarVencedorRodada(Carta carta1, Carta carta2) {
        // Comparar atributos das cartas (exemplo comparando por peso, pode mudar conforme necessidade)
        if (carta1.getPeso() > carta2.getPeso()) {
            return jogadores.get(0);
        } else if (carta1.getPeso() < carta2.getPeso()) {
            return jogadores.get(1);
        } else {
            // Em caso de empate (se necessário)
            return null;
        }
    }

    public Jogador getVencedor() {
        for (Jogador jogador : jogadores) {
            if (jogador.getPontos() == 2) {
                return jogador;
            }
        }
        return null;
    }
}