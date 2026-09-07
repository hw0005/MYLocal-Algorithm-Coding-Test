package Day260907.최소신장트리.다리만들기;

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
