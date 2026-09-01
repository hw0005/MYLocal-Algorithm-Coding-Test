package Day260901.다익스트라복습.K번째최단경로찾기;

public class Edge implements Comparable<Edge> {
	int node, value;
	Edge(int node, int value) {
		this.node = node;
		this.value = value;
	}
	public int compareTo(Edge e) {
		return this.value - e.value; // 오름차순
	}
}
