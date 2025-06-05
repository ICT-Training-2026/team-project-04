package 演習;
import java.util.Scanner;
public class 演習12 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scanner = new Scanner(System.in);
		System.out.println("0~13のうちいずれかを入力してください");
		int score = scanner.nextInt();
		switch(score) {
			case 1:{
				System.out.println("A");
				break;
			}
			case 11:{
				System.out.println("J");
				break;
			}
			case 12:{
				System.out.println("Q");
				break;
			}
			case 13:{
				System.out.println("K");
				break;
			}
			default:{
				if(2 <= score && score<= 11) {
					System.out.println(score);
				}
			}
		}
		
	}

}
