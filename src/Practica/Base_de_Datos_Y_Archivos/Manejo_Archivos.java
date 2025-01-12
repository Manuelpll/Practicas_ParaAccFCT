package Practica.Base_de_Datos_Y_Archivos;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Manejo_Archivos {
    private static void CrearArchivoAleatorio(String fileName) throws IOException {
    try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
        System.out.println("Archivo aleatorio creado: " + fileName);
    }//Fin try-catch
    }

    private static void CrearArchivoSecuencial(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Archivo secuencial creado: " + fileName);
        }//Fin try-catch
    }

    private static void AñadirInformacion(String fileName, String data, boolean isRandom) throws IOException {
        if (isRandom) {
            try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
                file.seek(file.length());
                file.writeUTF(data);
                System.out.println("Información añadida al archivo aleatorio.");
            }//Fin try-catch
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(data);
                writer.newLine();
                System.out.println("Información añadida al archivo secuencial.");
            }//Fin try-catch
        }//Fin del if-else
    }

    private static void CrearFicheroObjetos(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            System.out.println("Archivo de objetos creado: " + fileName);
        }//Fin try-catch
    }

    private static void AñadirObjetoAlFichero(String fileName, Serializable obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
            oos.writeObject(obj);
            System.out.println("Objeto añadido al archivo de objetos.");
        }//Fin try-catch
    }

    private static void LeerFichero(String fileName, boolean isRandom) throws IOException, ClassNotFoundException {
        if (isRandom) {
            try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
                String data;
                while ((data = file.readUTF()) != null) {
                    System.out.println("Leído del archivo aleatorio: " + data);
                }//Fin while
            }//Fin try-catch
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Leído del archivo secuencial: " + line);
                }
            }//Fin try-catch
        }//Fin del if-else
    }

    private static void LecturaArchivoObjetos(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            List<Object> objetos = new ArrayList<>();
            Object obj; //Aqui lo cambio por el objeto que corresponda

            while (true) {
                try {
                    obj = ois.readObject();
                    objetos.add(obj);
                } catch (EOFException e) {
                    // Se alcanzó el final del archivo
                    break;
                }//Fin try-catch
            }//Fin while

            for (Object objeto : objetos) {
                System.out.println("Objeto leído: " + objeto.toString());
            }//Fin for
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }//Fin try-catch
    }

    private static void ObtenerMetadataArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            System.out.println("Nombre del archivo: " + archivo.getName());
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Tamaño del archivo: " + archivo.length() + " bytes");
            System.out.println("¿Es un directorio?: " + archivo.isDirectory());
            System.out.println("¿Es un archivo?: " + archivo.isFile());
            System.out.println("¿Es ejecutable?: " + archivo.canExecute());
            System.out.println("¿Es legible?: " + archivo.canRead());
            System.out.println("¿Es escribible?: " + archivo.canWrite());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("Última modificación: " + sdf.format(archivo.lastModified()));
        } else {
            System.out.println("El archivo no existe.");
        }//Fin if-else
    }
}//Fin de Manejo_Archivos
