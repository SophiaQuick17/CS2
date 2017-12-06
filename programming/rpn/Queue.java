public class Queue<T> implements IQueue<T>{

  Cell<T> front = null;
  Cell<T> back = null;
  int size = 0;

  public T dequeue() throws UnderFlowException{
    if (back == null){ throw new UnderFlowException();}
    T v = front.getValue();
    front = front.getPointer();
    size--;
    return v;
  }

  public void enqueue(T v) throws OverFlowException{
    Cell<T> n = new Cell<T>(v, front);
    if (size == 0){
      front = n;
    }
    back = n;
    size++;
  }

}
