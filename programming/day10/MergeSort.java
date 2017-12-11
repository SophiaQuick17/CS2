public class MergeSort<T extends Comparable> implements ISort<T>{

  //recursive function that splits an array in half until each array is of length 1
  //and then calls on merge to merge the arrays in order
  public T[] split(T[] a){
    // for (int i = 0; i < a.length; i++){
    //   System.out.println(a[i]);
    // }
    if (a.length == 1){
      return a;
    }
    int half = a.length/2;
    T[] first = (T[]) new Comparable[half];
    for (int i = 0; i < half; i++){
      first[i] = a[i];
    }
    T[] second = (T[]) new Comparable[half + a.length%2];
    for (int i = 0; i < second.length; i++){
      second[i] = a[first.length+i];
    }
    first = split(first);
    second = split(second);
    T[] newArray = merge(first, second);
    return newArray;
  }

  public T[] merge(T[] a, T[] b){
    T[] temp = (T[]) new Comparable[a.length + b.length];
    int acount = 0;
    int bcount = 0;
    int index = 0;
    while(acount < a.length || bcount < b.length){
      //if all of the a values have been placed
      if (acount == a.length){
        temp[index] = b[bcount];
        bcount++;
        index++;
      }
      //if all of the b values have been placed
      else if (bcount == b.length){
        temp[index] = a[acount];
        acount++;
        index++;
      }
      //if value a is less than b, place a in the array
      else if (a[acount].compareTo(b[bcount]) < 0){
        temp[index] = a[acount];
        acount++;
        index++;
      }
      //if value b is less than a, place b in the array
      else {
        temp[index] = b[bcount];
        bcount++;
        index++;
      }
    }
    return temp;
  }

  public  void sort(T[] in){
    T[] arr = split(in);
    for (int i = 0; i < arr.length; i++){
      in[i] = arr[i];
    }
  }

  public String sortName(){
    return "Merge Sort";
  }

  public static void main(String[] args) {
    ISort<Integer> s = new MergeSort<Integer>();
    Integer[] a = {5,4,3,2,1};
    s.sort(a);
  }

}
