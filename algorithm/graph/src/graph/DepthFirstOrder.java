package graph;

import java.util.Stack;

public class DepthFirstOrder {
	private boolean marked[];
	private Stack<Integer> reversePost;

	public DepthFirstOrder(Digraph g)
	{
		marked = new boolean[g.V()];
		this.reversePost = new Stack<Integer>();
		for (int v = 0; v < g.V(); ++v)
			if (!marked[v]) dfs(g, v);
	}

	private void dfs(Digraph g, int v)
	{
		marked[v] = true;
		for (int w : g.adj(v))
			if (!marked[w]) dfs(g, w);
		this.reversePost.push(v);
	}

	public Iterable<Integer> reversePost()
	{
		return this.reversePost;
	}
}
