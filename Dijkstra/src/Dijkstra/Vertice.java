package Dijkstra;

public class Vertice {

	public final Nodo destino;
	public final double peso;
	public Vertice(Nodo nodoDestino, double valorPeso){
		destino = nodoDestino;
		peso = valorPeso;
	}
}