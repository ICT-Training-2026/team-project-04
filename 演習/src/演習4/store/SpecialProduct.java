package 演習4.store;

public class SpecialProduct extends AbsProduct implements Deliverable{
	int orgPrice;
	public SpecialProduct(String name,int price,int orgPrice) {
		super.AbsProduct(name,price);
		this.orgPrice = orgPrice;
	}
	
	@Override
	public void display() {
		System.out.println(super.getNameAndPrice()+"円 (定価："+this.orgPrice+"円)");
	}
	
	@Override
	public void displayDeliv() {
		System.out.println("[*通常送料300円*]"+super.getNameAndPrice());
	}
}
