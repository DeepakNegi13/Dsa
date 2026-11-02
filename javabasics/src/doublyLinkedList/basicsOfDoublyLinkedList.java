package doublyLinkedList;
class Node{
    int data;
    Node next;
    Node previous;
    Node(int data,Node next,Node previous ){
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
    Node(int data){
        this.data = data;
    }
}
public class basicsOfDoublyLinkedList {

    //array to linked list method
    public static Node arrToLinkedList(int[] arr){

//        Node currentNode = head;
        Node temp = new Node(arr[0]);
        Node head = temp;

        for(int i=1 ; i<arr.length;i++) {
            Node temp2 = new Node(arr[i]);
            temp.next = temp2;
            temp2.previous = temp;
            temp = temp2;
        }

        return head;
    }

    //to display all the elem in linked list
    public static void display(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }

    }

    //delete head of the linkedList
    public static Node deleteHead(Node head) {
        if(head==null) return head;
        if(head.next==null) return null;
        head = head.next;
        head.previous.next = null;
        head.previous = null;
        return head;
    }

    //delete tail of the Linked List
    public static Node deleteTail(Node head){
        if(head==null) return head;
        if(head.next==null) return null;
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.previous.next = null;
        temp.previous = null;
        return head;
    }

    //delete nth Node(index start from Zero)
    public static Node deleteNthNode(Node head,int idx){
        if(head==null||head.next==null) return null;
        Node temp = head;
        for(int i = 0;i<idx;i++){
            temp = temp.next;
        }
        if(temp.next==null) return deleteTail(head);
        if(temp.previous==null) return deleteHead(head);
        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
        temp.next = null;
        temp.previous = null;
        return head;
    }

    //delete the given Node (Note : Node is not head)
    public static void deletGivenNode(Node temp){
        temp.previous.next = temp.next;
        if(temp.next==null){
            temp.previous = null;
            return;
        }

        temp.next.previous = temp.previous;
        temp.next = null;
        temp.previous = null;
    }

    //insert the Node before the head
    public static Node insertBeforeHead(Node head,int data){

        Node temp = new Node(data);
        if(head==null) return temp;
        temp.next = head;
        head.previous = temp;
        head = temp;
        return head;
    }

    //insert Node after the tail
    public static Node insertAfterTail(Node head,int data){
        Node temp = new Node(data);
        if(head==null) return temp;
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        tail.next = temp;
        temp.previous = tail;
        return head;
    }

    //insert nth index(idx start from zero)
    public static Node insertAtAnIdx(Node head,int data,int idx){
        if(idx==0) return insertBeforeHead(head,data);
        Node newNode = new Node(data);
        Node temp = head;
        for(int i = 1;i<idx;i++){
            temp = temp.next;
        }
        if(temp.next==null) return insertAfterTail(head,data);
        Node temp2 = temp.next;
        temp.next = newNode;
        newNode.previous = temp;
        newNode.next = temp2;
        temp2.previous = newNode;
        return head;
    }

    //insert before the given node (given Node is not equals to head)
    public static void insertBeforeTheNode(Node temp,int data){
        Node newNode = new Node(data);
        temp.previous.next = newNode;
        newNode.previous = temp.previous;
        newNode.next = temp;
        temp.previous = newNode;
    }

    //reverse doubly linked list
    public Node reverseDLL(Node head) {
        // Your code goes here
        Node node = head;
        while(node!=null){
            Node temp = node.next;
            node.next = node.previous;
            node.previous = temp;
            if(node.previous == null) break;
            node = node.previous;
        }
        head = node;
        return head;

    }
    //main function
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = arrToLinkedList(arr);
        display(head);
        System.out.println();
        head = insertBeforeHead(head,8);
        display(head);
        System.out.println();
        head = insertAfterTail(head,8);
        display(head);
        System.out.println();
        head = insertAtAnIdx(head,8,6);
        display(head);
        System.out.println();
        insertBeforeTheNode(head.next.next,6);
        display(head);



    }
}
