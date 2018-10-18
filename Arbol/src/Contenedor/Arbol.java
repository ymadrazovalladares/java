package Contenedor;

public class Arbol {
	 
    private Nodo raiz;
 
    public Arbol( int valor ) {
        this.raiz = new Nodo( valor );
    }
 
    public Arbol( Nodo raiz ) {
        this.raiz = raiz;
    }
 
    public Nodo getRaiz() {
        return raiz;
    }
 
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    private void addNodo( Integer anodo, Nodo raiz ) 
    {
    	Nodo nodo = new Nodo(anodo);
        if ( raiz == null )
        {
             this.setRaiz(nodo);
             return;
        }
        else
        {
            if ( nodo.getValor() <= raiz.getValor() )
            {
                 if (raiz.getHojaIzquierda() == null) 
                {
                    raiz.setHojaIzquierda(nodo);
                    nodo.setPadre(raiz);
                }
                else 
                {
                    addNodo( anodo , raiz.getHojaIzquierda() );
                }
            }
            else 
            {
                if (raiz.getHojaDerecha() == null)
                  {
                    raiz.setHojaDerecha(nodo);
                    nodo.setPadre(raiz);
                  }
                else 
                  {
                    addNodo( anodo, raiz.getHojaDerecha() );
                  }
            }
        }
    }
 
    public void addNodo( Integer nodo ) 
    {
        this.addNodo( nodo, this.raiz );
    }
    public void Preorden()    //RID
    {
		//Integer rid []= new Integer[100];
		Preorden(this.raiz);
		
	}
    public void Preorden(Nodo raiz)    //RID
    { 
      
       if(raiz == null)
    	   return;
        
          System.out.print(raiz.getValor() + " ");
          Preorden(raiz.getHojaIzquierda());
          Preorden(raiz.getHojaDerecha());
        
    }
    
    public void PostOrden()    //RID
    {
		//Integer rid []= new Integer[100];
        PostOrden(this.raiz);
		
	}
    public void PostOrden(Nodo raiz)    //RID
    {

        if(raiz.getHojaIzquierda() == null)
            return;

        System.out.print(raiz.getHojaIzquierda().getValor() + " ");
        PostOrden(raiz.getHojaDerecha());
        PostOrden(raiz);
    }

    public void InOrden()    //RID
       {
        //Integer rid []= new Integer[100];
           InOrden(this.raiz);

       }
    public void InOrden(Nodo raiz)    //RID
      {

        if(raiz.getHojaIzquierda() == null)
            return;

          System.out.print(raiz.getHojaIzquierda().getValor() + " ");
          PostOrden(raiz);
          PostOrden(raiz.getHojaDerecha());

     }
}