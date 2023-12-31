public class MallardDuck extends ADuck implements IFlyable, IQuackable {
    public void display() { System.out.println("This is a Mallard Duck!"); }
    public void fly() { System.out.println("I fly low.");}
    public void quack() { System.out.println("I love quacking.");}
}
