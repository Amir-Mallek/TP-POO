import java.util.Scanner;

public class ElectronicProducts extends Product {
    private final int memory;
    private final int capacity;
    private final double clockSpeed;

    public ElectronicProducts(int id) {
        super(id);
        Scanner sc = new Scanner(System.in);
        System.out.println("Memory: ");
        this.memory = sc.nextInt();
        System.out.println("Capacity: ");
        this.capacity = sc.nextInt();
        System.out.println("Clock Speed: ");
        this.clockSpeed = sc.nextDouble();
    }

    public int getMemory() {
        return memory;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    public void description() {
        System.out.println("Product Name: " + getName() + "\n"
                + "Unit Price: " + getUnitPrice() + "\n"
                + "Manufacturer: " + getManufacturer() + "\n"
                + "Memory: " + memory + "\n"
                + "Capacity: " + capacity + "\n"
                + "Clock Speed: " + clockSpeed + "\n");
    }

    public int getCategory() {
        return 3;
    }
}
