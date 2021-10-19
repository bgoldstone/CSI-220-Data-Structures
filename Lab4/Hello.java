public class Hello {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(10);
        stack.push("Hello");
        stack.push("Hello");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
