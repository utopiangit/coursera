package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class Digraph implements IGraph {
	private int V;
	private HashSet<Integer>[] adj;

	public Digraph(int V)
	{
		this.V = V;
		initializeAdj(V);
	}

	Digraph(BufferedReader br)
	{
		try {
			this.V = Integer.parseInt(br.readLine());
			initializeAdj(this.V);
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; ++i) {
				String[] s = br.readLine().split(" ");
				int left = Integer.parseInt(s[0]);
				int right = Integer.parseInt(s[1]);
				this.addEdge(left, right);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void initializeAdj(int V) {
		this.adj = new HashSet[V];
		for (int v = 0; v < V; ++v)
			adj[v] = new HashSet<Integer>();
	}

	void addEdge(int v, int w)
	{
		adj[v].add(w);
	}

	@Override
	public Iterable<Integer> adj(int v)
	{
		return this.adj[v];
	}

	@Override
	public int V()
	{
		return this.V;
	}

	@Override
	public int E()
	{
		return Arrays.stream(adj)
			.mapToInt(e -> e.size())
			.sum();
	}

	public Digraph reverse()
	{
		Digraph g = new Digraph(this.V());
		for (int v = 0; v < this.V(); ++v)
		{
			for (int w : this.adj(v))
			{
				g.addEdge(w, v);
			}
		}
		return g;
	}
	void show()
	{
		for (int v = 0; v < this.V; ++v)
			for (int w : this.adj(v))
				System.out.println(v + "-" + w);
	}

}
