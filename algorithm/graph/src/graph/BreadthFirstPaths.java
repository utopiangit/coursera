package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public BreadthFirstPaths(IGraph g, int s)
	{
		this.marked = new boolean[g.E()];
		this.edgeTo = new int[g.V()];
		this.s = s;
		bfs(g, s);
	}

	private void bfs(IGraph g, int s)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		marked[s] = true;
		while (!q.isEmpty())
		{
			int v = q.poll();
			for (int w : g.adj(v))
			{
				if (!marked[w])
				{
					q.add(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}

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
