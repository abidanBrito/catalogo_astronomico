package com.example.catalogoastronomico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author (IOT)
 * @version (2020)
 */
public class CatalogoAstronomico {
    private ArrayList<Astro> catalogo;
    private HashSet<String> galaxias;
    private int numEstrellasSimpleVista;

    public CatalogoAstronomico() {
        catalogo = new ArrayList<>();
        galaxias = new HashSet<>();
        numEstrellasSimpleVista = 0;
    }

    public ArrayList<Astro> getCatalogo() {
        return catalogo;
    }

    public HashSet<String> getGalaxias() {
        return galaxias;
    }

    public int getNumEstrellasSimpleVista() {
        return filtraEstrellasSimpleVista().size();
    }

    // Devuelve true si el Astro en una posición válida del catálogo es una estrella
    // visible a simple vista
    boolean esEstrellaSimpleVista(int pos) {
        return catalogo.get(pos).visibleCon().equals("a simple vista");
    }

    // Añade un astro al catálogo (comprueba que no esté repetido) y devuelve true si
    // se ha podido añadir
    boolean anade(Astro a) {
        if (!catalogo.contains(a)) {
            if (a instanceof Galaxia) {
                for (Astro g : catalogo) {
                    if (g.getNombre().equals(a.getNombre())) {
                        return false;
                    }
                }
                catalogo.add(a);
                galaxias.add(a.getNombre());
            }

            if (a instanceof Estrella) {
                catalogo.add(a);
                if (((Estrella) a).getGalaxia() != null) {
                    if (!catalogo.contains(((Estrella) a).getGalaxia())) {
                        catalogo.add(((Estrella) a).getGalaxia());
                    }
                    galaxias.add(((Estrella) a).getGalaxia().getNombre());
                }
            }

            if (a instanceof Planeta) {
                catalogo.add(a);
                if (((Planeta) a).getEstrella() != null) {
                    if (catalogo.contains(((Planeta) a).getEstrella())) {
                        catalogo.add(((Planeta) a).getEstrella());
                    }
                    galaxias.add(((Planeta) a).getEstrella().getNombre());
                }
            }

            return true;
        }

        return false;
    }

    // Elimina el astro con el nombre indicado
    void borrar(String nombre) {
        for (Astro a : catalogo) {
            if (a.getNombre().equals(nombre)) {
                catalogo.remove(a);
            }
        }
    }

    // Busca un astro por su nombre
    Astro buscaAstro(String nombre) {
        for (Astro a : catalogo) {
            if (a.getNombre().equals(nombre)) {
                return a;
            }
        }

        return null;
    }

    // Devuelve el primer Astro del catálogo que es más brillante en magnitud absoluta
    // que un Astro dado (devuelve el primero que cumpla esa condición)
    Astro primeroMasBrillanteQue(Astro a) {
        for (Astro otro : catalogo) {
            if (otro.getBrillo() > a.getBrillo()) {
                return otro;
            }
        }

        return null;
    }

    // Devuelve una lista de objetos Astro con las estrellas visibles a simple vista
    // que contiene el catálogo
    List<Astro> filtraEstrellasSimpleVista() {
        List<Astro> estrellasVisibles = new ArrayList<>();
        for (Astro a : catalogo) {
            if (a instanceof Estrella) {
                if (esEstrellaSimpleVista(catalogo.indexOf(a))) {
                    estrellasVisibles.add(a);
                }
            }
        }

        return estrellasVisibles;
    }

    // Devuelve el Astro que es más brillante en magnitud absoluta de todos
    // los del catálogo
    Astro brillaMas() {
        int pos = 0;
        for (int i = 1; i < catalogo.size(); ++i) {
            if (catalogo.get(i).getBrillo() > catalogo.get(pos).getBrillo()) {
                pos = i;
            }
        }

        return catalogo.get(pos);
    }

    @Override
    public String toString() {
        String finalStr = "";
        for (Astro a : catalogo) {
            finalStr += a.toString() + "\n";
        }

        return finalStr;
    }

}