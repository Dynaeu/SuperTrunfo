package Backend;

import console.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SalvarJogatina {

    // Método para escrever o texto em um arquivo
    public static void escreverArquivo(String path, String texto) {
        try {
            // Certifique-se de que o diretório de saves existe
            File file = new File(path).getParentFile();
            if (!file.exists()) {
                file.mkdirs();
            }

            FileWriter arquivo = new FileWriter(path);
            arquivo.write(texto);
            arquivo.close();
            Console.println("Arquivo salvo em: " + path); // Mensagem de depuração
        } catch (IOException e) {
            Console.println("Erro ao Salvar o Jogo.");
        }
    }

    // Método para criar o save, recebendo as dimensões e o estado do tabuleiro como parâmetros
    public static void criarSave(String path, int totalColunas, int totalLinhas, String[][] fundo, int pontos) {
        StringBuilder resultado = new StringBuilder();
        for (int xDim = 0; xDim < totalColunas; xDim++) {
            for (int yDim = 0; yDim < totalLinhas; yDim++) {
                resultado.append(fundo[xDim][yDim]);
                if (!(xDim == (totalColunas - 1) && yDim == (totalLinhas - 1))) {
                    resultado.append(";");
                }
            }
        }
        resultado.append(";").append(pontos);
        SalvarJogatina.escreverArquivo(getSavesPath() + path, resultado.toString());
    }

    // Método simplificado para obter o caminho onde os saves serão armazenados
    public static String getSavesPath() {
        return "saves/";
    }
}
