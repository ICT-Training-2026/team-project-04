package 演習3;

public class Driver {
	public static void main(String[]args) {
		product.display_Store();
		product[]prod = new product[] {
				new product("マウス",3000),
				new product("キーボード",3000),
				new product("webカメラ",3000),
				new product("マイク",3000),
				new product("ディスプレイ",3000),
		};
		for(product i : prod) {
			i.display();
		}
	}
}
