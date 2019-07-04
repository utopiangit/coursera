package graph;

import java.util.Stack;

public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;

	public DepthFirstPaths(IGraph g, int s)
	{
		this.marked = new boolean[g.E()];
		this.edgeTo = new int[g.V()];
		this.s = s;
		dfs(g, s);
	}

	private void dfs(IGraph g, int v)
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

//	public Iterable<Integer> visitedVertices()
//	{
//		ArrayList<Integer> l = new ArrayList<Integer>();
//		for (int i = 0; i < this.marked.length; ++i)
//		{
//			if (marked[i])
//				l.add(i);
//		}
//		return l;
//	}

	public boolean hasPathTo(int v)
	{
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v)
	{
	   if (!hasPathTo(v)) return null;
	   Stack<Integer> path = new Stack<Integer>();
	   for (int x = v; x != this.s; x = edgeTo[x])
	      path.push(x);
	   path.push(this.s);
	   return path;
	}
}
