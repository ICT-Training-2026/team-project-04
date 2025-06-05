package store;

public class Product {
    private String name;
    private int price;
    private static String STORE_NAME = "速水PC販売店";
    private int DEFAULT_CHANGE_AMT = 1000;

    // コンストラクタの修正
    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public Product(String name){
        this(name, 0);
    }
    
    public int getPrice() {
    	return price;
    }
    
    public void setPrice(int price) {
    	this.price = price;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    public void up(int amt){
        this.price += amt;
    }
    
    public void up(){
    	up(DEFAULT_CHANGE_AMT);
    }
    
    void down(int amt){
        this.price -= amt;
    }
    
    void down(){
        down(DEFAULT_CHANGE_AMT);
    }
    
    public void display() {
        System.out.println(this.name + "：" + this.price);
    }

    public static void display_Store() {
        System.out.println("店舗名：" + STORE_NAME);
    }
}