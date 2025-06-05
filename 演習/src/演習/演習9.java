package 演習;

import java.util.Scanner;

public class 演習9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[]subName = new String[]{"A教科","B教科"};
		int[]subScore = new int[2];
		subScore[0] = scanner.nextInt();
		subScore[1] = scanner.nextInt();
		for(int i = 0; i < subName.length; i++) {
			System.out.println(subName[i]+":"+subScore[i]+"点");
		}

	}

}
