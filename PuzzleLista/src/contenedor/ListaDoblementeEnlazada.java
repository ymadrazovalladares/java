package contenedor;

public class ListaDoblementeEnlazada
{
    Nodo inicioLista;
    Nodo finalLista;
    int totalX;
    int totalY;


    public int getTotalX() {
        return totalX;
    }

    public void setTotalX(int totalX) {
        this.totalX = totalX;
    }

    public int getTotalY() {
        return totalY;
    }

    public void setTotalY(int totalY) {
        this.totalY = totalY;
    }

   public ListaDoblementeEnlazada()
    {
        inicioLista =new Nodo(0,0,0);;
        finalLista =new Nodo(0,0,0);
        totalX = 0;
        totalY = 0;
    }

    public void PushMatrix(Integer aMatrix[][])
    {
        inicioLista = new Nodo(0,0,aMatrix[0][0]);;
        inicioLista.setIdFicha(aMatrix[0][0]);
        Nodo newNodo;
        inicioLista.setSuperior(null);
        inicioLista.setAnterior(null);
        Nodo temp = inicioLista;
        Nodo aux = new Nodo(0,0,aMatrix[0][0]);
        newNodo = new Nodo(0,0,aMatrix[0][0]);
        totalX = aMatrix.length;
        totalY = aMatrix[0].length;
        int jj = 0;
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
                newNodo = new Nodo(i,j,aMatrix[i][j]);;
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

                newNodo.setIdFicha(aMatrix[i][j]);
                newNodo.setAnterior(temp);
                temp.setSiguiente(newNodo);
                temp = temp.getSiguiente();
                finalLista = newNodo;
                jj = j;
            }
            temp = Buscar(aMatrix[i][0]);
            if((i+1) < aMatrix[0].length)
               {
                 newNodo = new Nodo(i+1,0,aMatrix[i + 1][0]);
                 newNodo.setIdFicha(aMatrix[i + 1][0]);
                 temp.setInferior(newNodo);
                 temp = temp.getInferior();
               }
        }
  }

   public  Integer[][] getListaDoble()
    {
       Nodo temporal;
       Nodo aux = inicioLista;
       Integer vector[][] = new Integer[totalX][totalY];
       int k=0;
       int i=0;
        while(aux!=null)
        {
            temporal = aux;
            while (temporal != null)
            {
                vector[k][i] = temporal.getIdFicha();
                k++;
                temporal = temporal.getSiguiente();
            }
            i++;
            k = 0;

            aux = aux.getInferior();
        }
        return vector;
    }

    public Nodo Buscar(Integer valor)
    {
        Nodo temporalX = inicioLista;
        Nodo temporalY = inicioLista;
        Nodo newNodo= new Nodo(0,0,0);
        while(temporalY !=null)
        {
            while(temporalX!=null)
            {
              if (temporalX.getIdFicha() == valor)
                {
                    return temporalX;
                }
                temporalX = temporalX.getSiguiente();
            }
            temporalY = temporalY.getInferior();
            temporalX = temporalY;
        }
        return newNodo;
    }
    public Nodo BuscarPorPosicion(Nodo aNodo)
    {
        Nodo temporalX = inicioLista;
        Nodo temporalY = inicioLista;
        Nodo newNodo= new Nodo(0,0,0);;
        int a,b,c,d;
        while(temporalY !=null)
        {
            while(temporalX!=null)
            {  a =temporalX.getPosicionArregloX();
               b = aNodo.getPosicionArregloY();
               c = temporalX.getPosicionArregloY();
               d = aNodo.getPosicionArregloX();
                if (( a== b)&& (c == d))
                {
                    return temporalX;
                }
                temporalX = temporalX.getSiguiente();
            }
            temporalY = temporalY.getInferior();
            temporalX = temporalY;
        }
        return newNodo;
    }


    public Integer CambiarNodos(Nodo valor)
    {
      Nodo vacio = Buscar(0);
      Integer aux;
      aux = vacio.getIdFicha();
      Integer salida = valor.getIdFicha();
      if(((vacio.getSiguiente() != null)&&(vacio.getSiguiente().getIdFicha() == valor.getIdFicha()))||
              ((vacio.getAnterior() != null)&&(vacio.getAnterior().getIdFicha() == valor.getIdFicha()))||
              ((vacio.getSuperior() != null)&&(vacio.getSuperior().getIdFicha() == valor.getIdFicha()))||
              ((vacio.getInferior() != null)&&(vacio.getInferior().getIdFicha() == valor.getIdFicha())))
        {
           vacio.setIdFicha(valor.getIdFicha());
           vacio.getButton().setText(String.valueOf(valor.getIdFicha()));
           System.out.print(vacio.getButton().getText());
           valor.getButton().setText(String.valueOf(aux));
           valor.setIdFicha(aux);

            return valor.getIdFicha();
        }
        return salida;
    }

}
