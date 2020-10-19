package com.example.catalogoastronomico;
/**
 *
 * @author (IOT)
 * @version (2020)
 *
 */
class Principal {
   public static void main(String[] main) {
      Astro marte, otro;
      marte = new Astro("marte", 2.3, 0.5);
      otro = new Astro();
      System.out.println(otro.toString());

      if (marte.masBrillante(otro) == 1) {
         System.out.println("Marte es más brillante que otro");
      }
      else if (marte.masBrillante(otro) == -1) {
         System.out.println("Otro es más brillante que Marte");
      }
      else {
         System.out.println("Marte y otro son igual de brillantes");
      }
   }
}