public class MallardDuck extends Duck implements Flyable, Quackable {
    public void display() {
        System.out.println("This is a Mallard Duck!");
    }

    public void fly() {
        System.out.println("Mallard Duck flies!");
    }

    public void quack() {
        System.out.println("Mallard Duck quacks!");
    }
}
