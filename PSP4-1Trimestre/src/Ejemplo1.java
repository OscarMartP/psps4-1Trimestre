

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ejemplo1 {

	public static void main(String[] args) throws IOException {
		
		Process p = new ProcessBuilder("CMD", "/C", "DATE").start();
		
		// Enviamos la nueva feca para su escritura a la entrada a DATE
		OutputStream OS = p.getOutputStream();
		OS.write("15-03-21".getBytes());
		OS.flush(); // Guarda y vacia el buffer de salida
		
		// Leemos la salida DATE
		InputStream IS = p.getInputStream();
		int C;
		
			while ((C = IS.read()) != -1) {
				
				System.out.print((char) C);
				
			}
			
			IS.close();
		
		// Comprobamos si se ha producido error en el proceso -0 bien - 1 mal
		int exitVAL;
		
			try {
				
				exitVAL = p.waitFor();
					System.out.println("Valor de Salida: " + exitVAL);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
// para que cambie la fecha se necesitan permisos de administrador del cmd, pero nose el codigo para ejecutarlo.
		

	}

}