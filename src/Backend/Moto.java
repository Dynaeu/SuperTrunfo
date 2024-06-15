package Backend;

import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;

public class Moto {

    private String nome;
    private double peso;
    private int cilindrada;
    private double velocidade;
    private double aceleracao;
    private int potencia;

    public Moto(String nome) {
        this.nome = nome;
        this.peso = ThreadLocalRandom.current().nextDouble(120.00, 482.00);
        this.cilindrada = ThreadLocalRandom.current().nextInt(100, 1200);
        this.velocidade = ThreadLocalRandom.current().nextDouble(100.00, 330.00);
        this.aceleracao = ThreadLocalRandom.current().nextDouble(2.30, 10.00);
        this.potencia = ThreadLocalRandom.current().nextInt(100, 1200);
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public double getAceleracao() {
        return aceleracao;
    }

    public int getPotencia() {
        return potencia;
    }

    public static String imprimirNome(String nome, int length){
        // Calcula o comprimento do nome ajustado para alinhamento
        int nomeLength = Math.min(nome.length(), length); 

        String nomePreenchido = nome + " ".repeat(length - nomeLength);

        // Calcula o comprimento do score ajustado para alinhamento


        // Exibe o nome e o score alinhados com colunas
       return   nomePreenchido;

    }
    
    @Override
    public String toString() {
        int tamanho = nome.length()+5;
        return  "┎" +"━".repeat(tamanho+15)+ "┒"+
                "\n│ Nome Moto:  ╎ " + imprimirNome(nome,tamanho) + "│" +
                "\n│             ╎ "+" ".repeat(tamanho)+ "│" +
                "\n│             ╎ "+" ".repeat(tamanho)+ "│" +
                "\n│ Peso      : ╎ " + imprimirNome (new DecimalFormat("#.0#").format(peso),tamanho) + "│" +
                "\n│ Cilindrada: ╎ " + imprimirNome (String.valueOf(cilindrada),tamanho) + "│" +
                "\n│ Velocidade: ╎ " + imprimirNome (new DecimalFormat("#.0#").format(velocidade),tamanho) + "│" +
                "\n│ Aceleração: ╎ " + imprimirNome (new DecimalFormat("#.0#").format(aceleracao),tamanho) + "│" +
                "\n│ Potência  : ╎ " + imprimirNome (String.valueOf(potencia),tamanho) + "│" +
                "\n┖" +"━".repeat(tamanho+15)+ "┚";
    }
}