import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class AnalitzadorPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escriu el nom del fitxer log: ");
        String arxiu = scanner.nextLine();
        scanner.close();

        try {
            String java = Paths.get(System.getProperty("java.home"),"bin","java").toString();
            String classpath = System.getProperty("java.class.path");
            ProcessBuilder pb = new ProcessBuilder( java, "-cp", classpath, "FiltreLog");
            Process p = pb.start();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader brSortida = new BufferedReader(new FileReader(arxiu));

            String currentLine;
            String outputLine;
            while ((currentLine = brSortida.readLine()) != null) {
                writer.write(currentLine);
                writer.newLine();
                writer.flush();

                outputLine = reader.readLine();
                System.out.println(outputLine);
            }

            writer.close();
            reader.close();
            brSortida.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}