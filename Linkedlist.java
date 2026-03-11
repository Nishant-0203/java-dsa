import java.util.*;
public class Linkedlist {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    Node tail;

    int size;
    public void insertatstart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }
    public void insertatlast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void insertatkth(int data,int k){
        Node temp=getkthNode(k);
        Node newNode=new Node(data);
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
    public Node getkthNode(int k){
        Node temp=head;
        for(int i=1;i<k;i++){
            temp=temp.next;
        }
        return temp;
    }
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
}
public static void main(String[] args) {
    Linkedlist list = new Linkedlist();
    list.insertatstart(5);
    list.insertatlast(10);
    list.insertatstart(11);
    list.insertatlast(20);  
    list.insertatkth(15, 3);

    list.display();
}
}