package Practica.Manejo_Servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor_MultiHilo  {
    public static void main (String[] args) throws IOException {
        try(ServerSocket listener = new ServerSocket(20064)) {
            System.out.println("El servidor multihilo se ha iniciado...");
          ExecutorService poll= Executors.newFixedThreadPool(20);
          while (true)
poll.execute(new Capitalizacion (listener.accept()));
        }
    }
    private static class Capitalizacion implements Runnable {
        private Socket socket;

        public Capitalizacion(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Conectado"+socket);
    try{
           Scanner lector = new Scanner(socket.getInputStream());
           PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

           while(lector.hasNextLine ()){
               pw.println(lector.nextLine().toUpperCase());

           }


    }catch(IOException e){
        System.out.println("Error -> "+e.getMessage());
    }finally {
        try {
            socket.close();
        }catch (IOException e){
            System.out.println("Error -> "+e.getMessage());
        }
        System.out.println("Cerrado :"+socket);
    }
        }
    }
}
