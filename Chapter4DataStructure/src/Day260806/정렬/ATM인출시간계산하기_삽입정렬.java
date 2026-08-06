package Day260806.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM인출시간계산하기_삽입정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 받는 개수 n
		
		// 삽입 배열, 돌아서 합배열 2개 선언
		int[] a = new int[n];
		int[] s= new int[n];
		
		// 삽입 배열 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		// 삽입배열 for (i ~ n만큼)
		// 1. 삽입할 위치, 현재 값 선언. insertPoint, insertValue
		// 2. 원소값 비교하며 삽입 위치 찾기 for(j: i - 1 ~ 0까지)
			// 2-1. 삽입할 위치 찾아서 저장(inserPoint) 현재값 > 돌고있는 값 ->그 인덱스 저장 다음 걸로 pass, 현재 돌고있는 인덱스가 0이라면 끝까지 for문 다 돌았네? poitn 0 해,
		// 3. 한 칸씩 뒤로 밀기 for(j: insertPoint(삽입할 인덱스) ~ i - 1(지금 돌고있는 i인덱스까지 밀어))
		// ex) 21 63 42 24 -> 21. 63 42 뒤로 밀리고, insertPoint에 insertValue 삽입
		// 4. 정렬된 걸 합배열 만들어야돼 우리 위에 a,s 만들었지 -> for(i=0; i< a.length;) s[i] = s[i-1] + a[i]
			// 4-1. a[0] = s[0]
		// 5. 출력 for(Syso 누적시간)
		
		for (int i = 0; i < n; i++) {
			int insertPoint = i; // 현재 돌고있는 인덱스
			int insertValue = a[i]; // 현재 넣을 원소값
			
			// 넣을 point 찾고 저장
			for (int j = i - 1; j >=0; j--) {
				if (a[i] > a[j]) {
					insertPoint = j + 1;
					break;
				}
				if (j == 0) { // 못 찾음 그럼 너가 0이야
					insertPoint = 0;
				}
			}
			
			// 밀기
			for (int j = i - 1; j >= insertPoint; j--) {
				a[j + 1] = a[j];
			}
			
			//넣을 포인트에 value넣기
			a[insertPoint] = insertValue;
		}
		// 합배열 만들기 초기화
		s[0] = a[0];
		
		// s에 각 값 저장
		for (int i = 1; i < n; i++) {
			s[i] = s[i-1] + a[i];
		}
		
		// 그리고 합배열 출력
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += s[i];
		}
		System.out.println(sum);
	}
}
