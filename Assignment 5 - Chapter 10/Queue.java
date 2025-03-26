public class Queue {
    private int[] elements; //Array to store queue elements
    private int size; //Number of elements in the queue
    private int capacity; //Maximum capacity of the queue

    //Constructor creates Queue object with default capacity of 8
    public Queue() {
        this.capacity=8; //Set initial capacity
        this.elements=new int[capacity]; //Create the elements array
        this.size=0; //Initialize size to 0
    }

    //Method to add element to queue
    public void enqueue(int v) {
        //Check if queue is full
        if (size==capacity) {
            //Double size if queue is full
            capacity*=2;
            int[] newElements=new int[capacity]; //Create new array with larger capacity
            
            //Copy existing elements to new array
            System.arraycopy(elements, 0, newElements, 0, size);
            elements=newElements; //Update reference to new array
        }
        
        //Add new element to the end of queue
        elements[size]=v;
        size++; //Increment the size
    }

    //Method removes and returns first element of queue
    public int dequeue() {
        //Check if queue is empty before removing element
        if (empty()) {
            throw new IllegalStateException("Queue is empty."); //Throw exception if empty
        }
        
        int value=elements[0]; //Store first element to return
        
        //Move elements left to remove the first element
        for (int i=1; i<size; i++) {
            elements[i-1]=elements[i]; //Move each element one position to the left
        }
        size--; //Lower the size of the queue
        return value; //Return removed element
    }

    //Method to check if queue is empty
    public boolean empty() {
        return size==0; //Returns true if size=0
    }

    //Method to get size of queue
    public int getSize() {
        return size; //Return the current size
    }

    //Start program
    public static void main(String[] args) {
        Queue queue=new Queue(); //Create new Queue instance

        //Adding numbers from 1 to 20 to queue
        for (int i=1; i<=20; i++) {
            queue.enqueue(i); //Enqueue each number
        }

        //Remove and display each number from queue
        while (!queue.empty()) {
            System.out.print(queue.dequeue()+" "); //Dequeue and print each element
        }
    }
}