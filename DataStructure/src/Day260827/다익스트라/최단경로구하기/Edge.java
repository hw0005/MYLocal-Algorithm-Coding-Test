package Day260827.다익스트라.최단경로구하기;

public class Edge implements Comparable <Edge> {
	int node;
	int value;
	Edge (int node, int value) {
		this.node = node;
		this.value = value;
	}
	
	public int compareTo(Edge e) {
		if (this.value > e.value) {
			return 1;
		}
		else  {
			return -1;
		}
	}

}
