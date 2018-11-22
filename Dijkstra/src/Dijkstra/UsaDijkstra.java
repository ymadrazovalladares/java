package Dijkstra;

  import java.util.PriorityQueue;
  import java.util.List;
  import java.util.ArrayList;

     public class UsaDijkstra {

     public static void CalculoDeRuta(Nodo inicio){
	 inicio.distanciaMasCorta=0;

	//implement a priority queue
		PriorityQueue<Nodo> queue = new PriorityQueue<Nodo>();
		queue.add(inicio);

		while(!queue.isEmpty()){
		Nodo u = queue.poll();

	/*visit the adjacencies, starting from 
	the nearest node(smallest shortestDistance)*/
					
		for(Vertice e: u.adjacentes){

		Nodo v = e.destino;
		double peso = e.peso;

	//relax(u,v,weight)
		double distanciaDesdeU = u.distanciaMasCorta + peso;
		if(distanciaDesdeU<v.distanciaMasCorta){

	/*remove v from queue for updating 
	the shortestDistance value*/
		queue.remove(v);
		v.distanciaMasCorta = distanciaDesdeU;
		v.parent = u;
		queue.add(v);

	      }
		}
	  }
    }

	  public static List<Nodo> getCaminoMasCortoA(Nodo destino){

	//trace path from target to source
	  List<Nodo> camino = new ArrayList<Nodo>();
       for(Nodo nodo = destino;
    	   nodo!=null; nodo = nodo.parent){
			camino.add(nodo);
		}


	//reverse the order such that it will be from source to target
	//Collections.reverse(path);

		return camino;
	}

	     public static void main(String[] args){

	   //initialize the graph base on the Romania map
	    Nodo n1 = new Nodo("A");
	    Nodo n2 = new Nodo("B");
	    Nodo n3 = new Nodo("C");
	    Nodo n4 = new Nodo("D");
		Nodo n5 = new Nodo("E");
		Nodo n6 = new Nodo("F");
		Nodo n7 = new Nodo("G");
		Nodo n8 = new Nodo("H");
				
	//initialize the edges
	n1.adjacentes = new Vertice[]{
		new Vertice(n2,27),
		new Vertice(n3,70),
		new Vertice(n4,52)
                };

	n2.adjacentes = new Vertice[]{
		new Vertice(n1,27),
	    new Vertice(n5,41),
		new Vertice(n7,70),
		new Vertice(n3,44)
				};

	n3.adjacentes = new Vertice[]{
		new Vertice(n1,70),	
		new Vertice(n2,44),
		new Vertice(n8,67),
		new Vertice(n4,151)
				};

	n4.adjacentes = new Vertice[]{
		new Vertice(n1,52),
		new Vertice(n5,35),
		new Vertice(n6,60),
		new Vertice(n7,46)
				};

	n5.adjacentes = new Vertice[]{
		new Vertice(n2,41),
		new Vertice(n4,35),
		new Vertice(n7,35),
		new Vertice(n6,30)
				};

	n6.adjacentes = new Vertice[]{
		new Vertice(n3,40),
		new Vertice(n5,30),
		new Vertice(n4,60),
		new Vertice(n8,29)
				};

	n7.adjacentes = new Vertice[]{
		new Vertice(n5,35),
		new Vertice(n2,70),
		new Vertice(n4,46),
		new Vertice(n8,45)
				};

	n8.adjacentes = new Vertice[]{
		new Vertice(n3,67),
		new Vertice(n6,29),
		new Vertice(n7,45)
				};				

		
		Nodo[] nodos = {n1,n2,n3,n4,n5,n6,n7,n8,};

	//compute paths
		CalculoDeRuta(n1);

	//print shortest paths

			for(Nodo n: nodos){
		 System.out.println("Distancia desde A hasta " + n + ": " + n.distanciaMasCorta);
		    List<Nodo> camino = getCaminoMasCortoA(n);
		     System.out.println("Camino: " + camino);
				}

				//List<Node> camino = getCaminoMasCortoA(n7);
				//System.out.println("Camino: " + camino);

			}
}

