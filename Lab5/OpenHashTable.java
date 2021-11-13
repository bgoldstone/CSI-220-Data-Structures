public class OpenHashTable<T>{
  private int D;
  private Node[] nodeArray;
  
  public OpenHashTable(int D){
    this.D = D;
    nodeArray = new Node[D];
  }
  
  public void insert(T data){
    Node current = nodeArray[((int) data) % D];
    if(current != null){
      while(current.next != null){
        current = current.next;
      }
    current.next = Node(data);
    }else{
      current = Node(data);
    }
  }
  public boolean search(T data){
    Node current = d[((int) data) % D];
    if(current == null){
      return false;
    }else{
      while(current.next != null){
        if(current.value.equals(value))
          return true;
        else{
          current = current.next
        }
      }
      return false;
  }
  
  public void display(){
    int currentD = 0;
    for (Node current : nodeArray){
      System.out.println("Row " + currentD + ":");
      if(current != null){
        while(current != null){
          System.out.print(current.value);
          current = current.next;
        }
        System.out.println();
      }
      currentD++;
    }
  }
  
  public boolean remove(T data){
    Node current = d[((int) data) % D];
    while(current != null){
      if(current.next.value.equals(value)){
        current.next = current.next.next;
        return true;
      }
    }
    return false;
  }
  
  class Node<T>{
    T data;
    Node next;
    public Node(T data){
      this.data = data;
      this.next = null;
    }
  }

}
