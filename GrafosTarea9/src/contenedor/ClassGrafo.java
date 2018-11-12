package contenedor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public abstract class ClassGrafo<T> {

    private TreeMap<T, ArrayList<T>> grafo;

    public ClassGrafo(){
        grafo= new TreeMap<>();
    }

    public abstract int compara(T o1,T o2);

    public TreeMap<T, ArrayList<T>> getGrafo() {
        return grafo;
    }

    public void setGrafo(TreeMap<T, ArrayList<T>> grafo) {
        this.grafo = grafo;
    }

    public void addNodo(T valor){
        grafo.put(valor,null);
    }

    public void addAdyacentes(T nodo, T esAdyacenteA){
        if (!grafo.containsKey(nodo) && !grafo.containsKey(esAdyacenteA) )
            return;

        if (grafo.get(nodo)==null){
            ArrayList<T> listadeNodosDeQuienEsAdyacente= new ArrayList<>();
            listadeNodosDeQuienEsAdyacente.add(esAdyacenteA);
            grafo.replace(nodo,listadeNodosDeQuienEsAdyacente);
            return;
        }

        ArrayList<T> listadeNodosDeQuienEsAdyacente = grafo.get(nodo);
        listadeNodosDeQuienEsAdyacente.add(esAdyacenteA);
        listadeNodosDeQuienEsAdyacente.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return compara(o1,o2);
            }
        });
        grafo.replace(nodo,listadeNodosDeQuienEsAdyacente);

    }

    public Object[] getNodos(){
        if (grafo.isEmpty())
            return null;

        return grafo.keySet().toArray();
    }

    public ArrayList<T> getListadeNodosdeQuienEsAdyacente(T nodo){
        if (grafo.isEmpty())
            return null;
        return grafo.get(nodo);
    };


    public void eliminarAdyacentes(T nodo, T dejaDeSerAdyacenteA){
        if (!grafo.containsKey(nodo) && !grafo.containsKey(dejaDeSerAdyacenteA))
            return;
        ArrayList<T> listadeNosoDeQuienEsAdyacente = grafo.get(nodo);
        listadeNosoDeQuienEsAdyacente.remove(dejaDeSerAdyacenteA);
        grafo.replace(nodo,listadeNosoDeQuienEsAdyacente);
    }

    public void eliminaNodo(T nodo){
        if (!grafo.containsKey(nodo))
            return;

        ArrayList<T> listadeNodosDeQuienEsAdyacente = grafo.get(nodo);
        for(T nodoAdyecente : listadeNodosDeQuienEsAdyacente){
            eliminarAdyacentes(nodoAdyecente,nodo);
        }
        grafo.get(nodo).clear();
        grafo.remove(nodo);

    }

}
