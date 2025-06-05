package 演習2;
import java.util.Scanner;
public class 演習2 {
	public static void main(String[]args) {
		int a = inputInt();
		int b = inputInt();
		displayDelimiter();
		displayAddResult(a,b);
		displayDelimiter();
	}
	public static int inputInt(){	
		System.out.print("整数を入力してください");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		return a;
	}
	public static void displayDelimiter(){	
		System.out.println("--------");
	}
	public static void displayAddResult(int a,int b){	
		
		System.out.println("数値1："+a+"\n数値2："+b+"\n---------"+"\n合計："+(a+b));
	}
}
