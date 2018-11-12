package contenedor;
import java.util.ArrayList;
import java.util.LinkedList;

public class ClaseBfsGrafo<T> {
    ClassGrafo grafo;
    LinkedList cola;

    LinkedList recorrido;

    public ClaseBfsGrafo(ClassGrafo grafo){
        this.grafo= grafo;
        cola = new LinkedList<T>();
        recorrido = new LinkedList<T>();
    }

    public Object[] bfsRecorrido (T nodoInicio){
        if(grafo.getGrafo().isEmpty())
            return null;

        cola.addLast(nodoInicio);

        while(!cola.isEmpty()){
            nodoInicio = (T) cola.pollFirst();
            recorrido.addLast(nodoInicio);
            ArrayList<T> listaDenodosAQuienEsAdyacente = grafo.getListadeNodosdeQuienEsAdyacente(nodoInicio);
            for (T EsadyacenteDe : listaDenodosAQuienEsAdyacente){
                if(!recorrido.contains(EsadyacenteDe) && !cola.contains(EsadyacenteDe)){
                    cola.addLast(EsadyacenteDe);
                }
            }

        }
        return recorrido.toArray();
    }
}