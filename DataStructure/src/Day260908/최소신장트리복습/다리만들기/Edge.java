package Day260908.최소신장트리복습.다리만들기;

public class Edge implements Comparable<Edge> {
	
	int s, e, v;
	
	Edge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}
	
	public int compareTo(Edge e) {
		return this.v - e.v;
	}

}
