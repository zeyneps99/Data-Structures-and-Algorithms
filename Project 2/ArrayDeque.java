package code;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  <Sezen Zeynep Sumer>
 * Class : ArrayDeque
 *
 * You are not allowed to use Java containers!
 * You must implement the Array Deque yourself
 *
 * MODIFY 
 * 
 * */

import given.iDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import given.Util;


/*
 * You must have a circular implementation. 
 * 
 * WARNING: Modulo operator (%) might create issues with negative numbers.
 * Use Math.floorMod instead if you are having issues
 */
public class ArrayDeque<E> implements iDeque<E> {

 
  private E[] A; //Do not change this name!
  private int f;
  private int sz; 

  /*
   * ADD FIELDS IF NEEDED
   */
	
	public ArrayDeque() {
		this(1000);
    /*
     * ADD CODE IF NEEDED
     */
	}
	
	public ArrayDeque(int initialCapacity) {
	   if(initialCapacity < 1)
	      throw new IllegalArgumentException();
		A = createNewArrayWithSize(initialCapacity);
		
		/*
		 * ADD CODE IF NEEDED
		 */
	}
	
	// This is given to you for your convenience since creating arrays of generics is not straightforward in Java
	@SuppressWarnings({"unchecked" })
  private E[] createNewArrayWithSize(int size) {
	  return (E[]) new Object[size];
	}
	
	//Modify this such that the dequeue prints from front to back!
	//Hint, after you implement the iterator, use that!
  public String toString() {
   
    /*
     * MODIFY THE BELOW CODE
     */

	if(!isEmpty()) {  
    StringBuilder sb = new StringBuilder(1000);
    sb.append("[");
    Iterator<E> iter = iterator();
    while(iter.hasNext()) {
      E e = iter.next();
      if(e == null)
        continue;
      sb.append(e);
      if(!iter.hasNext())
        sb.append("]");
      else
        sb.append(", ");
    }
    return sb.toString();
	} else {
		return "";
	}
   
  }
	
  /*
   * ADD METHODS IF NEEDED
   */
  
  public void resizeStorage() {
	  E[] Q =createNewArrayWithSize(A.length*2);
	  for(int i =0; i<A.length; i++) {
		 int j =  Math.floorMod((f + i), A.length);
		 Q[i] = A[j];
	  }
	  	A = Q;
		 f = 0;
			 
	  }
  
  public boolean isFull() {
	  return (sz == A.length);
  }
  

  /*
   * Below are the interface methods to be overriden
   */
	
  @Override
  public int size() {
    // TODO Auto-generated method stub
   
    return sz;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
	  return (sz == 0);
  }

  @Override
  public void addFront(E o) {
    // TODO Auto-generated method stub
    if (isFull()) resizeStorage();
    if (isEmpty()) {
    	f = 0;
    	A[f] = o;
    } else if (f == 0){
    	f = A.length -1;
    } else {
    	f = Math.floorMod((f-1),A.length);
    }
   
    A[f]=o;
    sz++;
    
  }

  @Override
  public E removeFront() {
    // TODO Auto-generated method stub
	if (isEmpty()) return null;
    E o = A[f];
    A[f] = null;
    f = Math.floorMod((f+1),A.length);
    sz--;
    return o;
  } 

  @Override
  public E front() {
    // TODO Auto-generated method stub
	  if (isEmpty()) return null;
	  else 
		  return A[f];

  }

  @Override
  public void addBehind(E o) {
    // TODO Auto-generated method stub
    if (isFull()) resizeStorage();
    int r = Math.floorMod((f+sz),A.length);
    A[r] = o;
    sz++;
  }

  @Override
  public E removeBehind() {
    // TODO Auto-generated method stub
   if (isEmpty()) return null;
   int r = Math.floorMod((f + sz - 1),A.length);
   E o = A [r];
   A[r] = null;
   sz--;
   return o; 
  }

  @Override
  public E behind() {
    // TODO Auto-generated method stub
   if(isEmpty()) return null;
   return A[Math.floorMod((f + sz -1) , A.length)];
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
	  A = createNewArrayWithSize(A.length);
	  f=0;
	  sz = 0;
  }
  
  //Must print from front to back
  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    //Hint: Fill in the ArrayDequeIterator given below and return a new instance of it
	ArrayDequeIterator iterate = new ArrayDequeIterator();
	  
    return iterate;
  }
  
  private final class ArrayDequeIterator implements Iterator<E> {
    
    /*w
     * 
     * ADD A CONSTRUCTOR IF NEEDED
     * Note that you can freely access everything about the outer class!
     * 
     */
	  int pos = f;
	  

    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
    	return (A[pos % A.length] != null) ;
    }

    @Override
    public E next() {
      // TODO Auto-generated method stub
    	if (this.hasNext()) {
    	E temp = A[pos % A.length];
    	pos ++;
    	return temp;
    	}
    	
      return null;
    }        
  }
}
