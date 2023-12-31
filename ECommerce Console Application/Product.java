import java.util.Scanner;

public abstract class Product {
    private final int id;
    private final String name;
    private double unitPrice;
    private final String manufacturer;

    public Product(int id) {
        Scanner sc = new Scanner(System.in);
        this.id = id;
        System.out.println("Name: ");
        this.name = sc.nextLine();
        System.out.println("Price: ");
        this.unitPrice = sc.nextDouble();
        System.out.println("Manufacturer: ");
        sc.nextLine();
        this.manufacturer = sc.nextLine();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String toString() {
        return "ID: " + id + "\n" + "Name: " + name + "\n" + "Price: " + unitPrice + "\n" + "Manufacturer: "
                + manufacturer + "\n";
    }

    abstract public void description();

    abstract public int getCategory();
}
