package Day261006.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 숫자 수
		int l = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기
		
		Deque<Node> myDeque = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
				myDeque.removeLast();
			}
			
			myDeque.addLast(new Node(i, now));
			
			if (myDeque.getFirst().index <= i - l) {
				myDeque.removeFirst();
			}
			bw.write(myDeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
		
	}
	
	public static class Node {
		int index;
		int value;
		
		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

}
