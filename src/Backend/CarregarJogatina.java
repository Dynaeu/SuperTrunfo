package Backend;

import console.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarregarJogatina {

    public static String carregar(String path) {
        return lerArquivo(getSavesPath() + path);
    }

    public static String lerArquivo(String path) {
        StringBuilder data = new StringBuilder();
        try {
            File arquivo = new File(path);
            Scanner scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
                data.append(System.lineSeparator());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            Console.println("Erro ao carregar o arquivo: " + path);
        }
        return data.toString();
    }

    public static File[] listaArquivo(String path) {
        File file = new File(path);
        return file.listFiles();
    }

    // Método simplificado para obter o caminho onde os saves serão armazenados
    public static String getSavesPath() {
        return "saves/";
    }
}
