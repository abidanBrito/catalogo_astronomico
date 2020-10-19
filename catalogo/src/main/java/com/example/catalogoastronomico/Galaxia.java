package com.example.catalogoastronomico;
/**
 *
 * @author (IOT)
 * @version (2020)
 *
 */
public class Galaxia extends Astro {
    public Galaxia(String nombre, double brillo, double distancia) {
        super(nombre, brillo, distancia);
    }

    @Override
    public String toString() {
        return "objeto-Astro {" +
                "nombre: " + super.getNombre() +
                ", tipo: Galaxia" +
                ", brillo: " + super.getBrillo() +
                ", distancia: " + super.getDistancia() +
                '}';
    }
}
