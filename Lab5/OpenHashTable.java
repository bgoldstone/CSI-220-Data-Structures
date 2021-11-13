public class OpenHashTable<T>{
  private int D;
  private Node[] nodeArray;
  
  public OpenHashTable(int D){
    this.D = D;
    nodeArray = new Node[D];
  }
  
  public void insert(T, key, T value){
    Node current = nodeArray[((int) key) % D];
    if(current != null){
      while(current.next != null){
        current = current.next;
      }
    current.next = Node(key, value);
    }else{
      current = Node(key, value);
    }
  }
  public boolean search(T key){
    Node current = d[((int) key) % D];
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
  
  public boolean remove(T key){
    Node current = d[((int) key) % D];
    while(current != null){
      if(current.next.value.equals(value)){
        current.next = current.next.next;
        return true;
      }
    }
    return false;
  }
  
  class Node<T>{
    T key;
    T value;
    Node next;
    public Node(T key, T value){
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }

}
