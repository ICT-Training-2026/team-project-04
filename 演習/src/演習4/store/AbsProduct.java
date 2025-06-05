package 演習4.store;

public abstract class AbsProduct {
	String name;
	int price;
	protected void AbsProduct(String name,int price) {
		this.name = name;
		this.price = price;
	}
	public abstract void display();
	
	protected String getNameAndPrice() {
		return(this.name+"："+this.price+"円");
	}
}
