//Got this code from class
public class LinkStack<T> implements IStack<T>{

  Cell<T> top;
  int size;

  public LinkStack(){
    size = 0;
    top = null;
  }

  public void push(T v) throws OverFlowException{
    Cell<T> n = new Cell<T>(v, top);
    top = n;
    size++;
  }

  public T pop() throws UnderFlowException{
    if (top == null){ throw new UnderFlowException();}
    T v = top.getValue();
    top = top.getPointer();
    size--;
    return v;
  }

}
