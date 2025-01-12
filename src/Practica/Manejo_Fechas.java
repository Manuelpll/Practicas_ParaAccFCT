package Practica;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Metodos de la libreria java.time
 * @author Mparr
 * @date  12/01/2025
 */
public class Manejo_Fechas {
    public static void main(String[] args) {
        //Fecha actual
        FechaActual();
        //Uso de off
        FechaPersonalizada();
        //Provocando un error
        ErrorPosible();
        //Añado tiempo
        AñadirTiempo();
        //Utilizo el TemporalAjuster
        MostrarFechaExacta();
        //Tiempo trasncurrido entre fechas y horas
        FranjadeTiempo();
        // Si queremos determinar cuanto falta para el fin de Año
        TiempoRestante();
        //Parseado de fechas
        FormateoDeFechas();
    }

    private static void FormateoDeFechas() {
        LocalDate fechaDeHoy = LocalDate.parse("2024-09-01");

        // Formatear correctamente la fecha con el patrón adecuado
        DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate sietedeOctubre = LocalDate.parse("07/10/2024", formatterEntrada);

        // Crear un formateador para mostrar la fecha en el formato deseado
        DateTimeFormatter formatterSalida = DateTimeFormatter.ofPattern("d/M/yyyy");

        System.out.println("Fecha de Hoy *****> " + fechaDeHoy.format(formatterSalida));
        System.out.println("Otra fecha *******> " + sietedeOctubre.format(formatterSalida));
    }

    private static void TiempoRestante() {
        LocalDate hoy =LocalDate.now();
        LocalDate finAnio = hoy.with(TemporalAdjusters.lastDayOfYear());
        Period hastafindeAnio =hoy.until(finAnio);
        int meses = hastafindeAnio.getMonths();
        int dias= hastafindeAnio.getDays();
        System.out.println("Faltan "+meses+" Meses "+dias+" días hasta final de año");
    }

    private static void FranjadeTiempo() {
        LocalDate fechaNacimiento=LocalDate.of(2004, Month.OCTOBER,28);

        System.out.println("La edad que tienes en Años es de "+
                ChronoUnit.YEARS.between(fechaNacimiento,LocalDate.now()));
    }

    private static void MostrarFechaExacta() {
        System.out.println("El primer día del Próximo mes es -->"+
                LocalDate.now().with(
                                TemporalAdjusters.firstDayOfNextMonth())
                        .getDayOfWeek());
    }

    private static void AñadirTiempo() {
        System.out.println("La fecha dentro de 2 días .......:"+LocalDate.now().plusDays(2));
        System.out.println("La fecha y hora de hace 48 horas.:"+ LocalDateTime.now().minusHours(48));
          /* La clase LocalDate tiene los siguientes métodos:
        plusDays()/ minusDays() --> Sumar o restar días a una fecha dada
        plusWeek()/ minusWeek() --> Sumar o restar semanas a una fecha dada
        plusMoths() / minusMoths() --> Sumar o restar meses a una fecha dada
        plusYears() / minusYears() ---> Sumar o restar años a una fecha dada
         */
    }

    private static void ErrorPosible() {
        System.out.println("Periodo Bisiesto de 2019 "+LocalDate.of(2020,Month.FEBRUARY,28));
        //Si coloco una fecha que no existe da la excepcion DateTimeExcepcion
    }

    private static void FechaPersonalizada() {
        System.out.println("Fecha de mi cumpleaños -->" +LocalDate.of(2004,Month.OCTOBER,31));
        System.out.println("Hora exacta ------------>"+LocalDateTime.of(1990,Month.DECEMBER,24,20,
                01,15,0017));
    }

    private static void FechaActual() {
        System.out.println("Fecha del Día de Hoy ----->" +LocalDate.now());
        System.out.println("Hora Actual-------------------->"+ LocalTime.now());
        System.out.println("Fecha y Hora Actual ----------->"+LocalDateTime.now());
        System.out.println("El momento actual ------------->"+Instant.now());
        System.out.println("Dia Actual  ...:"+LocalDate.now().getDayOfMonth());
        System.out.println("Mes actual  ...:"+LocalDate.now().getMonth()+" "+LocalDate.now().getMonthValue());
        System.out.println("Año Actual ....:"+LocalDate.now().getYear());
    }
}//Fin de Manejo_Fechas
