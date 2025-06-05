package 演習4.store;

public class LimitedProduct extends AbsProduct {
	int dayCnt;
	public LimitedProduct(String name,int price,int dayCnt) {
		super.AbsProduct(name,price);
		this.dayCnt = dayCnt;
	}
	
	@Override
	public void display() {
		System.out.println(super.getNameAndPrice()+"(残り："+this.dayCnt+"円)");
	}

}
