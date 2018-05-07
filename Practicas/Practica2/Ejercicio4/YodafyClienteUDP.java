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
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.DatagramSocket;		
import java.net.DatagramPacket;		
import java.net.InetAddress;

public class YodafyClienteUDP {

	public static void main(String[] args) {
		
		int port=8989;
		byte []buferEnvio = new byte[256];;
		byte []buferRecepcion = new byte[256];

		DatagramSocket socket = null;
		DatagramPacket paquete = null;
		InetAddress direccion=null;
		DatagramPacket paqueteYodificado = null; 

		String mensaje;

		try{
			socket = new DatagramSocket();
		}catch(IOException e){
			System.err.println("Error de entrada/salida en Socket");
		}

		try{
		direccion  = InetAddress.getByName("localhost");
		}catch(UnknownHostException e){
			System.out.println("Error al obtener la direccion");
		}

		buferEnvio = "Al monte del volcan debes ir sin demora".getBytes();

		try{

			paquete = new DatagramPacket(buferEnvio, buferEnvio.length, direccion, port);
			socket.send(paquete);

			paqueteYodificado = new DatagramPacket(buferRecepcion, buferRecepcion.length);
			socket.receive(paqueteYodificado);
		}catch(IOException e){
			System.err.println("Error de entrada/salida en el socket");
		}
		
		mensaje = new String(paqueteYodificado.getData());

		System.out.println("Recibido: " + mensaje + "\n");

		socket.close();

	}
}
