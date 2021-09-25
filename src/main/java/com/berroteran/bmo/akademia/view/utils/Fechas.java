package com.berroteran.bmo.akademia.view.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class Fechas {

    public static String MY_TIME_ZONE = "America/Managua";

    static DateTimeFormatter fechaTimeFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate getFechaActual() {
        LocalDate currentDate = LocalDate.now(ZoneId.of(MY_TIME_ZONE));
        return currentDate;
    }

    public static int getAnioActual() {
        return getFechaActual().getYear();
    }

    public static int getAnioActualYY() {
        return Integer.parseInt(String.valueOf(getFechaActual().getYear()).substring(2));
    }

    public static String getMesActual(){
        return getFechaActual().getMonth().name();
    }

    public static int getMesActualInt(){
        return getFechaActual().getMonth().getValue();
    }
    public static String getMesActualStrg(){
        return String.format("%02d",  getFechaActual().getMonth().getValue() );
    }

    public static LocalDateTime getFechaHoraActual() {
        LocalDateTime currentDate = LocalDateTime.now(ZoneId.of(MY_TIME_ZONE));
        return currentDate;
    }

    public static DateTimeFormatter getFormatDateTime() {
        return fechaFormato;
    }

    public static DateTimeFormatter getFechaTimeFormato() {
        return fechaTimeFormato;
    }

    public static int getDiasDiff(LocalDate fechaInicial, LocalDate fechaFinal) {
        int dato =  Math.toIntExact( DAYS.between(fechaInicial, fechaFinal) );
        return dato;
    }

}
