package 演習;

import java.util.Scanner;

public class 演習11 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		String grade = "";
		String isTutoringRequired = "なし";
		score = scanner.nextInt();
		
		if(score >= 80) {
			grade = "A";
		}
		else if(score >= 60) {
			grade = "B";
		}
		else if(score >= 60) {
			grade = "C";
			System.out.print("補習しますか？");
			isTutoringRequired = scanner.nextLine();
		}
		System.out.println("結果 ： " + grade + "評価");
		System.out.println("補習 ： " + isTutoringRequired);
	}

}
