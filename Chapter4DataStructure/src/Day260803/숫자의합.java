package Day260803;
import java.util.Scanner;

public class 숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String sNum = sc.next();

		char[] cNum = sNum.toCharArray();
		int sum = 0;

		for (int i = 0; i < cNum.length; i++) {
			sum += cNum[i] - '0'; // 문자유형 마이너스 48해주기
		}
		System.out.println(sum);

	}

}
