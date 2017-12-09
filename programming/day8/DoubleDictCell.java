public class DoubleDictCell<K, V>{

  DoubleDictCell<K, V> next = null;
  DoubleDictCell<K, V> previous =  null;
  V value = null;
  K key = null;

  public void setNext(DoubleDictCell<K, V> n){
    next = n;
  }

  public DoubleDictCell<K, V> getNext(){
    return next;
  }

  public void setPrevious(DoubleDictCell<K, V> p){
    previous = p;
  }

  public DoubleDictCell<K, V> getPrevious(){
    return previous;
  }

  public void setValue(V v){
    value = v;
  }

  public V getValue(){
    return value;
  }

  public void setKey(K k){
    key = k;
  }

  public K getKey(){
    return key;
  }

}
