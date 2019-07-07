import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {

	private boolean[] marked;
	private Queue<Edge> mst;
	private PriorityQueue<Edge> pq;

	public LazyPrimMST(EdgeWeightedGraph g)
	{
		pq = new PriorityQueue<Edge>();
		mst = new LinkedList<Edge>();
		marked = new boolean[g.V];
		visit(g, 0);

		while(!pq.isEmpty() && mst.size() > g.V - 1)
		{
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if (marked[v] && marked[w]) continue;
			mst.add(e);
			if (!marked[v]) visit(g, v);
			if (!marked[w]) visit(g, w);
		}
	}

	private void visit(EdgeWeightedGraph g, int v)
	{
		marked[v] = true;
		for (Edge e : g.adj(v))
		{
			if (!marked[e.other(v)])
				pq.add(e);
		}
	}

	public Iterable<Edge> mst()
	{
		return mst;
	}
}
