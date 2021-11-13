/**
  * Creates an object of a MinHeap where the smaller the number, the higher the priority.
*/
public class MinHeap<T>{
  private Node root;
  
  /**
    * Constructor for a MinHeap.
  */
  public Heap(){
    root = null;
  }
    
    /**
      * Function to insert into a MinHeap.
      * @param priority the prioriry order. Smallest is highest priority.
      * @param data the data or value of the node.
    */
    public void insert(int priority, T data){
      if(isEmpty()){
        root = new HeapNode(int priority, T data);
      } else{
        
      }
    }
  }
  
  /**
    * Gets if heap is Empty
    * @return true if heap is empty.
  */
  public boolean isEmpty(){
    return root == null;
  }

  /**
    * Creates an object of a HeapNode.
    */
  class HeapNode{
    int priority;
    T data;
    Node left;
    Node Right;

     /**
      * Constructor for a HeapNode.
      * @param priority the prioriry order. Smallest is highest priority.
      * @param data the data or value of the node.
    */
    public HeapNode(int priority, T data){
      this.priority = priority;
      this.data = data;
    }
    
    /**
      * Constructor for a HeapNode.
      * @param priority the prioriry order. Smallest is highest priority.
      * @param data the data or value of the node.
      * @param left the current node's left node.
      * @param right the current node's right node.
    */
    public HeapNode(int priority, T data, Node left, Node right){
      this.priority = priority;
      this.data = data;
      this.left = left;
      this.right = right;
    }

}
