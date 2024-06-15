package Backend;

public class Carta extends Moto {

    private final String letra;
    private final int numero;
    private final boolean superTrunfo;

    public Carta(String letra, int numero, String nome, boolean superTrunfo) {
        super(nome);
        this.letra = letra;
        this.numero = numero;
        this.superTrunfo = superTrunfo;
    }

    public String getLetra() {
        return letra;
    }

    public int getNumero() {
        return numero;
    }


    public boolean getSuperTrunfo() {
        return superTrunfo;
    }

    @Override
    public String toString() {
        String str = "CARTA : " + letra + numero;

        if (superTrunfo) {
            str += " (SUPER TRUNFO)";
        }

        return str + "\n" + super.toString();
    }
}
