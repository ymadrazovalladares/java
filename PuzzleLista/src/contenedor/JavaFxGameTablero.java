package contenedor;

import javafx.scene.layout.Pane;

public class JavaFxGameTablero {
    Pane pane;
    Nodo inicioLista;
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


    public JavaFxGameTablero(Integer datostablero[][])
    {
        pane = new Pane();
        inicioLista =new Nodo();
        totalX = 0;
        totalY = 0;
        setFichas(datostablero);
    }

    public void setFichas(Integer atablero[][])
    {
        this.PushMatrix(atablero);
        Integer temp[][] = new Integer[this.getTotalX()][this.getTotalX()];
        temp = this.getListaDoble();

        for (Integer i=0; i<temp.length;i++)
            for (Integer j=0; j<temp[0].length;j++)
            {

                Nodo javaFxFicha = GetFicha(i,j);
                javaFxFicha.getButton().setOnMouseClicked(event ->
                {
                  CambiarNodos(javaFxFicha);
                  if(Ganador() == true)
                       Regalo();
                }
                );

               pane.getChildren().add(javaFxFicha.getButton());
            }
    }

    public boolean Ganador()
    {
        Nodo temp = new Nodo();
        temp = inicioLista;
        Nodo temp1 = new Nodo();
        temp1 = inicioLista;

        for (Integer i=1; i<=totalY;i++)
        {
            for (Integer j = 1; j <= totalX; j++)
            {
                if((i == totalY)&&(j == totalX))
                    return true;
                if(temp.getIdFicha() != (totalX*(i-1)) + j)
                    return false;
                temp = temp.getSiguiente();
            }
            temp1 = temp1.getInferior();
            temp = temp1;
        }
        return true;
    }

    public void Regalo()
    {
        Nodo temp = new Nodo();
        temp = inicioLista;
        Nodo temp1 = new Nodo();
        temp1 = inicioLista;

        for (Integer i=1; i<=totalY;i++)
        {
            for (Integer j = 1; j <= totalX; j++)
            {
                temp.setIdFicha(0);
                temp.getButton().setText("0");
                temp = temp.getSiguiente();
            }
            temp1 = temp1.getInferior();
            temp = temp1;
        }

    }

    public  Nodo GetFicha(int a, int b)
    {
        Nodo temp = new Nodo();
        temp = inicioLista;
        Nodo temp1 = new Nodo();
        temp1 = inicioLista;

        for (Integer i=0; i<totalX;i++)
        {
            for (Integer j = 0; j < totalY; j++) {
                if ((i == a) && (j == b))
                    return temp;
                temp = temp.getSiguiente();
            }
            temp1 = temp1.getInferior();
            temp = temp1;
        }
        return null;
    }

    public void CambiarNodos(Nodo jajavaFxFicha)
    {

        Integer aux;
        Nodo vacio = new Nodo();
        vacio = Buscar(0);
        if(((jajavaFxFicha.getSiguiente() != null)&&(jajavaFxFicha.getSiguiente().getIdFicha() == 0))||
                ((jajavaFxFicha.getAnterior() != null)&&(jajavaFxFicha.getAnterior().getIdFicha() == 0))||
                ((jajavaFxFicha.getSuperior() != null)&&(jajavaFxFicha.getSuperior().getIdFicha() == 0))||
                ((jajavaFxFicha.getInferior() != null)&&(jajavaFxFicha.getInferior().getIdFicha() == 0)))
        {
            vacio.setIdFicha(jajavaFxFicha.getIdFicha());
            vacio.getButton().setText(String.valueOf(jajavaFxFicha.getIdFicha()));
            jajavaFxFicha.getButton().setText(String.valueOf(0));
            jajavaFxFicha.setIdFicha(0);
             }

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

   /*public Nodo BuscarPorPosicion(Integer xx, Integer yy)
    {
        Nodo temporalX = inicioLista;
        Nodo temporalY = inicioLista;
        Nodo newNodo= new Nodo(0,0,0);;
        int a,b,c,d;
        while(temporalY !=null)
        {
            while(temporalX!=null)
            {  a =temporalX.getPosicionArregloX();
                b = yy;
                c = temporalX.getPosicionArregloY();
                d = xx;
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
    }*/

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }


}