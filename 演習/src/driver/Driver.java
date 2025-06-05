package driver;
import store.Product;
import store.SpecialProduct;
public class Driver {
    public static void main(String[] args) {
        Product.display_Store();
        Product[] prod = new Product[] {
            new Product("マウス", 3000),
            new Product("キーボード", 3000),
            new Product("webカメラ", 3000),
            new Product("マイク", 3000),
            new Product("ディスプレイ", 3000),
        };
        for(Product i : prod) {
            i.display();
            
        }
        Product specialProd = new SpecialProduct("特価キーボード",3600,4500);
        specialProd.display();
        specialProd.display();
        System.out.print(specialProd.getName());
    }
}