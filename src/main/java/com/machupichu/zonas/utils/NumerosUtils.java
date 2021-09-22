package com.machupichu.zonas.utils;

import java.text.DecimalFormat;

public class NumerosUtils {

    public static double truncateValor(Double valor) {
        try {
            DecimalFormat df2 = new DecimalFormat("#####0.000");
            String cadena = new Double(df2.format(valor)).toString();
            int puntoPosicion = cadena.indexOf(".");
            String resto = cadena.substring(puntoPosicion);

            cadena = cadena.concat("00");
            String newCadena = cadena.substring(0, puntoPosicion + 3);
            return Double.valueOf(newCadena);
        } catch (Exception e) {
            System.out.println("Truncate: valor del objeto pasado" + valor);
            e.printStackTrace();
            return 0d;
        }
    }

    public static double truncateValor3(Double valor) {
        try {
            if ( valor == null )
                return 0;

            DecimalFormat df2 = new DecimalFormat("#####0.000");
            String cadena = new Double(df2.format(valor)).toString();
            int puntoPosicion = cadena.indexOf(".");
            String resto = cadena.substring(puntoPosicion);

            cadena = cadena.concat("00000");
            int totalCadena = puntoPosicion + 5;
            if ( totalCadena > cadena.length() )
                totalCadena = cadena.length();
            String newCadena = cadena.substring(0, totalCadena);
            return Double.valueOf(newCadena);
        } catch (Exception e) {
            System.out.println("Truncate: valor del objeto pasado" + valor);
            e.printStackTrace();
            return 0d;
        }
    }

}
