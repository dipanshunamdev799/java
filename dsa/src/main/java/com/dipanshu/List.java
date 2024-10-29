package com.dipanshu;

/*
 * This is a singly link list implemenatation.
 */
public class List {
    private Node head;
    private Node tail;
    private Integer size = 0;
    // single node constructor
    List(Integer val){
        head = new Node(val);
        tail = head;
        size++;
    }
    // array values constructor
    List(Integer[] values){
        size+= values.length;
        for(Integer i=0; i<values.length; i++){
            if(head==null){
                head = new Node(values[i]);
                tail = head;
            }else{
                tail.next = new Node(values[i]);
                tail = tail.next;
            }
        }
    }
    List(int[] values){
        size+= values.length;
        for(int i=0; i<values.length; i++){
            if(head==null){
                head = new Node(values[i]);
                tail = head;
            }else{
                tail.next = new Node(values[i]);
                tail = tail.next;
            }
        }
    }
    //prints the list values
    public void printList(){
        if(head==null){
            System.out.println();
            return;
        }else{
            Node temp = head;
            for(Integer i=0; i<size; i++){
                System.out.print(temp.val);
                temp = temp.next;
            }
            System.out.println("");
        }
    }
    public void pushBack(Integer val){
        //add the value in the back of the list
        size++;
        if(head==null){
            head = tail = new Node(val);
        }else{
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
    public void popBack(){
        //pops the value from back if it is there
        if(head==null) return;
        else{
            size--;
            if(head==tail){
                head = tail = null;
            }else{
                Node temp = head;
                while(temp.next != tail){
                    temp = temp.next;
                }
                tail = temp;
            }
        }
    }
    public void popFront(){
        //push the given value in the front of the list
        if(head==null) return;
        else{
            size--;
            if(head==tail){
                head = tail = null;
            }else{
                head = head.next;
            }
        }
    }
    public void pushFront(Integer val){
        //pops the value form the front(head) of the list
        size++;
        if(head==null){
            head = tail = new Node(val);
        }else{
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
        }
    }
    public Integer getHeadValue(){
        // get the head value
        if(head==null){
            return -1;
        }else{
            return head.val;
        }
    }
    public Integer getTailValue(){
        //get the tail value
        if(head==null){
            return -1;
        }else{
            return tail.val;
        }
    }
    public boolean isEmpty(){
        // return true if the list is empty
        return size==0;
    }
    public Node getHead() {
        // returns back the head node of the list
        return head;
    }
    public Node getTail() {
        // returns back the tail node of the list
        return tail;
    }
    public Integer getSize(){
        // returns the size of the link list
        return size;
    }
}
