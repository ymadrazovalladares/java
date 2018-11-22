package contenedor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public  class ClassGrafoPonderado<T> {

    private TreeMap<T, TreeMap<T,Integer>> grafo;

    public ClassGrafoPonderado(){
        grafo= new TreeMap<T, TreeMap<T, Integer>>();
    }

    public TreeMap<T, TreeMap<T, Integer>> getGrafo() {
        return grafo;
    }

    public void setGrafo(TreeMap<T, TreeMap<T, Integer>> grafo) {
        this.grafo = grafo;
    }

    public void addNodo(T valor){
        grafo.put(valor,null);
    }

    private void add(T nodo, T esAdyacenteA,Integer ponderacion){

        if (grafo.get(nodo)==null){
            TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente= new TreeMap<>();
            listadeNodosDeQuienEsAdyacente.put(esAdyacenteA,ponderacion);
            grafo.replace((T)nodo,listadeNodosDeQuienEsAdyacente);
            return;
        }

        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente = grafo.get(nodo);
        listadeNodosDeQuienEsAdyacente.put(esAdyacenteA,ponderacion);
        grafo.replace((T)nodo,listadeNodosDeQuienEsAdyacente);

    }

    public void addAdyacentes(T nodo, T esAdyacenteA,Integer ponderacion){
        if (!grafo.containsKey(nodo) && !grafo.containsKey(esAdyacenteA) )
            return;
        add(nodo,esAdyacenteA,ponderacion);
        add(esAdyacenteA,nodo,ponderacion);

    }

    public Object[] getNodos(){
        if (grafo.isEmpty())
            return null;

        return grafo.keySet().toArray();
    }

    public ArrayList<T> getListadeNodosdeQuienEsAdyacente(T nodo){
        if (grafo.isEmpty())
            return null;
        return (ArrayList<T>) grafo.get(nodo).keySet();
    };


    private void remover(T nodo, T dejaDeSerAdyacenteA){
        TreeMap<T,Integer> listadeNosoDeQuienEsAdyacente = grafo.get(nodo);
        listadeNosoDeQuienEsAdyacente.remove(dejaDeSerAdyacenteA);
        grafo.replace(nodo,listadeNosoDeQuienEsAdyacente);
    }

    public void eliminarAdyacentes(T nodo, T dejaDeSerAdyacenteA) {
        if (!grafo.containsKey(nodo) && !grafo.containsKey(dejaDeSerAdyacenteA))
            return;

        remover(nodo,dejaDeSerAdyacenteA);
        remover(dejaDeSerAdyacenteA,nodo);
    }

    public void eliminaNodo(T nodo){
        if (!grafo.containsKey(nodo))
            return;

        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente = grafo.get(nodo);
        for(Object nodoAdyecente : listadeNodosDeQuienEsAdyacente.keySet().toArray()){
            eliminarAdyacentes((T)nodoAdyecente,nodo);
        }
        grafo.get(nodo).clear();
        grafo.remove(nodo);

    }

    public Integer getPonderacion(T nodo, T esAdyacenteA){
        Integer ponderacion =null;
        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente = grafo.get(nodo);
        ponderacion = listadeNodosDeQuienEsAdyacente.get(esAdyacenteA);
        return ponderacion;

    }





}