import java.util.HashMap;

public class Order {
    private final int id;
    private final String username;
    private final String address;
    private final String dueDate;
    private final HashMap<Product, Integer> products;
    private boolean status;

    public Order(int id, String username, String address, String dueDate) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.dueDate = dueDate;
        this.products = new HashMap<Product, Integer>();
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public boolean isDelivered() {
        return status;
    }

    public void setStatus() {
        this.status = true;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public String toString() {
        String result = "Order ID: " + id + "\n";
        result += "Username: " + username + "\n";
        result += "Address: " + address + "\n";
        result += "Due Date: " + dueDate + "\n";
        result += "Products: \n";
        for (Product product : products.keySet()) {
            System.out.println("----------------");
            result += product + "Quantity: " + products.get(product) + "\n";
            System.out.println("----------------");
        }
        return result;
    }
}
