package graph;

import java.util.ArrayList;

public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
//	private int s;

	public DepthFirstPaths(Graph g, int s)
	{
		// 全部-1等で初期化すべき？
		this.marked = new boolean[g.E()];
		this.edgeTo = new int[g.V()];
//		this.s = s;
		dfs(g, s);
	}

	private void dfs(Graph g, int v)
	{
		marked[v] = true;
		for (int w : g.adj(v))
		{
			if (!marked[w])
			{
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}

	public int[] getEdgeTo()
	{
		return this.edgeTo;
	}

	public Iterable<Integer> visitedVertices()
	{
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < this.marked.length; ++i)
		{
			if (marked[i])
				l.add(i);
		}
		return l;
	}

}
