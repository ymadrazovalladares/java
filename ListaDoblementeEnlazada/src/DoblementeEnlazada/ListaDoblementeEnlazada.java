package DoblementeEnlazada;

public class ListaDoblementeEnlazada
{

    Nodo inicioLista;
    Nodo finalLista;
    Integer totalAlmacenados;

    public Integer getTotalalmacenados()
    {
        return this.totalAlmacenados;
    }


    public ListaDoblementeEnlazada()
    {
        inicioLista =null;
        finalLista =null;
        totalAlmacenados =0;
    }

    public void cargarAlFinaldeLaLista(Integer  valor)
    {
        if(finalLista ==null)
            cargarAlInicioDeLaLista(valor);
        Nodo newnodo = new Nodo(valor);
        finalLista.setSiguiente(newnodo);
        newnodo.setAnterior(finalLista);       // se añade
        finalLista = newnodo;
        totalAlmacenados++;
        return;
    }


    public void cargarAlInicioDeLaLista(Integer valor)
    {
        Nodo newnodo = new Nodo(valor);
        if(inicioLista ==null)
        {
            inicioLista =newnodo;
            finalLista = newnodo;
            totalAlmacenados++;
            return;
        }

        newnodo.setSiguiente(inicioLista);
        inicioLista.setAnterior(newnodo);
        inicioLista = newnodo;
        totalAlmacenados++;
        return;
    }

    public void cargarOrdenadamente(Integer valor)
    {
        if(inicioLista ==null)
        {
            cargarAlInicioDeLaLista(valor);
            return;
        }
        Nodo temp = inicioLista;
        while (temp.getValor()!= null)
        {
            if(temp.getValor() > valor)
            {
                cargarAntesDe(valor, temp.getValor());
                break;
            }
            else
            {
                if(temp == finalLista)
                {
                    cargarAlFinaldeLaLista(valor);
                    break;
                }
            }
            temp = temp.getSiguiente();
        }
    }


    public void cargarAntesDe(Integer valor,Integer antesDe ){
        if (inicioLista ==null)
        {
            cargarAlInicioDeLaLista(valor);
            return;
        }
        Nodo temporal = inicioLista;
        Nodo aux = temporal;
        Nodo newNodo= new Nodo(valor);

        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(antesDe) == 0)
            {
                if (inicioLista.getValor().compareTo(temporal.getValor()) == 0)
                {
                    newNodo.setSiguiente(temporal);
                    temporal.setAnterior(newNodo);
                    inicioLista = newNodo;
                    totalAlmacenados++;
                    return;
                }
                newNodo.setSiguiente(temporal);
                newNodo.setAnterior(temporal.getAnterior());
                aux =temporal.getAnterior();
                aux.setSiguiente(newNodo);
                temporal.setAnterior(newNodo);
                totalAlmacenados++;
                break;
            }
            temporal = temporal.getSiguiente();
        }
    }

    public void cargarAntesDe(Integer[] vector,Integer antesDe)
    {
        Integer temp = antesDe;
        for (int i = 0; i < vector.length;i++)
        {
            cargarAntesDe(vector[vector.length - 1 - i],temp);
            temp = vector[vector.length - 1 - i];
        }
    }

    public void cargarAntesDe(ListaDoblementeEnlazada listaEDobleDEnteraClase, Integer antesDe)
    {
        Nodo temporal = inicioLista;
        Nodo aux = listaEDobleDEnteraClase.inicioLista;

        if (inicioLista ==null)
        {
            cargarAlInicioDeLaLista(aux.getValor());
            while (aux.getSiguiente() != null)
            {
                cargarAlFinaldeLaLista(aux.getSiguiente().getValor());
                aux = aux.getSiguiente();
            }
             return;
        }

        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(antesDe) == 0)
            {
                if (inicioLista.getValor().compareTo(temporal.getValor()) == 0)
                {
                    cargarAlInicioDeLaLista(aux.getValor());
                    while (aux.getSiguiente() != null)
                    {
                        cargarDespuesDe(aux.getSiguiente().getValor(), aux.getValor());
                        aux = aux.getSiguiente();
                    }
                    return;
                }
                cargarAntesDe(aux.getValor(),antesDe);
                while (aux.getSiguiente() != null)
                {
                    cargarDespuesDe(aux.getSiguiente().getValor(), aux.getValor());
                    aux = aux.getSiguiente();
                }
                return;
             }
            temporal = temporal.getSiguiente();
        }
    }


    public void cargarDespuesDe(Integer valor,Integer despuesDe)
    {
        if (inicioLista ==null)
        {
            cargarAlInicioDeLaLista(valor);
            return;
        }
        Nodo temporal = inicioLista;
        Nodo newNodo= new Nodo(valor);
        Nodo aux= new Nodo(valor);

        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(despuesDe)==0)
            {
                if(finalLista ==temporal)
                {
                    cargarAlFinaldeLaLista(valor);
                    return;
                }
                newNodo.setSiguiente(temporal.getSiguiente());
                aux = temporal.getSiguiente();
                newNodo.setAnterior(temporal);
                temporal.setSiguiente(newNodo);
                aux.setAnterior(newNodo);
                this.totalAlmacenados++;
                return;
            }
            temporal = temporal.getSiguiente();
        }
    }

    public void cargarDespuesDe(Integer []vector ,Integer despuesDe)
    {
        Integer temp = despuesDe;
        for (int i = 0; i < vector.length;i++)
        {
            cargarDespuesDe(vector[i],temp);
            temp = vector[i];
        }

    }

    public void cargarListaOrdenada(ListaDoblementeEnlazada listaEDobleDEnteraClase)
    {
        Nodo aux = listaEDobleDEnteraClase.inicioLista;
        for(int i = 0; i < listaEDobleDEnteraClase.totalAlmacenados; i++)
        {
            cargarOrdenadamente(aux.getValor());
            aux = aux.getSiguiente();
        }

    }

    public void cargarDespuesDe(ListaDoblementeEnlazada listaEDobleDEnteraClase, Integer despuesDe)
    {
        Nodo temporal = inicioLista;
        Nodo aux = listaEDobleDEnteraClase.inicioLista;

        if (inicioLista == null)
        {
            cargarAlInicioDeLaLista(aux.getValor());
            while (aux.getSiguiente() != null)
            {
                cargarAlFinaldeLaLista(aux.getSiguiente().getValor());
                aux = aux.getSiguiente();
            }
            return;
        }

        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(despuesDe)==0)
            {
                if(finalLista == temporal)
                {
                    cargarAlFinaldeLaLista(aux.getValor());
                    while (aux.getSiguiente() != null)
                    {
                        cargarAlFinaldeLaLista(aux.getSiguiente().getValor());
                        aux = aux.getSiguiente();
                    }
                    return;
                }

                cargarDespuesDe(aux.getValor(),despuesDe);
                while (aux.getSiguiente() != null)
                {
                    cargarDespuesDe(aux.getSiguiente().getValor(),aux.getValor());
                    aux = aux.getSiguiente();
                }
               return;
            }
            temporal = temporal.getSiguiente();
        }

    }

    public  Integer[] getListaDoble()
    {

        Nodo temporal = inicioLista;
        Integer[] vector;
        vector = new Integer[totalAlmacenados];


        Integer contador=0;
        while(temporal!=null)
        {
            vector[contador] = temporal.getValor();
            contador++;
            temporal= temporal.getSiguiente();
        }

        return (vector);

    }
    public  Integer[] getListaDoble(Integer tipo)
    {
        Nodo temporal = inicioLista;
        Integer[] vector;
        vector = new Integer[totalAlmacenados];

        Integer contador=0;
        switch (tipo)
        {
            case 1:
                while(temporal!=null)
                {
                    vector[contador] = temporal.getValor();
                    contador++;
                    temporal= temporal.getSiguiente();
                };
                break;

            default:
                temporal = finalLista;

                while(temporal!=null)
                {
                    vector[contador] = temporal.getValor();
                    contador++;
                    temporal= temporal.getAnterior();
                };
                break;
        }

        return (vector);
  }

  public Integer eliminarPrimerElementoLista()
    {
        inicioLista = inicioLista.getSiguiente();
        inicioLista.setAnterior(null);
        totalAlmacenados--;
        return totalAlmacenados;
    }

    public Integer eliminarUltimoElementoLista()
    {
        finalLista = finalLista.getAnterior();
        finalLista.setSiguiente(null);
        totalAlmacenados--;
        return totalAlmacenados;
    }
    public Integer eliminarElementoLista(Integer valor)
    {
        Nodo temporal = inicioLista;
        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(valor)==0)
            {
                if(inicioLista == temporal)
                {
                    eliminarPrimerElementoLista();
                }
                else
                 {
                    if (finalLista == temporal)
                      {
                        eliminarUltimoElementoLista();
                      }
                    else
                      {

                         temporal.getAnterior().setSiguiente(temporal.getSiguiente());
                         temporal.getSiguiente().setAnterior(temporal.getAnterior());
                         totalAlmacenados--;
                         return totalAlmacenados;
                      }
                 }
            }
           temporal = temporal.getSiguiente();
        }
        return 0;
    }
    /////////////////////////////////////////////////
    public Integer eliminarElementoLista(Integer[] vector)
    {
        int cant = 0;
        for (int i = 0; i < vector.length; i++)
        {
            if(eliminarElementoLista(vector[i]) != 0)
                cant++;
        }
        return cant;
    }

    public boolean esVacia()
    {
        if(totalAlmacenados == 0)
            return true;
        else
            return false;
    }

    public Integer Buscar(Integer valor)
    {
        Nodo temporal = inicioLista;
        Nodo newNodo= new Nodo(valor);
        Integer cursor = 0;
        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(valor)==0)
            {
                cursor++;
                return cursor;
            }
            cursor++;
            temporal = temporal.getSiguiente();
        }
        return 0;
    }

    public void vaciarLista()
    {
        totalAlmacenados = 0;
        inicioLista = null;
    }

}
