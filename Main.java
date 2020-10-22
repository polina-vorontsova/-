package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args){
        CombiQ cQ = new CombiQ();
        Random rand = new Random();

        //Заполняем комбинированную очередь 1000 пакетами
        for (int i = 0; i < 1000; i++) {
            long info = rand.nextInt(200);  // случ. число от [0;200)
            long type = rand.nextInt(5);    // случ. число от [0;5)
            cQ.insert(new Data(info, type)); // вставка
        }

        System.out.println("Проверка поиска в очереди");
        //Ищем данные в очереди
        cQ.insert(new Data(-4,0));
        System.out.println(cQ.find(-4));       // успешно
        cQ.insert(new Data(-11, 1));
        System.out.println(cQ.find(-11));       // успешно
        System.out.println(cQ.find(-13));       // безуспешно(null)
        cQ.insert(new Data(-13, 2));
        System.out.println(cQ.find(-13));       // успешно
        System.out.println(cQ.find(-256));      // безуспешно(null)
        cQ.insert(new Data(-100, 3));
        System.out.println(cQ.find(-100));      // успешно
        System.out.println(cQ.find(-1));        // безуспешно(null)
        cQ.insert(new Data(-220, 4));
        System.out.println(cQ.find(-220));      // успешно
        System.out.println(cQ.find(-22));        // безуспешно(null)
        System.out.println(cQ.find(-7));        // безуспешно(null)
        System.out.println(cQ.find(-1));        // безуспешно(null)


        System.out.println("\n\n\n");

        System.out.println("Проверка обработки данных в очереди");
        while (!cQ.isEmpty()) {
            cQ.process();
            System.out.println("-----------------------------------------------------------------");
        }
        cQ.process();   // показываем, что извлекать больше нечего
    }

}
