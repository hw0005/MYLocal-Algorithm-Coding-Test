package Day260904.최소신장트리.다리만들기;

public class Edge implements Comparable<Edge>{
	int s, e, v;
	Edge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}
	
	public int compareTo(Edge e) {
		return this.v < e.v ? -1 : 1;// 오름차순
	}
}
