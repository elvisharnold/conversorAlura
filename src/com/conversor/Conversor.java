package com.conversor;

import java.util.HashMap;
import java.util.Map;

public class Conversor {

    private Map<String, Double> factores;

    public Conversor() {
        factores = new HashMap<>();
        factores.put("Metro", 1.0);
        factores.put("Centímetro", 0.01);
        factores.put("Pulgada", 0.0254);
        factores.put("Pie", 0.3048);
        factores.put("Kilómetro", 1000.0);
        factores.put("Millas", 1609.344);
        factores.put("Celsius", 1.0);
        factores.put("Fahrenheit", 0.5555555555555556);
        factores.put("Kelvin", 1.0);        
        factores.put("Dólar", 1.0);
        factores.put("Euro", 0.9374);
        factores.put("Libra E", 0.8204);
        factores.put("Yen", 132.01);
        factores.put("Won CS", 1305.34);
        factores.put("Nuevo Sol", 3.7898);
    }

    public double convertir(String unidadOrigen, String unidadDestino, double cantidad) {
        if (unidadOrigen.equals(unidadDestino)) {
            return cantidad;
        } else if (unidadOrigen.equals("Celsius") && unidadDestino.equals("Fahrenheit")) {
            return (cantidad * 1.8) + 32;
        } else if (unidadOrigen.equals("Fahrenheit") && unidadDestino.equals("Celsius")) {
            return (cantidad - 32) / 1.8;
        } else if (unidadOrigen.equals("Celsius") && unidadDestino.equals("Kelvin")) {
            return cantidad + 273.15;
        } else if (unidadOrigen.equals("Kelvin") && unidadDestino.equals("Celsius")) {
            return cantidad - 273.15;
        } else {
            double factorOrigen = factores.get(unidadOrigen);
            double factorDestino = factores.get(unidadDestino);
            return cantidad * factorDestino / factorOrigen;
        }
    }
}
//probando mi git 