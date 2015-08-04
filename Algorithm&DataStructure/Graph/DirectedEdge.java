// @breif: DirectEdge Class
//         Mainly used for EdgeWeightedDigraph
// @reference: Princeton Algorithm book P.415

public class DirectedEdge {
	private int v;
	private int w;
	private double weight;
	
	// @brief DirectedEdge Constructor
	// @status finished
	public DirectedEdge(int v, int w, double weight){
		this.v = v; 
		this.w = w;
		this.weight = weight;
	}
	
	// @brief Return weight of a DirectedEdge
	// @status finished
	public double weight(){	return weight;	}
	
	// @brief Return source node of DirectedEdge
	// @status finished
	public int from(){ return v;	}
	
	// @brief Return destination node of DirectedEdge
	// @status finished
	public int to(){ return w;	} 
}
