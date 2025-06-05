package 演習;

public class 演習18 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String[]productName=new String[]{"ボールペン","ノート","付箋","テープ","ホチキス"};
		String[]storeName=new String[]{"A店舗","B店舗","C店舗"};
		int[][]price=new int[][] {{90, 80, 98, 95, 87},
								{110, 120, 130, 140, 150},
								{210, 220, 230, 240, 250}};
		System.out.println("------------");
		for(int i = 0;i<(price.length);i++) {
			System.out.println("【"+storeName[i]+"】");
			for(int j = 0;j<(price[i].length);j++) {
				System.out.println(productName[j]+":"+price[i][j]+"円");
			}
			System.out.println("------------");
		}
	}
}
