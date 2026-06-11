package mn.icode;

public class Product implements Comparable<Product> {
	String productName;
	double price;
	
	public Product(String productName, double price) {
		this.productName = productName;
		this.price = price;
	}
	
	@Override
	public int compareTo(Product other) {
		if(this.price > other.price) return -1;
		if(this.price < other.price) return 1;
		return 0;
	}
	
	@Override
	public String toString() {
		return productName + " (" + price + ") ";
	}
}