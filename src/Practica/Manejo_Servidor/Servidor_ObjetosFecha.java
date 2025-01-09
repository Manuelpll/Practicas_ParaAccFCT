package Practica.Manejo_Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor_ObjetosFecha {
    public static void main(String[] args) throws IOException {
        final int puerto = 20064;
        ServerSocket socket ;
        Socket socketcliente;

        try {
            socket = new ServerSocket(puerto);

            while ((socketcliente= socket.accept()) != null){
                System.out.println("Conexion desde : "
                        +socketcliente.getInetAddress());

                ObjectOutputStream os = new ObjectOutputStream(socketcliente.getOutputStream());
                os.writeObject(new Date());
                os.close();
            }

        }catch (IOException e){
            System.err.println("Error ->"+e.getMessage());
        }
    }
}
