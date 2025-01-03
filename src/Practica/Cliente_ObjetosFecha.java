package Practica;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

public class Cliente_ObjetosFecha {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int puerto = 20064;

        Socket socket = new Socket("localhost", puerto);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Date fecha = (Date) ois.readObject();

        System.out.println(fecha.toString());
    }
}
