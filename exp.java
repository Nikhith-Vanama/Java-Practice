class QueueException extends Exception 
{
    public QueueException(String message) 
    {
        super(message);
    }
}
class CustomQueue 
{
    int[] queueArray;
    int front;
    int rear;
    int size;

    public CustomQueue(int capacity) 
    {
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) throws QueueException 
    {
        if (size == queueArray.length) 
	{
            throw new QueueException("Queue is full! Cannot enqueue.");
        }
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = value;
        size++;
    }

    int dequeue() throws QueueException 
    {
        if (size == 0) 
	{
            throw new QueueException("Queue is empty! Cannot dequeue.");
        }
        int value = queueArray[front];
        front = (front + 1) % queueArray.length;
        size--;
        return value;
    }

    int peek() throws QueueException 
    {
        if (size == 0) 
	{
            throw new QueueException("Queue is empty! Cannot peek.");
        }
        return queueArray[front];
    }

    boolean isEmpty() 
    {
        return size == 0;
    }

    boolean isFull() 
    {
        return size == queueArray.length;
    }

    int getSize() 
    {
        return size;
    }
}
class QueueDemo 
{
    public static void main(String[] args) 
    {
        CustomQueue queue = new CustomQueue(5);
        
        try 
	{
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(40);
            queue.enqueue(50);
            queue.enqueue(60); // This will throw a QueueException
        } 
        catch (QueueException e) 
	{
            System.out.println(e.getMessage());
        }

        try 
	{
            System.out.println("Front element: " + queue.peek());
            
            System.out.println("Dequeue: " + queue.dequeue());
            System.out.println("Dequeue: " + queue.dequeue());

            System.out.println("Front element after two dequeues: " + queue.peek());
            while (!queue.isEmpty()) 
	    {
                System.out.println("Dequeue: " + queue.dequeue());
            }
            queue.dequeue(); 
        } 
	catch (QueueException e) 
	{
            System.out.println(e.getMessage());
        }
    }
}
