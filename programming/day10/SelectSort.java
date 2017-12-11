public class SelectSort<T extends Comparable> implements ISort<T>{

  T[] array = (T[]) new Comparable[0];

  public void sort(T[] in){
    T small;
    int smallIndex;
    array = in;
    int size = array.length;
    for (int i = 0; i < size; i++){
      small = array[i];
      smallIndex = i;
      for (int j = i+1; j < size; j++){
        if (array[j].compareTo(small) < 0){
          small = array[j];
          smallIndex = j;
        }
      array[smallIndex] = array[i];
      array[i] = small;
      }
    }
  }

  public String sortName(){
    return "Select Sort";
  }

}
