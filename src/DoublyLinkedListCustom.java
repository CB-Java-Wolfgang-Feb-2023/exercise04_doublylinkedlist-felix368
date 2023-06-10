import java.util.Random;
public class DoublyLinkedListCustom implements MyListInterface {
    private Node head;
    private Node tail;

    //TODO implement methods

    @Override
    public void addFirst(int item) {
        Node newNode = new Node(item);
        // 1. [ ]
        if (isEmpty()) {
            head = tail = newNode;

        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

    }

    @Override
    public void addLast(int item) {
        Node newNode = new Node(item);
        // 1. [ ]
        if (isEmpty()) {
            head = tail = newNode;

        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public void addAtIndex(int index, int item) {
        int size = getSize();
        if(index < 0 && index >= size){
            throw new IllegalArgumentException("pleas give me a index between 0 and " + (size));
        }

        if(index == 0){
            Node newNode = new Node(item);
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }else if(index == size ){
            Node newNode = new Node(item);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;

        }else{

            Node currentNode = head;
            for (int NodeIndex = 0; NodeIndex < index; NodeIndex++) {
                currentNode = currentNode.getNext();

            }

            Node newNode = new Node(item);
            newNode.setNext(currentNode);
            newNode.setPrev(currentNode.getPrev());
            currentNode.setPrev(newNode);

            Node beforeNode = newNode.getPrev();
            beforeNode.setNext(newNode);
        }








    }

    @Override
    public void addElementAtRandomIndex(int value) {
        Random rand = new Random();
        int int_random = rand.nextInt(getSize());
        addAtIndex(int_random,value);

    }

    @Override
    public Node removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("the list in empty");
        }

        if (head == tail){
            head = null;
            tail = null;
            return null;
        }else {
            Node oldHead = head;
            head = head.getNext();
            head.setPrev(null);
            return oldHead;
        }

    }

    @Override
    public Node removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("the list in empty");
        }

        if (head == tail){
            head = null;
            tail = null;
            return null;
        }else {
            Node oldTail = tail;
            tail = tail.getPrev();
            tail.setNext(null);
            return oldTail;
        }

    }

    @Override
    public Node removeAtIndex(int index) {

        int size = getSize();
        if(index < 0 || index > size-1){
            throw new IllegalArgumentException("pleas give me a index between 0 and " + (size -1));
        }

        if(index == 0){
            Node oldHead = head;
            head = head.getNext();
            head.setPrev(null);
            return oldHead;

        }else if(index == size -1 ){
            Node oldTail = tail;
            tail =tail.getPrev();
            tail.setNext(null);
            return oldTail;

        }else{
            Node currentNode = head;
            for (int NodeIndex = 0; NodeIndex < index; NodeIndex++) {
                currentNode = currentNode.getNext();

            }

            Node nodeBefore = currentNode.getPrev();
            Node afterNode = currentNode.getNext();

            nodeBefore.setNext(afterNode);
            afterNode.setPrev(nodeBefore);
            return currentNode;
        }
    }



    @Override
    public int getSize() {

        Node currentNode = head;
        int nodeCounter = 0;
        while (currentNode !=null){
            currentNode = currentNode.getNext();
            nodeCounter += 1;
        }
        return nodeCounter;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void printList() {
        Node currentNode = head;

        while (currentNode != null){
            System.out.print(currentNode.getValue());

            if(currentNode.getNext() != null){
                System.out.print(", ");
            }
            currentNode = currentNode.getNext();
        }
        System.out.println();

    }

    @Override
    public void printListBackwards() {
        Node currentNode = tail;

        while (currentNode != null){
            System.out.print(currentNode.getValue());

            if(currentNode.getPrev() != null){
                System.out.print(", ");
            }
            currentNode = currentNode.getPrev();
        }
        System.out.println();

    }

    @Override
    public int get(int index) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public void removeDuplicates() {

        Node currentNode = head;
        while (currentNode != null){

            int nodeValue = currentNode.getValue();
            Node checkNode = head;
            while (checkNode != null){

                if(checkNode.getValue() == nodeValue && checkNode != currentNode){

                    if(checkNode.getPrev() == null){
                        head =checkNode.getNext();
                    }
                    else if(checkNode.getNext() == null){
                        tail = checkNode.getPrev();

                    }else {
                        Node nodeBefore = checkNode.getPrev();
                        Node afterNode = checkNode.getNext();

                        nodeBefore.setNext(afterNode);
                        afterNode.setPrev(nodeBefore);
                    }

                }
                checkNode = checkNode.getNext();
            }


            currentNode = currentNode.getNext();
        }

    }

    @Override
    public void reverseList() {

        Node currentNode = head;
        while (currentNode != null){

            Node nodePrev = currentNode.getPrev();
            Node nodeNext = currentNode.getNext();

            currentNode.setPrev(nodeNext);
            currentNode.setNext(nodePrev);

            currentNode = currentNode.getPrev();
        }
        Node oldTail = tail;
        tail = head;
        head = oldTail;
    }

    @Override
    public DoublyLinkedListCustom copyList() {
        return this;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;

    }

    @Override
    public boolean insertAfter(int key, int data) {
        addAtIndex(key+1,data);
        return true;
    }

}

