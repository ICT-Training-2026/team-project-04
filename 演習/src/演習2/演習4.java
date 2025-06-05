package 演習2;

public class 演習4 {

	public static void main(String[]args) {
		int[] score = new int[] {3,5,-8,11};
		System.out.println("【結果】");
		absArray(score);
	}
	public static void absArray(int[]src){
		for(int i = 0; i < src.length;i++) {
			System.out.println(Math.abs(src[i]));
		}
	}

}
