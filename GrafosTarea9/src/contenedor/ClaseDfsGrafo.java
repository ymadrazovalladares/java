package contenedor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ClaseDfsGrafo<T> {
	
	ClassGrafo grafo;
    Stack<T> pila;
    LinkedList recorrido;

    public ClaseDfsGrafo(ClassGrafo grafo){
       this.grafo= grafo;
       pila = new Stack<T>();
       recorrido = new LinkedList<T>();
    }

    public Object[] dfsRecorrido (T nodoInicio){
        if(grafo.getGrafo().isEmpty())
            return null;

        pila.add(nodoInicio);

        while(!pila.isEmpty()){
           nodoInicio = (T) pila.pop();
           recorrido.addLast(nodoInicio);
            ArrayList<T> listaDenodosAQuienEsAdyacente = grafo.getListadeNodosdeQuienEsAdyacente(nodoInicio);
            for (T EsadyacenteDe : listaDenodosAQuienEsAdyacente){
                if(!recorrido.contains(EsadyacenteDe) && !pila.contains(EsadyacenteDe)){
                    pila.add(EsadyacenteDe);
                }
            }

        }
        return recorrido.toArray();
    }

}
