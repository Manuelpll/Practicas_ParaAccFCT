package Practica.Estruturas_Control_y_Manejo_Lambda;
/*
Es una interfaz funcional para luego poder definir el metodo en el Ejecutor
 */
@FunctionalInterface
public interface ICalculadora {
    void operacion(Double a, Double b);
}
