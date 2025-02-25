import java.util.Iterator;


/**
 * A generic implementation of a linked bag
 * @param <E> generic type
 * @author Lois Lanctot
 * @version 1.0
 */
public class LinkedBag<E> implements Bag<E> {

    private Node head;
    private int size;

    private class Node {
        E item;
        Node next;
    }

    /**
     * Add an item to the bag.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @param item the item to be added
     */
    @Override
    public void add(E item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    /**
     * Checks to see if the bag is empty.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns a count of the number of items in the bag.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return the number of items in the bag
     */
    @Override
    public int size() {
        return size;
    }

     /**
     * Returns an iterator over elements of type {@code T}.
      * This method runs in O(1) or constant time in the worst case because
      * regardless of the size of the array, the number of operations executed remains the same
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedBag.ListIterator();
    }

    private class ListIterator implements Iterator<E> {

        private LinkedBag.Node current;

        public ListIterator() {
            this.current = head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {

            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            E item = (E) current.item;
            current = current.next;
            return item;
        }
    }
}
