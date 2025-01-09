package Practica.Estruturas_Control_y_Manejo_Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Perro perro1 = new Perro("Max",6,"Husky");
        Perro perro2 = new Perro("Nieve",3,"Pomerania");
        Perro perro3 = new Perro("Martin",5,"Beagle");
        Perro perro4 = new Perro("Niebla",4,"Alaska Malamute");
        Perro perro5 = new Perro("Algodon",8,"Bulldog");
        ArrayList<Perro> perros = new ArrayList<Perro>();
        añadirPerro(perros, perro1);
        añadirPerro(perros, perro2);
        añadirPerro(perros, perro3);
        añadirPerro(perros, perro4);
        añadirPerro(perros, perro5);
        List<Perro> perrosMayoresDeCuatro = perros.stream()
                .filter(perro -> perro.getEdad() > 4)
                .filter(perro -> perro.getNombre().toLowerCase().contains("n"))
                .collect(Collectors.toList());
        perrosMayoresDeCuatro.forEach(perro ->
                System.out.println("Nombre: " + perro.getNombre() + ", Edad: " + perro.getEdad() + ", Raza: " + perro.getRaza()));
        List <Perro> perroConNombreEmpezadoEnN= perros.stream()
                        .filter(perro ->perro.getNombre().startsWith("N"))
                                .collect(Collectors.toList());
        perroConNombreEmpezadoEnN.forEach(perro ->
                System.out.println("Nombre: "+perro.getNombre()+", Edad: "+perro.getEdad() +", Raza: "+perro.getRaza()));
    }

    private static void añadirPerro(ArrayList<Perro> perros, Perro perro) {
        perros.add(perro);
    }
}
