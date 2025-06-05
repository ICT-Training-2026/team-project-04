package 演習4.driver;
import 演習4.store.AbsProduct;
import 演習4.store.Deliverable;
import 演習4.store.LimitedProduct;
import 演習4.store.NormalProduct;
import 演習4.store.SpecialProduct;
public class Driver {

	public static void main(String[] args) {
		AbsProduct[] item_list = makeProductList();
		System.out.println("--- 商品リスト ---");
        displayProductList(item_list);
        Deliverable[] deliver_list = getDeliverable(item_list);
        System.out.println("--- 配送可能商品リスト ---");
        displayDelivList(deliver_list);
	}
	
	public static AbsProduct[] makeProductList() {
		AbsProduct[] products = {
		new LimitedProduct("マウス", 2000, 10),
		new SpecialProduct("特化キーボード", 3600, 4500),
		new LimitedProduct("Webカメラ", 3900, 7),
		new NormalProduct("マイク",2800),
		new SpecialProduct("ディスプレイ", 15000, 20000),
		new NormalProduct("LED照明", 4200)};
		return products;
	}
	
	public static void displayProductList(AbsProduct[] absProd) {
		for(AbsProduct product:absProd) {
			product.display();
		}

	}
	
	public static Deliverable[] getDeliverable(AbsProduct[] prod){
		Deliverable[] deliverables = new Deliverable[prod.length];  
		int index = 0;
		for(AbsProduct product:prod) {
			if(product instanceof Deliverable) {
				deliverables[index++] = (Deliverable)product;
			}
		}
		return deliverables;
		
	}
	
	public static void displayDelivList(Deliverable[] deliv){
		for(int i = 0; i < deliv.length;i++) {
			if(deliv[i] == null)
				break;
			deliv[i].displayDeliv();
		}
	}

}
