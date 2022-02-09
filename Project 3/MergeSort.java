package code;

import given.AbstractArraySort;

import java.lang.reflect.Array;

/*
 * Implement the merge-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 * You may need to create an Array of K (Hint: the auxiliary array). 
 * Look at the previous assignments on how we did this!
 * 
 */

public class MergeSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  // Add any fields here
  K[] helperArray;

  public MergeSort() {
    name = "Mergesort";

    // Initialize anything else here
  }

  @Override
  public void sort(K[] inputArray) {
    // TODO: Implement the merge-sort algorithm
  mergeSort(inputArray, 0,inputArray.length-1);

  }

  public void mergeSort(K[] inputArray, int low, int high){
    if(low<high){
      int mid= (low+high)/2;
      mergeSort(inputArray,low,mid);
      mergeSort(inputArray,mid+1,high);
      merge(inputArray,low,mid,high);
    }
  }

  // Public since we are going to check its output!
  public void merge(K[] inputArray, int lo, int mid, int hi) {
    // TODO: Implement the merging algorithm
    helperArray = inputArray.clone();
    int indexFirst= lo;
    int indexSecond = mid+1;
    int indexActual = lo;
    while(indexActual<=hi){
      if(indexSecond>hi || (indexFirst<=mid && compare(helperArray[indexFirst], helperArray[indexSecond])<=0)){
      inputArray[indexActual] = helperArray[indexFirst];
      indexActual++;
      indexFirst++;
      } else {
        inputArray[indexActual] = helperArray[indexSecond];
        indexActual++;
        indexSecond++;
      }
    }

  }
  
  // Feel free to add more methods
}
