import java.util.LinkedList;
import java.util.PriorityQueue;

//Priority Queue based Dijkstra
public class ShortestPaths {
	private boolean[] marked;
	private int[] distance;
	private int[] parent;
	private PriorityQueue<Node> pq;

	public ShortestPaths(EdgeWeightedDigraph g, int start)
	{
		distance = new int[g.V()];
		parent = new int[g.V()];
		marked = new boolean[g.V()];
		pq = new PriorityQueue<Node>();
		for (int i = 0; i < g.V(); ++i)
		{
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		parent[start] = start;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty())
		{
			Node node = pq.poll();
			if (!marked[node.Index()])
			{
				int visiting = node.Index();
				marked[visiting] = true;
				for (DirectedEdge edge : g.adj(visiting))
				{
					if (marked[edge.to()]) continue;
					if (distance[visiting] + edge.weight() < distance[edge.to()])
					{
						distance[edge.to()] = distance[visiting] + (int)edge.weight();
						parent[edge.to()] = visiting;
						pq.add(new Node(edge.to(), distance[edge.to()]));
					}
				}
			}
		}

	}

	public int distTo(int v)
	{
		return distance[v];
	}

	public Iterable<Integer> pathTo(int v)
	{
		LinkedList<Integer> path = new LinkedList<Integer>();
		int bc = v;
		while (!(parent[bc] == bc))
		{
			path.add(bc);
			bc = parent[bc];
		}
		path.add(bc);
		return path;
	}
}
