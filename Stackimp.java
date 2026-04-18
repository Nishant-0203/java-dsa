import java.util.ArrayList;

public class Stackimp {
    private ArrayList<Integer> list;

    public Stackimp() {
        list = new ArrayList<>();
    }

    public void push(int data) {
        list.add(data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return list.remove(list.size() - 1);
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Stackimp stack = new Stackimp();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Current size: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
