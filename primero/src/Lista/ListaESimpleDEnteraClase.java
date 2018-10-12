package Lista;

public  class ListaESimpleDEnteraClase {
    Nodo inicioLista;
    Nodo finalLista;
    Integer totalAlmacenados;

    public Integer getTotalalmacenados(){
        return this.totalAlmacenados;
    }


    public ListaESimpleDEnteraClase() {
        inicioLista =null;
        finalLista =null;
        totalAlmacenados =0;
    }

    public void cargarAlFinaldeLaLista(Integer  valor){
        if(finalLista ==null)
          cargarAlInicioDeLaLista(valor);
        Nodo newnodo = new Nodo(valor);
        finalLista.setSiguiente(newnodo);
        finalLista = newnodo;
        return;
    }


    public void cargarAlInicioDeLaLista(Integer valor)
    {
        Nodo newnodo = new Nodo(valor);
        if(inicioLista ==null){
            inicioLista =newnodo;
            finalLista = newnodo;
            totalAlmacenados++;
            return;
        }

        newnodo.setSiguiente(inicioLista);
        inicioLista = newnodo;
        totalAlmacenados++;
        return;
    }

    public void cargarOrdenadamente(Integer valor)
    {
        if(inicioLista ==null)
        {
            inicioLista.setValor(valor);
            finalLista = inicioLista;
            totalAlmacenados++;
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
        Nodo temporalanterior = temporal;
        Nodo newNodo= new Nodo(valor);

        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(antesDe) == 0)
            {
                if (inicioLista.getValor().compareTo(temporal.getValor()) == 0)
                {
                    newNodo.setSiguiente(temporal);
                    inicioLista = newNodo;
                    totalAlmacenados++;
                    return;
                }
                newNodo.setSiguiente(temporal);
                temporalanterior.setSiguiente(newNodo);
                totalAlmacenados++;
                break;
            }
            temporalanterior = temporal;
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

    public void cargarAntesDe(ListaESimpleDEnteraClase listaESimpleDEnteraClase, Integer antesDe)
    {
        Nodo temporal = inicioLista;
        Nodo temporalanterior = temporal;
        Nodo aux = new Nodo(listaESimpleDEnteraClase.inicioLista.getValor());
        aux.setSiguiente(listaESimpleDEnteraClase.inicioLista.getSiguiente());
        if (inicioLista ==null)
        {
            inicioLista = aux;
            while (aux.getSiguiente() != null)
            {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(temporal);
            totalAlmacenados = listaESimpleDEnteraClase.totalAlmacenados;
            return;
        }

        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(antesDe) == 0)
            {
                if (inicioLista.getValor().compareTo(temporal.getValor()) == 0)
                {
                  inicioLista = aux;
                  while (aux.getSiguiente() != null)
                  {
                      aux = aux.getSiguiente();
                  }
                  aux.setSiguiente(temporal);
                  totalAlmacenados += listaESimpleDEnteraClase.totalAlmacenados;
                  return;
                }
                temporalanterior.setSiguiente(aux);
                while (aux.getSiguiente() != null)
                {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(temporal);
                totalAlmacenados += listaESimpleDEnteraClase.totalAlmacenados;
                return;

            }
            temporalanterior = temporal;
            temporal = temporal.getSiguiente();
        }
        //listaESimpleDEnteraClase.finalLista = new Nodo(listaESimpleDEnteraClase.finalLista.getValor());
    }


    public void cargarDespuesDe(Integer valor,Integer despuesDe) {
        if (inicioLista ==null){
            cargarAlInicioDeLaLista(valor);
            return;
        }
        Nodo temporal = inicioLista;
        Nodo newNodo= new Nodo(valor);

        while(temporal!=null){
            if (temporal.getValor().compareTo(despuesDe)==0){
                newNodo.setSiguiente(temporal.getSiguiente());
                temporal.setSiguiente(newNodo);
                this.totalAlmacenados++;
                if(finalLista ==temporal){
                    finalLista = newNodo;
                    return;
                }
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

    public void cargarDespuesDe(ListaESimpleDEnteraClase listaESimpleDEnteraClase, Integer despuesDe)
    {
        if (inicioLista ==null){
            inicioLista = listaESimpleDEnteraClase.inicioLista;
            finalLista = listaESimpleDEnteraClase.finalLista;
            totalAlmacenados = listaESimpleDEnteraClase.totalAlmacenados;
            return;
        }
        Nodo temporal = inicioLista;

        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(despuesDe)==0)
            {
               if(finalLista == temporal)
                {
                    listaESimpleDEnteraClase.finalLista.setSiguiente(null);
                    finalLista = listaESimpleDEnteraClase.finalLista;
                    temporal.setSiguiente(listaESimpleDEnteraClase.inicioLista);
                    this.totalAlmacenados += listaESimpleDEnteraClase.totalAlmacenados;
                    return;
                }
                listaESimpleDEnteraClase.finalLista.setSiguiente(temporal.getSiguiente());
                temporal.setSiguiente(listaESimpleDEnteraClase.inicioLista);
                this.totalAlmacenados += listaESimpleDEnteraClase.totalAlmacenados;
                return;
            }
            temporal = temporal.getSiguiente();
        }

    }


    public  Integer[] getListaSimple(){

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

    public Integer eliminarPrimerElementoLista()
    {
        inicioLista = inicioLista.getSiguiente();
        totalAlmacenados--;
        return totalAlmacenados;
    }

    public Integer eliminarUltimoElementoLista()
    {
      Nodo temp = inicioLista;
        for (int i = 0; i < totalAlmacenados;i++)
         {
            if(i == totalAlmacenados - 2)
            {
                temp.setSiguiente(null);
                totalAlmacenados --;
                break;
            }
            temp = temp.getSiguiente();
         }
         return totalAlmacenados;
    }

    public Integer eliminarElementoLista(Integer valor)
    {
        Nodo temporal = inicioLista;
        Nodo temporalAnterior = temporal;
        while(temporal!=null)
        {
            if (temporal.getValor().compareTo(valor)==0)
            {
                if(inicioLista == temporal)
                  inicioLista = inicioLista.getSiguiente();
                else
                   temporalAnterior.setSiguiente(temporal.getSiguiente());
                totalAlmacenados--;
                return totalAlmacenados;

             }
            temporalAnterior = temporal;
            temporal = temporal.getSiguiente();
        }
        return 0;
    }

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


