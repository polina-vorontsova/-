package com.company;

//Класс - приоритетная очередь

class PriorityQueue {

    private Data head; //первый пакет приоритетной очереди
    private long size;
    
    public long getSize() {
        return size;  //Возвращаем размер приритетной очереди
    }
    
    public PriorityQueue() {
        head = null;
        size = 0;
    }
    
    //Добавление нового пакета данных в приоритетную очередь
    public void insert(Data d) {
        if (head == null) {
            head = d;//Если очередь пуста, то просто запоминаем новое начало
        } else {
            Data current = head;
            if (d.getInfo() >= head.getInfo()){
                d.next = head;
                head = d;
            } else {
                Data previous = current;

                while (current != null && d.getInfo() < current.getInfo()) {
                    previous = current;
                    current = current.next;
                }

                d.next = current;
                previous.next = d;
            }
        }
        size++;// увеличение  размер списка
    }


    //Извлечения элементов из начала очереди
    public Data[] remove(long removedEl){
        Data[] toReturn = null;// массив с возвратом адресов извлекаемых из очереди объектов
        if (size < removedEl){
            toReturn = new Data[(int)size];//возврат всей очереди
        } else {
            toReturn = new Data[(int)removedEl];//её часть
        }
        int ind = 0;
        while (ind != toReturn.length){
            Data temp = head;
            head = head.next; // заполняем массив,сдвигая голову очереди
            temp.next = null;
            toReturn[ind] = temp;
            ind++;
        }
        size -= toReturn.length;
        return toReturn;
    }

    //Поиск пакета данных по содержимому
    public Data find(long info){
        Data current = head;
        while (current != null ) {
            if (current.getInfo() == info)
                break;
            current = current.next;
        }
        return current;
    }
}