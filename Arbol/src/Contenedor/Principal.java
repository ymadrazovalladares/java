package Contenedor;

public class Principal 
{
    public static void main(String arg[]) 
    {
		Arbol aArbol = new Arbol(100);
		aArbol.addNodo(50);
		aArbol.addNodo(25);
		aArbol.addNodo(75);
		aArbol.addNodo(55);
		aArbol.addNodo(150);
		aArbol.addNodo(125);
		aArbol.addNodo(175);

		aArbol.Preorden();


		ArbolListaDoble  aArbolListaEnlazada = new ArbolListaDoble(100);
		aArbolListaEnlazada.addNodo(50);
		aArbolListaEnlazada.addNodo(25);
		aArbolListaEnlazada.addNodo(75);
		aArbolListaEnlazada.addNodo(55);
		aArbolListaEnlazada.addNodo(150);
		aArbolListaEnlazada.addNodo(125);
		aArbolListaEnlazada.addNodo(175);

		aArbolListaEnlazada.Preorden();
	}
}