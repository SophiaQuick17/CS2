public class DictList <K extends Comparable<K>,V> implements IDict<K,V>{

  DoubleDictCell<K, V> head = null;
  DoubleDictCell<K, V> tail = null;
  int length = 0;
  K[] keys;

  public V add(K k, V v){
    DoubleDictCell<K, V> node = new DoubleDictCell();
    V returnValue = null;
    node.setValue(v);
    node.setKey(k);
    if (length == 0){
      head = node;
      tail = node;
      length++;
    }
    else{
      DoubleDictCell<K, V> current = head;
      for (int i = 0; i <= length; i++){
        if (i < length && node.getKey().compareTo(current.getKey()) == 0){
          returnValue = current.getValue();
          current.setValue(node.getValue());
        }
        else if (i < length && node.getKey().compareTo(current.getKey()) != 0){
          current = current.getNext();
        }
        if(i == length){
          node.setPrevious(tail);
          tail.setNext(node);
          tail = node;
          length++;
          break;
        }
      }
    }
    return returnValue;
  }

  public V remove(K k){
    DoubleDictCell<K, V> current = head;
    DoubleDictCell<K, V> before = null;
    DoubleDictCell<K, V> after = null;
    while (current.getKey() != k){
      current = current.getNext();
    }
    if (current == tail){
      current.setPrevious(before);
      tail = before;
      before.setNext(null);
    }
    else if(current == head){
      current.setNext(after);
      head = after;
      head.setPrevious(null);
    }
    else{
      before = current.getPrevious();
      after = current.getNext();
      before.setNext(after);
      after.setPrevious(before);
    }
    length--;
    return current.getValue();
  }

  public int size(){
    return length;
  }

  public V fetch(K k){
    DoubleDictCell<K, V> current = head;
    while (current.getKey() != k){
      current = current.getNext();
    }
    return current.getValue();
  }

  public K[] keys(){
    DoubleDictCell<K, V> current = head;
    keys = (K[]) new Object[length];
    for (int i = 0; i < length; i++){
      keys[i] = current.getKey();
      current = current.getNext();
    }
    return keys;
  }

}
