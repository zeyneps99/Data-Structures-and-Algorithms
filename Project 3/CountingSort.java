package code;

import given.AbstractArraySort;

import java.security.Key;

/*
 * Implement the c algorithm here. You can look at the slides for the pseudo-codes.
 * You do not have to use swap or compare from the AbstractArraySort here
 * 
 * You may need to cast any K to Integer
 * 
 */

public class CountingSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  //Add any fields here
  
  public CountingSort()
  {
    name = "Countingsort";
  }
  
  @Override
  public void sort(K[] inputArray) {
    
    if(inputArray == null)
    {
      System.out.println("Null array");
      return;
    }
    if(inputArray.length < 1)
    {
      System.out.println("Empty array");
      return;
    }   
    
    if(!(inputArray[0] instanceof Integer)) {
      System.out.println("Can only sort integers!");
      return;
    }
    int min = maxAndMin(inputArray).p1;
    int max = maxAndMin(inputArray).p2;
    int maxRange = max-min+1;
    int[] counts = new int[maxRange];

    for(int i=0; i<inputArray.length;i++){
      counts[(Integer) inputArray[i]-min]++;
    }
    int counter = 0;
    for(int i=0; i<maxRange;i++){
      for(int j=0; j<counts[i];j++){
        inputArray[counter] = (K) (Object) (i+min);
        counter++;
      }
    }

 //TODO:: Implement the counting-sort algorithm here
  }

  protected indexPair maxAndMin(K[] inputArray){
    int min = (Integer) inputArray[0];
    int max = (Integer) inputArray[0];

    for(K elt :inputArray){
      if((Integer) elt > max){
        max = (Integer) elt;
      } else if ((Integer) elt < min){
        min = (Integer) elt;
      }
    }
    return new indexPair(min,max);

  }

  public class indexPair {
    public int p1, p2;

    indexPair(int pos1, int pos2) {
      p1 = pos1;
      p2 = pos2;
    }

    public String toString() {
      return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
    }
  }
}
