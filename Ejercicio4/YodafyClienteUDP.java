//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class YodafyClienteUDP {

	public static void main(String[] args) {
				
		byte [] buferEnvio;
		byte [] buferRecepcion = new byte[1024];
		
		// Nombre del host donde se ejecuta el servidor:
		String host = "localhost";
		// Puerto en el que espera el servidor:
		int port = 8989;
		
		// Socket para la conexión UDP
		DatagramSocket socketServicio;
		
		try {
			// Creamos un socket que se conecte a "host" y "port":
			socketServicio = new DatagramSocket();		
			
			// Traducimos el mensaje a un array de bytes:
			buferEnvio = "Al monte del volcan debes ir sin demora".getBytes();
			
			// Enviamos el array;
			DatagramPacket paquete = new DatagramPacket(buferEnvio, buferEnvio.length, InetAddress.getByName(host), port);
			socketServicio.send(paquete);

			// Leemos la respuesta del servidor. Para ello le pasamos un array de bytes, que intentará
			// rellenar.
			paquete = new DatagramPacket(buferRecepcion, buferRecepcion.length);
			socketServicio.receive(paquete);
			
			// Mostremos la cadena de caracteres recibidos:
			System.out.println("Recibido: ");
			for(int i = 0; i < paquete.getData().length; i++){
				System.out.print((char)paquete.getData()[i]);
			}
			
			// Una vez terminado el servicio, cerramos el socket (automáticamente se cierran
			// el inpuStream  y el outputStream)

			socketServicio.close();
			
			// Excepciones:
		} catch (UnknownHostException e) {
			System.err.println("Error: Nombre de host no encontrado.");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida al abrir el socket.");
		}
	}
}
