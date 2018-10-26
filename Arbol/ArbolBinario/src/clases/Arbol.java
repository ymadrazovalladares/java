package clases;

public class Arbol {
    CNodo raiz;

    public CNodo getRaiz() {
        return raiz;
    }

    public void setRaiz(CNodo raiz) {
        this.raiz = raiz;
    }

    public Arbol(){
        raiz = null;
    }

    public CNodo add(CNodo padre, CNodo hijo, CNodo caja){
        if (hijo ==null){
            hijo = caja;
            hijo.setPadre(padre);
            return hijo;
        }

        if (caja.getValor().compareTo(hijo.getValor())<0)
            hijo.sethIzq(add(hijo,hijo.gethIzq(),caja));

        else
            hijo.sethDer(add(hijo,hijo.gethDer(),caja));

        return hijo;
    }

    public void add(Integer valor){
        CNodo caja  = new CNodo(valor);
        if (raiz ==null){
            raiz =caja;
            return;
        }

        if (valor.compareTo(raiz.getValor())<0)
            raiz.sethIzq(add(raiz,raiz.gethIzq(),caja));
        else
            raiz.sethDer(add(raiz,raiz.gethDer(),caja));


    }

    public void preorden(CNodo raiz){ //preorden
        if(raiz ==null)
            return;

        System.out.print(raiz.getValor() + " ");
        preorden(raiz.gethIzq());
        preorden(raiz.gethDer());
    }


    public void preorden(){ // preorden
        if (raiz==null)
            return;
        preorden(raiz);

    }

    public void inorden(CNodo raiz){ //inorden
        if(raiz ==null)
            return;

        inorden(raiz.gethIzq());
        System.out.print(raiz.getValor() + " ");
        inorden(raiz.gethDer());
    }


    public void inorden(){ // inorden
        if (raiz==null)
            return;
        inorden(raiz);

    }


    public void postorden(CNodo raiz){ //postorden
        if(raiz ==null)
            return;

        postorden(raiz.gethIzq());
        postorden(raiz.gethDer());
        System.out.print(raiz.getValor() + " ");
    }


    public void postorden(){ // postorden
        if (raiz==null)
            return;
        postorden(raiz);

    }

    public CNodo BuscarPreorrden(CNodo raiz, Integer valor)
    {
       CNodo nodoBuscado = null;
        if(raiz == null)
          return null;
        if(raiz.getValor().compareTo(valor) == 0)
        {
            nodoBuscado = raiz;
            return nodoBuscado;
        }
        nodoBuscado = BuscarPreorrden(raiz.gethIzq(), valor);
        if(nodoBuscado == null)
            nodoBuscado = BuscarPreorrden(raiz.gethDer(),valor);
        if(nodoBuscado == null)
                return null;
        return nodoBuscado;
    }
    public void Eliminar(CNodo nodoEliminar)
    {
        CNodo padre = nodoEliminar.getPadre();

        if((nodoEliminar == padre.gethDer())&&(nodoEliminar.gethIzq() == null)&&(nodoEliminar.gethDer() == null))
        {
            padre.sethDer(null);
            nodoEliminar = null;
            return;
        }
        if((nodoEliminar == padre.gethIzq())&&(nodoEliminar.gethIzq() == null)&&(nodoEliminar.gethDer() == null))
        {
            padre.sethIzq(null);
            nodoEliminar = null;
            return;
        }
        CNodo subarbol;
        if((nodoEliminar == padre.gethIzq())&&(nodoEliminar.gethIzq() != null)&&(nodoEliminar.gethDer() == null))
        {
            subarbol= nodoEliminar.gethIzq();
            padre.sethIzq(subarbol);
            subarbol.setPadre(padre);
            nodoEliminar = null;
            return;
        }
        if((nodoEliminar == padre.gethDer())&&(nodoEliminar.gethIzq() == null)&&(nodoEliminar.gethDer() != null))
        {
            subarbol= nodoEliminar.gethDer();
            padre.sethDer(subarbol);
            subarbol.setPadre(padre);
            nodoEliminar = null;
            return;
        }
   /// nodo con los dos hijos recorrido por el hijo izq
        CNodo temp = nodoEliminar;
        if((nodoEliminar == padre.gethIzq())&&(nodoEliminar.gethIzq() != null)&&(nodoEliminar.gethDer() != null))
        {
            temp = temp.gethIzq();

            while(temp.gethDer()!= null)
            {
                temp = temp.gethDer();
            }
            nodoEliminar.setValor(temp.getValor());
            Eliminar(temp);
            return;
        }
  /// nodo con los dos hijos recorrido por el hijo der
        if((nodoEliminar == padre.gethDer())&&(nodoEliminar.gethIzq() != null)&&(nodoEliminar.gethDer() != null))
        {
            temp = temp.gethDer();

            while(temp.gethIzq()!= null)
            {
                temp = temp.gethIzq();
            }
            nodoEliminar.setValor(temp.getValor());
            Eliminar(temp);
            return;
        }
    }
}
