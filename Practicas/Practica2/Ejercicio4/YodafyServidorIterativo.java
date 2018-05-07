import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.DatagramSocket;		
import java.net.DatagramPacket;		
import java.net.InetAddress;		
import java.util.Random;

//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
public class YodafyServidorIterativo {

	public static void main(String[] args) {
	
		int port=8989;
		DatagramSocket socketServidor=null;
		int puerto;
		byte []bufferEnvio=new byte[256];
		byte []bufferRecepcion=new byte[256];
		//Direccion
		InetAddress direccion;
		DatagramPacket paquete;
		DatagramPacket paqueteYodificado;
		String recibido;
		
		try {
			socketServidor = new DatagramSocket(port);
		} catch (IOException e) {
			System.err.println("Error: no se pudo atender en el puerto "+port);
		}

		do{
			paquete = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
			
			try{
				socketServidor.receive(paquete);
			}catch (IOException e) {
				System.err.println("Error: no se pudo atender en el puerto "+port);
			}

			
			recibido = new String(paquete.getData());
			direccion = paquete.getAddress();
			puerto = paquete.getPort();
			
			String[] s = recibido.split(" ");
			String resultado="";

			Random random = new Random();
		
			for(int i=0;i<s.length;i++){
				int j=random.nextInt(s.length);
				int k=random.nextInt(s.length);
				String tmp=s[j];
			
				s[j]=s[k];
				s[k]=tmp;
			}
		
			resultado=s[0];
			for(int i=1;i<s.length;i++){
		  		resultado+=" "+s[i];
			}


			bufferEnvio = resultado.getBytes();


			paqueteYodificado = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccion, puerto);

			try{
				socketServidor.send(paqueteYodificado);
			}catch (IOException e) {
				System.err.println("Error: no se pudo atender en el puerto "+port);
			}	

		}while (true);

		//Cerrar el socket
		//socketServidor.close();

	}

}
