package code;

import given.Util;
import given.iDeque;

/* 
 * ASSIGNMENT 2
 * AUTHOR:  <Sezen Zeynep Sumer>
 * Class : Queue
 *
 * MODIFY 
 * 
 * */

import given.iSimpleContainer;

//Queue implementation
//E is the element type
//C is the underlying Deque type
public class Queue<C extends iDeque<E>, E> implements iSimpleContainer <E> {
  
  //C is generic. It indicates the type of the deque to store the elements
  //E is generic. It indicates the type of data to be stored in the deque


  C deque;
  
  public Queue(C inDeque){
    deque = inDeque;
    /*
     * ADD CODE IF NEEDED
     * 
     */
  }
  
  public String toString() {
    return deque.toString();
  }
  
  
  /*
   * ADD FIELDS AND METHODS IF NEEDED
   * 
   */
  
  /*
   * Below are the interface methods to be overriden
   */
  
  @Override
  public void push(E obj) {
    // TODO Auto-generated method stub
    this.deque.addBehind(obj);
  }

  @Override
  public E pop() {
    // TODO Auto-generated method stub
	E elt = this.deque.front();
    this.deque.removeFront();
    return elt;
  }

  @Override
  public E peek() {
    // TODO Auto-generated method stub
    return this.deque.front();
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return this.deque.size();
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return this.deque.isEmpty();
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
	  this.deque.clear();
    
  }
}
