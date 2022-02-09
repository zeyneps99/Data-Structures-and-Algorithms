package code;

import given.AbstractArraySort;

import java.util.Arrays;

/*
 * Implement the heap-sort algorithm here. You can look at the slides for the pseudo-code.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 *
 */

public class HeapSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  // Add any fields here

  public HeapSort() {
    name = "Heapsort";

    // Initialize anything else here
  }

  @Override
  public void sort(K[] inputArray) {
    // TODO: Implement the heap-sort algorithm
    heapify(inputArray);
    int lastIndex = inputArray.length - 1;
    while(0<lastIndex){
      swap(inputArray,0,lastIndex);
      lastIndex--;
      downheap(inputArray, 0, lastIndex);

    }

  }

  // Public since we are going to check its output!
  public void heapify(K[] inputArray) {
    // TODO: Heapify the array. See the slides for an O(n) version which uses
    // downheap
    int size = inputArray.length;
    for(int i=size/2; i>=0; i--){
      downheap(inputArray,i,size-1);
    }

  }

  // The below methods are given given as suggestion. You do not need to use them.
  // Feel free to add more methods



  protected void downheap(K[] inputArray, int i, int k){
    int index = i;
    int leftChild = (2*i)+1;
    int rightChild = (2*i)+2;
    if(leftChild<=k && compare(inputArray[leftChild],inputArray[index])>0){
      index = leftChild;
    }
    if(rightChild<=k && compare(inputArray[rightChild],inputArray[index])>0){
      index = rightChild;
    }
    if(index!=i){
      swap(inputArray, i, index);
      downheap(inputArray, index, k);
    }
  }
}
