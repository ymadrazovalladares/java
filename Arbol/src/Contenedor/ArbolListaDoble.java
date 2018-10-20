package Contenedor;

public class ArbolListaDoble 
{
	 private Nodo inicioLista;
	 private Nodo finalLista;
	 
	    public ArbolListaDoble( int valor ) {
	        this.inicioLista = new Nodo( valor );
			this.finalLista = inicioLista;
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
					finalLista.setSiguiente(nodo);
					nodo.setAnterior(finalLista);
					finalLista = finalLista.getSiguiente();
					return;
				}
				temp = temp.getHojaDerecha();

			}
			else
				{
					if(temp.getValor() == nodo.getValor())
					{
						System.out.print("El nodo" + nodo.getValor()+" existe en el arbol");
						temp.setSiguiente(null);
						return;
					}
					if (temp.getHojaIzquierda() == null)
					{
						temp.setHojaIzquierda(nodo);
						nodo.setPadre(temp);
						finalLista.setSiguiente(nodo);
						nodo.setAnterior(finalLista);
						finalLista = finalLista.getSiguiente();
						return;
					}
					temp = temp.getHojaIzquierda();
				}

		   }
	    }


	    public void PostOrden()    //IDR
	    {
	       PostOrden(this.inicioLista);
    	}
	    public void PostOrden(Nodo raiz)    //IDR
	    {
		   if(raiz== null)
		    	return;

		   PostOrden(raiz.getHojaIzquierda());
		   PostOrden(raiz.getHojaDerecha());
		   System.out.print(raiz.getValor() + " ");
	    }

	    public void Preorden()    //RID
	    {
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
	    public void InOrden()    //IRD
	    {
	    	//Integer rid []= new Integer[100];
	    	InOrden(this.inicioLista);
	    }
	    public void InOrden(Nodo raiz)    //IRD
	    {
	    	if(raiz == null)
	    		return;

			  InOrden(raiz.getHojaIzquierda());
		      System.out.print(raiz.getValor() + " ");
			  InOrden(raiz.getHojaDerecha());

    	}
    	public  void GetLista()
		{
			Nodo temp = new Nodo(0);
			temp = inicioLista;

			while (temp != null)
			{
				System.out.print(temp.getValor() + " ");
				temp = temp.getSiguiente();
			}
		}
}
