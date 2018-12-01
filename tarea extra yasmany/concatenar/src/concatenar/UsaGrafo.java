package concatenar;

import java.util.Iterator;
import java.util.TreeMap;

public class UsaGrafo {
    public static void main(String args[]){


        ClassGrafoPonderado<String> grafo1= new ClassGrafoPonderado<String>();
        ClassGrafoPonderado<String> grafo2= new ClassGrafoPonderado<String>();

        grafo1.addNodo("A");
        grafo1.addNodo("B");
        grafo1.addNodo("C");
        grafo1.addNodo("D");

        grafo2.addNodo("A");
        grafo2.addNodo("B");
        grafo2.addNodo("C");
        grafo2.addNodo("D");


        grafo1.addAdyacentes("A","B");
        grafo1.addAdyacentes("A","D");
        grafo1.addAdyacentes("B","C");
        grafo1.addAdyacentes("B","A");
        grafo1.addAdyacentes("C","B");
        grafo1.addAdyacentes("C","D");
        grafo1.addAdyacentes("D","A");
        grafo1.addAdyacentes("D","C");

        grafo2.addAdyacentes("A","A");
        grafo2.addAdyacentes("A","C");
        grafo2.addAdyacentes("B","D");
        grafo2.addAdyacentes("C","A");
        grafo2.addAdyacentes("C","C");
        grafo2.addAdyacentes("D","A");

        Iterator<String> it;

        System.out.println();
        System.out.println("****GRAFO ORIGINAL****");
        System.out.println();

        it=grafo1.getGrafo().keySet().iterator();
        System.out.println("Lectura de Grafo ");
        while(it.hasNext()){
            String valor = (String) it.next();
            System.out.println(valor);
            if (  grafo1.getGrafo().get(valor)!=null) {
                TreeMap<String, Integer> listaadyacente=grafo1.getGrafo().get(valor);

                Iterator<String> itAdyacentes =listaadyacente.keySet().iterator();
                while(itAdyacentes.hasNext()) {
                    String NodoaQuienEsAdyacente = (String) itAdyacentes.next();
                    System.out.println("Es Adyacente a ->"+NodoaQuienEsAdyacente);
                  }
            }

        }

        grafo1.ConcatenarGrafo(grafo2);

        System.out.println();
        System.out.println("****GRAFO CONCATENADO****");
        System.out.println();


        it=grafo2.getGrafo().keySet().iterator();
        System.out.println("Lectura de Grafo ");
        while(it.hasNext()){
            String valor = (String) it.next();
            System.out.println(valor);
            if (  grafo2.getGrafo().get(valor)!=null) {
                TreeMap<String, Integer> listaadyacente=grafo2.getGrafo().get(valor);

                Iterator<String> itAdyacentes =listaadyacente.keySet().iterator();
                while(itAdyacentes.hasNext()) {
                    String NodoaQuienEsAdyacente = (String) itAdyacentes.next();
                    System.out.println("Es Adyacente a ->"+NodoaQuienEsAdyacente);
                }
            }

        }

   }




}

