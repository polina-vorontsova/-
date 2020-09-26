package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.fillListAuto();   //заполняет список 10-ю случайными абонентами и случайными номерами для каждого абонента
        list.print();

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ФИО для поиска: ");
        String name = scan.nextLine();
        PhonesList phList = list.searchByName(name);
        phList.print();

        System.out.println("Введите номер для поиска: ");
        String number = scan.nextLine();
        if(list.searchByNumber(number) == null){
            System.out.println("Номера в списке не существует");
        }else{
            System.out.println(list.searchByNumber(number));
        }

    }
}