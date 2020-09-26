package com.company;

import java.util.Random;
import java.util.Scanner;

public class LinkedList {
    Node head;

    public class Node {
        String name;
        String number;
        Node next;

        Node(String name, String number) {
            this.name = name;
            this.number = number;
            next=null;
        }
    }

    void fillListAuto() {
        Random random = new Random();
        String[] names = {"Воронцова П.В.", "Селюк Д.Д.", "Доведько Д.Ю.", "Ахмед А.Н.", "Живлюк И.С.", "Коваленок К.В.", "Пинчук Л.Г."};
        for (int i = 0; i < 7; i++) {
            String name = names[i];
            String number = "";
            for(int k = 0; k < 7; k++){
                number += Integer.toString(random.nextInt(10));
            }
            this.add(name, number);
        }
    }

    void add(String name, String number) {
        Node new_node = new Node(name, number);
        if(this.head == null){
            new_node.next = null;
            this.head = new_node;
            return;
        }
        Node currNode = this.head;
        Node prevNode = null;
        while (currNode != null) {
            if(compareStrings(currNode.name, name)){
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(prevNode == null){
            new_node.next = currNode;
            this.head = new_node;
            return;
        }
        prevNode.next = new_node;
        new_node.next = currNode;
    }

    void print() {
        Node currNode = this.head;
        while (currNode != null) {
            System.out.println("ФИО абонента: " + currNode.name + "   НОМЕР: " + currNode.number);
            currNode = currNode.next;
        }
    }

    int size(){
        Node currNode = this.head;
        int size = 0;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }
        return size;
    }

    Node getByIndex(int index){
        Node currNode = this.head;
        int ind = 0;
        while ((ind != index)&&(currNode != null)) {
            ind++;
            currNode = currNode.next;
        }
        if(currNode!=null){
            return currNode;
        }
        throw new IndexOutOfBoundsException();
    }

    boolean compareStrings(String str1, String str2){
        int min = Math.min(str1.length(), str2.length());
        for(int i = 0; i < min; i++){
            if(str1.charAt(i) > str2.charAt(i)){
                return true;
            }
            if(str1.charAt(i) < str2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    PhonesList searchByName(String name){
        boolean found = false;
        PhonesList List = new PhonesList();
        for (int i = 0; i < this.size(); i++) {
            if (this.getByIndex(i).name.equals(name)) {
                List.add(this.getByIndex(i).number);
                found = true;
            }
        }
        if(!found){
            System.out.println("Данного имени в списке не существует!!!");
        }
        return List;
    }

    String searchByNumber(String number) {
        for (int i = 0; i < this.size(); i++) {
            if (this.getByIndex(i).number.equals(number)) {
                return this.getByIndex(i).name;
            }
        }
        return null;
    }
}