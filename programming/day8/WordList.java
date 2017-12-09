public class WordList<T> implements IList<T>{

  T[] list;
  int length = 0;
  int current = 0;
  T holder;

  public WordList(){
    list = (T[]) new Object[length];
  }

  public void insert(int idx, T v){
    T[] temp = (T[]) new Object[list.length+1];
    for (int i = 0; i < list.length + 1; i++){
      if (i == idx){
        temp[i] = v;
      }
      else if (i > idx){
        temp[i] = list[i-1];
      }
      else{
        temp[i] = list[i];
      }
    }
    list = temp;
  }

  public void append(T v){
    T[] temp = (T[]) new Object[list.length+1];
    if (list.length == 0){
      temp[list.length] = v;
      list = temp;
    }
    else{
      for (int i = 0; i < list.length; i++){
        temp[i] = list[i];
      }
      temp[list.length] = v;
      list = temp;
    }
    current = list.length-1;
  }

  public void remove(){
    T[] temp = (T[]) new Object[list.length-1];
    if (current == list.length-1){
      for (int i = 0; i < list.length; i++){
        if (i < current){
          temp[i] = list[i];
        }
      }
    list = temp;
    }
    else if (current < list.length-1){
      for (int i = 0; i < list.length; i++){
        if (i < current){
          temp[i] = list[i];
        }
        else if (i > current){
          temp[i-1] = list[i];
        }
      }
      list = temp;
    }
    if (current == 0){
      current = 0;
    }
    else{
      current--;
    }
  }

  public void remove(int idx){
    T[] temp = (T[]) new Object[list.length-1];
    for (int i = 0; i < list.length; i++){
      if (i == idx){
      }
      else if (i < idx){
        temp[i] = list[i];
      }
      else{
        temp[i - 1] = list[i];
      }

    }
    list = temp;
  }

  public void move(int sidx, int didx){
    holder = list[sidx];
    remove(sidx);
    insert(didx, holder);
  }

  public T fetch(){
    return list[current];
  }

  public T fetch(int idx){
    return list[idx];
  }

  public void next(){
    if (current < list.length-1){
      current++;
    }
  }

  public void prev(){
    if (current > 0){
      current--;
    }
  }

  public void jumpToTail(){
    current = list.length-1;
  }

  public void jumpToHead(){
    current = 0;
  }

  public int size(){
    return list.length;
  }

}
