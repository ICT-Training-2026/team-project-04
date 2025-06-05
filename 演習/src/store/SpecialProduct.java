package store;

public class SpecialProduct extends Product {
	private int OrgPrice;
	public SpecialProduct(String name,int price,int orgPrice) {
		super(name,price);
		this.OrgPrice = orgPrice;
		// TODO 自動生成されたコンストラクター・スタブ
	}

	
	public int getOrgPrice(){
		return this.OrgPrice;
	}
	
	public void OrgPrice(int OrgPrice) {
		this.OrgPrice = OrgPrice;
	}
	
	public void displayOrgPrice() {
		System.out.println(OrgPrice);
	}
	
	public void display() {
		super.display();
		System.out.println(super.getName()+"："+super.getPrice()+"円　定価："+OrgPrice);
	}
}
