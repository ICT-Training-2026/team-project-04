package 演習3;

public class product{
	String name;
	int price;
	static int count = 0;
	static String STORE_NAME = "速水PC販売店";
	
	public product(String name,int price){
		this.name = name;
		this.price = price;
		count++;
	}
	
	public product(String name){
		this(name,0);
	}
	
	
	void up(int amt){
		this.price+=amt;
	}
	
	void down(int amt){
		this.price-=amt;
	}
		
	void display() {
		System.out.println(this.name+"："+this.price);
	}
	
	static void display_Store() {
		System.out.println("店舗名："+STORE_NAME);
	}
	
	static void display_counts() {
		System.out.println(count);
	}
}
