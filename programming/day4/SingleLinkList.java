public class SingleLinkList<T> implements IList<T>{

  ISLink<T> head = null;
  ISLink<T> tail = null;
  ISLink<T> current = null;
  int size = 0;

  public void insert(int idx, T v){
    if (idx == size){
      append(v);
      return;
    }
    else if (idx == 0){
      ISLink<T> n = new SNode(v, null);
      ISLink<T> after = head;
      n.setNext(head);
      head = n;
      size++;
      return;
    }
    else{
      ISLink<T> n = new SNode(v, null);
      ISLink<T> after = head;
      ISLink<T> prev = head;
      for (int i = 0; i < idx; i++){
        after = after.getNext();
      }
      for(int i = 0; i < idx-1; i++){
        prev = prev.getNext();
      }
      prev.setNext(n);
      n.setNext(after);
      size++;
    }
  }

  public void append(T v){
    SNode<T> n = new SNode(v, null);
    if (size == 0){
      head = n;
      tail = n;
      n.setNext(n);
      size++;
      current = n;
    }
    else{
      tail.setNext(n);
      n.setNext(n);
      size++;
      tail = n;
      current = n;
    }
  }
  public void remove(){
    if (current == tail){
      ISLink<T> p = head;
      for (int i = 0; i < size; i++){
        p = p.getNext();
      }
      p.setNext(null);
      current = p;
      tail = current;
    }
    else if (current == head){
      ISLink<T> f = current.getNext();
      current = current.getNext();
      head = current;
    }
    else{
      int count = 0;
      ISLink<T> p = head;
      ISLink<T> n = current.getNext();
      while(p != current){
        p = p.getNext();
        count++;
      }
      p = head;
      for (int i = 0; i < count-1; i++){
        p = p.getNext();
      }
      p.setNext(n);
    }
    size--;
  }

  public void remove(int idx){
    ISLink<T> temp = head;
    int count = 0;
    if (idx != 0){
      for (int i =0; i < idx; i++){
        temp = temp.getNext();
        count++;
      }
    }
    if (temp == tail){
      ISLink<T> l = head;
      for (int i = 0; i < count-1; i++){
        l = l.getNext();
      }
      l.setNext(null);
      tail = l;
    }
    else if (temp == head){
      ISLink<T> f = temp.getNext();
      head = f;
    }
    else{
      ISLink<T> l = head;
      for (int i = 0; i < count-1; i++){
        l = l.getNext();
      }
      ISLink<T> f = temp.getNext();
      l.setNext(f);
    }
    if (temp == current){
      ISLink<T> l = head;
      for (int i = 0; i < count-1; i++){
        l = l.getNext();
      }
      current = l;
    }
    size--;
  }

  public void move(int sidx, int didx){
    ISLink<T> v = head;
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
    ISLink<T> temp = head;
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
      int count = 0;
      ISLink<T> n = head;
      while (n != current){
        n = n.getNext();
        count++;
      }
      n = head;
      for (int i = 0; i < count-1; i++){
        n = n.getNext();
      }
      current = n;
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


  public static void main(String[] args){
    IList<Integer> singleList = new SingleLinkList<Integer>();
    singleList.append(0);
    singleList.append(1);
    singleList.append(2);
    singleList.append(3);
    singleList.insert(1, 17);
    System.out.println(singleList.fetch(0));
    System.out.println(singleList.fetch(1));
    System.out.println(singleList.fetch(2));
    System.out.println(singleList.fetch(3));
    System.out.println(singleList.fetch(4));
  }

}
