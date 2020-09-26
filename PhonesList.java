package com.company;


public class PhonesList {
    Node head;

    class Node {
        String number;
        Node next;

        Node(String n) {
            number = n;
            next=null;
        }
    }

    public void add(String number) {
        Node newNode = new Node(number);
        newNode.next = null;
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    public void print() {
        Node current = this.head;
        while (current != null) {
            System.out.print("Номер: ");
            System.out.print(current.number + "\n");
            current = current.next;
        }
    }
}