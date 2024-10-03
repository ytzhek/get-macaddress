package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Principal {

	    public static void main(String[] args) {
	        // Comando a ejecutar
	        String[] comando = {"ipconfig", "/all"};

	        try {
	            // Crear el proceso
	            ProcessBuilder builder = new ProcessBuilder(comando);
	            builder.redirectErrorStream(true); // Combinar salida de error y salida est�ndar
	            Process proceso = builder.start();

	            // Leer la salida del comando
	            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	            String linea;

	            while ((linea = reader.readLine()) != null) {
	              //  System.out.println(linea);
	               
	                if (linea.contains("Adaptador") && (linea.contains("Wi-Fi"))) {
	                    System.out.println(linea);
	                }    
	            }

	            // Esperar a que el proceso termine
	            int exitCode = proceso.waitFor();
	            System.out.println("C�digo de salida: " + exitCode);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
