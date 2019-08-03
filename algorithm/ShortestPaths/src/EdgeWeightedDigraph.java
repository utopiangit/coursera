import java.util.Arrays;
import java.util.HashSet;

public class EdgeWeightedDigraph {
	private final int V;
	private final HashSet<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int v)
	{
		this.V = v;
		adj = (HashSet<DirectedEdge>[])new HashSet[V];
		for (int i = 0; i < V; ++i)
			adj[i] = new HashSet<DirectedEdge>();
	}

	public void addEdge(DirectedEdge e)
	{
		int v = e.from();
		adj[v].add(e);
	}

	public Iterable<DirectedEdge> adj(int v)
	{
		return adj[v];
	}

	public int V()
	{
		return V;
	}

	public int E()
	{
		return Arrays.stream(adj)
				.mapToInt(h -> h.size())
				.sum();
	}

	@SuppressWarnings("unchecked")
	public Iterable<DirectedEdge> edges()
	{
		return (Iterable<DirectedEdge>)Arrays.stream(adj)
				.flatMap(e -> e.stream())
				.iterator();

	}
}
