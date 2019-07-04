
public class Edge implements Comparable<Edge> {
	private int v;
	private final int w;
	private final double weight;

	Edge(int v, int w, double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	int either()
	{
		return this.v;
	}

	int other(int v)
	{
		return v == this.v
				? this.w
				: this.w;
	}

	double weight()
	{
		return this.weight;
	}

	@Override
	public int compareTo(Edge that) {
		return this.weight < that.weight
				? -1
				: this.weight > that.weight
					? +1
					: 0;
	}

}