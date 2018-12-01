package Clonar;

import java.util.Iterator;
import java.util.TreeMap;

public class UsaGrafo {
    public static void main(String args[]){


        ClassGrafoPonderado<String> grafo= new ClassGrafoPonderado<String>();

        grafo.addNodo("A");
        grafo.addNodo("B");
        grafo.addNodo("C");
        grafo.addNodo("D");
        grafo.addNodo("E");
        grafo.addNodo("F");
        grafo.addNodo("G");
        grafo.addNodo("Z");


        grafo.addAdyacentes("A","B",16);
        grafo.addAdyacentes("A","C",10);
        grafo.addAdyacentes("A","D",5);
        grafo.addAdyacentes("B","C",2);
        grafo.addAdyacentes("B","G",6);
        grafo.addAdyacentes("B","F",4);
        grafo.addAdyacentes("C","D",4);
        grafo.addAdyacentes("C","E",10);
        grafo.addAdyacentes("C","F",12);
        grafo.addAdyacentes("D","E",15);
        grafo.addAdyacentes("E","F",3);
        grafo.addAdyacentes("E","Z",5);
        grafo.addAdyacentes("F","G",8);
        grafo.addAdyacentes("F","Z",16);
        grafo.addAdyacentes("G","Z",7);

        Iterator<String> it;

        System.out.println();
        System.out.println("****GRAFO ORIGINAL****");
        System.out.println();

        it=grafo.getGrafo().keySet().iterator();
        System.out.println("Lectura de Grafo ");
        while(it.hasNext()){
            String valor = (String) it.next();
            System.out.println(valor);
            if (  grafo.getGrafo().get(valor)!=null) {
                TreeMap<String, Integer> listaadyacente=grafo.getGrafo().get(valor);

                Iterator<String> itAdyacentes =listaadyacente.keySet().iterator();
                while(itAdyacentes.hasNext()) {
                    String NodoaQuienEsAdyacente = (String) itAdyacentes.next();
                    System.out.print("Adyacente a ->"+NodoaQuienEsAdyacente);
                    System.out.println("  Ponderacion :"+listaadyacente.get(NodoaQuienEsAdyacente));

                   }
            }

        }

        ClassGrafoPonderado<String> grafoCopia =grafo;
        ClassGrafoPonderado<String> grafoClon = grafo.getGrafoclonado();
        grafo.eliminaNodo("A");

        System.out.println();
        System.out.println("****GRAFO COPIADO****");
        System.out.println();

        it=grafoCopia.getGrafo().keySet().iterator();
        System.out.println("Lectura de Grafo ");
        while(it.hasNext()){
            String valor = (String) it.next();
            System.out.println(valor);
            if (  grafoCopia.getGrafo().get(valor)!=null) {
                TreeMap<String, Integer> listaadyacente=grafoCopia.getGrafo().get(valor);

                Iterator<String> itAdyacentes =listaadyacente.keySet().iterator();
                while(itAdyacentes.hasNext()) {
                    String NodoaQuienEsAdyacente = (String) itAdyacentes.next();
                    System.out.print("Adyacente a ->"+NodoaQuienEsAdyacente);
                    System.out.println("  Ponderacion :"+listaadyacente.get(NodoaQuienEsAdyacente));

                }
            }

        }


        System.out.println();
        System.out.println("****GRAFO CLONADO****");
        System.out.println();

        it=grafoClon.getGrafo().keySet().iterator();
        System.out.println("Lectura de Grafo ");
        while(it.hasNext()){
            String valor = (String) it.next();
            System.out.println(valor);
            if (  grafoClon.getGrafo().get(valor)!=null) {
                TreeMap<String, Integer> listaadyacente=grafoClon.getGrafo().get(valor);

                Iterator<String> itAdyacentes =listaadyacente.keySet().iterator();
                while(itAdyacentes.hasNext()) {
                    String NodoaQuienEsAdyacente = (String) itAdyacentes.next();
                    System.out.print("Adyacente a ->"+NodoaQuienEsAdyacente);
                    System.out.println("  Ponderacion :"+listaadyacente.get(NodoaQuienEsAdyacente));

                }
            }

        }

   }




}

