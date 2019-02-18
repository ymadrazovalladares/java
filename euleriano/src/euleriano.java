
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Graph {
    private int vCount;
    private List<Integer>[] adj;

    public int getvCount() {
        return vCount;
    }

    public Graph(int vCount) {
        this.vCount = vCount;
        adj = (List<Integer>[]) new List[vCount];
        for (int i = 0; i < vCount; i++)
            adj[i] = new ArrayList<Integer>();
    }

    public void addEdge(int i, int j) {
        adj[i].add(j);
        adj[j].add(i);
    }

    public void removeEdge(int i, int j) {
        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()) {
            if (it.next() == j) {
                it.remove();
                break;
            }
        }
        Iterator<Integer> it2 = adj[j].iterator();
        while (it.hasNext()) {
            if (it.next() == i) {
                it.remove();
                return;
            }
        }
    }

    public boolean hasEdge(int i, int j) {
        return adj[i].contains(j);
    }

    public List<Integer> neighbours(int vertex) {
        return adj[vertex];
    }

    public void printGraph() {
        for (int i = 0; i < vCount; i++) {
            List<Integer> edges = neighbours(i);
            System.out.print(i + ": ");
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(edges.get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        // Let us create and test graphs shown in above figures
           /*Graph g1 = new Graph(5);
            g1.addEdge(1, 0);
            g1.addEdge(0, 2);
            g1.addEdge(2, 1);
            g1.addEdge(0, 3);
            g1.addEdge(3, 4);
            g1.test("G1: ");*/

        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
       // g2.test("G2: ");
        g2.printGraph();
    }
}

