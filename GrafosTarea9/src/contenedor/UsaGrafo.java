package contenedor;
public class UsaGrafo {
    public static void main(String args[]){
        ClassGrafo<String> grafo= new ClassGrafo<String>() {
            @Override
            public int compara(String o1, String o2) {
                if(o1.compareTo(o2)<0 )
                    return -1;
                if(o1.compareTo(o2)>0 )
                    return 1;
                else
                    return 0;
            }
        };

        grafo.addNodo("R");
        grafo.addNodo("S");
        grafo.addNodo("T");
        grafo.addNodo("U");
        grafo.addNodo("V");
        grafo.addNodo("W");
        grafo.addNodo("X");
        grafo.addNodo("Y");


        grafo.addAdyacentes("X","T");
        grafo.addAdyacentes("X","U");
        grafo.addAdyacentes("X","W");
        grafo.addAdyacentes("X","Y");

        grafo.addAdyacentes("R","V");
        grafo.addAdyacentes("R","S");

        grafo.addAdyacentes("S","W");
        grafo.addAdyacentes("S","R");


        grafo.addAdyacentes("T","X");
        grafo.addAdyacentes("T","W");
        grafo.addAdyacentes("T","U");



        grafo.addAdyacentes("U","T");
        grafo.addAdyacentes("U","X");
        grafo.addAdyacentes("U","Y");

        grafo.addAdyacentes("V","R");

        grafo.addAdyacentes("W","S");
        grafo.addAdyacentes("W","T");
        grafo.addAdyacentes("W","X");


        grafo.addAdyacentes("Y","U");
        grafo.addAdyacentes("Y","X");

        //*** B'usqueda BFS

        ClaseBfsGrafo bfs= new ClaseBfsGrafo(grafo);
        Object[] recorridoBfs = bfs.bfsRecorrido("S");

        ClaseDfsGrafo DFS= new ClaseDfsGrafo(grafo);
        Object[] recorridoDfs = DFS.dfsRecorrido("S");

        System.out.println();
        System.out.println("Busqueda en Achura BFS ");
        for (Object nodo : recorridoBfs)
            System.out.print((String)nodo+",");
        System.out.println();

        System.out.println();
        System.out.println("Busqueda en Profundidad DFS ");
        for (Object nodo : recorridoDfs)
            System.out.print((String)nodo+",");
        System.out.println();

    }
}
