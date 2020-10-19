package com.example.catalogoastronomico;

import java.util.Objects;

/**
 *
 * @author (IOT)
 * @version (2020)
 *
 */


public class EstrellaConTipo extends Estrella{
    private TipoEstrella tipo;

    public EstrellaConTipo(String nombre, double brillo, double distancia, int planetas,
                           Galaxia galaxia, TipoEstrella tipo) {
        super(nombre, brillo, distancia, planetas, galaxia);
        this.tipo = tipo;
    }

    public TipoEstrella getTipo() {
        return tipo;
    }

    public void setTipo(TipoEstrella tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EstrellaConTipo that = (EstrellaConTipo) o;
        return tipo == that.tipo;
    }

    @Override
    public String toString() {
        return "objeto-Astro {" +
                "nombre: " + super.getNombre() +
                ", tipo: EstrellaConTipo" +
                ", brillo: " + super.getBrillo() +
                ", distancia: " + super.getDistancia() +
                ", planetas: " + super.getPlanetas() +
                ", galaxia: " + super.getGalaxia().getNombre() +
                ", info: " + tipo.getTipo() + ' ' + '"' + tipo.getUrl() + '"' +
                '}';
    }
}
