package mn.icode;

interface Taxable {
	double taxRate();
	default double taxAmount(double price) {
		return price * taxRate();
	}
	
	default double priceWithTax(double price) {
		return price + taxAmount(price);
	}
}

interface Discountable {
	double discountRate();
	default double discountAmount(double price) {
		return price * discountRate();
	}
	
	default double priceAfterDiscount(double price) {
		return price - discountAmount(price);
	}
}

class PremiumProduct implements Taxable, Discountable {
	 String name;
	 double basePrice;
	 
	 public PremiumProduct(String name, double basePrice) {
		this.name = name;
		this.basePrice = basePrice;
	}
	 
	@Override
	public double taxRate(){
		return 0.10;
	}
	
	@Override
	public double discountRate() {
		return 0.15;
	}

	double finalPrice() {
		double discounted = priceAfterDiscount(basePrice);
		return discounted + taxAmount(discounted);
	}
	
	void showPricing() {
        double discounted = priceAfterDiscount(basePrice);
        System.out.println("Product:    " + name);
        System.out.printf("Base:       %.0f%n", basePrice);
        System.out.printf("Discount:   -%.0f (%.0f%%)%n",
            discountAmount(basePrice), discountRate() * 100);
        System.out.printf("After disc: %.0f%n", discounted);
        System.out.printf("Tax:        +%.0f (%.0f%%)%n",
            taxAmount(discounted), taxRate() * 100);
        System.out.printf("Final:      %.0f%n", finalPrice());
    }
}
