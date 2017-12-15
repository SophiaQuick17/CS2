public class SNode<T> implements ISLink<T>{

  ISLink<T> next;
  T value;

  public SNode(T v, ISLink<T> n){
    value = v;
    next = n;
  }

  public T getValue(){
    return value;
  }

  public void setValue(T v){
    value = v;
  }

  public ISLink<T> getNext(){
    return next;
  }

  public void setNext(ISLink<T> c){
    next = c;
  }

}
