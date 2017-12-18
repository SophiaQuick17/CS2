public class DLLNode<T> implements IDLink<T>{

  IDLink<T> next;
  IDLink<T> previous;
  T value;

  public DLLNode(T v, IDLink<T> n, IDLink p){
    next = n;
    previous = p;
    value = v;
  }

  public T getValue(){
    return value;
  }

  public void setValue(T v){
    value = v;
  }

  public IDLink<T> getNext(){
    return next;
  }

  public IDLink<T> getPrev(){
    return previous;
  }

  public void setNext(IDLink<T> c){
    next = c;
  }

  public void setPrev(IDLink<T> c){
    previous = c;
  }

}
