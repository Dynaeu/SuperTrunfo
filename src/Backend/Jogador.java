package Backend;

import console.Console;
import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private final String nome;
    private final List<Carta> cartas;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        this.cartas = new ArrayList<>();
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPonto() {
        pontos++;
    }

    public void adicionarCarta(Carta carta) {
        cartas.add(carta);
    }

    public void removerCarta(int index) {
        cartas.remove(index);
    }

    public void mostrarCartas() {
        Console.println("Cartas de " + nome + ":");
        for (int i = 0; i < cartas.size(); i++) {
            Console.println((i + 1) + ". " + cartas.get(i));
        }
    }
}
