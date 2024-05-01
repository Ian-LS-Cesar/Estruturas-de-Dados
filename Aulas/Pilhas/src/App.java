import collections.DynamicStack;
import collections.StaticStack;

public class App {
    public static void main(String[] args) throws Exception {
        DynamicStack<Integer> stack = new DynamicStack<>();

        stack.push(7);
        stack.push(9);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.pop();
        System.out.println(stack);
    }
}
