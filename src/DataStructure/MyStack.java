package DataStructure;

interface IsStack {
    public boolean push(int value);

    public int pop();

    public int peek();

    public int size();

    public boolean isEmpty();

}

public class MyStack implements IsStack {
    // Nơi lưu trữ dữ liệu (Array / LinkedList)
    private int[] stack;
    // Top là con trỏ trỏ đến phần tử đầu của Stack
    private int top;
    private int size;

    // Constructor
    public MyStack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    @Override
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        } else {
            top++;
            stack[top] = value;
            return true;
        }
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int value = stack[top];
            top--;
            return value;
        }
        
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int tvalue = stack[top];
            System.out.println("Top value is " + tvalue);
            return tvalue;
        }
    }

    @Override
    public int size() {
        int elements = top + 1;
        System.out.println("Stack have: " + elements +" element");
        return top + 1;
        
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + "-");
            }
            System.out.println();
        }
    }
}
