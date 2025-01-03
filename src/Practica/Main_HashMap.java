package Practica;

import java.util.HashMap;
import java.util.function.Supplier;

public class Main_HashMap {
    public static void main(String[] args) {
        // Supplier: Genera un HashMap predeterminado
        Supplier<HashMap<String, Integer>> generarMapa = () -> {
            HashMap<String, Integer> mapa = new HashMap<>();
            mapa.put("Max", 6);
            mapa.put("Nieve", 3);
            return mapa;
        };

        HashMap<String, Integer> perros = generarMapa.get();
        System.out.println(perros);
    }
}
