
public class Node implements Comparable<Node> {
	private final int index;
	private final int distance;

	public Node(int i, int dist)
	{
		this.index = i;
		this.distance = dist;
	}

	public int Index()
	{
		return this.index;
	}

	@Override
	public int compareTo(Node that) {
		return this.distance < that.distance
				? -1
				: this.distance > that.distance
					? +1
					: 0;
	}

}
