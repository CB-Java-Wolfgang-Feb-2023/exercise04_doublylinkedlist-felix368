public class Main {
    public static void main(String[] args) {

        //TODO test all methods
        // don't forget to also check the head and tail references

        DoublyLinkedListCustom myList = new DoublyLinkedListCustom();


        for (int i = 0; i < 20; i++) {
            myList.addFirst(19-i);
        }


        for (int i = 0; i < 8; i++) {
            myList.removeFirst();
            myList.removeLast();
        }




        for (int i = 0; i < 5; i++) {
            myList.addLast(i + 30);
        }
        myList.printList();

        myList.addAtIndex(0,5);
        myList.printList();

        for (int i = 0; i < 10; i++) {
            myList.addElementAtRandomIndex(i);
        }

        myList.clear();

        for (int i = 0; i < 10; i++) {
            myList.addLast(i );
        }
        myList.printList();

        myList.removeAtIndex(9);
        myList.printList();

        myList.reverseList();
        myList.printList();
        myList.removeLast();
        myList.printList();
        myList.removeFirst();
        myList.printList();


    }

    }
