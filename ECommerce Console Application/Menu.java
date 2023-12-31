import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private final ArrayList<User> users;
    private final Inventory inventory;
    private final ArrayList<Order> orders;

    public Menu() {
        users = new ArrayList<User>();
        orders = new ArrayList<Order>();
        inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        String firstName, lastName, email, phone;
        System.out.println("-----------Primary Admin-----------");
        System.out.println("Your first name: ");
        firstName = sc.nextLine();
        System.out.println("Your last name: ");
        lastName = sc.nextLine();
        System.out.println("Your email: ");
        email = sc.nextLine();
        System.out.println("Your phone number: ");
        phone = sc.nextLine();
        users.add(new Admin("admin", "admin", firstName, lastName, email, phone));
        System.out.println("Welcome admin!");
        System.out.println("These are the default admin account credentials:");
        System.out.println("Username: admin");
        System.out.println("Password: admin");
        System.out.println("Please change the password after logging in.");
    }

    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    private void updateUsername(User user) {
        Scanner sc = new Scanner(System.in);
        String username;
        System.out.println("Enter your new username: ");
        username = sc.nextLine();
        if (findUser(username) != null) {
            System.out.println("Username already exists.");
            return;
        }
        user.setUsername(username);
        System.out.println("Your username has been changed successfully!");
    }

    private void updatePassword(User user) {
        Scanner sc = new Scanner(System.in);
        String password;
        System.out.println("Enter your old password: ");
        password = sc.nextLine();
        if (!user.verifyPassword(password)) {
            System.out.println("Your old password is incorrect.");
            return;
        }
        System.out.println("Enter your new password: ");
        password = sc.nextLine();
        user.setPassword(password);
        System.out.println("Your password has been changed successfully!");
    }

    private void profile(User user) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------Profile-----------");
            System.out.println("Username: " + user.getUsername());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("-----------Options-----------");
            System.out.println("1 --> Update Username");
            System.out.println("2 --> Update Password");
            System.out.println("3 --> Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    updateUsername(user);
                    break;
                case 2:
                    updatePassword(user);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void register() {
        Scanner sc = new Scanner(System.in);
        String username, password, firstName, lastName, email, phone, address, choice;
        System.out.println("-----------Register-----------");
        System.out.println("Enter your Username: ");
        username = sc.nextLine();
        while (findUser(username) != null) {
            System.out.println("Username already exists. Please enter another username: ");
            username = sc.nextLine();
        }
        System.out.println("Enter your Password: ");
        password = sc.nextLine();
        System.out.println("Enter your First Name: ");
        firstName = sc.nextLine();
        System.out.println("Enter your Last Name: ");
        lastName = sc.nextLine();
        System.out.println("Enter your Email: ");
        email = sc.nextLine();
        Customer newCustomer = new Customer(username, password, firstName, lastName, email);
        users.add(newCustomer);
        System.out.println("You have successfully registered!");
    }

    private void login() {
        Scanner sc = new Scanner(System.in);
        String username, password;
        while (true) {
            System.out.println("-----------Login/Register-----------");
            System.out.println("1 --> Login");
            System.out.println("2 --> Register");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("-----------Login-----------");
                    System.out.println("Enter your Username: ");
                    sc.nextLine();
                    username = sc.nextLine();
                    System.out.println("Enter your Password: ");
                    password = sc.nextLine();
                    User user = findUser(username);
                    if (user == null || !user.verifyPassword(password)) {
                        System.out.println("Your Password or Username is incorrect. Please try again.");
                        continue;
                    }
                    System.out.println("You have successfully logged in!");
                    if (user instanceof Admin) adminMenu((Admin)user);
                    else {
                        customerMenu((Customer)user);
                    }
                    return;
                case 2:
                    register();
                    continue;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("------Welcome to our application------");
            login();
        }
    }

    private void alert() {
        System.out.println("-----------Alerts-----------");
        HashMap<Integer, String> status = inventory.getStatus();
        if (status.isEmpty()) {
            System.out.println("No alerts.");
            return;
        }
        for (Integer id : status.keySet()) {
            try {
                System.out.println("Status: " + status.get(id));
                System.out.println(inventory.getProduct(id));
                System.out.println("Available Quantity: " + inventory.getQuantity(id));
                System.out.println("--------------------");
            } catch (ProductNotFoundException e) {
                System.out.println("Product not found");
            }
        }
    }

    private int nbPendingOrders() {
        int count = 0;
        for (Order order : orders) {
            if (!order.isDelivered())
                count++;
        }
        return count;
    }

    private void listPendingOrders() {
        for (Order order : orders) {
            if (!order.isDelivered()) {
                System.out.println("--------------------");
                System.out.println(order);
                System.out.println("--------------------");
            }
        }
    }

    private void addNewProduct() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("------Adding a new Product------");
            System.out.println("Select category: ");
            System.out.println("1 --> Food Product");
            System.out.println("2 --> Clothing Product");
            System.out.println("3 --> Electronic Product");
            System.out.println("4 --> Quit");
            int choice = sc.nextInt();
            if (choice == 4) return;
            int id, quantity;
            id = inventory.getNewId();
            System.out.println("Product ID: " + id);
            System.out.println("Quantity: ");
            quantity = sc.nextInt();
            switch (choice) {
                case 1:
                    inventory.addProduct(new FoodProducts(id), quantity);
                    break;
                case 2:
                    inventory.addProduct(new ClothingProducts(id), quantity);
                    break;
                case 3:
                    inventory.addProduct(new ElectronicProducts(id), quantity);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println("Product added successfully!");
        }
    }

    private void updateProduct() {
        Scanner sc = new Scanner(System.in);
        int id, update;
        System.out.println("------Updating Product------");
        while (true) {
            System.out.println("Product ID: ");
            id = sc.nextInt();
            try {
                inventory.getProduct(id);
                break;
            } catch (ProductNotFoundException e) {
                System.out.println("Product not found");
            }
        }
        System.out.println("Quantity Update: ");
        update = sc.nextInt();
        inventory.updateProduct(id, update);
        System.out.println("Product updated successfully!");
    }

    private void reviewInventory() {
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------Inventory-----------");
            System.out.println("1 --> View Inventory");
            System.out.println("2 --> Add New Product");
            System.out.println("3 --> Update Product");
            System.out.println("4 --> Quit Inventory");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    inventory.viewInventory();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void adminMenu(Admin admin) {
        System.out.println("Welcome " + admin.getFirstName() + " " + admin.getLastName() + "!");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------Admin Menu-----------");
            System.out.println("1 --> Inventory");
            System.out.println("2 --> Alerts (" + inventory.getStatus().size() + ")");
            System.out.println("3 --> Profile");
            System.out.println("4 --> Pending Orders (" + nbPendingOrders() + ")");
            System.out.println("5 --> Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    reviewInventory();
                    break;
                case 2:
                    alert();
                    break;
                case 3:
                    profile(admin);
                    break;
                case 4:
                    listPendingOrders();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
            }
        }
    }

    private double getTotalPrice(Customer customer) {
        HashMap<Integer, Integer> cart = customer.getCart();
        double totalPrice = 0;
        for (Integer id : cart.keySet()) {
            try {
                Product product = inventory.getProduct(id);
                totalPrice += product.getUnitPrice() * cart.get(id);
            } catch (ProductNotFoundException e) {
                System.out.println("Product not found");
            }
        }
        return totalPrice;
    }

    private void viewCart(Customer customer) {
        HashMap<Integer, Integer> cart = customer.getCart();
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        for (Integer id : cart.keySet()) {
            try {
                Product product = inventory.getProduct(id);
                System.out.println("--------------------");
                System.out.println("Product ID: " + product.getId());
                product.description();
                System.out.println("Quantity: " + cart.get(id));
                System.out.println("Price: " + product.getUnitPrice() * cart.get(id));
                System.out.println("--------------------");
            } catch (ProductNotFoundException e) {
                System.out.println("Product not found");
            }
        }
        System.out.println("Total Price: " + getTotalPrice(customer));
        System.out.println("--------------------");
    }

    private void editCart(Customer customer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Edit Cart-----------");
        System.out.println("1 --> Remove from Cart");
        System.out.println("2 --> Modify item in Cart");
        System.out.println("3 --> Quit");
        int choice = sc.nextInt();
        if (choice == 3) return;
        int id, quantity;
        while (true) {
            System.out.println("Product ID: ");
            id = sc.nextInt();
            if (customer.getCart().containsKey(id)) break;
            System.out.println("Product not found in cart.");
        }
        switch (choice) {
            case 1:
                customer.removeFromCart(id);
                System.out.println("Item removed successfully!");
                break;
            case 2:
                while (true) {
                    System.out.println("New Quantity: ");
                    quantity = sc.nextInt();
                    if (inventory.checkQuantity(id, quantity)) break;
                    System.out.println("Quantity exceeds inventory.");
                    System.out.println("Available Quantity: " + inventory.getQuantity(id));
                }
                customer.modifyCart(id, quantity);
                break;
        }
    }

    private boolean payment(double totalPrice) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Payment-----------");
        System.out.println("Enter your card number: ");
        String cardNumber = sc.nextLine();
        System.out.println("Enter your cvv: ");
        String cvv = sc.nextLine();
        System.out.println("Enter your expiry date: ");
        String expiryDate = sc.nextLine();
        System.out.println("Enter your balance: ");
        double balance = sc.nextDouble();
        System.out.println("Amount to be paid: " + totalPrice);
        if (balance < totalPrice) {
            System.out.println("Insufficient balance.");
            return false;
        }
        System.out.println("Payment successful!");
        return true;
    }

    private void placeOrder(Customer customer) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Place Order-----------");
        System.out.println("Enter your address: ");
        String address = sc.nextLine();
        System.out.println("Enter due date: ");
        String dueDate = sc.nextLine();
        Order order = new Order(orders.size(), customer.getUsername(), address, dueDate);
        HashMap<Integer, Integer> cart = customer.getCart();
        for (Integer id : cart.keySet()) {
            try {
                Product product = inventory.getProduct(id);
                order.addProduct(product, cart.get(id));
            } catch (ProductNotFoundException e) {
                System.out.println("Product not found");
            }
        }
        double totalPrice = getTotalPrice(customer);
        orders.add(order);
        if (payment(totalPrice)) {
            System.out.println("Order placed successfully!");
            for (Integer id : cart.keySet()) {
                inventory.updateProduct(id, -cart.get(id));
            }
            customer.clearCart();
            customer.addOrder(order);
        } else {
            System.out.println("Order cancelled.");
        }
    }

    private void shoppingCart(Customer customer) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------Shopping Cart-----------");
            System.out.println("1 --> View Cart");
            System.out.println("2 --> Edit Cart");
            System.out.println("3 --> Place Order");
            System.out.println("4 --> Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewCart(customer);
                    break;
                case 2:
                    editCart(customer);
                    break;
                case 3:
                    placeOrder(customer);
                    break;
                case 4:
                    return;
            }
        }
    }

    private void reviewOrders(Customer customer) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-------Orders-------");
            System.out.println("1 --> Pending Orders (" + customer.nbPendingOrders() + ")");
            System.out.println("2 --> Delivered Orders");
            System.out.println("3 --> Confirm Delivery");
            System.out.println("4 --> Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    customer.listPendingOrders();
                    break;
                case 2:
                    customer.listDeliveredOrders();
                    break;
                case 3:
                    int id;
                    while (true) {
                        System.out.println("Order ID: ");
                        id = sc.nextInt();
                        if (customer.getOrder(id) != null && !customer.getOrder(id).isDelivered()) break;
                        System.out.println("Pending Order not found.");
                    }
                    customer.getOrder(id).setStatus();
                    break;
                case 4:
                    return;
            }
        }
    }

    private ArrayList<Integer> filter() {
        Scanner sc = new Scanner(System.in);
        double minPrice = 0, maxPrice = 999999999;
        int category = 0;
        while (true) {
            System.out.println("-----------Filter-----------");
            System.out.println("1 --> Price Range");
            System.out.println("2 --> Category");
            System.out.println("3 --> Clear Filter");
            System.out.println("4 --> Confirm and Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter minimum price: ");
                    minPrice = sc.nextDouble();
                    System.out.println("Enter maximum price: ");
                    maxPrice = sc.nextDouble();
                    break;
                case 2:
                    System.out.println("Select category: ");
                    System.out.println("1 --> Food Product");
                    System.out.println("2 --> Clothing Product");
                    System.out.println("3 --> Electronic Product");
                    category = sc.nextInt();
                    break;
                case 3:
                    minPrice = 0;
                    maxPrice = 999999999;
                    category = 0;
                    break;
                case 4:
                    return inventory.search(minPrice, maxPrice, category);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void viewProductDetails(int id, Customer customer) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------Product Details-----------");
            try {
                inventory.getProduct(id).description();
            } catch (ProductNotFoundException e) {
                System.out.println("Product not found");
            }
            System.out.println("Available Quantity: " + inventory.getQuantity(id));
            System.out.println("-----------Options-----------");
            System.out.println("1 --> Add to Cart");
            System.out.println("2 --> Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int quantity;
                    if (inventory.getQuantity(id) == 0) {
                        System.out.println("Product out of stock.");
                        break;
                    }
                    while (true) {
                        System.out.println("Enter quantity: ");
                        quantity = sc.nextInt();
                        if (inventory.checkQuantity(id, quantity)) {
                            customer.addToCart(id, quantity);
                            break;
                        }
                        System.out.println("Quantity exceeds inventory.");
                        System.out.println("Available Quantity: " + inventory.getQuantity(id));
                    }
                    customer.addToCart(id, quantity);
                    System.out.println("Item added to cart successfully!");
                    return;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void search(Customer customer) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------Search Products-----------");
            System.out.println("1 --> View All Products");
            System.out.println("2 --> Search");
            System.out.println("3 --> Filter Search");
            System.out.println("4 --> View Product Details");
            System.out.println("5 --> Quit");
            int choice = sc.nextInt();
            ArrayList<Integer> ids;
            switch (choice) {
                case 1:
                    inventory.viewInventory();
                    ids = inventory.getIds();
                    break;
                case 2:
                    System.out.println("Enter your query: ");
                    sc.nextLine();
                    String query = sc.nextLine();
                    ids = inventory.search(query);
                    break;
                case 3:
                    ids = filter();
                    break;
                case 4:
                    System.out.println("Type Product ID to view: ");
                    int id = sc.nextInt();
                    try {
                        inventory.getProduct(id);
                        viewProductDetails(id, customer);
                    } catch (ProductNotFoundException e) {
                        System.out.println("Product not found");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void customerMenu(Customer customer) {
        System.out.println("Welcome " + customer.getFirstName() + " " + customer.getLastName() + "!");
        customer.getCart().put(1, 1);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-----------Customer Menu-----------");
            System.out.println("1 --> Search Products");
            System.out.println("2 --> Shopping Cart");
            System.out.println("3 --> Review Orders");
            System.out.println("4 --> Profile");
            System.out.println("5 --> Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    search(customer);
                    break;
                case 2:
                    shoppingCart(customer);
                    break;
                case 3:
                    reviewOrders(customer);
                    break;
                case 4:
                    profile(customer);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
