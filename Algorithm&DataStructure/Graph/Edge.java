// @breif: Edge Class
//         Mainly used for EdgeWeightedGraph
// @reference: Princeton Algorithm book P.394

public class Edge implements Comparable<Edge>{
	private int v;
	private int w;
	private double weight;
	
	// @brief Edge Constructor
	// @status finished
	public Edge(int v, int w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	// @brief Return weight of an edge
	// @status finished
	public double weight(){	return weight;	}
	
	// @brief Return either end of an edge
	// @status finished
	public int either(){ return v;	}
	
	// @brief Return the other end of an edge
	// @status finished
	public int other(int vertex){
		if(vertex == v)	return w;
		else if(vertex == w)	return v;
		else throw new RuntimeException("Inconsistent edge");
	}

	@Override
	public int compareTo(Edge that) {
		if(this.weight() > that.weight())
			return 1;
		else if(this.weight() < that.weight())
			return -1;
		else
			return 0;
	}
}
