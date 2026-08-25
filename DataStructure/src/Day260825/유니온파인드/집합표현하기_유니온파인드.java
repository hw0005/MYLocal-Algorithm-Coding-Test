package Day260825.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합표현하기_유니온파인드 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 초기화
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int question = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (question == 0) { // 합치기
				union(a, b);
			} else {
				boolean result = checkSame(a, b);
				if (result) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void union(int a, int b) { // 합치는 로직
		// 우선 찾아
		a = find(a);
		b = find(b);
		if (a != b) { // a값과 b값이 다르다면 b의 밸류에 i의 인덱스(i의 value임)값 넣기
			parent[b] = a; // 덮어씌우기(먼저 들어온 값에 어차피 상관없음)
		}
	}

	private static int find(int idx) { // 찾는 로직
		// 들어온 인덱스 기준으로 찾을 것
		if (idx == parent[idx]) { // 들어온 인덱스와 밸류값이 같다면
			return idx; // 그대로 인덱스 출력
		} else { // 다르다면
			return parent[idx] = find(parent[idx]); // 그 인덱스를 통해 찾은 밸류값으로 또 찾기(루트 노드 찾기). 그리고 찾은 걸 현재 내 밸류값에 넣고 이값 반환
		}
	}

	private static boolean checkSame(int a, int b) {
		// 우선 찾아
		a = find(a);
		b = find(b);

		// 같다면, 참이야
		if (a == b) {
			return true;
		} else {
			return false;
		}
	}
}
