public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CustomStack s = new CustomStack(5);
        s.addElement(1);
        s.addElement(2);
        s.addElement(3);
        while (!s.stackIsEmpty()) {
            System.out.println(s.lastInStack());
            s.removeElement();
        }
    }
}