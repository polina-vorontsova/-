package com.company;

//Класс - очередь с комбинированным алгоритмом обработки

public class CombiQ {

    private PriorityQueue PriorityQ;//Приоритетная очередь
    private WeightedQueue[] WeightedQ;//Массив для хранения четырех взвешенных очередей

    private final long dataFlow = 50;
    private final long pqCapacity = 40;//Из приоритетной очереди - извлечение 40% от пропускной способности всей очереди
    private final long wqCapacity = 100 - pqCapacity; //Из взвешенных очередей - 60% от пропускной способности всей очереди
    private final long wqSize = 4;    // 4 взвешенные очереди

    public CombiQ(){
        WeightedQ = new WeightedQueue[(int)wqSize];
        WeightedQ[0] = new WeightedQueue(10);  //10 процентов
        WeightedQ[1] = new WeightedQueue(20);  //20 процентов
        WeightedQ[2] = new WeightedQueue(30);  //30 процентов
        WeightedQ[3] = new WeightedQueue(40);  //40 процентов
        PriorityQ = new PriorityQueue();
    }

    //Вставка в очередь
    public void insert(Data d){
        int type = (int) d.getType();
        switch (type) {
            case 0:
                WeightedQ[0].pushBack(d);
                break;
            case 1:
                WeightedQ[1].pushBack(d);
                break;
            case 2:
                WeightedQ[2].pushBack(d);
                break;
            case 3:
                WeightedQ[3].pushBack(d);
                break;
            case 4:
                PriorityQ.insert(d);
                break;
        }
    }

    //Проверка на отсутствие элементов в комбинированной очереди
    public boolean isEmpty(){
        return WeightedQ[0].getSize() == 0 &&  WeightedQ[1].getSize() == 0 &&
                WeightedQ[2].getSize() == 0 &&  WeightedQ[3].getSize() == 0 &&  PriorityQ.getSize() == 0;
    }

    //Обработка хранимых в очереди пакетов данных
    public void process(){
        long fullCapacity = Math.round(dataFlow * wqCapacity / 100.0);
        Data[] fromWQ0 = WeightedQ[0].remove(fullCapacity);
        Data[] fromWQ1 = WeightedQ[1].remove(fullCapacity);
        Data[] fromWQ2 = WeightedQ[2].remove(fullCapacity);
        Data[] fromWQ3 = WeightedQ[3].remove(fullCapacity);

        Data[] fromPQ  = PriorityQ.remove(Math.round(dataFlow * pqCapacity / 100.0));
        printData("WQ0", fromWQ0);
        printData("WQ1", fromWQ1);
        printData("WQ2", fromWQ2);
        printData("WQ3", fromWQ3);
        printData("PriorityQ", fromPQ);
    }

    //Поиск пакета по содержимому в очереди
    public Data find(long info){
        Data result;
        for (int i = 0; i < 4; i++) {
            result = WeightedQ[i].find(info);
            if (result != null)
                return result;
        }
        result = PriorityQ.find(info);
        return result;
    }


    private void printData(String type, Data[] arr){
        if (arr.length == 0){
            System.out.println("Из него ничего не было извлечено " + type + "!");
        } else {
            System.out.print("Извлечено из " + type + ": ");
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i].getInfo() + " ");
            System.out.println();
        }
    }

}
