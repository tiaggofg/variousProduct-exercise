package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date manufactureDate;
	
	public UsedProduct() {
		super();
	}
	
	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	public Date getManufactureDate() {
		return manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return super.getName() + " (USED) $" + String.format("%.2f", super.getPrice()) + " (Manufacture date: " + dateFormat.format(getManufactureDate()) + ")";
	}
}
