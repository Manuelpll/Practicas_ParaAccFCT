package Practica;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente_TCP {
    public static void main(String[] args) throws IOException {
        final int puerto = 20084;
        Socket socket = new Socket("localhost", puerto);
        Scanner entrada = new Scanner(socket.getInputStream());
        System.out.println("Respuesta del servidor: "+entrada.nextLine());
    }
}
