import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends User {
    private final HashMap<Integer, Integer> cart;
    private final ArrayList<Order> orders;

    public Customer(String username, String password, String firstName, String lastName, String email) {
        super(username, password, firstName, lastName, email);
        cart = new HashMap<Integer, Integer>();
        orders = new ArrayList<Order>();
    }

    public void addToCart(int id, int quantity) {
        cart.put(id, quantity);
    }

    public void removeFromCart(int id) {
        cart.remove(id);
    }

    public void modifyCart(int id, int quantity) {
        if (quantity == 0)
            cart.remove(id);
        else
            cart.put(id, quantity);
    }

    public void clearCart() {
        cart.clear();
    }

    public HashMap<Integer, Integer> getCart() {
        return cart;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int nbPendingOrders() {
        int count = 0;
        for (Order order : orders) {
            if (!order.isDelivered())
                count++;
        }
        return count;
    }

    public void listPendingOrders() {
        for (Order order : orders) {
            if (!order.isDelivered()) {
                System.out.println("--------------------");
                System.out.println(order);
                System.out.println("--------------------");
            }
        }
    }

    public void listDeliveredOrders() {
        for (Order order : orders) {
            if (order.isDelivered()) {
                System.out.println("--------------------");
                System.out.println(order);
                System.out.println("--------------------");
            }
        }
    }

    public Order getOrder(int id) {
        for (Order order : orders) {
            if (order.getId() == id)
                return order;
        }
        return null;
    }
}
