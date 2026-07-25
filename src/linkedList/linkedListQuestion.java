package linkedlist;
class Node {
    int data;
    Node next;
    Node(int x) { data = x;}
}
public class linkedListQuestion {
    //detect loop
    public static boolean detectLoop(Node head) {
        try{
            Node temp = head;
            while(temp!=null){
                temp = temp.next;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(1);
        Node d = new Node(1);
        Node e = new Node(1);
        Node f = new Node(1);
        Node g = new Node(1);
        Node h = new Node(1);
        Node i = new Node(1);
        Node j = new Node(1);
        Node k = new Node(1);
        Node l = new Node(1);


        Node a_ = new Node(1);
        Node b_ = new Node(1);
        Node c_ = new Node(1);
        Node d_ = new Node(1);
        Node e_ = new Node(1);
        Node f_ = new Node(1);
        Node g_ = new Node(1);
        Node h_ = new Node(1);
        Node i_ = new Node(1);
        Node j_ = new Node(1);
        Node k_ = new Node(1);
        Node l_ = new Node(1);
        //        a.next = a;
//        System.out.println(detectLoop(a));
    }
}
