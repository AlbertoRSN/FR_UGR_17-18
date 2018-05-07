

//PARTE REALIZADA POR  ALICIA RODRIGUEZ SANCHEZ

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;

public class Procesador extends Thread {

    private Socket socketServicio;

    public Procesador(Socket socketServicio) {
        this.socketServicio = socketServicio;
    }

    public void run() {
        procesa();
    }

    void procesa() {
        String buferRecepcion = null;
        String buferEnvio = null;

        String mensajeRecibido;
        String[] mens;
        String resultado = "";

        boolean fin = false;

        InputStream inputStream = null;
        OutputStream outputStream = null;

        PrintWriter outPrinter = null;
        BufferedReader inReader = null;



        try {
            inputStream = socketServicio.getInputStream();
            outputStream = socketServicio.getOutputStream();
            inReader = new BufferedReader(new InputStreamReader(inputStream));
            outPrinter = new PrintWriter(outputStream, true);

            while(fin == false){

                buferRecepcion = inReader.readLine();
                mensajeRecibido = buferRecepcion; //Aqui recibe mensaje cliente

                mens= mensajeRecibido.split(" "); //Aqui nos quedamos con la primera palabra
                resultado=mens[0];

                    if (resultado.equals("Hora")) {
                        buferEnvio = "Cita Seleccionada";
                         outPrinter.println(buferEnvio);
                         outPrinter.flush();
                        fin = true;
                    }

                    else{

                    if (resultado.equals("Quiero")) {
                        buferEnvio = "Gestion Academica - Rel. Internacionales - Solicitud Titulo";
                    } 

                    if(resultado.equals("Gestion")){
                        buferEnvio = "Dias Disponibles: Lunes - Martes - Jueves";
                    }

                    if(resultado.equals("Dia")){
                        buferEnvio = "Franjas Horarias Disponibles: 9h-10h-11h-12h-13h";

                    }

                    if(resultado.equals("Franja")){
                        buferEnvio = "Horas disponibles: 10:05 - 10:30 - 10:35 - 10:47 - 10:53";
                    }


                    System.out.println("\nServidor envía: " + buferEnvio);

                    outPrinter.println(buferEnvio);
                    outPrinter.flush();

                }
                     buferRecepcion = inReader.readLine();
                     mens = mensajeRecibido.split(" "); //Aqui nos quedamos con la primera palabra
                     resultado=mens[0];



                    if (resultado.equals("Hora ")) {
                        fin = true;
                        socketServicio.close();
                        System.out.println("\nEl cliente ha seleccionado la cita correctamente. Sale del sistema.");
                    } 

                    else {
                        System.out.println("\n\tRespuesta de cliente: " + buferRecepcion);
                    }

            } 

        } catch (IOException e) {
            System.err.println("Error al obtener los flujo de entrada/salida.");
        }
    }
}