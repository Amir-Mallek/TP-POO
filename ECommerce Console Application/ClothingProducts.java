import java.util.Scanner;

public class ClothingProducts extends Product {
    private final String size;
    private final String color;
    private final String material;

    public ClothingProducts(int id) {
        super(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Size: ");
        this.size = sc.nextLine();
        System.out.println("Color: ");
        this.color = sc.nextLine();
        System.out.println("Material: ");
        this.material = sc.nextLine();
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    public void description() {
        System.out.println("Product Name: " + getName() + "\n"
                + "Unit Price: " + getUnitPrice() + "\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Size: " + size + "\n"
                + "Color: " + color + "\n"
                + "Material: " + material + "\n");
    }

    public int getCategory() {
        return 2;
    }
}
