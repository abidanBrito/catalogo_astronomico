package com.example.catalogoastronomico;

import java.util.Objects;

/**
 *
 * @author (IOT)
 * @version (2020)
 *
 */
public class Estrella extends Astro {
    private int planetas;
    private Galaxia galaxia;

    public Estrella(String nombre, double brillo, double distancia, int planetas, Galaxia galaxia) {
        super(nombre, brillo, distancia);
        this.planetas = planetas;
        this.galaxia = galaxia;
    }

    public int getPlanetas() {
        return planetas;
    }

    public void setPlanetas(int planetas) {
        this.planetas = planetas;
    }

    public Galaxia getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(Galaxia galaxia) {
        this.galaxia = galaxia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estrella estrella = (Estrella) o;
        return planetas == estrella.planetas &&
                Objects.equals(galaxia, estrella.galaxia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planetas, galaxia);
    }

    @Override
    public String toString() {
        return "objeto-Astro {" +
                "nombre: " + super.getNombre() +
                ", tipo: Estrella" +
                ", brillo: " + super.getBrillo() +
                ", distancia: " + super.getDistancia()+
                ", planetas: " + planetas +
                ", galaxia: " + galaxia.getNombre() +
                '}';
    }
}
