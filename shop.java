interface Product 
{
    void getProductDetails();
    double getPrice();
    void applyDiscount(double percentage) throws InvalidDiscountException;
}
abstract class Electronics implements Product 
{
    String brand;
    int warranty;
    public Electronics(String brand, int warranty) 
    {
        this.brand = brand;
        this.warranty = warranty;
    }
}
class Mobile extends Electronics 
{
    String model;
    double price;
    public Mobile(String brand, String model, double price, int warranty) 
    {
        super(brand, warranty);
        this.model = model;
        this.price = price;
    }
    @Override
    public void applyDiscount(double percentage) throws InvalidDiscountException 
    {
        applyDiscount(percentage, false); // Default behavior
    }

    public void applyDiscount(double percentage, boolean isSpecialOffer) throws InvalidDiscountException 
    {
        if (percentage > 0 && percentage <= 50) 
	{
            if (isSpecialOffer) 
	    {
                price *= (1 - percentage / 100);
            } else 
 	    {
                throw new InvalidDiscountException("Special offer required for this discount.");
            }
        } 
	else 
	{
            throw new InvalidDiscountException("Discount percentage must be between 0 and 50.");
        }
    }

    @Override
    public void getProductDetails() 
    {
        System.out.println("Mobile: " + brand + " " + model + ", Warranty: " + warranty + " years");
    }

    @Override
    public double getPrice() 
    {
        return price;
    }
}
class Laptop extends Electronics {
    String model;
    double price;
    String batteryLife;
    public Laptop(String brand, String model, double price, int warranty, String batteryLife) 
    {
        super(brand, warranty);
        this.model = model;
        this.price = price;
        this.batteryLife = batteryLife;
    }

    @Override
    public void getProductDetails() 
    {
        System.out.println("Laptop: " + brand + " " + model + ", Warranty: " + warranty + " years, Battery: " + batteryLife);
    }

    @Override
    double getPrice() 
    {
        return price;
    }

    @Override
    public void applyDiscount(double percentage) throws InvalidDiscountException 
    {
        if (percentage > 0 && percentage <= 40) 
	{
            price *= (1 - percentage / 100);
        } 
	else 
	{
            throw new InvalidDiscountException("Discount percentage must be between 0 and 40.");
        }
    }
}
class Clothing implements Product 
{
    String size;
    String material;
    double price;
    public Clothing(String size, String material, double price) 
    {
        this.size = size;
        this.material = material;
        this.price = price;
    }

    @Override
    public void getProductDetails() 
    {
        System.out.println("Clothing: Size " + size + ", Material: " + material);
    }

    @Override
    public double getPrice() 
    {
        return price;
    }

    @Override
    public void applyDiscount(double percentage) throws InvalidDiscountException 
    {
        if (percentage > 0 && percentage <= 60) 
	{
            price *= (1 - percentage / 100);
        } 
	else 
	{
            throw new InvalidDiscountException("Discount percentage must be between 0 and 60.");
        }
    }
}
class OutOfStockException extends Exception 
{
    public OutOfStockException(String message) 
    {
        super(message);
    }
}
class InvalidDiscountException extends Exception 
{
    public InvalidDiscountException(String message) 
    {
        super(message);
    }
}
class ProductTest 
{
    public static void main(String[] args) 
    {
        Product mobile = new Mobile("Samsung", "Galaxy S20", 1000, 2);
        Product laptop = new Laptop("Dell", "XPS 15", 2000, 3, "8 hours");
        Product clothing = new Clothing("M", "Cotton", 50);
        identifyProduct(mobile);
        identifyProduct(laptop);
        identifyProduct(clothing);
        try 
	{
            ((Mobile) mobile).applyDiscount(10);
            mobile.getProductDetails();
            System.out.println("Price after discount: $" + mobile.getPrice());
        } 
	catch (InvalidDiscountException e) 
	{
            System.out.println("Discount error: " + e.getMessage());
        }
    }

    public static void identifyProduct(Product product) 
    {
        if (product instanceof Mobile) 
	{
            System.out.print("Mobile: ");
            product.getProductDetails();
        } 
	else if (product instanceof Laptop) 
	{
            System.out.print("Laptop: ");
            product.getProductDetails();
        } 
	else if (product instanceof Clothing) 
	{
            System.out.print("Clothing: ");
            product.getProductDetails();
        }
    }
}