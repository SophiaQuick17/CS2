public class Cell<T>{

  T value;
  Cell ptr;

  public Cell(T v, Cell p){
    value = v;
    ptr = p;
  }

  public void setValue(T v){
    value = v;
  }

  public T getValue(){
    return value;
  }

  public void setPointer(Cell p){
    ptr = p;
  }

  public Cell getPointer(){
    return ptr;
  }

}
