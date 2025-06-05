package 演習2;

public class 演習3 {

	public static void main(String[]args) {
		int[] score = new int[] {3,5,8};
		System.out.print("合計："+total(score));
	}
	public static int total(int[]score){
		int sum = 0;
		for(int i = 0; i < score.length;i++) {
			sum += score[i];
		}
		return sum;
	}

}
