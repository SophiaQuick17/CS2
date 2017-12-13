public class DoubleLinkList<T> implements IList<T>{

  IDLink<T> head = null;
  IDLink<T> tail = null;
  IDLink<T> current = null;
  int size = 0;

  public void insert(int idx, T v){
    IDLink<T> n = new DLLNode(v, null, null);
    IDLink<T> after = head;
    n.setValue(v);
    if (idx == size){
      append(v);
      return;
    }
    else if (idx == 0){
      n.setNext(head);
      head.setPrev(n);
      head = n;
      size++;
      return;
    }
    else{
      for (int i = 0; i < idx; i++){
        after = after.getNext();
      }
    }
    IDLink<T> before = after.getPrev();
    if (before == null){}
    else{
      before.setNext(n);
    }
    after.setPrev(n);
    n.setNext(after);
    n.setPrev(before);
    size++;
  }

  public void append(T v){
    IDLink<T> n = new DLLNode(v, null, tail);
    if (size == 0){
      head = n;
      tail = n;
      n.setPrev(n);
      n.setNext(n);
      size++;
      current = n;
    }
    else{
      tail.setNext(n);
      n.setPrev(tail);
      n.setNext(n);
      size++;
      tail = n;
      current = n;
    }
  }

  public void remove(){
    if (current == tail){
      IDLink<T> l = current.getPrev();
      l.setNext(null);
      current = current.getPrev();
      tail = current;
    }
    else if (current == head){
      IDLink<T> f = current.getNext();
      f.setPrev(null);
      current = current.getNext();
      head = current;
    }
    else{
      IDLink<T> l = current.getPrev();
      IDLink<T> f = current.getNext();
      l.setNext(f);
      f.setPrev(l);
      current = current.getPrev();
    }
    size--;
  }

  public void remove(int idx){
    IDLink<T> temp = head;
    if (idx != 0){
      for (int i =0; i < idx; i++){
        temp = temp.getNext();
      }
    }
    if (temp == tail){
      IDLink<T> l = temp.getPrev();
      l.setNext(null);
      tail = l;
    }
    else if (temp == head){
      IDLink<T> f = temp.getNext();
      f.setPrev(null);
      head = f;
    }
    else{
      IDLink<T> l = temp.getPrev();
      IDLink<T> f = temp.getNext();
      l.setNext(f);
      f.setPrev(l);
    }
    if (temp == current){
      current = temp.getPrev();
    }
    size--;
  }

  public void move(int sidx, int didx){
    IDLink<T> v = head;
    if (sidx == 0){
    }
    else{
      for (int i = 0; i < sidx; i++){
        v = v.getNext();
      }
    }
    this.remove(sidx);
    this.insert(didx, v.getValue());
  }

  public T fetch(){
    return current.getValue();
  }

  public T fetch(int idx){
    IDLink<T> temp = head;
    if (idx == 0){
    }
    for (int i = 0; i < idx; i++){
      temp = temp.getNext();
    }
    return temp.getValue();
  }

  public void next(){
    if (current != tail){
      current = current.getNext();
    }
  }

  public void prev(){
    if (current != head){
      current = current.getPrev();
    }
  }

  public void jumpToTail(){
    current = tail;
  }

  public void jumpToHead(){
    current = head;
  }

  public int size(){
    return size;
  }

  public static void main(String[] argv){
    IList<Integer> doubleList = new DoubleLinkList<Integer>();
    for (int i = 0; i < 4; i++){
      doubleList.append(i);
    }
    doubleList.insert(2,17);
    for (int i = 0; i <5; i ++){
      System.out.println(doubleList.fetch(i));
    }
  }

}
