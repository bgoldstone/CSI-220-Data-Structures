public interface Stack<E> {
    public boolean empty();

    public E peek();

    public E pop();

    public E push(E item);

    public int search(Object o);

}