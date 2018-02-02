import java.util.NoSuchElementException;

/**
 * LinkedList - A class for creating and manipulating a doubly linked list of nodes containing generic data of type T.
 *
 * <pre>
 *
 * Assignment:     #1
 * Course:         ADEV-3001
 * Date Created:   January 11th 2018
 *
 * Revision Log
 * Who       When          Reason
 * --------- ------------- ---------------------------------
 *
 * </pre>
 *
 * @author Christian Wenham
 * @version 1.0
 *
 */
public class LinkedList<E extends Comparable<E>> {

    private Node<E> head, tail;
    private int size;

    /**
     * Constructor, initializes private fields
     */
    public LinkedList(){
        this.size = 0;
    }

    /**
     * Creates a new Node with the new element and adds it to the head of the list.
     * @param element
     */
    public void addFirst(E element){
        Node<E> first;
        if(isEmpty()){
            first = new Node<E>(element, null, null);
            this.head = first;
            this.tail = first;
        } else {
            first = new Node<E>(element, null, head);
            this.head.setPrevious(first);
            this.head = first;
        }
        this.size += 1;
    }

    /**
     * Empty all elements from the list.
     */
    public void clear(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * @return true if the list is empty, else return false.
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * @return the head node.
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * @return the tail node
     */
    public Node<E> getTail() {
        return tail;
    }

    /**
     * @return the element in the head node.
     */
    public E getFirst(){
        if(!isEmpty()) {
            return head.getElement();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * @return the element in the tail node.
     */
    public E getLast(){
        if(!isEmpty()) {
            return tail.getElement();
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * @return the count of the number of nodes in the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Set head node element to parameter value.
     * @param element
     * @return the element removed
     */
    public E setFirst(E element){
        if(!isEmpty()) {
            E oldElement = head.getElement();
            head.setElement(element);
            return oldElement;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Set tail node element to parameter value.
     * @param element
     * @return the element removed
     */
    public E setLast(E element){
        if(!isEmpty()) {
            E oldElement = tail.getElement();
            tail.setElement(element);
            return oldElement;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Adds new element to the tail of the list
     * @param element
     */
    public void addLast(E element){
        Node<E> last;
        if(isEmpty()){
            last = new Node<E>(element, null, null);
            this.head = last;
            this.tail = last;
        } else {
            last = new Node<E>(element, tail, null);
            this.tail.setNext(last);
            this.tail = last;
        }
        this.size += 1;
    }

    /**
     * @return the removed head node
     */
    public E removeFirst() {
        if(!isEmpty()) {
            E first = this.head.getElement();
            if(this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.getNext();
                this.head.setPrevious(null);
            }
            this.size -= 1;
            return first;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return the removed tail node
     */
    public E removeLast() {
        if(!isEmpty()) {
            E last = this.tail.getElement();
            if(this.size == 1) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail = this.tail.getPrevious();
                this.tail.setNext(null);
            }
            this.size -= 1;
            return last;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @param position
     * @return the element in the node at the specified position.
     */
    public E get(int position) {
        if (isEmpty() || position <= 0 || position > size) {
            throw new IllegalArgumentException();
        }

        Node<E> current = getNodeByPosition(position);
        return current.getElement();
    }

    /**
     * Remove the node at the numeric position specified
     * @param position
     * @return the removed node
     */
    public E remove(int position) {
        if(isEmpty() || position <= 0 || position > size) {
            throw new IllegalArgumentException();
        }

        Node<E> currentNode = getNodeByPosition(position);
        Node<E> prevNode = currentNode.getPrevious();
        Node<E> nextNode = currentNode.getPrevious();
        if(currentNode == head) {
            return removeFirst();
        }

        if(currentNode == tail) {
            return removeLast();
        }

        E oldElement = currentNode.getElement();
        prevNode.setNext(nextNode);
        nextNode.setPrevious(prevNode);
        this.size -= 1;
        return oldElement;
    }

    /**
     * Change specified node to element in parameter
     * @param element
     * @param position
     */
    public E set(E element, int position) {
        if(isEmpty() || position <= 0 || position > size) {
            throw new IllegalArgumentException();
        }

        Node<E> current = getNodeByPosition(position);
        E oldElement = current.getElement();
        current.setElement(element);
        return oldElement;
    }

    /**
     * Add new element after the node at the provided position
     * @param element
     * @param position
     * @return the new element node
     */
    public void addAfter(E element, int position) {
        if(isEmpty() || position <= 0 || position > size) {
            throw new IllegalArgumentException();
        }

        Node<E> currentNode = getNodeByPosition(position);
        Node<E> nextNode = currentNode.getNext();
        Node<E> newNode = new Node<E>(element, currentNode, nextNode);

        currentNode.setNext(newNode);
        if (currentNode == tail) {
            tail = newNode;
        }
        else {
            nextNode.setPrevious(newNode);
        }
        this.size += 1;
    }

    /**
     * Add new element before the node at the provided position
     * @param element
     * @param position
     */
    public void addBefore(E element, int position) {
        if(isEmpty() || position <= 0 || position > size) {
            throw new IllegalArgumentException();
        }

        Node<E> currentNode = getNodeByPosition(position);
        Node<E> prevNode = currentNode.getPrevious();
        Node<E> newNode = new Node<E>(element, prevNode, currentNode);

        currentNode.setPrevious(newNode);
        if(currentNode == head){
            head = newNode;
        } else {
            prevNode.setNext(newNode);
        }
        this.size += 1;
    }

    /**
     * Add new element after the node containing the 'oldElement' specified.
     * @param element
     * @param oldElement
     */
    public void addAfter(E element, E oldElement) {
        if(oldElement == null) {
            throw new NullPointerException();
        }

        if(isEmpty() || getNodeByElement(oldElement).getElement() != oldElement) {
            throw new IllegalArgumentException();
        }

        Node<E> currentNode = getNodeByElement(oldElement);
        Node<E> nextNode = currentNode.getNext();
        Node<E> newNode = new Node<E>(element, currentNode, nextNode);

        currentNode.setNext(newNode);
        if (currentNode == tail) {
            tail = newNode;
        }
        else {
            nextNode.setPrevious(newNode);
        }
        this.size += 1;
    }

    /**
     * Add new element before the node containing the 'oldElement' specified.
     * @param element
     * @param oldElement
     */
    public void addBefore(E element, E oldElement) {
        if(oldElement == null) {
            throw new NullPointerException();
        }

        if(isEmpty() || getNodeByElement(oldElement).getElement() != oldElement) {
            throw new IllegalArgumentException();
        }

        Node<E> currentNode = getNodeByElement(oldElement);
        Node<E> prevNode = currentNode.getPrevious();
        Node<E> newNode = new Node<E>(element, prevNode, currentNode);

        currentNode.setPrevious(newNode);
        if(currentNode == head){
            head = newNode;
        } else {
            prevNode.setNext(newNode);
        }
        this.size += 1;
    }

    /**
     * @param element
     * @return the element in the node containing the element specified.
     */
    public E get(E element){
        if(isEmpty() || getNodeByElement(element).getElement() != element) {
            throw new IllegalArgumentException();
        }
        Node<E> current = getNodeByElement(element);
        return current.getElement();
    }

    /**
     * Remove the node containing the element specified.
     * @param element
     * @return the removed node.
     */
    public E remove(E element){
        if(isEmpty() || getNodeByElement(element).getElement().compareTo(element) != 0) {
            throw new IllegalArgumentException();
        }

        Node<E> currentNode = getNodeByElement(element);
        Node<E> prevNode = currentNode.getPrevious();
        Node<E> nextNode = currentNode.getNext();
        if(currentNode == head) {
            return removeFirst();
        }

        if(currentNode == tail) {
            return removeLast();
        }

        E oldElement = currentNode.getElement();
        prevNode.setNext(nextNode);
        nextNode.setPrevious(prevNode);
        this.size -= 1;
        return oldElement;
    }

    /**
     * Change element on the node containing the 'oldElement' with the element passed.
     * @param element
     * @param oldElement
     * @return the old element.
     */
    public E set(E element, E oldElement){
        if(oldElement == null) {
            throw new NullPointerException();
        }

        if(isEmpty() || getNodeByElement(oldElement).getElement().compareTo(oldElement) != 0) {
            throw new IllegalArgumentException();
        }

        Node<E> current = getNodeByElement(oldElement);
        current.setElement(element);
        return oldElement;
    }

    /**
     * Add the element into the linked list in natural ascending order.
     * @param element
     */
    public void insert(E element){
        Node<E> newNode = new Node<E>(element, null, null);
//        sortAscending();
        Node<E> current = head;

        if(isEmpty()) {
            addFirst(element);
        } else if(current.getElement().compareTo(newNode.getElement()) >= 1) {
            newNode.setNext(current);
            current.setPrevious(newNode);
            head = newNode;
            this.size += 1;
        } else {
            Node<E> nextNode = current.getNext();

            while(nextNode != null && nextNode.getElement().compareTo(element) < 0) {
                current = nextNode;
                nextNode = nextNode.getNext();
            }

            current.setNext(newNode);
            newNode.setPrevious(current);
            if(current == tail){
                tail = newNode;
            }

            if(nextNode != null) {
                nextNode.setPrevious(newNode);
                newNode.setNext(nextNode);
            }
            this.size += 1;
        }
    }

    /**
     * Sort elements into ascending order.
     */
    public void sortAscending(){
        Node<E> current = head;
        int index = 0;

        while (current != null && index <= size && size > 1){
            if(current.getNext() == null){
                index++;
                current = head;
            } else if(current.getElement().compareTo(current.getNext().getElement()) > 0) {
                E tempElement = current.getElement();
                current.setElement(current.getNext().getElement());
                current.getNext().setElement(tempElement);
            }

            if(current.getElement().compareTo(current.getNext().getElement()) <= 0) {
                current = current.getNext();
            }
        }
    }

    /**
     * Loops through linked list till Node is found at specified position.
     * @param position
     * @return Node at specified position.
     */
    private Node<E> getNodeByPosition(int position) {
        Node<E> current = this.head;
        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Loops through linked list till Node is found with specified element.
     * @param element
     * @return Node containing specified element.
     */
    private Node<E> getNodeByElement(E element) {
        Node<E> current = this.head;
        while (current.getNext() != null && current.getElement().compareTo(element) != 0){
            current = current.getNext();
        }
        return current;
    }
}
