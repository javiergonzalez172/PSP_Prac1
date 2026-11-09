import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiltreLog {
    public static void main(String[] args) {
        int errorCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            System.out.println("Llegint fitxer...");
            while ((input = br.readLine()) != null) {
                System.out.println(input); //Comentar esta linea rompe el programa
                if (input.contains("ERROR")){
                    errorCount++;
                }
            }

        } catch (IOException e) {
            System.err.println("Error de lectura/escritura en el procés fill: " + e.getMessage());
        } finally {
            System.out.println("Trobat " + errorCount + " logs de tipus ERROR");
        }
    }
}
