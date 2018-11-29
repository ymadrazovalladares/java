package Clonar;

import java.util.ArrayList;

public interface InterfaceGrafo<T> {
     void addNodo(T valor);
     void addAdyacentes(T nodo, T esAdyacenteA);
     void addAdyacentes(T nodo, T esAdyacenteA, Integer ponderacion);
     Object[] getNodos();
     Object[] getListadeNodosdeQuienEsAdyacente(T nodo);
     void eliminarAdyacentes(T nodo, T dejaDeSerAdyacenteA);
     void eliminaNodo(T nodo);

}
