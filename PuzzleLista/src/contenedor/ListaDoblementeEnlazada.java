package contenedor;

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

    public void PushMatrix(Integer aMatrix[][])
    {
        inicioLista.setValor(aMatrix[0][0]);
        Nodo newNodo = new Nodo(aMatrix[0][0]);
        inicioLista.setSuperior(null);
        inicioLista.setAnterior(null);
        Nodo temp = inicioLista;
        Nodo aux = new Nodo();
        for (int i = 0; i < aMatrix.length; i++)
        {
            for (int j = 1; j <= aMatrix[0].length; j++)
            {
                newNodo = new Nodo();
                if(i ==0)
                {
                    newNodo.setSuperior(null);
                }
                if(i ==aMatrix.length-1)
                {
                    newNodo.setInferior(null);
                }
                if((i < aMatrix.length-1)&&(i > 0) )
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
            }
            temp = temp.getInferior();

        }
        finalLista = newNodo;

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

    public boolean esVacia()
    {
        if(totalAlmacenados == 0)
            return true;
        else
            return false;
    }

    public Nodo Buscar(Integer valor)
    {
        Nodo temporalX = inicioLista;
        Nodo temporalY = inicioLista;
        Nodo newNodo= new Nodo();
        Integer cursor = 0;
        while(temporalY !=null)
        {
            while(temporalX!=null)
            {
                if (temporalX.getValor().compareTo(valor)==0)
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

}
