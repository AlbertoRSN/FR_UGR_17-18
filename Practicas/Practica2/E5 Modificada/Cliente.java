
// PARTE REALIZADA POR ALBERTO RODRIGUEZ SANTANA

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        String buferEnvio;
        String buferRecepcion = null;
        String resultado="";
        String[] mens;
        String mensajeRecibido;


        String host = "localhost";
        int port = 8989;

        boolean fin = false;

        Socket socketServicio = null;

        InputStream inputStream = null;
        OutputStream outputStream = null;
        PrintWriter outPrinter = null;
        BufferedReader inReader = null;


        try {
            socketServicio = new Socket(host, port);
            inputStream = socketServicio.getInputStream();
            outputStream = socketServicio.getOutputStream();
            outPrinter = new PrintWriter(outputStream, true);
            inReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            System.err.println("Error de entrada/salida al abrir el socket.");
        }

        buferEnvio = "Quiero Cita";

        do {


            try {


                System.out.println("\nCliente envía: " + buferEnvio);


                outPrinter.println(buferEnvio);
                outPrinter.flush();

                buferRecepcion = inReader.readLine();
                mensajeRecibido = buferRecepcion; //Aqui recibe mensaje cliente

                mens= mensajeRecibido.split(" "); //Aqui nos quedamos con la primera palabra
                resultado=mens[0];


                if (resultado.equals("Cita")) {
                    fin = true;
                    socketServicio.close();
                    System.out.println("\n\tRespuesta de servidor: Cita Guardada");

                } else {

                    if (resultado.equals("Gestion")) {
                        buferEnvio = "Gestion Academica";
                        outPrinter.println(buferEnvio);
                        outPrinter.flush();
                    } 

                    if (resultado.equals("Dias")) {
                        buferEnvio = "Dia Lunes";
                        outPrinter.println(buferEnvio);
                        outPrinter.flush();
                    } 

                    if (resultado.equals("Franjas")) {
                        buferEnvio = "Franja 10h";outPrinter.println(buferEnvio);
                        outPrinter.flush();
                    }

                    if (resultado.equals("Horas")) {
                        buferEnvio = "Hora 10:35";
                        outPrinter.println(buferEnvio);
                        outPrinter.flush();
                    } 

                    System.out.println("\n\tRespuesta de servidor: " + buferRecepcion);
                    


                }

            } catch (IOException e) {
                System.err.println("Error de entrada/salida al abrir el socket.");
            }
        } while (!fin);
    }
}