package Day260804.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호 {
	static int[] checkArr;
	static int[] myArr;
	static int check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		// 받아 올 것 세팅
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		// 기본 적으로 담아야 할 것 세팅
		int Result = 0;
		char[] A = new char[S]; // S크기 만큼 담을 A배열 생성
		checkArr = new int[4]; // 몇 개인지 담을 배열 ACGT
		myArr = new int[4]; // 실제로 내 로직에서 checkArr과 맞나 비교 or ++ -- 할 것
		check = 0; // 맞아서 결국엔 result++해야 할 것 처리
		
		// A받아오기
		A = br.readLine().toCharArray(); // 받아온 것 Char배열로 각각 저장
		
		// 읽어오기 ACGT 숫자 4개
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			
			if (checkArr[i] == 0) { // 0이 들어온 거면 그냥 ++ 해라 조건 있든 없든 상관없이 check++
				check++;
			}
		}
		
		//처음 슬라이딩 구현 및 check가 4라면 Result++
		for (int i=0; i<P; i++) {
			Add(A[i]);
		}
		if (check == 4) {
			Result++;
		}
		
		// 슬라이딩 윈도우 구현 밀자
		for (int i=P; i< S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			
			if (check == 4) {
				Result++;
			}
		}
		
		System.out.println(Result);
		br.close();
		
	} // main 끝

	private static void Add (char c) {
		switch(c) {
		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0]) {
				check++;
			}
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1]) {
				check++;
			}
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2]) {
				check++;
			}
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3]) {
				check++;
			}
			break;
		}
	}
	
	private static void Remove (char c) {
		switch(c) {
		case 'A':
			if(myArr[0] == checkArr[0]) {
				check--;
			}
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) {
				check--;
			}
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) {
				check--;
			}
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) {
				check--;
			}
			myArr[3]--;
			break;
		}
	}
	

}
