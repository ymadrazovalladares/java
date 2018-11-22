package contenedor;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class UsaGrafo<T> {


    public static void main(String args[]) {
        ClassGrafoPonderado<String> grafo = new ClassGrafoPonderado<>();

        grafo.addNodo("A");
        grafo.addNodo("B");
        grafo.addNodo("C");
        grafo.addNodo("D");
        grafo.addNodo("E");
        grafo.addNodo("F");
        grafo.addNodo("G");
        grafo.addNodo("H");


        grafo.addAdyacentes("A", "B", 27);
        grafo.addAdyacentes("A", "C", 70);
        grafo.addAdyacentes("A", "D", 52);
        grafo.addAdyacentes("B", "C", 44);
        grafo.addAdyacentes("B", "E", 41);
        grafo.addAdyacentes("B", "G", 70);
        grafo.addAdyacentes("C", "F", 40);
        grafo.addAdyacentes("C", "H", 67);
        grafo.addAdyacentes("D", "E", 35);
        grafo.addAdyacentes("D", "F", 60);
        grafo.addAdyacentes("D", "G", 46);
        grafo.addAdyacentes("E", "F", 30);
        grafo.addAdyacentes("E", "G", 35);
        grafo.addAdyacentes("F", "H", 29);
        grafo.addAdyacentes("G", "H", 45);

        Iterator<String> it = grafo.getGrafo().keySet().iterator();
        System.out.println("Lectura de Grafo ");

        ArrayList<Estructura> lista = new ArrayList<Estructura>();
        ArrayList<String> listaAnalizada = new ArrayList<String>();
        ArrayList<Estructura> cola = new ArrayList<>();
        Estructura temp = new Estructura("A");


        String valor = (String) it.next();
        lista.add(temp);
        Estructura temp1 = new Estructura();
        while (valor != "")
        {
            if (grafo.getGrafo().get(valor) != null) {
                TreeMap<String, Integer> listaadyacente = grafo.getGrafo().get(valor);

                Iterator<String> itAdyacentes = listaadyacente.keySet().iterator();
                String aux = "";
                temp = new Estructura();
                while (itAdyacentes.hasNext())
                {
                    temp = new Estructura();
                    temp1 = new Estructura();
                    String NodoaQuienEsAdyacente = (String) itAdyacentes.next();
                    if (!listaAnalizada.contains(NodoaQuienEsAdyacente))
                    {
                        temp.setValor(listaadyacente.get(NodoaQuienEsAdyacente));

                        temp.setOrigen(valor);
                        temp.setDestino(NodoaQuienEsAdyacente);
                        if(!EstaLista(lista,NodoaQuienEsAdyacente))
                        {
                            temp.setValor(temp.getValor()+Acumulado(lista,valor));
                            lista.add(temp);
                        }
                        else
                        {
                            temp1 = GetUnDatosLista(lista,NodoaQuienEsAdyacente);
                            if(temp1.getValor()>Acumulado(lista,valor) + temp.getValor())
                            {
                                temp1.setValor(Acumulado(lista,valor) + temp.getValor());
                                temp1.setOrigen(temp.getOrigen());
                                temp1.setDestino(temp.getDestino());
                             }
                        }
                    }
                }
                listaAnalizada.add(valor);
                valor = ProximoNodo(lista,listaAnalizada);
            }
        }
        for(int i = 0; i < lista.size(); i++)
        {
            System.out.println(lista.get(i).getOrigen()+" "+ lista.get(i).getValor()+ " " +lista.get(i).getDestino());
      }
  }

    private static  Estructura GetUnDatosLista(ArrayList<Estructura> lista, String valor)
    {
        for(int i = 0; i < lista.size();i++)
        {
            if(lista.get(i).getDestino() == valor)
                return lista.get(i);
        }
        return null;
    }

    private static Integer Acumulado(ArrayList<Estructura> lista, String variale)
    {
        for(int i = 0; i < lista.size();i++)
        {
            if(lista.get(i).getDestino() == variale)
                return lista.get(i).getValor();
        }
        return -1;
    }
    private static String ProximoNodo(ArrayList<Estructura> lista, ArrayList<String> analizada)
    {
        Integer menor = 1000;
        String salida = "";
        for (int i = 0; i < lista.size(); i++)
            if (!ListaAnalizada(analizada, lista.get(i).getDestino()) && menor > lista.get(i).getValor()) {
                menor = lista.get(i).getValor();
                salida = lista.get(i).getDestino();
            }
        return salida;
    }
    private static boolean EstaLista(ArrayList<Estructura> lista, String valor)
    {
        for (int i = 0; i < lista.size();i++)
        {
            if(lista.get(i).getDestino() == valor)
                return true;
        }
            return false;
    }
    private static boolean ListaAnalizada(ArrayList<String> lista, String valor)
    {
        for (int i = 0; i < lista.size();i++)
        {
            if(lista.get(i).toString() == valor)
                return true;
        }
        return false;
    }
}