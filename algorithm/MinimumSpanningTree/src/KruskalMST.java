

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {
	private Queue<Edge> mst = new LinkedList<Edge>();

	public KruskalMST(EdgeWeightedGraph g)
	{
		PriorityQueue<Edge> pq = g.edges();
		UnionFind uf = new UnionFind(g.V);
		while(!pq.isEmpty() && mst.size() < (g.V - 1))
		{
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if (!uf.same(v, w))
			{
				uf.unite(v, w);
				mst.add(e);
			}
		}
	}

	public Iterable<Edge> edges()
	{
		return mst;
	}
}
