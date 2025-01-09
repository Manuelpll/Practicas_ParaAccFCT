package Practica.Estruturas_Control_y_Manejo_Lambda;

/**
 * Programa que integra la interfaz funcional ICalculadora y la utiliza con distintos metodos
 * @author Mparr
 * @date 09/07/2025
 */
public class Ejecutor {
    public static void main(String[] args) {
        //ICalculadora calculadora =  (n)-> System.out.println(n +"  Bienvenido a las expresiones lamda");
        //calculadora.mensaje("Manuel");

        ICalculadora calculadora1 = (n1,n2) -> {
            double resultado = n1+n2;
            System.out.println("La suma es "+resultado);
        };
        calculadora1.operacion(5.0,8.0);
        ICalculadora calculadora2 = (n1,n2) -> {
            double resultado = n1-n2;
            System.out.println("La resta es "+resultado);
        };
        calculadora2.operacion(15.0,9.0);

        ICalculadora calculadora3 = (n1,n2) -> {
            double resultado = n1*n2;
            System.out.println("La multiplicacion es "+resultado);
        };
        calculadora3.operacion(2.0,4.0);

        ICalculadora calculadora4 = (n1,n2) -> {
            double resultado = n1 / n2;
            System.out.println("La division es "+resultado);
        };
        calculadora4.operacion(2.0,4.0);
    }
}
