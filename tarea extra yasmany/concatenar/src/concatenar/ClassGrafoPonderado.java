package concatenar;

import java.util.Iterator;
import java.util.TreeMap;

public class ClassGrafoPonderado<T> implements InterfaceGrafo<T> {
    private TreeMap<T, TreeMap<T,Integer>> grafo;

    public ClassGrafoPonderado() {
        grafo= new TreeMap<T, TreeMap<T, Integer>>();

    }



    public TreeMap<T, TreeMap<T, Integer>> getGrafo() {
        return grafo;
    }

    public void setGrafo(TreeMap<T, TreeMap<T, Integer>> grafo) {
        this.grafo = new TreeMap<T, TreeMap<T, Integer>>();
        this.grafo  = grafo;
    }

    @Override
    public void addNodo(T valor) {
        grafo.put((T) valor,null);
    }


    private void Add(T nodo, T esAdyacenteA) {
        if (!grafo.containsKey(nodo) && !grafo.containsKey(esAdyacenteA) )
            return;

        if (grafo.get(nodo)==null){
            TreeMap<T,Integer>  listadeNodosDeQuienEsAdyacente=new TreeMap<>();
            listadeNodosDeQuienEsAdyacente.put(esAdyacenteA, null);
            grafo.replace((T) nodo,listadeNodosDeQuienEsAdyacente);
            return;
        }

        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente= grafo.get(nodo);
        listadeNodosDeQuienEsAdyacente.put(esAdyacenteA,null);
        grafo.replace((T) nodo,listadeNodosDeQuienEsAdyacente);

    }

    @Override
    public void addAdyacentes(T nodo, T esAdyacenteA){
        if (!grafo.containsKey(nodo) && !grafo.containsKey(esAdyacenteA) )
            return;

        add(nodo,esAdyacenteA);
        add(esAdyacenteA,nodo);
    }
    @Override

    public void addAdyacentes(T nodo, T esAdyacenteA,Integer ponderacion){
        if (!grafo.containsKey(nodo) && !grafo.containsKey(esAdyacenteA) )
            return;

        add(nodo,esAdyacenteA,ponderacion);
        add(esAdyacenteA,nodo,ponderacion);
    }

    private void add(T nodo, T esAdyacenteA) {

        if (grafo.get(nodo)==null){
            TreeMap<T,Integer>  listadeNodosDeQuienEsAdyacente=new TreeMap<>();
            listadeNodosDeQuienEsAdyacente.put(esAdyacenteA, null);
            grafo.replace((T) nodo,listadeNodosDeQuienEsAdyacente);
            return;
        }

        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente= grafo.get(nodo);
        listadeNodosDeQuienEsAdyacente.put(esAdyacenteA,null);
        grafo.replace((T) nodo,listadeNodosDeQuienEsAdyacente);

    }

     private void add(T nodo, T esAdyacenteA, Integer ponderacion) {
        if (!grafo.containsKey(nodo) && !grafo.containsKey(esAdyacenteA) )
            return;

        if (grafo.get(nodo)==null){
            TreeMap<T,Integer>  listadeNodosDeQuienEsAdyacente=new TreeMap<>();
            listadeNodosDeQuienEsAdyacente.put(esAdyacenteA,ponderacion);
            grafo.replace((T) nodo,listadeNodosDeQuienEsAdyacente);
            return;
        }

        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente= grafo.get(nodo);
        listadeNodosDeQuienEsAdyacente.put(esAdyacenteA,ponderacion);
        grafo.replace((T) nodo,listadeNodosDeQuienEsAdyacente);

    }

    @Override
    public Object[] getNodos() {
        if (grafo.isEmpty())
            return null;

        return grafo.keySet().toArray();
    }

    public Object[] GetListadeNodosdeQuienEsAdyacente(T nodo) {
        if (grafo.isEmpty())
            return null;

        return (grafo.get(nodo).keySet().toArray());
    }

    @Override
    public Object[] getListadeNodosdeQuienEsAdyacente(T nodo) {
        if (grafo.isEmpty())
            return null;

        return  grafo.get(nodo).keySet().toArray();
    }

    @Override
    public void eliminarAdyacentes(T nodo, T dejaDeSerAdyacenteA){
        if (!grafo.containsKey(nodo) && !grafo.containsKey(dejaDeSerAdyacenteA))
            return;

        remove(nodo,dejaDeSerAdyacenteA);
        remove(dejaDeSerAdyacenteA,nodo);
    }

    private void remove(T nodo, T dejaDeSerAdyacenteA) {
        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente= grafo.get(nodo);
        listadeNodosDeQuienEsAdyacente.remove(dejaDeSerAdyacenteA);
        grafo.replace(nodo,listadeNodosDeQuienEsAdyacente);

    }

    public Integer getPonderacion(T nodo, T esAdyacenteA) {
        Integer ponderacion=null;
        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente= grafo.get(nodo);
        ponderacion = listadeNodosDeQuienEsAdyacente.get(esAdyacenteA);
        return ponderacion;
    }

    @Override
    public void eliminaNodo(T nodo) {

        if (!grafo.containsKey(nodo))
            return;

        TreeMap<T,Integer> listadeNodosDeQuienEsAdyacente= grafo.get(nodo);
        for(Object nodoAdyecente : listadeNodosDeQuienEsAdyacente.keySet().toArray()){
            eliminarAdyacentes((T)nodoAdyecente,nodo);
        }
        grafo.get(nodo).clear();
        grafo.remove(nodo);

    }

    public ClassGrafoPonderado<T> getGrafoclonado()
    {
        ClassGrafoPonderado<T> grafoclonado = new ClassGrafoPonderado<T>();
        Iterator<String> it;
        it= (Iterator<String>) grafo.keySet().iterator();
        System.out.println("Lectura de Grafo ");
        while(it.hasNext()){
            String valor = (String) it.next();
             grafoclonado.addNodo((T) valor);
            if (  grafo.get(valor)!=null) {
                TreeMap<String, Integer> listaadyacente= (TreeMap<String, Integer>) grafo.get(valor);

                Iterator<String> itAdyacentes =listaadyacente.keySet().iterator();
                while(itAdyacentes.hasNext()) {
                    String NodoaQuienEsAdyacente = (String) itAdyacentes.next();
                   grafoclonado.addAdyacentes((T)valor,(T)NodoaQuienEsAdyacente,listaadyacente.get(NodoaQuienEsAdyacente));
                }
            }
     }
   return grafoclonado;
    }

    public ClassGrafoPonderado<Object> ConcatenarGrafo(ClassGrafoPonderado<T> agrafo)
    {
        Iterator<String> it;
        it= (Iterator<String>) grafo.keySet().iterator();
        System.out.println("Lectura de Grafo ");
        while(it.hasNext()) {
            String valor = (String) it.next();
            // agrafo.addNodo((T) valor);
            if (grafo.get(valor) != null) {
                TreeMap<String, Integer> listaadyacente = (TreeMap<String, Integer>) grafo.get(valor);

                Iterator<String> itAdyacentes = listaadyacente.keySet().iterator();
                while (itAdyacentes.hasNext()) {
                    String NodoaQuienEsAdyacente = (String) itAdyacentes.next();
                    agrafo.addAdyacentes((T) valor, (T) NodoaQuienEsAdyacente);
                }
            }
        }
            return (ClassGrafoPonderado<Object>) agrafo;
    }

}
