public class Queue<T> implements IQueue<T>{

  Cell<T> front = null;
  Cell<T> back = null;
  int size = 0;

  public T dequeue() throws UnderFlowException{
    if (front == null){
      System.out.println("Empty Queue");
      return null;
    }
    T v = front.getValue();
    front = front.getPointer();
    size--;
    return v;
  }

  public void enqueue(T v) throws OverFlowException{
    Cell<T> n = new Cell<T>(v, back);
    if (size == 0){
      front = n;
    }
    back = n;
    size++;
  }

  public static void main(String[] args) throws UnderFlowException, OverFlowException{
    Queue<Integer> q = new Queue();
    q.enqueue(5);
    q.enqueue(15);
    Integer dq = q.dequeue();
    System.out.println(dq);
  }

}
