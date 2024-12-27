package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date manufacturedDate;

    public UsedProduct() {
    }

    public UsedProduct(String productName, Double price, Date manufacturedDate) {
        super(productName, price);
        this.manufacturedDate = manufacturedDate;
    }

    public Date getManufacturedDate() {
        return manufacturedDate;
    }
    public void setManufacturedDate(Date manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    @Override
    public String priceTag() {
        return
                getProductName() + " (used) $"
                        + String.format("%.2f", getPrice())
                        + "( Manufactured date: " + sdf.format(manufacturedDate)
                ;
    }
}
