package 演習4.store;

public class NormalProduct extends AbsProduct implements Deliverable {
	public NormalProduct(String name,int price) {
		super.AbsProduct(name,price);
	}

	@Override
	public void display() {
		System.out.println(super.getNameAndPrice());
	}

	public void displayDeliv() {
		System.out.println("[通常送料500円]"+super.getNameAndPrice());
	}
}
