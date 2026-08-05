package Day260805.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_복습 {
	static int[] checkArr; // 숫자 4개 담고 체크할 것 -> 알파벳 제대로 들어왔는지 검증
	static int[] myArr; // 숫자 4개 담고 -> 지금 들어온 알파벳 체크
	static int checkCount; // myArr에서 들어온 것 몇 개인지 담는 int
	
		
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//받아온 것 2개
		int totalLen = Integer.parseInt(st.nextToken()); // DNA문자열 길이
		int partLen = Integer.parseInt(st.nextToken()); // 부분 문자열길이
		
		// 담을 것 관련
		int result = 0;
		checkArr = new int[4];
		myArr = new int[4];
		checkCount = 0;
		
		// DNA문자열 담아서 char 배열로 처리
		char[] A = new char[totalLen];
		A = br.readLine().toCharArray();
		
		// checkArr 세팅: 몇인지 읽어오기
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			
			if (checkArr[i] == 0) {
				checkCount++;
			}
			
		}
		
		// myArr세팅: 처음 슬라이딩 구현부분문자열 만큼 담고 어차피 0이라면 그냥 더해주자 예외처리
		for (int i = 0; i < partLen; i++) {
			add(A[i]);
		}
		if (checkCount == 4) {
			result++;
		}
		
		// 슬라이딩 섹션 0~3했으니까 다음인 Add는4 부터 Remove는 1
		for (int i = partLen; i < totalLen; i++) {
			//remove 담을 변수
			int j = i - partLen;
			
			add(A[i]);
			remove(A[j]);
			
			if(checkCount == 4) {
				result++;
			}
			
		}
		System.out.println(result);
		br.close();
		
	} // main 끝
	private static void add(char c) {
		switch(c) {
		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0]) {
				checkCount++;
			}
		break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1]) {
				checkCount++;
			}
		break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2]) {
				checkCount++;
			}
		break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3]) {
				checkCount++;
			}
		break;
		}

	} // add 끝
	
	private static void remove (char c) {
		switch(c) {
		case 'A':
			if (myArr[0] == checkArr[0]) {
				checkCount--;
			}
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1]) {
				checkCount--;
			}
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2]) {
				checkCount--;
			}
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3]) {
				checkCount--;
			}
			myArr[3]--;
			break;
		}
	}

}
