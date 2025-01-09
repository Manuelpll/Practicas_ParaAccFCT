package Practica.Estruturas_Control_y_Manejo_Lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Programa que explica los diferes usos del lambda
 * @author Mparr
 * @date 09/01/2025
 */
public class Uso_Basico_Lambda {
    public static void main(String[] args) {
        //Uso del lambda como un consumer para imprimir una lista de paises
        List<String> listapa = new ArrayList<>(); //Se puede utilizar tambien com objetos el lambda
        listapa.add("Argentina");
        listapa.add("Bolivia");
        listapa.add("Peru");
        listapa.add("Dinamarca");
        listapa.forEach(lis-> System.out.println("Pais: "+lis));

        System.out.println("--------------------------------");
        //Uso del lambda para utilizarlo como filtro de informacion
        List <Integer> listanum = new ArrayList<>();
        listanum.add(18);
        listanum.add(12);
        listanum.add(31);
        listanum.add(9);
        listanum.add(5);
        listanum.add(37);
        listanum.add(70);
        listanum.stream().filter(edad -> edad >=18 && edad<=31).forEach(lis-> System.out.println("Edad: "+lis));
    }
}
