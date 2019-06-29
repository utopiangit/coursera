package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

public class Graph {
	private int V;
	private HashSet<Integer>[] adj;

	public Graph(int V)
	{
		this.V = V;
		initializeAdj(V);
	}

	Graph(BufferedReader br)
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
		adj[w].add(v);
	}

	Iterable<Integer> adj(int v)
	{
		return this.adj[v];
	}

	int V()
	{
		return this.V;
	}

	int E()
	{
		// Streamで書いた方がいいかも
		int e = 0;
		for (HashSet<Integer> v : adj)
		{
			e += v.size();
		}
		return e;
	}

	void show()
	{
		for (int v = 0; v < this.V; ++v)
			for (int w : this.adj(v))
				System.out.println(v + "-" + w);
	}
}
