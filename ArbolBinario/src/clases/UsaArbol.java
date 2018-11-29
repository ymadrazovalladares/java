package clases;

public class UsaArbol {

    public static void main(String args[]){
        Arbol estruturaArbol = new Arbol();
        estruturaArbol.add(90);
        estruturaArbol.add(100);
        estruturaArbol.add(65);
        estruturaArbol.add(66);
        estruturaArbol.add(68);
        estruturaArbol.add(80);
        estruturaArbol.add(75);
        estruturaArbol.add(82);
        estruturaArbol.add(83);
        estruturaArbol.add(100);
        estruturaArbol.add(98);
        estruturaArbol.add(93);
        estruturaArbol.add(150);
        estruturaArbol.add(125);
        estruturaArbol.add(175);

        System.out.println("PreOrden");
        estruturaArbol.preorden();
        System.out.println("");
        estruturaArbol.Eliminar(estruturaArbol.BuscarPreorrden(estruturaArbol.getRaiz(),98));
        System.out.println("PostOrden");
        estruturaArbol.postorden();
        System.out.println("");
        System.out.println("InOrden");
        estruturaArbol.inorden();
        System.out.println("");
        System.out.println("PreOrden");
        estruturaArbol.preorden();
        //estruturaArbol.Eliminar(estruturaArbol.BuscarPreorrden(estruturaArbol.getRaiz(),90));



    }
}
