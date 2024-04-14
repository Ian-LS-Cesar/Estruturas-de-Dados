import collections.StaticStack;
import collections.DynamicStack;

public class App {
    public static void main(String[] args) throws Exception {
        DynamicStack<Integer> stack = new DynamicStack<>(9);
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(9);
        stack.push(15);
        stack.pop();
        System.out.println(stack);
    }
}
