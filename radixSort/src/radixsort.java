import java.util.ArrayList;

class Radixsort {
    ArrayList<String> listaNumeros;

    public Radixsort(ArrayList<String> listaNumeros) {
        this.listaNumeros = listaNumeros;
    }
    public Radixsort() {
        this.listaNumeros = null;
    }
    public ArrayList<String> getListaNumeros() {
        return listaNumeros;
    }

    public void setListaNumeros(ArrayList<String> listaNumeros) {
        this.listaNumeros = listaNumeros;
    }
    public int MayorCantidadDigitos(ArrayList<String> listaNumeros) {
        int mayor = 0;
        for(int i = 0; i< listaNumeros.size(); i++)
       {
           if(listaNumeros.get(i).length() > mayor)
               mayor = listaNumeros.get(i).length();
       }
       return mayor;
    }

    public int RellenarCeros(ArrayList<String> listaNumeros) {
        int mayor = MayorCantidadDigitos(listaNumeros);
        for(int i = 0; i< listaNumeros.size(); i++)
        {
            while(listaNumeros.get(i).length() < mayor)
            {
                listaNumeros.add(i,"0"+listaNumeros.get(i).length());
            }
        }
        return mayor;
    }

    public int ordenarRadixSort(ArrayList<String> listaNumeros) {
        int mayor = MayorCantidadDigitos(listaNumeros);
        for(int i = mayor; i > 0; i--)
        {

        }
        return mayor;
    }
}
