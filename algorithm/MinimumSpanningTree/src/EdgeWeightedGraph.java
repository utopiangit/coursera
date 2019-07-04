import java.util.HashSet;
import java.util.PriorityQueue;

public class EdgeWeightedGraph
{
   public final int V;
   private final HashSet<Edge>[] adj;
   private PriorityQueue<Edge> edges;
   public EdgeWeightedGraph(int V)

   {
      this.V = V;
      adj = (HashSet<Edge>[]) new HashSet[V];
      for (int v = 0; v < V; v++)
         adj[v] = new HashSet<Edge>();
}
   public void addEdge(Edge e)
   {
      int v = e.either(), w = e.other(v);
      adj[v].add(e);
      adj[w].add(e);
      edges.add(e);
   }
   public Iterable<Edge> adj(int v)
   {
	   return adj[v];
   }

   public PriorityQueue<Edge> edges()
   {
	   return this.edges;
   }
}