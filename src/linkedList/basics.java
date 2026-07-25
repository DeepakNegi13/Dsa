package linkedList;


//Node of the linked list
class node{
    int val; // default zero
    node next; // default value null
    node(int val){
        this.val = val;
    }
}
//User define data structure linked list
class Linkedlist{
    private node head;
    private node tail;
    private int size;
    Linkedlist(){
        head = tail = null;
    }
    //add element in the tail new node
    public void addAtTail(int n){
        node temp = new node(n);
        if(head == null){
            head = tail = temp;

        }else{
            tail.next = temp;
            tail = temp;

        }
        size++;
    }
    //add at front
    public void addAtHead(int val){
        node temp = new node(val);
        if(head == null){
            head = tail = temp;

        }else{
            temp.next = head;
            head = temp;

        }
        size++;
    }
    //display
    public void display(){
        node temp =  this.head;
        if(head==null) return ;
        while (temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    //delete at head
    public void deleteAtHead(){
        if(this.head == null) return;
        this.head = this.head.next;
        if(head == null) tail = head;
        size--;
    }
    //delete at tail
    public void deleteAtTail(){
        if(tail==null) return;
        if(head==tail) {
            head = tail = null;
            return;
        }
        node temp = head;
        while (temp.next != tail){
            temp = temp.next;
        }
        this.tail = temp;
        this.tail.next = null;
        size--;
    }
    //length of the linkedList
    public int length(){
        return size;
    }
    //isExist
    public boolean isExist(int val){
        node temp = this.head;
        while(temp != null){
            if (temp.val == val) return true;
            temp = temp.next;
        }
        return false;
    }
    //search
    public int search(int val){
        int count = 0;
        node temp = this.head;
        while(temp != null){
            if (temp.val == val) return count;
            temp = temp.next;
            count++;
        }
        return -1;
    }
    //insert at particular index
    public void insert(int index,int val){
        node temp = new node(val);
        try{
            if(index == 0){
                this.addAtHead(val);
                size++;
                return;
            }
            if(index == size-1){
                this.addAtTail(val);
                size++;
                return;
            }
            node tempHead = head;
            for(int i = 1;i<index;i++){
                tempHead = tempHead.next;
            }
            temp.next = tempHead.next;
            tempHead.next = temp;

        } catch (NullPointerException e) {
            System.out.println("Error: Index not found");
        }

    }
    //get function
    public int get(int index){

        try{
            node temp = head;
            for(int i = 1;i<=index;i++){
                temp = temp.next;
            }
            return temp.val;

        } catch (NullPointerException e) {
            System.out.println("index out of bound");
        }
        return Integer.MIN_VALUE;
    }
    //delete at index
    public void delete(int index){
        try{
            node temp = head;
            for(int i = 1;i<index;i++){
                temp = temp.next;
            }
            if(index==0) {
                this.deleteAtHead();
                return;
            }
            if(index == size-1){
                this.deleteAtTail();
                return;
            }
            temp.next = temp.next.next;
            size--;

        } catch (NullPointerException e) {
            System.out.println("index out of bound");
        }

    }
}

public class basics {
    static void main(String[] args) {

    }


}
