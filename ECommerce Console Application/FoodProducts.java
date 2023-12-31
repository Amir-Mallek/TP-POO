import java.util.Scanner;

public class FoodProducts extends Product {
    private final String expirationDate;
    private final double weight;
    private final double calories;

    public FoodProducts(int id) {
        super(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Expiration Date: ");
        this.expirationDate = sc.nextLine();
        System.out.println("Weight: ");
        this.weight = sc.nextDouble();
        System.out.println("Calories: ");
        this.calories = sc.nextDouble();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public double getWeight() {
        return weight;
    }

    public double getCalories() {
        return calories;
    }

    public void description() {
        System.out.println("Product Name: " + getName() + "\n"
                + "Unit Price: " + getUnitPrice() + "\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Expiration Date: " + expirationDate + "\n"
                + "Weight: " + weight + "\n"
                + "Calories: " + calories + "\n");
    }

    public int getCategory() {
        return 1;
    }
}
