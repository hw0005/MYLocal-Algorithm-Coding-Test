package Day260904.최소신장트리.최소신장트리구하기;

public class Edge implements Comparable<Edge>{

	int start, end, value;
	
	Edge(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}
	
	public int compareTo(Edge e) {
		return this.value - e.value;
	}
	
}
