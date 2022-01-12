//author: Damandeep Singh

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class Program6 {
    public static void main(String[] args) {
        //Some tests
        SinglyLinkedList list = new SinglyLinkedList();
        list.append("This");
        list.append("is");
        list.append("programming");
        list.append("assignment");
        list.append("programming");
        list.append("number");
        list.append("6");

        System.out.println(list);
        list.clear();
        System.out.println(list);



    }
}
    class SinglyLinkedList {
        Node head;
        int size;

        //inner class -Node
        class Node {
            //instance variables
            String data;
            Node next;

            //constructor for Node
            public Node(String data) {
                this.data = data;
                next = null;
            }
        }

        //constructor for linked list
        public SinglyLinkedList() {
            head = null;
            size = 0;
        }

        /**
         * TODO: implement get() method
         * Get data at specified index, return null if cannot get the data.
         */
        public String get(int index){
            //Your implementation goes here
            Node temp = head;
            int count = 0;

            while(temp != null){
                if(count == index){
                    return temp.data;
                }
                count++;
                temp = temp.next;
            }

            return null;
        }

        /**
         * TODO: implement set() method
         * Set data at specified index, return true if set successfully, false otherwise
         */
        public boolean set(String data, int index){
            //Your implementation goes here
            if(index > size()){
                return false;
            }
            else {
                boolean flag = insert(data, index);
                return flag;
            }

            }



        /**
         * TODO: implement delete() method
         * Remove the FIRST node that contains specified data, return the data of the removed node.
         * Return null if nothing is removed.
         */
        public String delete(String data){
            if(contains(data)){
                int index = find(data);
                String delete = remove(index);
                return delete;

            }
            else {
                return null;
            }


        }

        /**
         * TODO: implement clear() method
         * Removes all elements from this linked list.
         */
        public void clear(){
            //Your implementation goes here
            head = null;


        }

        /**
         * TODO: implement toArray() method
         * Convert the current linked list to array.
         * Return the converted array.
         * Return null if the linked list is empty.
         */
        public String[] toArray(){
            String[] arr = new String[size()];
            //Your implementation goes here
            Node temp = head;
            if(temp == null)
            return null;
            else{
                for(int i = 0; i < arr.length; i++){
                        arr[i] = get(i);
                }
            }
            return arr;

        }

        /**
         * TODO: implement peekFirst() method
         * Returns the first element in the linked list, null if the list is empty.
         */
        public String peekFirst(){
            //Your implementation goes here
            if (head == null){
                return null;
            }
            return head.data;
        }

        /**
         * TODO: implement peekLast() method
         * Returns the last element in the linked list, null if the list is empty.
         */
        public String peekLast(){
            //Your implementation goes here
            if(head == null) {
                return null;
            }
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;

            }
            return temp.data;
        }

        /**
         * TODO: implement contains() method
         * Returns true if a node with specified data is in the linked list, false otherwise.
         */
        public boolean contains (String data){
            //Your implementation goes here
            Node temp = head;
            while (temp != null){
                if(temp.data.equals(data)){
                    return true;
                }
                temp = temp.next;
            }
            return false;

        }

        /**TODO: =============EXTRA CREDIT===============
         * implement jumpingLinkedList() method
         * This method shall print linkedlist using the following pattern
         * If size is even (e.g. 6), print data at indices 0,2,4,5,3,1.
         * If size is odd (e.g. 5), print data at indices 0,2,4,3,1.
         *
         * E.g. ["This", "is", "a", "linked", "list"]
         * Output:
         * This
         * a
         * list
         * linked
         * is
         *
         * Hint: use recursion
         */
        public void jumpingLinkedList() {
           helper(head);
            //Your implementation goes here
        }

        /**
         * TODO: Helper recursive method for jumpingLinkedList
         * @param curr
         */
        private void helper(Node curr){
           if(curr != null){
               System.out.println(curr.data);
               if(curr.next != null){
                   helper(curr.next.next);
                   System.out.println(curr.next.data);

               }
           }



            //Your implementation goes here
        }

        public void append(String data) {
            Node newNode = new Node(data);
            //if the list is empty
            if (size == 0) {
                head = newNode;
            }else{
                Node node = head;
                while(node.next != null){
                    node = node.next;
                }
                node.next = newNode;
            }
            size++;
        }

        public boolean insert(String data, int index) {
            //check for valid input
            if (index > size || index < 0) {
                return false;
            }

            if (index==size || size == 0){
                append(data);
                return true;
            }

            //the node that we're gonna insert
            Node newNode = new Node(data);

            //if index is equal to 0
            if (index == 0) {
                newNode.next = head;
                head = newNode;
                size++;
                return true;
            }

            //create a frontNode and rearNode for traversing
            Node frontNode = head;
            Node rearNode = head.next;
            for (int i = 0; i < index - 1; i++) {
                frontNode = frontNode.next;
                rearNode = rearNode.next;
            }
            //now, frontNode is one less than index, and rearNode is equal to index.
            //let's insert newNode in between frontNode and rearNode
            frontNode.next = newNode;
            newNode.next = rearNode;
            size++;
            return true;

        }


        public String remove(int index) {
            //invalid index
            if (index >= size) {
                return "";
            }

            Node removedNode;

            //if there's one element
            if (size == 1) {
                removedNode = head;
                head = null;
                size--;
                return removedNode.data;
            }

            //if we want to remove the head
            if (index == 0) {
                removedNode = head;
                head = head.next;
                size--;
                return removedNode.data;
            }

            Node frontNode = head;
            Node rearNode = head.next;

            for(int i = 0; i < index - 1; i++) {
                frontNode = frontNode.next;
                rearNode = rearNode.next;
            }

            removedNode = rearNode;
            rearNode = rearNode.next;
            frontNode.next = rearNode;
            size--;

            return removedNode.data;
        }

        public int find (String data){
            //if list is empty, return -1
            if(size == 0){
                return -1;
            }

            //Create a tempNode for list traversal
            Node tempNode = head;

            //Keep track of list index
            int index = 0;

            //iterate through the list until data are equal
            do{
                //check if data are equal. If so, return the index
                if(tempNode.data.equals(data)) {
                    return index;
                }
                tempNode = tempNode.next; //update tempNode to be its next
                index++; //increment index
            }while(tempNode != null);

            //if nothing found, return -1
            return -1;
        }

        public int size() {
            return size;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node tempNode = head;

            //let the tempNode to be the next one until it reaches to null
            while(tempNode!=null && tempNode.next!=null){
                sb.append("\""+tempNode.data + "\", ");
                tempNode = tempNode.next;
            }
            if(tempNode!=null){
                sb.append("\""+tempNode.data+"\"");
            }
            sb.append("]");

            return sb.toString();
        }
    }


