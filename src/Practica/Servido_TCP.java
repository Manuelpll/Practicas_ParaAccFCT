package Practica;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Servido_TCP {
    public static void main(String[] args) throws IOException {
        final int puerto = 20084;

        try(ServerSocket listener = new ServerSocket(puerto)) {
            System.out.println("El servidor se ha iniciado");
            while(true) {
                try(Socket socket = listener.accept()) {
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

                    pw.println(LocalDateTime.now());
                }
            }
        }
    }
}
