package 演習;

import java.util.Scanner;

public class 演習14 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		int minscore = 0;
		int maxscore = 0;
		int count = 0;
		System.out.println("3つずつ増やして表示します");
		System.out.print("最小値：");
		minscore = scanner.nextInt();
		System.out.print("最大値：");
		maxscore = scanner.nextInt();
		for(int i = minscore; i < maxscore; i+=3) {
			System.out.println(i);
			count++;
		}
		System.out.println("回数："+count);
		
	}

}
