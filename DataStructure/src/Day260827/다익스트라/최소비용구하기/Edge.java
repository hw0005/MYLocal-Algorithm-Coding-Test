package Day260827.다익스트라.최소비용구하기;

public class Edge implements Comparable<Edge> {
	int node, value;
	
	Edge(int node, int value) {
		this.node = node;
		this.value = value;
	}
	public int compareTo(Edge e) {
		return this.value = e.value;
	}
	

}
