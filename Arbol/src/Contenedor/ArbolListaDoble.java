package Contenedor;

public class ArbolListaDoble 
{
	 private Nodo inicioLista;
	 
	    public ArbolListaDoble( int valor ) {
	        this.inicioLista = new Nodo( valor );
	    }
	 
	    public ArbolListaDoble( Nodo raiz ) {
	        this.inicioLista = raiz;
	    }
	 
	    public Nodo getRaiz() {
	        return inicioLista;
	    }
	 
	    public void setRaiz(Nodo raiz) {
	        this.inicioLista = raiz;
	    }

    	public void addNodo( Integer valor)
	    {
	       Nodo temp = new Nodo(inicioLista);
	       temp = inicioLista;
		   Nodo nodo = new Nodo(valor);
	       if(inicioLista == null)
		   {
		   	inicioLista = nodo;
		   	return;
		   }
		   boolean bandera = false;
	       while (!bandera)
		   {
		   	if(nodo.getValor() > temp.getValor())
			{
				if (temp.getHojaDerecha() == null)
				{
					temp.setHojaDerecha(nodo);
					nodo.setPadre(temp);
					return;
				}
				temp = temp.getHojaDerecha();

			}
			else
				{
					if(temp.getValor() == nodo.getValor())
					{
						System.out.print("El nodo" + nodo.getValor()+" existe en el arbol");
						return;
					}
					if (temp.getHojaIzquierda() == null)
					{
						temp.setHojaIzquierda(nodo);
						nodo.setPadre(temp);
						return;
					}
					temp = temp.getHojaIzquierda();
				}

		   }
	    }


	    public void PostOrden()    //RID
	    {
	     	//Integer rid []= new Integer[100];
		    Preorden(this.inicioLista);
    	}
	    public void PostOrden(Nodo raiz)    //RID
	    {
		   if(raiz.getHojaIzquierda() == null)
		    	return;

	       System.out.print(raiz.getHojaIzquierda().getValor() + " ");
		   PostOrden(raiz.getHojaDerecha());
		   PostOrden(raiz);
	    }

	    public void Preorden()    //RID
	    {
	     	//Integer rid []= new Integer[100];
		    Preorden(this.inicioLista);
     	}
	    public void Preorden(Nodo raiz)    //RID
     	{

	    	if(raiz == null)
	    		return;

		   System.out.print(raiz.getValor() + " ");
		   Preorden(raiz.getHojaIzquierda());
		   Preorden(raiz.getHojaDerecha());
    	}
}
