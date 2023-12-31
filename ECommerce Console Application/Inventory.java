import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private final HashMap<Integer, Product> allProducts;
    private final HashMap<Integer, Integer> quantities;
    private final HashMap<Integer, String> status;

    public Inventory() {
        allProducts = new HashMap<Integer, Product>();
        quantities = new HashMap<Integer, Integer>();
        status = new HashMap<Integer, String>();
    }
    public Product getProduct(int id) throws ProductNotFoundException {
        if (!allProducts.containsKey(id))
            throw new ProductNotFoundException("Product not found");
        return allProducts.get(id);
    }

    public int getQuantity(int id) {
        return quantities.get(id);
    }

    public int getNewId() {
        return allProducts.size() + 1;
    }

    private void updateStatus(int id, int quantity) {
        if (quantity < 10)
            status.put(id, "Critically Low");
        else if (quantity < 30)
            status.put(id, "Low");
        else
            status.remove(id);
    }

    public void addProduct(Product product, int quantity) {
        allProducts.put(product.getId(), product);
        quantities.put(product.getId(), quantity);
        updateStatus(product.getId(), quantity);
    }

    public void updateProduct(int id, int quantityUpdate) {
        quantities.computeIfPresent(id, (k, v) -> v + quantityUpdate);
        updateStatus(id, quantities.get(id));
    }

    public HashMap<Integer, String> getStatus() {
        return status;
    }

    public void viewInventory() {
        if (allProducts.isEmpty()) {
            System.out.println("Inventory is Empty");
        }
        for (Integer id : allProducts.keySet()) {
            System.out.println("----------------");
            System.out.println(allProducts.get(id) + "Quantity: " + quantities.get(id));
            System.out.println("----------------");
        }
    }

    public ArrayList<Integer> getIds() {
        return new ArrayList<Integer>(allProducts.keySet());
    }

    private void printProducts(ArrayList<Integer> ids) {
        if (ids.isEmpty()) {
            System.out.println("No results found");
            return;
        }
        System.out.println("--------Search Results--------");
        for (Integer id : ids) {
            System.out.println("----------------");
            System.out.println(allProducts.get(id) + "Quantity: " + quantities.get(id));
            System.out.println("----------------");
        }
    }

    public ArrayList<Integer> search(String query) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (Integer id : allProducts.keySet()) {
            Product product = allProducts.get(id);
            if (product.getName().toLowerCase().contains(query.toLowerCase()))
                ids.add(id);
        }
        printProducts(ids);
        return ids;
    }

    public ArrayList<Integer> search(double min, double max, int category) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (Integer id : allProducts.keySet()) {
            Product product = allProducts.get(id);
            if (product.getUnitPrice() >= min && product.getUnitPrice() <= max
                    && (category == 0 || product.getCategory() == category)) {
                ids.add(id);
            }
        }
        printProducts(ids);
        return ids;
    }

    boolean checkQuantity(int id, int quantity) {
        return quantities.get(id) >= quantity;
    }
}
