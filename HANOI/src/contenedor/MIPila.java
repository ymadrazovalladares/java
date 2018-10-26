package contenedor;

public class MIPila {
    int capacity;
    int top;
    int array[];

    MIPila createMiPila(int capacity)
    {
        MIPila pila=new MIPila();
        pila.capacity = capacity;
        pila.top = -1;
        pila.array = new int[capacity];
        return pila;
    }

    // Stack is full when top is equal to the last index
    boolean isFull(MIPila stack)
    {
        return (stack.top == stack.capacity - 1);
    }

    // Stack is empty when top is equal to -1
    boolean isEmpty(MIPila stack)
    {
        return (stack.top == -1);
    }

    // Function to add an item to stack. It increases
    // top by 1
    void push(MIPila stack,int item)
    {
        if(isFull(stack))
            return;
        stack.array[++stack.top] = item;
    }

    // Function to remove an item from stack. It
    // decreases top by 1
    int pop(MIPila stack)
    {
        if(isEmpty(stack))
            return Integer.MIN_VALUE;
        return stack.array[stack.top--];
    }

    // Function to implement legal movement between
    // two poles



    }
