package jp.co.wap.exam; 

import java.util.NoSuchElementException;
 
/** 
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of objects. 
 * @param <E> 
 */ 
public class PersistentQueue<E> { 

 /** 
 * requires default constructor. 
 */ 
	public class ModifiedList<E> {
		
		public ModifiedList<E> back;
		public E val;
		
		public ModifiedList(E val,ModifiedList<E> back){
			this.val = val;
			this.back = back;
		}
		public ModifiedList(){
			this.val = null;
			this.back = null;
		}
	}
	
	
	public ModifiedList<E> tail;
	public ModifiedList<E> head;
	
		 private PersistentQueue(ModifiedList<E> head,ModifiedList<E> tail) { 
		 // modify or remove this constructor if necessary 
		 this.tail = tail;
		 this.head = head;
		 }
		 public PersistentQueue() { 
			 // modify or remove this constructor if necessary 
			 this.tail = null;
			 this.head = null;
			 }
		 
		 private boolean isEmpty(){
			 if (this.head == null && this.tail == null)
				 return true;
			 else
				 return false;			 
		 }
 
 /** 
 * Returns the queue that adds an item into the tail of this queue without modifying this queue. 
 * <pre> 
 * e.g. 
 * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue, 
 * this method returns a new queue (2, 1, 2, 2, 6, 4) 
 * and this object still represents the queue (2, 1, 2, 2, 6) . 
 * </pre> 
 * If the element e is null, throws IllegalArgumentException. 
 * @param e 
 * @return 
 * @throws IllegalArgumentException 
 */ 
 public PersistentQueue<E> enqueue(E e) { 
	 if (e == null) { 
		 throw new IllegalArgumentException(); 
		 }
	 	 ModifiedList<E> last = new ModifiedList<E>(e,this.tail);
	 	 
	 	 if(this.isEmpty())
		 	return new PersistentQueue<E>(last,last); 
	 	 else
		 	return new PersistentQueue<E>(this.head,last); 
 } 
 
 /** 
 * Returns the queue that removes the object at the head of this queue without modifying this queue. 
 * <pre> 
 * e.g. 
 * When this queue represents the queue (7, 1, 3, 3, 5, 1) , 
 * this method returns a new queue (1, 3, 3, 5, 1) 
 * and this object still represents the queue (7, 1, 3, 3, 5, 1) . 
 * </pre> 
 * If this queue is empty, throws java.util.NoSuchElementException. 
 * @return 
 * @throws java.util.NoSuchElementException 
 */ 
 public PersistentQueue<E> dequeue() {
		 if(this.isEmpty()){
			 throw new NoSuchElementException(); 
		 }
	 
	 	 ModifiedList<E> clone = this.tail;
	 	 while(clone.back != this.head)
	 	 {
	 		 clone = clone.back;
	 	 }

		 return new PersistentQueue<E>(clone,this.tail); 
 } 
 
 /** 
 * Looks at the object which is the head of this queue without removing it from the queue. 
 * <pre> 
 * e.g. 
 * When this queue represents the queue (7, 1, 3, 3, 5, 1), 
 * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1) 
 * </pre> 
 * If the queue is empty, throws java.util.NoSuchElementException. 
 * @return 
 * @throws java.util.NoSuchElementException 
 */ 
 public E peek() { 
		 if(this.isEmpty()){
			 throw new NoSuchElementException(); 
		 }
		 return this.head.val;
 } 
 
 /** 
 * Returns the number of objects in this queue. 
 * @return 
 */ 
 public int size() {
	 if(this.isEmpty()){
		 return 0; 
	 }
	 ModifiedList<E> clone = this.tail;
	 int i = 1;
	 while(clone != this.head)
 	 {
 		 clone = clone.back;
 		 i++;
 	 }
	 return i;
 } 
}