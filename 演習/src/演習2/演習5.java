package 演習2;

public class 演習5 {

	public static void main(String[]args) {
		int sum = 0;
		for(int i=0;i<args.length;i++) {
			sum += Integer.parseInt(args[i]);
		}
		System.out.println("合計は" + sum);
	}
}
