package contenedor;

public class ListaDoblementeEnlazada<Integer>
{
    Nodo inicioLista;
    Nodo finalLista;
    int totalAlmacenados;

    public int getTotalalmacenados()
    {
        return this.totalAlmacenados;
    }


    public ListaDoblementeEnlazada()
    {
        inicioLista =null;
        finalLista =null;
        totalAlmacenados =0;
    }

    public void PushMatrix(int aMatrix[][])
    {
        inicioLista = new Nodo();
        inicioLista.setValor(aMatrix[0][0]);
        Nodo newNodo;
        inicioLista.setSuperior(null);
        inicioLista.setAnterior(null);
        Nodo temp = inicioLista;
        Nodo aux = new Nodo();
        newNodo = new Nodo();
        for (int i = 0; i < aMatrix.length; i++)
        {
            if((i != 0) )
            {
                aux = Buscar(aMatrix[i-1][0]);
                temp.setSuperior(aux);
                aux.setInferior(temp);
            }
            for (int j = 1; j < aMatrix[0].length; j++)
            {
                newNodo = new Nodo();
                if(i ==0)
                {
                    newNodo.setSuperior(null);
                }
                if(i ==aMatrix.length)
                {
                    newNodo.setInferior(null);
                }
                if((i < aMatrix.length)&&(i > 0) )
                {
                    aux = Buscar(aMatrix[i-1][j]);
                    newNodo.setSuperior(aux);
                    aux.setInferior(newNodo);
                }

                newNodo.setValor(aMatrix[i][j]);
                newNodo.setAnterior(temp);
                temp.setSiguiente(newNodo);
                temp = temp.getSiguiente();
                totalAlmacenados++;
                finalLista = newNodo;
            }
            temp = Buscar(aMatrix[i][0]);
           if((i+1) < aMatrix[0].length)
             {
               newNodo = new Nodo(aMatrix[i + 1][0]);
               temp.setInferior(newNodo);
               temp = temp.getInferior();
             }
        }


    }

   public  int[] getListaDoble()
    {

        Nodo temporal = inicioLista;
        int[] vector;
        vector = new int[totalAlmacenados];


        int  contador=0;
        while(temporal!=null)
        {
            vector[contador] = temporal.getValor();
            contador++;
            temporal= temporal.getSiguiente();
        }

        return (vector);

    }
    public  int[] getListaDoble(int tipo)
    {
        Nodo temporal = inicioLista;
        int [] vector;
        vector = new int[totalAlmacenados];

        int contador=0;
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

    public boolean esVacia()
    {
        if(totalAlmacenados == 0)
            return true;
        else
            return false;
    }

    public Nodo Buscar(int valor)
    {
        Nodo temporalX = inicioLista;
        Nodo temporalY = inicioLista;
        Nodo newNodo= new Nodo();
        int cursor = 0;
        while(temporalY !=null)
        {
            while(temporalX!=null)
            {
                if (temporalX.getValor() == valor)
                {
                    cursor++;
                    return temporalX;
                }
                cursor++;
                temporalX = temporalX.getSiguiente();
            }
            temporalY = temporalY.getInferior();
            temporalX = temporalY;
        }
        return newNodo;
    }

    public void vaciarLista()
    {
        totalAlmacenados = 0;
        inicioLista = null;
    }
    public boolean CambiarNodos(int valor)
    {
      Nodo vacio = new Nodo();
      vacio = Buscar(0);
      Nodo cambio = new Nodo();
      cambio = Buscar(valor);
      int aux;
      aux = vacio.getValor();
      if((vacio.getSiguiente().getValor() == valor)||(vacio.getAnterior().getValor() == valor)||
              (vacio.getSuperior().getValor() == valor)||(vacio.getInferior().getValor() == valor))
        {
           vacio.setValor(cambio.getValor());
           cambio.setValor(aux);
           return true;
        }
        return false;
    }

}
