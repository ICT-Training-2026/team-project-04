package 演習;
import java.util.Scanner;
public class 演習15 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		System.out.println("入力した数値を足し続けます");
		String score = "";
		int sum_score = 0;
		do {
			score = scanner.nextLine();
			if(score.equals("exit")) {
				break;
			}
			if(NumCheck(score)) {
				sum_score += Integer.parseInt(score);
			}
		}while(true);
		System.out.println(sum_score);
	}
	
	public static boolean NumCheck(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e) {
			return false; 
		}
	}
}
