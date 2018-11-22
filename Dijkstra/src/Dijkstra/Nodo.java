package Dijkstra;

public class Nodo implements Comparable<Nodo> {

	public final String value;
	public Vertice[] adjacentes;
	public double distanciaMasCorta = Double.POSITIVE_INFINITY;
	public Nodo parent;

	public Nodo(String val){
		value = val;
	}

	public String toString(){
			return value;
	}

	public int compareTo(Nodo other){
		return Double.compare(distanciaMasCorta, other.distanciaMasCorta);
	}

}
