import java.util.Iterator;

/**
 * A generic implementation of a linked queue
 * @param <E> generic type
 * @author Lois Lanctot
 * @version 1.0
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        E item;
        Node next;
    }

    /**
     * Add an item to the queue.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @param item the item to be added
     */
    @Override
    public void enqueue(E item) {
        Node oldLast = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        }
        else {
            oldLast.next = tail;
        }
        size++;
    }

    /**
     * Remove an item from the queue.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return the item that was removed
     */
    @Override
    public E dequeue() {
        E item = head.item;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return item;
    }

    /**
     * Checks to see if the queue is empty.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns a count of the number of items in the queue.
     * This method runs in O(1) or constant time in the worst case because
     * regardless of the size of the array, the number of operations executed remains the same
     * @return the number of items in the queue
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
        return new LinkedQueue.ListIterator();
    }

    private class ListIterator implements Iterator<E> {

        private LinkedQueue.Node current;

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
